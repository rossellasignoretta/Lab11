package it.polito.tdp.bar;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.bar.model.Model;
import it.polito.tdp.bar.model.Statistiche;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class BarController {
	
	Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSimula;

    @FXML
    private TextArea txtResult;

    @FXML
    void doSimulazione(ActionEvent event) {
    	txtResult.clear();
    	
    	String result="";
    	
    	Statistiche stats= model.simula();
    	
    	result+="Numero clienti totali = "+stats.getNumero_totale_clienti()+"\n";
    	result+="Numero clienti soddisfatti = "+stats.getNumero_clienti_soddisfatti()+"\n";
    	result+="Numero clienti insoddisfatti = "+stats.getNumero_clienti_insoddisfatti();

    	txtResult.setText(result);
    }

    @FXML
    void initialize() {
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Bar.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Bar.fxml'.";

    }
    
    public void setModel(Model model){
    	this.model=model;
    }
}

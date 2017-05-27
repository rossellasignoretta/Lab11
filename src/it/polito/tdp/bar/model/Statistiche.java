package it.polito.tdp.bar.model;

public class Statistiche {
	
	private int totale_clienti;
	private int clienti_soddisfatti;
	private int clienti_insoddisfatti;
	
	public Statistiche() {
		this.totale_clienti = 0;
		this.clienti_soddisfatti = 0;
		this.clienti_insoddisfatti = 0;
	}

	public int getNumero_totale_clienti() {
		return totale_clienti;
	}

	public int getNumero_clienti_soddisfatti() {
		return clienti_soddisfatti;
	}

	public int getNumero_clienti_insoddisfatti() {
		return clienti_insoddisfatti;
	}
	
	public void increaseClientiTotali(int num){
		totale_clienti+=num;
	}

	public void increaseClientiSoddisfatti(int num){
		clienti_soddisfatti+=num;
	}
	
	public void increaseClientiInsoddisfatti(int num){
		clienti_insoddisfatti+=num;
	}
}

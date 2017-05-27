package it.polito.tdp.bar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import it.polito.tdp.bar.model.Event.EventType;

public class Simulatore {
	
	private List <Tavolo> tavoli; 
	private PriorityQueue <Event> queue;
	private Statistiche stats;
	
	public Simulatore(){
		aggiungiTavoli();
		this.queue=new PriorityQueue<>();
		this.stats=new Statistiche();
		
	}

	private void aggiungiTavoli(){
		tavoli=new ArrayList<Tavolo>();

		tavoli.add(new Tavolo(10));
		tavoli.add(new Tavolo(10));
		
		tavoli.add(new Tavolo(8));
		tavoli.add(new Tavolo(8));
		tavoli.add(new Tavolo(8));
		tavoli.add(new Tavolo(8));
		
		tavoli.add(new Tavolo(6));
		tavoli.add(new Tavolo(6));
		tavoli.add(new Tavolo(6));
		tavoli.add(new Tavolo(6));
		
		tavoli.add(new Tavolo(4));
		tavoli.add(new Tavolo(4));
		tavoli.add(new Tavolo(4));
		tavoli.add(new Tavolo(4));
		tavoli.add(new Tavolo(4));

		Collections.sort(tavoli);
	}
	
	public void arrivoClienti(int time, GruppoClienti gruppo){
		Event e = new Event (EventType.ARRIVO_CLIENTI, time, gruppo);
		queue.add(e);
	}
	
	public void run(){
		while (!queue.isEmpty()) {
			Event e = queue.poll();

			switch (e.getType()) {
			case ARRIVO_CLIENTI:
				gestisciArrivoClienti(e);
				break;
			case USCITA_CLIENTI:
				gestisciUscitaCLienti(e);
				break;
			}
		}
	}
	
	private void gestisciArrivoClienti(Event e) {
		GruppoClienti g= e.getGruppo();
		stats.increaseClientiTotali(g.getNumeroPersone());
		
		//assegno il tavolo libero piu piccolo che sia in grado di accogliere i clienti
		//devono occupare almeno il 50% dei posti disponibili
		Tavolo disponibile=null;
		for (Tavolo t: tavoli){
			if (t.isLibero()==true &&
					t.getNumPosti()>=g.getNumeroPersone() && 
					g.getNumeroPersone()>=t.getNumPosti()/2){
				disponibile=t;
				break;
			}			
		}
		
		if(disponibile!=null){
			//se ho un tavolo disponibile li faccio accomodare lì
			g.setTavolo(disponibile);
			disponibile.occupa();	
			stats.increaseClientiSoddisfatti(g.getNumeroPersone());
			queue.add(new Event(EventType.USCITA_CLIENTI, e.getTime()+g.getDurata(), g));
		}else{
			//altrimenti provo a farli accomodare al bancone
			if (Math.random()<=g.getTolleranza()){
				stats.increaseClientiSoddisfatti(g.getNumeroPersone());
			}else{
				stats.increaseClientiInsoddisfatti(g.getNumeroPersone());
			}
		}
		
	}
	
	private void gestisciUscitaCLienti(Event e) {
		Tavolo t=e.getGruppo().getTavolo();
		t.libera();
	}

	public Statistiche getStats(){
		return stats;
	}
}

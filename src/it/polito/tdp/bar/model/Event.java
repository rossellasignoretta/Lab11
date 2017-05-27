package it.polito.tdp.bar.model;

public class Event implements Comparable<Event>{

	public enum EventType {ARRIVO_CLIENTI , USCITA_CLIENTI}
	
	private int time;
	private EventType type;
	private GruppoClienti gruppo;

	public Event(EventType et, int time, GruppoClienti gruppo) {
		this.time =time;
		this.type=et;
		this.gruppo=gruppo;
		
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}
	
	public GruppoClienti getGruppo() {
		return gruppo;
	}

	public void setGruppo(GruppoClienti gruppo) {
		this.gruppo = gruppo;
	}

	public int compareTo(Event altro) {
		return this.time-altro.time;
	}

	
	
	
}

package it.polito.tdp.bar.model;

public class GruppoClienti {
	
	private int numeroPersone;
	private int durata;
	private float tolleranza;
	private Tavolo tavolo;
	
	public GruppoClienti(int numeroPersone, int durata, float tolleranza) {
		super();
		this.numeroPersone = numeroPersone;
		this.durata = durata;
		this.tolleranza = tolleranza;
	}

	public int getNumeroPersone() {
		return numeroPersone;
	}

	public void setNumeroPersone(int numeroPersone) {
		this.numeroPersone = numeroPersone;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public float getTolleranza() {
		return tolleranza;
	}

	public void setTolleranza(float tolleranza) {
		this.tolleranza = tolleranza;
	}

	public Tavolo getTavolo() {
		return tavolo;
	}

	public void setTavolo(Tavolo tavolo) {
		this.tavolo = tavolo;
	}

	
	
	
	

}

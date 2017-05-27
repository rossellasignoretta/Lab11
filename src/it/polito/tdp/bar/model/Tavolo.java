package it.polito.tdp.bar.model;

public class Tavolo implements Comparable<Tavolo>{
	
	private int numPosti;
	private boolean libero;
	
	
	public Tavolo(int numPosti) {
		super();
		this.numPosti = numPosti;
		this.libero = true;
	}

	public int getNumPosti() {
		return numPosti;
	}

	public void setNumPosti(int numPosti) {
		this.numPosti = numPosti;
	}

	public boolean isLibero() {
		return libero;
	}

	public void occupa() {
		this.libero = false;
	}
	
	public void libera() {
		this.libero = true;
	}
	
	public int compareTo(Tavolo altro) {
		return this.numPosti-altro.numPosti;
	}

	
	

}

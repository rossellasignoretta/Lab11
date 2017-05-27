package it.polito.tdp.bar.model;

public class Model {
	
	Simulatore sim;
	
	public Statistiche simula(){
		sim= new Simulatore();
		
		int time=0;
		for (int i=0; i<2000; i++){
			
			time+=(int)(1+Math.random()*10);
			int numeroPersone=(int)(1+Math.random()*10);
			int durata= (int)(60+Math.random()*60);
			float tolleranza= (float) Math.random();
				if (tolleranza>0.9)
					tolleranza=(float) 0.9;
			
			GruppoClienti g= new GruppoClienti(numeroPersone, durata, tolleranza);
			sim.arrivoClienti(time, g);
		}

		sim.run();
		
		
		return sim.getStats();
	}

}

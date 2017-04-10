package br.ufc.quixada.eda.grafos;

public class Aresta {
	private int origem; //vertice origem
	private int destino; //vertice destino
	private double peso; //vertice peso origem
	
	public Aresta(int u, int v, double w){
		this.origem = u;
		this.destino = v;
		this.peso = w;
	}
	
	public int getOrigem(){
		return this.origem;
	}
	
	public int getDestino(){
		return this.destino;
	}
	
	public Double getPeso(){
		return this.peso;
	}

	public void setOrigem(int origem) {
		this.origem = origem;
	}

	public void setDestino(int destino) {
		this.destino = destino;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
}

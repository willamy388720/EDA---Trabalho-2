package br.ufc.quixada.eda.grafos;

public class Aresta {
	private int origem; //vertice origem
	private int destino; //vertice destino
	private int peso; //vertice peso origem
	
	public Aresta(int u, int v, int w){
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
	
	public int getPeso(){
		return this.peso;
	}
}

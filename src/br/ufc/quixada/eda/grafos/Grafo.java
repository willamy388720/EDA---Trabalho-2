package br.ufc.quixada.eda.grafos;

// Este é um exemplo simples de implementação de grafo representado por lista
// de adjacências

public class Grafo {
	private int QtdDeArestas; //Qtd de arestas
	private int QtdDeVertices; //Qtd de vertices
    private Aresta[] arestas = null;

    public Grafo(int n, int m){
    	this.QtdDeArestas = m;
    	this.QtdDeVertices = n;
        arestas = new Aresta[m];
    }
    
    public Grafo () {
    	
    }
    
    public int getQtdDeArestas(){
    	return this.QtdDeArestas;
    }
    
    public int getQtdDeVertices(){
    	return QtdDeVertices;
    }
    
    public Aresta[] getArestas(){
    	return this.arestas;
    }
    
    public void setQtdDeArestas(int qtdDeArestas) {
		QtdDeArestas = qtdDeArestas;
	}

	public void setQtdDeVertices(int qtdDeVertices) {
		QtdDeVertices = qtdDeVertices;
	}

	public void setArestas(Aresta[] arestas) {
		this.arestas = arestas;
	}
    
    private int particiona(int i, int j){	
		int pivo = j;
		int q = i - 1;
		for (int k = i; k < j; k++) {
			if(arestas[k].getPeso() < arestas[pivo].getPeso()) {
				q++;
				Aresta troca = arestas[k];
				arestas[k] = arestas[pivo];
				arestas[pivo] = troca;
			}
		}
		Aresta troca = arestas[q + 1];
		arestas[q + 1] = arestas[j];
		arestas[j] = troca;
		return q + 1;
	}
	
	public void quickSort(int i, int j){
		if(i < j){
			int k = particiona(i, j);
			quickSort(i, k - 1);
			quickSort(k + 1, j);
		}
	}
}
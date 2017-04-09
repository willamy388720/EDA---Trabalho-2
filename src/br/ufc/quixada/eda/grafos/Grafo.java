package br.ufc.quixada.eda.grafos;

import java.util.ArrayList;
import java.util.List;

// Este é um exemplo simples de implementação de grafo representado por lista
// de adjacências

public class Grafo {
	private int m; //Qtd de arestas
	private int n; //Qtd de vertices
    private List<Aresta> arestas;

    public Grafo(int n, int m){
    	this.m = m;
    	this.n = n;
        arestas = new ArrayList<>();
    }
    
    public int getQtdDeArestas(){
    	return this.m;
    }
    
    public int getQtdDeVertices(){
    	return n;
    }
    
    public List<Aresta> getArestas(){
    	return this.arestas;
    }
}
package br.ufc.quixada.eda.algoritmos;

import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.eda.grafos.*;
import br.ufc.quixada.eda.conjuntodisjuntos.*;

public class ArvoreGeradoraMinima {
	
	public List<Aresta> kruskal(Grafo g){
		List<Aresta> solucao = new ArrayList<Aresta>();
		ConjuntoDisjunto conj = new ConjuntoDisjunto(g.getQtdDeVertices());
		for(int i = 0; i < g.getQtdDeVertices(); i++)
			conj.make_set(i);
		g.quickSort(0, g.getQtdDeArestas());
		for(int i = 0; i < g.getQtdDeArestas(); i++){
			Aresta a = g.getArestas()[i];
			if(conj.find_set(a.getOrigem()) != conj.find_set(a.getDestino())){
				solucao.add(a);
				conj.union(conj.find_set(a.getOrigem()), a.getDestino());
			}
		}
		return solucao;
	}
	

}

package br.ufc.quixada.eda.algoritmos;

import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.eda.grafos.*;
import br.ufc.quixada.eda.conjuntodisjuntos.*;

public class ArvoreGeradoraMinima {
	private int vetor[] = null;
	
	public ArvoreGeradoraMinima(int n){
		vetor = new int[n];
	}
	
	private int particiona(int p, int r){	
		int pivo = vetor[p], i = (p + 1), f = r;
		while(i <= f){
			if(vetor[i] <= pivo){
				i++;
			}else if(pivo < vetor[f]){
				f--;
			}else{
				int troca = vetor[i];
				vetor[i] = vetor[f];
				vetor[f] = troca;
				i++; f--;
			}
		}
		vetor[p] = vetor[f];
		vetor[f] = pivo;
		return f;
	}
	
	private void quickSort(int ini, int fim){
		if(ini < fim){
			int meio = particiona(ini, fim);
			quickSort(ini, (meio - 1));
			quickSort((meio + 1), fim);
		}
	}
	
	public List<Aresta> kruskal(Grafo g){
		Aresta a = new Aresta(0, 0, 0);
		List<Aresta> solucao = new ArrayList<Aresta>();
		ConjuntoDisjunto conj = new ConjuntoDisjunto(g.getQtdDeVertices());
		for(int i = 0; i < g.getQtdDeVertices(); i++)
			conj.make_set(i);
		
		quickSort(a.getOrigem(), a.getDestino());
		
		for(int i = 0; i < g.getQtdDeArestas(); i++){
			
			if(conj.find_set(a.getDestino()) != conj.find_set(a.getOrigem())){
				solucao.add(a);
				conj.union(conj.find_set(a.getOrigem()), a.getDestino());
			}
		}
		return solucao;
	}
	

}

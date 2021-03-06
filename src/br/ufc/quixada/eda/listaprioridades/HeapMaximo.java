package br.ufc.quixada.eda.listaprioridades;

import java.util.List;

/**
 * Implementa a lista de prioridade usando Heap Maximo.
 * @author fabio
 *
 */
public class HeapMaximo {
	private int nMaximo = 0;
	private int vetor[] = null;
	private int n = 0;
	
	public HeapMaximo(int Nmaximo){
		nMaximo = Nmaximo;
		vetor = new int[Nmaximo];
	}
	
	private void subir(int i){
		int p = i/2;
		if(p >= 1){
			if(vetor[p] < vetor[i]){
				int aux = vetor[i];
				vetor[i] = vetor[p];
				vetor[p] = aux;
				subir(p);
			}
		}
	}
	
	private void descer(int i){
		int f = i * 2;
		if(f <= n){
			if((f + 1) <= n){
				if(vetor[f] < vetor[f + 1]){
					f++;
				}
			}
			if(vetor[f] > vetor[i]){
				int aux = vetor[f];
				vetor[f] = vetor[i];
				vetor[i] = aux;
				descer(f);
			}
		}
	}
	
	public void contruir(List<Integer> entrada){
		for(int i = 1; i < entrada.size(); i++){
			vetor[i] = entrada.get(i - 1);
			n++;
		}
		for(int i = (n/2); i > 1; i--){
			descer(i);
		}
	}
	
	public int getMaximaPrioridade(){
		return vetor[0];
	}
	
	public int remove(){
		if(n >= 1){
			int aux = vetor[0];
			vetor[0] = vetor[n - 1];
			n--;
			descer(0);
			return aux;
		}
		return -1;
	}	
	
	public void inserir(int prioridade){
		if(n < nMaximo){
			vetor[n + 1] = prioridade;
			n++;
			subir(n);
		}
	}
	
	public void alterarPrioridade(int prioridade, int novaPrioridade){	
		for(int i = 1; i < n; i++){
			if(vetor[i] == prioridade){
				vetor[i] = novaPrioridade;
				if(novaPrioridade > prioridade){
					subir(i);
				}else{
					descer(i);
				}
				return;
			}
		}
	}	
}
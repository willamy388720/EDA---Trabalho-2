package br.ufc.quixada.eda.listaprioridades;

import java.util.List;

/**
 * Implementa a lista de prioridade usando vetor ordenado.
 * Reparem que aqui voc� devem utilizar obrigat�riamente o quickSort 
 * para realizar a ordena��o, quando for necess�rio.
 * @author fabio
 *
 */
public class LPMaximaOrdenada {
	private int nMaximo = 0;
	private int vetor[] = null;
	private int n = 0;
	
	public LPMaximaOrdenada(int Nmaximo){
		nMaximo = Nmaximo;
		vetor = new int[Nmaximo];
	}
	
	public void contruir(List<Integer> entrada){
		for(int i = 0; i < entrada.size(); i++){
			vetor[i] = entrada.get(i);
		}
		n = entrada.size();
		quickSort(0, (n - 1));
	}
	
	public int getMaximaPrioridade(){
		if(n > 0){
			return vetor[n - 1];
		}
		return -1;
	}
	
	public int remove(){
		if(n > 0){
			return vetor[n - 1];
		}
		return 0;
	}	
	
	public void inserir(int prioridade){
		if(n + 1 < nMaximo){
			int i = 1;
			while(vetor[i] > prioridade && i <= (n - 1)){
				vetor[i + 1] = vetor[i];
				i++;
			}
			vetor[i - 1] = prioridade;
			n++;
		}
	}
	
	public void alterarPrioridade(int prioridade, int novaPrioridade){
		for(int i = 0; i < n; i++){
			if(vetor[i] == prioridade){
				vetor[i] = vetor[i + 1];
			}
			i++;
		}
		n--;
		inserir(novaPrioridade);
	}
	
	private void quickSort(int ini, int fim){
		if(ini < fim){
			int meio = particiona(ini, fim);
			quickSort(ini, (meio - 1));
			quickSort((meio + 1), fim);
		}
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
}

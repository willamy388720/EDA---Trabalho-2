package br.ufc.quixada.eda.arvoreavl;

public class AVL <Chave extends Comparable<Chave>, Info> {
	private No raiz = null;
	
	public class No {
		private Chave chave;
		private int altura;
		public No esq, dir;
		
		public No (Chave chave) {
			this.chave = chave;
			this.altura = 1;
		}
	}
	
	private No rotacaoDireita (No no) {
		No x = no.esq;
		no.esq = x.dir;
		x.dir = no;
		
		no.altura = ((altura(no.esq) > altura(no.dir) ? altura(no.esq) : altura(no.dir)) + 1);
		x.altura = ((altura(x.esq) > altura(x.dir) ? altura(x.esq) : altura(x.dir)) + 1);
		return x;
	}
	
	private No rotacaoEsquerda (No no) {
		No x = no.dir;
		no.dir = x.esq;
		x.esq = no;
		
		no.altura = ((altura(no.esq) > altura(no.dir) ? altura(no.esq) : altura(no.dir)) + 1);
		x.altura = ((altura(x.esq) > altura(x.dir) ? altura(x.esq) : altura(x.dir)) + 1);
		return x;
	}
	
	public void inserir(Chave chave){
		if(chave == null) throw new IllegalArgumentException("Chave deve ser diferente de null.");
		raiz = inserir(raiz, chave);
	}
	
	private No noInserido = null;
	private No inserir(No raiz, Chave chave){
		if(raiz == null){
			noInserido = new No(chave);
			return noInserido;
		}
		int cmp = chave.compareTo(raiz.chave);
		if(cmp < 0){
			raiz.esq = inserir(raiz.esq, chave);
			if((altura(raiz.esq) - altura(raiz.dir)) == 2){
				if(altura(raiz.esq.esq) > altura(raiz.esq.dir)){
					raiz = rotacaoDireita(raiz);
				}else{
					raiz = rotacaoDuplaDireita(raiz);
				}
			}
		}else if(cmp > 0){
			raiz.dir = inserir(raiz.dir, chave);
			if((altura(raiz.dir) - altura(raiz.esq)) == 2){
				if(altura(raiz.dir.dir) > altura(raiz.dir.esq)){
					raiz = rotacaoEsquerda(raiz);
				}else{
					raiz = rotacaoDuplaEsquerda(raiz);
				}
			}
		}
		raiz.altura = ((altura(raiz.dir) > altura(raiz.esq) ? altura(raiz.dir) : altura(raiz.esq)) + 1);
		return raiz;
	}
	
	private int altura(No raiz){
		return (raiz != null ? raiz.altura : 0);
	}
	
	private No rotacaoDuplaDireita(No no){
		if (no != null) no.esq = rotacaoEsquerda(no.esq);
		if (no != null) no = rotacaoDireita(no);
		return no;
	}
	
	
	private No rotacaoDuplaEsquerda(No no){
		no.dir = rotacaoDireita(no.dir);
		no = rotacaoEsquerda(no);
		return no;
	}
	
	private No busca(No raiz, Chave chave){
		if(raiz == null) return null;
		int cmp = chave.compareTo(raiz.chave);
		if(cmp > 0){
			return busca(raiz.dir, chave);
		}else if(cmp < 0){
			return busca(raiz.esq, chave);
		}
		return raiz;
	}
	
	public No busca(Chave chave){
		if (chave == null) return null;
		return busca(raiz, chave);
	}
	
	public void remover(Chave chave){
		if(chave == null) throw new IllegalArgumentException("Chave deve ser diferente de null.");
		this.raiz = remover(this.raiz, chave);
	}
	//ALTERAÇÃO
	private No remover (No raiz, Chave chave){
		if(raiz == null) return null;
		int cmp = chave.compareTo(raiz.chave);
		if(cmp > 0){
			raiz.dir = remover(raiz.dir, chave);
			if((altura(raiz.esq) - altura(raiz.dir)) == 2){
				if(altura(raiz.esq.esq) > altura(raiz.esq.dir)){
					raiz = rotacaoDireita(raiz);
				}else{
					raiz = rotacaoDuplaDireita(raiz);
				}
			}
		}else if(cmp < 0){
			raiz.esq = remover(raiz.esq, chave);
			if((altura(raiz.dir) - altura(raiz.esq)) == 2){
				if(altura(raiz.dir.dir) > altura(raiz.dir.esq)){
					raiz = rotacaoEsquerda(raiz);
				}else{
					raiz = rotacaoDuplaEsquerda(raiz);
				}
			}
		}else{
			if(raiz.dir == null || raiz.esq == null){
				if(raiz.dir == null && raiz.esq == null)
					return null;
				if(raiz.dir == null){
					raiz = raiz.esq;
				}else{
					raiz = raiz.dir;
				}
			}else{
				No aux = raiz.dir;
				while (aux.esq != null) {
					aux = aux.esq;
				}
				raiz.chave = (aux.chave);
				raiz.dir = remover(raiz.dir, aux.chave);
			}
		}
		raiz.altura = (((altura(raiz.dir) > altura(raiz.esq)) ? altura(raiz.dir) : (altura(raiz.esq))) + 1);
		return raiz;
	}
}
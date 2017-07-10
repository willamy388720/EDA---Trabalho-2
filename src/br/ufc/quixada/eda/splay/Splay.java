package br.ufc.quixada.eda.splay;

public class Splay<Chave extends Comparable<Chave>, Info> {
	private No raiz;
	
	private class No {
        public Chave chave;
        public No esq, dir;

        public No(Chave chave) {
            this.chave   = chave;
        }
    }
	
	private No splay (No raiz, Chave chave) {
		if (raiz == null) return null;
		if (raiz.chave == chave) return raiz;
		int cmp = chave.compareTo(raiz.chave);
		if (cmp < 0) {
			if (raiz.esq != null) {
				raiz.esq = splay(raiz.esq, chave);
				raiz = rotacaoDireita(raiz);
			}
		}
		else if (cmp > 0) { 
			if (raiz.dir != null) {
				raiz.dir = splay(raiz.dir, chave);
				raiz = rotacaoEsquerda(raiz);
			}
		}
		return raiz;
	}
	
	public No busca (Chave chave) {
		if (chave == null) return null;
		raiz = splay(raiz, chave);
		if (raiz.chave == chave) return raiz;
		else return null;
	}
	
	private No noInserido = null;
	private No inserir (No raiz, Chave chave) {
		if (raiz == null) {
			noInserido = new No(chave);
			return noInserido;
		}
		int cmp = chave.compareTo(raiz.chave);
		if (cmp < 0) {
			raiz.esq = inserir(raiz.esq, chave);
		}
		else if (cmp > 0) {
			raiz.dir = inserir(raiz.dir, chave);
		}
		return raiz;
	}
	
	public void inserir (Chave chave) {
		if (chave == null) throw new IllegalArgumentException("Chave deve ser diferente de null.");
		raiz = inserir(raiz, chave);
		raiz = splay(raiz, chave);
	}
	
	public void remover(Chave chave){
		this.raiz = splay(this.raiz, chave);
		if(this.raiz == null || this.raiz.chave != chave) 
			return;
		No aux = splay(this.raiz.esq, chave);
		if(raiz.dir != null && aux != null) 
			aux.dir = raiz.dir;
		raiz = aux;
	}
	
	private No rotacaoDireita(No raiz){
		No aux = raiz.esq;
		raiz.esq = raiz.esq.dir;
		aux.dir = raiz;
		return aux;
	}
	
	private No rotacaoEsquerda(No raiz){
		No aux = raiz.dir;
		raiz.dir = raiz.dir.esq;
		aux.esq = raiz;
		return aux;
	}      
}
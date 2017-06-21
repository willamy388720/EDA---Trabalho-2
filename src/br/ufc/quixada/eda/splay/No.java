package br.ufc.quixada.eda.splay;

public class No<T> {
	private No<T> esq, dir;
	private int chave;
	private T valor;
	
	public No(int chave, T valor) {
		this.esq = null;
		this.dir = null;
		this.chave = chave;
		this.valor = valor;
	}

	public No<T> getEsq() {
		return esq;
	}

	public void setEsq(No<T> esq) {
		this.esq = esq;
	}

	public No<T> getDir() {
		return dir;
	}

	public void setDir(No<T> dir) {
		this.dir = dir;
	}

	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}

	public T getValor() {
		return valor;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}
	
	
}

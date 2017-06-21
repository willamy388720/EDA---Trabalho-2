package br.ufc.quixada.eda.arvoreavl;

public class NoAvl<T> {
	private NoAvl<T> esq, dir;
	private int chave, altura;
	private T valor;
	
	public NoAvl(int chave, T valor) {
		esq = null;
		dir = null;
		this.chave = chave;
		this.altura = 1;
		this.valor = valor;
	}

	public NoAvl<T> getEsq() {
		return esq;
	}

	public void setEsq(NoAvl<T> esq) {
		this.esq = esq;
	}

	public NoAvl<T> getDir() {
		return dir;
	}

	public void setDir(NoAvl<T> dir) {
		this.dir = dir;
	}

	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	
}

package br.ufc.quixada.eda.arvoreavl;

public class NoAvl {
	private NoAvl esq, dir;
	private int chave, altura;
	
	public NoAvl(int chave) {
		super();
		esq = null;
		dir = null;
		this.chave = chave;
		this.altura = 1;
	}

	public NoAvl getEsq() {
		return esq;
	}

	public void setEsq(NoAvl esq) {
		this.esq = esq;
	}

	public NoAvl getDir() {
		return dir;
	}

	public void setDir(NoAvl dir) {
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

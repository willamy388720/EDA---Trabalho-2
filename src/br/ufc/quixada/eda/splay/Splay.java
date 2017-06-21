package br.ufc.quixada.eda.splay;

public class Splay<T> {
	private No<T> raiz;
	
	private No<T> splay(No<T> raiz, int chave){
		if(raiz == null)
			return null;
		if(raiz.getChave() == chave)
			return raiz;
		if(chave < raiz.getChave()){
			if(raiz.getEsq() != null){
				raiz.setEsq(splay(raiz.getEsq(), chave));
				raiz = rotacaoDireita(raiz);
			}
		}
		else if(chave > raiz.getChave()){
			if(raiz.getDir() != null){
				raiz.setDir(splay(raiz.getDir(), chave));
				raiz = rotacaoEsquerda(raiz);
			}
		}
		return raiz;
	}
	
	public void inserir(int chave, T valor){
		raiz = inserir(raiz, chave, valor);
	}
	
	private No<T> inserir(No<T> raiz, int chave, T valor){
		if(raiz == null)
			return new No<T>(chave, valor);
		
		if(chave < raiz.getChave())
			raiz.setEsq(inserir(raiz.getEsq(), chave, valor));
		
		else if(chave > raiz.getChave())
			raiz.setDir(inserir(raiz.getDir(), chave, valor));
		raiz = busca(chave);
		return raiz;
	}
	
	public No<T> busca(int chave){
		raiz = splay(raiz, chave);
		if(raiz.getChave() == chave)
			return raiz;
		else
			return null;
	}
	
	private No<T> rotacaoDireita(No<T> no){
		No<T> aux = no;
		no = aux.getEsq();
		aux.setEsq(no.getDir());
		no.setDir(aux);
		return no;
	}
	
	private No<T> rotacaoEsquerda(No<T> no){
		No<T> aux = no;
		no = aux.getDir();
		aux.setDir(no.getEsq());
		no.setEsq(aux);
		return no;
	}
}

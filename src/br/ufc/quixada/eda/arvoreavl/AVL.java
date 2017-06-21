package br.ufc.quixada.eda.arvoreavl;


public class AVL<T> {
	private NoAvl<T> raiz = null;
	
	public void inserir(int chave, T valor){
		this.raiz = inserir(this.raiz, chave, valor);
	} 
	
	public NoAvl<T> inserir(NoAvl<T> raiz, int chave, T valor){
		if(raiz == null){
			raiz = new NoAvl<T>(chave, valor);
		}
		else if(raiz.getChave() > chave){
			raiz.setEsq(inserir(raiz.getEsq(), chave, valor));
			
		}
		else if(raiz.getChave() < chave){
			raiz.setDir(inserir(raiz.getDir(), chave, valor));
		}
		
		raiz = balanceamento(raiz);
		
		return raiz;
	}
	
	private NoAvl<T> balanceamento(NoAvl<T> raiz){
		if(altura(raiz.getEsq()) - altura(raiz.getDir()) == 2){
			if(altura(raiz.getEsq().getEsq()) > altura(raiz.getDir().getDir()))
				raiz = rotacaoDireita(raiz);
			else
				raiz = rotacaoDuplaDireita(raiz);
		}
		
		else if(altura(raiz.getDir()) - altura(raiz.getEsq()) == 2){
			if(altura(raiz.getDir().getDir()) > altura(raiz.getEsq().getEsq()))
				raiz = rotacaoEsquerda(raiz);
			else
				raiz = rotacaoDuplaEsquerda(raiz);
		}
		
		//raiz.setAltura(Math.max(altura(raiz.getDir()), altura(raiz.getEsq())) + 1);
		
		return raiz;
	}
	
	private int altura(NoAvl<T> raiz){
		return (raiz != null ? raiz.getAltura() : 0);
	}
	
	private NoAvl<T> rotacaoDireita(NoAvl<T> no){
		NoAvl<T> aux = no;
		no = aux.getEsq();
		aux.setEsq(no.getDir());
		no.setDir(aux);
		return no;
	}
	
	private NoAvl<T> rotacaoDuplaDireita(NoAvl<T> no){
		no.setEsq(rotacaoEsquerda(no.getEsq()));
		return rotacaoDireita(no);
	}
	
	private NoAvl<T> rotacaoEsquerda(NoAvl<T> no){
		NoAvl<T> aux = no;
		no = aux.getDir();
		aux.setDir(no.getEsq());
		no.setEsq(aux);
		return no;
	}
	
	private NoAvl<T> rotacaoDuplaEsquerda(NoAvl<T> no){
		no.setDir(rotacaoDireita(no.getDir()));
		return rotacaoEsquerda(no);
	}
	
	private void apagaNo(NoAvl<T> node){
		if(node == null)
			return;
		apagaNo(node.getEsq());
		apagaNo(node.getDir());
		node = null;
	}
	
	private void imp(NoAvl<T> n, String s) {
		if(n != null && (n.getEsq() != null || n.getDir() != null))
			imp(n.getDir(), s + "r");
		int tam = s.length();
		for(int i = 0; i < tam - 1; i++) {
			if(s.charAt(i) != s.charAt(i+1)) {
				System.out.print("| "+"  ");
			}else {
				System.out.print("  "+"  ");
			}
		}
		if(s != "") {
			if(s.endsWith("r") == true)
				System.out.print("┌───");
			else
				System.out.print("└───");
		}
		if(n == null) {
			System.out.println("#");
			return;
		}
		System.out.println(n.getChave() +"(" + n.getAltura()+ ")");
		if(n != null && (n.getEsq() != null || n.getDir() != null)) {
			imp(n.getEsq(), s + "l");
		}
	}
	
	public void show() {
		imp(this.raiz, "");
	}
}

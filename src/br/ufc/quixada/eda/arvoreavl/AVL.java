package br.ufc.quixada.eda.arvoreavl;


public class AVL {
	private NoAvl raiz = null;
	
	public void inserir(int chave){
		this.raiz = inserir(this.raiz, chave);
	}
	
	public NoAvl inserir(NoAvl raiz, int chave){
		if(raiz == null){
			raiz = new NoAvl(chave);
		}
		else if(raiz.getChave() > chave){
			raiz.setEsq(inserir(raiz.getEsq(), chave));
			
		}
		else if(raiz.getChave() < chave){
			raiz.setDir(inserir(raiz.getDir(), chave));
		}
		
		raiz = balanceamento(raiz);
		
		return raiz;
	}
	
	private NoAvl balanceamento(NoAvl raiz){
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
	
	private int altura(NoAvl raiz){
		return (raiz != null ? raiz.getAltura() : 0);
	}
	
	private NoAvl rotacaoDireita(NoAvl no){
		NoAvl aux = no;
		no = aux.getEsq();
		aux.setEsq(no.getDir());
		no.setDir(aux);
		return no;
	}
	
	private NoAvl rotacaoDuplaDireita(NoAvl no){
		no.setEsq(rotacaoEsquerda(no.getEsq()));
		return rotacaoDireita(no);
	}
	
	private NoAvl rotacaoEsquerda(NoAvl no){
		NoAvl aux = no;
		no = aux.getDir();
		aux.setDir(no.getEsq());
		no.setEsq(aux);
		return no;
	}
	
	private NoAvl rotacaoDuplaEsquerda(NoAvl no){
		no.setDir(rotacaoDireita(no.getDir()));
		return rotacaoEsquerda(no);
	}
	
	private void apagaNo(NoAvl node){
		if(node == null)
			return;
		apagaNo(node.getEsq());
		apagaNo(node.getDir());
		node = null;
	}
	
	private void imp(NoAvl n, String s) {
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

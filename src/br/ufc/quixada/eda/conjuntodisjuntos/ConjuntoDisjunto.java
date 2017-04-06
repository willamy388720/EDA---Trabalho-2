package br.ufc.quixada.eda.conjuntodisjuntos;

public class ConjuntoDisjunto {
	private int pai[];
	private int ordem[];
	private int n = 0;
	
	public ConjuntoDisjunto(int n){
		this.n = n;
		pai = new int[n];
		ordem = new int[n];
	}
	
	public void make_set(int i){
		pai[i] = i;
		ordem[i] = 0;
	}
	
	public void make_set_all(){
		for(int v = 0; v < n; v++){
			make_set(v);
		}
	}
	
	public int find_set(int v){
		if(pai[v] == v){
			return v;
		}else{
			pai[v] = find_set(v);
			return pai[v];
		}
	}
	
	public void link_set(int u, int v){
		if(ordem[v] < ordem[u]){
			pai[v] = u;
		}else{
			pai[u] = v;
			if(ordem[u] == ordem[v])
				ordem[v]++;
		}
	}
	
	public void union(int u, int v){
		link_set(find_set(u), find_set(v));
	}

}

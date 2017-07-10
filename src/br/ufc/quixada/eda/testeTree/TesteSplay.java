package br.ufc.quixada.eda.testeTree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.ufc.quixada.eda.dados.Empresa;
import br.ufc.quixada.eda.splay.Splay;
import br.ufc.quixada.eda.utilTree.*;

public class TesteSplay {
	
	public static void main(String[] args) throws IOException {

		System.out.println("Árvore Splay");
		String arquivoOperacao = "empresasC";
		String path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
		List<Empresa> empresas = EDAUtil.getOperacoes(path);
		List<Empresa> buscados = new ArrayList<Empresa>();
		Splay<Empresa, Empresa> splay = new Splay<Empresa, Empresa>();
	
		long tempoInicial = System.currentTimeMillis();	
	
		for (Empresa empresa : empresas) {
			splay.inserir(empresa);
		}
		
		long tempo = (System.currentTimeMillis() - tempoInicial);			  
	
		System.out.println("Tempo de insercao: " + tempo);
		
		tempoInicial = System.currentTimeMillis();
		int tam = empresas.size();
		for (int i = 0; i < tam; i++) {
			Random rand = new Random();
			Empresa e = empresas.get(rand.nextInt(tam));
			buscados.add(e);
			splay.busca(e);
		}
		tempo = System.currentTimeMillis() - tempoInicial;			  
		System.out.println("Tempo de busca: " + tempo);
		
		tempoInicial = System.currentTimeMillis();
		for (Empresa empresa : buscados) {
			splay.remover(empresa);
		}
		tempo = System.currentTimeMillis() - tempoInicial;			  
		System.out.println("Tempo de remorcao: " + tempo);
	}	
}

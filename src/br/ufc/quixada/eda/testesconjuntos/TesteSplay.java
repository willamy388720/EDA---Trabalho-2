package br.ufc.quixada.eda.testesconjuntos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.ufc.quixada.eda.dados.Empresa;
import br.ufc.quixada.eda.splay.Splay;
import br.ufc.quixada.eda.utilTree.*;

public class TesteSplay {
	public static void main(String args[]){		
		try {
			System.out.println("Arvore Splay");
			String arquivoOperacao = "empresasC";
			String path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
			List<Empresa> empresas = EDAUtil.getOperacoes(path);
			List<Empresa> buscados = new ArrayList<Empresa>();
			Splay<Empresa, Empresa> s = new Splay<Empresa, Empresa>();
			long tempoInicial = System.currentTimeMillis();				
			int taxa = (int) (empresas.size() * 0.2);
			for (int i = 1; i <= empresas.size(); i++) {
				s.inserir(empresas.get(i - 1));
				if(i % taxa == 0){
					for (int j = 0; j < i * 0.3; j++) {
						Random rand = new Random();
						Empresa e = empresas.get(rand.nextInt(i));
						buscados.add(e);
						s.busca(e);
					}
					for (int j = 0; j < i * 0.1; j++) {
						Random rand = new Random();
						s.remover(buscados.remove(rand.nextInt(buscados.size())));
					}
				}
			}
			long tempo = System.currentTimeMillis() - tempoInicial;			  
			System.out.println("Tempo total: " + tempo);
		} catch (IOException e) {}
	}
}
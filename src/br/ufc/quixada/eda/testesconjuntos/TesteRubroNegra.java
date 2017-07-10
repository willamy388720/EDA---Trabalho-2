package br.ufc.quixada.eda.testesconjuntos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.ufc.quixada.eda.dados.*;
import br.ufc.quixada.eda.utilTree.*;
import br.ufc.quixada.eda.rubroNegra.*;

public class TesteRubroNegra {
	public static void main(String args[]){		
		try {
			System.out.println("Arvore RubroNegra");
			String arquivoOperacao = "empresasC";
			String path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
			List<Empresa> empresas = EDAUtil.getOperacoes(path);
			List<Empresa> buscados = new ArrayList<Empresa>();
			RubroNegra<Empresa, Empresa> rn = new RubroNegra<Empresa, Empresa>();
			long tempoInicial = System.currentTimeMillis();				
			int taxa = (int) (empresas.size() * 0.2);
			for (int i = 1; i <= empresas.size(); i++) {
				rn.inserir(empresas.get(i - 1), empresas.get(i - 1));
				if(i % taxa == 0){
					for (int j = 0; j < i * 0.3; j++) {
						Random rand = new Random();
						Empresa e = empresas.get(rand.nextInt(i));
						buscados.add(e);
						rn.busca(e);
					}
					for (int j = 0; j < i * 0.1; j++) {
						Random rand = new Random();
						rn.remover(buscados.remove(rand.nextInt(buscados.size())));
					}
				}
			}
			long tempo = System.currentTimeMillis() - tempoInicial;			  
			System.out.println("Tempo total: " + tempo);
		} catch (IOException e) {}
	}
}
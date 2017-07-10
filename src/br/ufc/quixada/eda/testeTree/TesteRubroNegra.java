package br.ufc.quixada.eda.testeTree;

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
			System.out.println("Arvore Rubro Negra");
			String arquivoOperacao = "empresasC";
			String path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
			List<Empresa> empresas = EDAUtil.getOperacoes(path);
			List<Empresa> buscados = new ArrayList<Empresa>();
			RubroNegra<Empresa, Empresa> rn = new RubroNegra<Empresa, Empresa>();
			
			long tempoInicial = System.currentTimeMillis();				
			for (Empresa empresa : empresas) {
				rn.inserir(empresa, empresa);
			}
			long tempo = System.currentTimeMillis() - tempoInicial;			  
			System.out.println("Tempo de insercao: " + tempo);
			
			tempoInicial = System.currentTimeMillis();
			int tam = empresas.size();
			for (int i = 0; i < tam * 0.3; i++) {
				Random rand = new Random();
				Empresa e = empresas.get(rand.nextInt(tam));
				buscados.add(e);
				rn.busca(e);
			}
			tempo = System.currentTimeMillis() - tempoInicial;			  
			System.out.println("Tempo de busca: " + tempo);
			
			tempoInicial = System.currentTimeMillis();
			for (Empresa empresa : buscados) {
				rn.remover(empresa);
			}
			tempo = System.currentTimeMillis() - tempoInicial;			  
			System.out.println("Tempo de remorcao: " + tempo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

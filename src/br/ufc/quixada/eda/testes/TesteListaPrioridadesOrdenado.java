package br.ufc.quixada.eda.testes;

import java.io.IOException;
import java.util.List;


import br.ufc.quixada.eda.listaprioridades.LPMaximaOrdenada;
import br.ufc.quixada.eda.util.CriarInstancia;
import br.ufc.quixada.eda.util.EDAConstants;
import br.ufc.quixada.eda.util.EDAUtil;
import br.ufc.quixada.eda.util.Operacao;

public class TesteListaPrioridadesOrdenado {
	public static void main(String args[]){		
		try {
			long tempoTotal = 0;
			for (int tamanho : CriarInstancia.tamanhoInstancias) {				
				String path = EDAConstants.caminhoPasta + "tarefa" + tamanho + ".txt";
				List<Integer> entrada = EDAUtil.getDadosIniciais(path);
				
				
				//PARA ARQUIVO COM MAIOR QUANTIDADE DE INSER��ES
				String arquivoOperacao = "operacoesI_" + tamanho;
				path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
				List<Operacao> operacoes = EDAUtil.getOperacoes(path);
				
				long tempoInicial = System.currentTimeMillis();				
				LPMaximaOrdenada listaPrioridade = new LPMaximaOrdenada(2 * entrada.size());
				listaPrioridade.contruir(entrada);							
				
				for (Operacao operacao : operacoes) {
					//System.out.println(operacao.getId() + " " + operacao.getValor() + " " + operacao.getNovoValor());
					if(operacao.getId().equals("I"))
						listaPrioridade.inserir(operacao.getValor());
				}	
				long tempo = System.currentTimeMillis() - tempoInicial;			  
				System.out.println(arquivoOperacao + ": " + tempo +"\n");
				
				tempoTotal += tempo;
				System.out.println("Tempo Total é: " + tempoTotal);
			
				//PARA ARQUIVO COM MAIOR QUANTIDADE DE ALTERA��ES
				arquivoOperacao = "operacoesA_" + tamanho;
				path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
				operacoes = EDAUtil.getOperacoes(path);
				
				tempoInicial = System.currentTimeMillis();				
				listaPrioridade = new LPMaximaOrdenada(2*entrada.size());
				listaPrioridade.contruir(entrada);							
				
				for (Operacao operacao : operacoes) {
					//System.out.println(operacao.getId() + " " + operacao.getValor() + " " + operacao.getNovoValor());
					if(operacao.getId().equals("A"))
						listaPrioridade.alterarPrioridade(operacao.getValor(), operacao.getNovoValor());
				}	
				tempo = System.currentTimeMillis() - tempoInicial;			  
				System.out.println(arquivoOperacao + ": " + tempo + "\n");		
				
				tempoTotal += tempo;
				System.out.println("Tempo Total é: " + tempoTotal);
				
				//ASSIM POR DIANTE, PARA REMO��O E SELE��O
				
				//PARA ARQUIVO COM MAIOR QUANTIDADE DE REMOÇÕES
				arquivoOperacao = "operacoesR_" + tamanho;
				path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
				operacoes = EDAUtil.getOperacoes(path);
				
				tempoInicial = System.currentTimeMillis();				
				listaPrioridade = new LPMaximaOrdenada(2*entrada.size());
				listaPrioridade.contruir(entrada);							
				
				for (Operacao operacao : operacoes) {
					//System.out.println(operacao.getId() + " " + operacao.getValor() + " " + operacao.getNovoValor());
					if(operacao.getId().equals("R"))
						listaPrioridade.remove();
				
				}	
				tempo = System.currentTimeMillis() - tempoInicial;			  
				System.out.println(arquivoOperacao + ": " + tempo + "\n");
				
				tempoTotal += tempo;
				System.out.println("Tempo Total é: " + tempoTotal);
				
				
				//PARA ARQUIVO COM MAIOR QUANTIDADE DE SELEÇÕES
				arquivoOperacao = "operacoesS_" + tamanho;
				path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
				operacoes = EDAUtil.getOperacoes(path);
				
				tempoInicial = System.currentTimeMillis();				
				listaPrioridade = new LPMaximaOrdenada(2*entrada.size());
				listaPrioridade.contruir(entrada);							
				
				for (Operacao operacao : operacoes) {
					//System.out.println(operacao.getId() + " " + operacao.getValor() + " " + operacao.getNovoValor());
					if(operacao.getId().equals("S"))
						listaPrioridade.getMaximaPrioridade();
				}	
				tempo = System.currentTimeMillis() - tempoInicial;			  
				System.out.println(arquivoOperacao + ": " + tempo + "\n");
				
				tempoTotal += tempo;
				System.out.println("Tempo Total é: " + tempoTotal);
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}			
}				
				
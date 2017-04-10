package br.ufc.quixada.eda.util;

import br.ufc.quixada.eda.grafos.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EDAUtil {
	
    public static Grafo lerGrafo(String path) throws IOException {
    	Grafo g = new Grafo();
    	List<Aresta> listaAresta = new ArrayList<Aresta>();
    	Scanner scanner = new Scanner(new FileReader(path)).useDelimiter(" |\r\n");
    	if(scanner.hasNext()){
    		g.setQtdDeVertices(scanner.nextInt());
    		g.setQtdDeArestas(scanner.nextInt());
    	}
    	while (scanner.hasNext())
    		listaAresta.add(new Aresta(scanner.nextInt(), scanner.nextInt(), scanner.nextDouble()));
    	scanner.close();
    	return g;
    }
    
    /**
     * Ler as opera��es que ser�o realizadas na lista de prioridades ap�s a sua cria��o.
     * @param path
     * @return
     * @throws IOException
     */
    public static List<Operacao> getOperacoes(String path) throws IOException {
        List<Operacao> operacoes = new ArrayList<Operacao>();
        Scanner scanner = new Scanner(new FileReader(path)).useDelimiter(" |\r\n");	
		while (scanner.hasNext())
			operacoes.add(new Operacao(scanner.next(), scanner.nextInt(), scanner.nextInt()));
			
		scanner.close();
        return operacoes;
    }    
}

package br.ufc.quixada.eda.utilTree;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import br.ufc.quixada.eda.dados.*;
public class EDAUtil {
	
	public static List<Empresa> getOperacoes(String path) throws IOException {
        List<Empresa> operacoes = new ArrayList<Empresa>();
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(new FileReader(path)).useDelimiter(", |\r\n");	
		while (scanner.hasNext()){
			try{
				operacoes.add(new Empresa(scanner.next().substring(5), scanner.next().substring(5), scanner.next().substring(13), scanner.next().substring(13), scanner.next().substring(5), scanner.next().substring(6), scanner.next().substring(4), scanner.next().substring(4), scanner.next().substring(7), scanner.next().substring(7), scanner.next().substring(7), scanner.next().substring(7), scanner.next().substring(9), scanner.next().substring(8)));
			}catch(Exception e) {}
		}
		scanner.close();
        return operacoes;
    } 
}

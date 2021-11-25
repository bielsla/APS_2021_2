package Estrutura_de_Dados_CRUD;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class BubbleSort {
	Charset cs = Charset.forName("UTF-8");
	String caminho = "c:/temp/APS";
	public void ordenarBubble() throws IOException { 
	BufferedReader ler = new BufferedReader(new FileReader(caminho+"/entrada.txt", cs));
	ArrayList<String> str = new ArrayList<>();
	String linha = "";
	while((linha=ler.readLine())!=null) { // ENQUANTO LINHA FOR DIFERENTE DE NULO, ADICIONA LINHA NA LISTA
		str.add(linha);
	}
	ler.close();
    bubbleSort(str);
	FileWriter escrever = new FileWriter(caminho+"/sortionBubble.txt", true);
	for(String s: str) { // ESCREVE TODAS AS LINHAS JA ORDENADAS NO NOVO TXT
		escrever.write(s);
		escrever.write("\r\n");
	}
	escrever.close();
	} 
	public static void bubbleSort(ArrayList<String> str) {
		String temp;
		boolean troca = true;
	    if (str.size()>1) { // CHECA SE O TAMANHO DA LISTA É MAIOR QUE 1
	    	while (troca) { // LAÇO FOR DO TAMANHO DO ARRAY
	    		troca = false;
	    		for (int i=0; i < str.size()-1; i++) { // LAÇO FOR PERCORRE O PRIMEIRO ELEMENTO ATÉ O ÚLTIMO -1
	                if (str.get(i).compareTo(str.get(i+1)) > 0) { // VERIFICA SE O ELEMENTO ATUAL QUE ESTÁ SENDO LIDO É MAIOR 
		    			// QUE O PRÓXIMO ELEMENTO QUE SERÁ LIDO, ENTRA NO IF SE FOR
	                    temp = str.get(i); 
	                    str.set(i,str.get(i+1) ); // FAZ A SUBSTITUIÇÃO DESSES VALORES 
	                    str.set(i+1, temp);
	                    troca = true; // QUE ANTES ERA FALSE, AGORA RECEBE TRUE PARA INDICAR QUE HOUVE UMA TROCA.
	                }
	    		}
            }
        }
    }
}
package Estrutura_de_Dados_CRUD;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class QuickSort{
	 Charset cs = Charset.forName("UTF-8");
	 
	public void ordenarSort() throws IOException { 
	BufferedReader ler = new BufferedReader(new FileReader("c:/temp/APS/entrada.txt", cs));
	ArrayList<String> str = new ArrayList<>();
	String linha = "";
	while((linha=ler.readLine())!=null){ // ENQUANTO LINHA FOR DIFERENTE DE NULO, ADICIONA LINHA NA LISTA
			str.add(linha);
	}
	ler.close();
	quickSort(str,0,str.size()-1);
	FileWriter escrever = new FileWriter("c:/temp/APS/sortionQuick.txt", true);
	for(String s: str) { // ESCREVE TODAS AS LINHAS JA ORDENADAS NO NOVO TXT
			escrever.write(s);
			escrever.write("\r\n");
	}
	escrever.close();
	} 

	private static void quickSort(ArrayList<String> str, int inicio, int fim) {
        int i = inicio;
        int j = fim;
        if (j - i >= 1) { // CHECA SE O TAMANHO DA LISTA É MAIOR QUE 1
            String pivo = str.get(i); // DEFINE O PRIMEIRO ITEM DA LISTA COMO PIVÔ 
            while (j > i) {
                while (str.get(i).compareTo(pivo) <= 0 && i < fim && j > i) { // ENQUANTO I FOR MENOR OU IGUAL PIVO, I FOR MENOR 
                	// QUE J E FIM FOR MAIOR QUE I
                    i++;
                }
                while (str.get(j).compareTo(pivo) >= 0 && j > inicio && j >= i) { // ENQUANTO J FOR MAIOR OU IGUAL PIVO, J FOR
                	// MAIOR QUE 0 E J FOR MAIOR OU IGUAL A I
                    j--;
                }
                if (j > i) // SE J FOR MAIOR QUE I
                    troca(str, i, j);
            }
            troca(str, inicio, j);
            quickSort(str, inicio, j - 1); // CHAMADA PARA ELEMENTOS MENORES QUE O PIVO
            quickSort(str, j + 1, fim); // CHAMADA PARA ELEMENTOS MAIORES QUE O PIVO
        }
    }
    private static void troca(ArrayList<String> str, int i, int j) // TROCA DE POSIÇÃO OS VALORES I E J
    {
    String temp = str.get(i); // ARMAZENA I EM UMA VARIAVEL TEMPORARIA
    str.set(i, str.get(j)); // I RECEBE J
    str.set(j, temp); // J RECEBE TEMP
    }
}
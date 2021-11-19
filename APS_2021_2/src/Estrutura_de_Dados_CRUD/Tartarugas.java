package Estrutura_de_Dados_CRUD;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import javax.swing.JOptionPane;

	public class Tartarugas {
	private String id, nome, especie, genero, idade, eixoX, eixoY;
	Charset cs = Charset.forName("UTF-8");
	String caminho = "c:/temp/APS";
	
	public void gravar() { //METÓDO DE GRAVAR LINHAS DE REGISTRO NO TXT
        try {
        	File dir = new File(caminho);
            if (!dir.exists()) { //VERIFICA SE A PASTA DO CAMINHO RECEBIDO EXISTE, SE NÃO, CRIA O CAMINHO
                dir.mkdir(); 
            }
            BufferedReader br = new BufferedReader(new FileReader(caminho + "/entrada.txt", cs));
            BufferedReader br1 = new BufferedReader(new FileReader(caminho + "/entrada.txt", cs));
            PrintWriter pw = new PrintWriter(new FileWriter(caminho + "/entrada.txt", true));
            boolean aux = false; // FLAG PARA SABER SE EXISTE ALGUM ID IGUAL
            String pID = getId();
            Object [] vetorLinhas = br.lines().toArray(); // RECEBE TODAS AS LINAHS DO TXT EM UM VETOR
            for(int i = 0; i <vetorLinhas.length; i++) { // FOR DO TAMANHO DE LINHAS DO VETOR
            	String line1 = vetorLinhas[i].toString().trim(); // LINHA DO INDICE I DO VETOR É PASSADO PARA UMA VARIAVEL
                String [] indice = line1.split(";"); // SEPARA A LINHA EM TODOS OS ";"
                if (indice[0].equals(pID)) { // SE O INDICE FOR IGUAL O ID
                    aux = true; // FLAG RECEBE TRUE
                }
            }
            br.close();
            br1.close();
            if (aux == false) { // SE NÃO EXISTIR ID IGUAL NO TXT
            	while (pID.length() < 3) { // SE O ID DIGITADO NÃO TIVER 3 DÍGITOS
	            	pID = ("000" + pID).substring(pID.length()); // ADICIONA ZEROS ATÉ FICAR COM 3 DÍGITOS
	            }
                pw.print(pID + ";");   // ESCREVE TODOS OS DADOS NO TXT
                pw.print(nome + ";");
                pw.print(especie + ";");
                pw.print(idade + ";");
                pw.print(genero + ";");
                pw.print(eixoY + ";");
                pw.println(eixoX + ";");
                pw.flush();
                pw.close();
                JOptionPane.showMessageDialog(null, "Registro criado!");
            } else {
            	JOptionPane.showMessageDialog(null, "Este ID já existe, digite outro!");
            }
        } catch (IOException erro) {
        	return;
        }
    }

	public void atualizar() { // METÓDO DE ATUALIZAR A LINHA DE REGISTRO DO TXT
		try {
		File originalFile = new File(caminho + "/entrada.txt");
        BufferedReader br = new BufferedReader(new FileReader(caminho + "/entrada.txt", cs));
        BufferedReader br1 = new BufferedReader(new FileReader(caminho + "/entrada.txt", cs));
        boolean aux = false; // FLAG PARA SABER SE EXISTE ALGUM ID IGUAL
        String pID = getId();
        File tempFile = new File(caminho + "/tempfile.txt");
        PrintWriter pw = new PrintWriter(new FileWriter(tempFile, cs));
        Object [] vetorLinhas = br.lines().toArray(); // RECEBE TODAS AS LINAHS DO TXT EM UM VETOR
        for(int i = 0; i <vetorLinhas.length; i++) { // FOR DO TAMANHO DE LINHAS DO VETOR
        	String linha = br1.readLine(); // VARIAVEL RECEBE LINHA DO TXT
        	String line1 = vetorLinhas[i].toString().trim(); // LINHA DO INDICE I DO VETOR É PASSADO PARA UMA VARIAVEL
            String [] indice = line1.split(";"); // SEPARA A LINHA EM TODOS OS ";"
            if (indice[0].equals(pID)) { // SE O INDICE FOR IGUAL O ID
                String linhaAtual = linha; 
                if (linhaAtual != null) {
                    String novaLinha = (getId() + ";" + getNome() + ";" + getEspecie() + ";" + getIdade() + ";" + getGenero()
                    + ";" + getEixoY() + ";" + getEixoX()); 
                    linha = novaLinha;
                    aux = true;
                }
            }
            pw.println(linha); // ESCREVE A NOVA LINHA NO TXT
            pw.flush();
        }
        if (aux == false) {
        	JOptionPane.showMessageDialog(null, "Você não pode alterar o ID!");
        } else {
        	JOptionPane.showMessageDialog(null, "Update feito com sucesso!");
        }
		pw.close();
        br.close();
        br1.close();
        // DELETA O ARQUIVO ORIGINAL
        if (!originalFile.delete()) {
            JOptionPane.showMessageDialog(null, "Não foi possível deletar o arquivo!");
        }
        // RENOMEIA O NOVO ARQUIVO PARA O NOME DO ARQUIVO ORIGINAL
        if (!tempFile.renameTo(originalFile)) {
        	JOptionPane.showMessageDialog(null, "Não foi possível renomear o arquivo!");
        }
		} catch (IOException erro) {
			return;
		}
	}
	
	public void deletar() { // MÉTODO PARA DELETAR A PRIMEIRA LINHA DE REGISTRO DO TXT
	try {
		File originalFile = new File(caminho + "/entrada.txt");
        BufferedReader br = new BufferedReader(new FileReader(caminho + "/entrada.txt", cs));
        BufferedReader br1 = new BufferedReader(new FileReader(caminho + "/entrada.txt", cs));
        File tempFile = new File(caminho + "/tempfile.txt");
        PrintWriter pw = new PrintWriter(new FileWriter(tempFile, cs));
        Object [] vetorLinhas = br.lines().toArray(); // RECEBE TODAS AS LINAHS DO TXT EM UM VETOR
        for(int i = 0; i <vetorLinhas.length; i++) { // FOR DO TAMANHO DE LINHAS DO VETOR
        	String linha = br1.readLine(); // VARIAVEL RECEBE LINHA DO TXT
        	if (i != 0) { // LINHA SÓ É ESCRITA NO TXT SE NÃO FOR A PRIMEIRA
            pw.println(linha);
            pw.flush();
        } 
        }
		pw.close();
        br.close();
        br1.close();
        // DELETA O ARQUIVO ORIGINAL
        if (!originalFile.delete()) {
            JOptionPane.showMessageDialog(null, "Não foi possível deletar o arquivo!");
        }
        // RENOMEIA O NOVO ARQUIVO PARA O NOME DO ARQUIVO ORIGINAL
        if (!tempFile.renameTo(originalFile)) {
        	JOptionPane.showMessageDialog(null, "Não foi possível renomear o arquivo!");
        }
		} catch (IOException erro) {
			return;
		}
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public String getEixoX() {
		return eixoX;
	}
	public void setEixoX(String eixoX) {
		this.eixoX = eixoX;
	}
	public String getEixoY() {
		return eixoY;
	}
	public void setEixoY(String eixoY) {
		this.eixoY = eixoY;
	}
}
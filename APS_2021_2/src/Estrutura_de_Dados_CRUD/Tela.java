package Estrutura_de_Dados_CRUD;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class Tela extends JFrame {
    private JLabel lblId , lblNome, lblGenero, lblEspecie, lblIdade, lblEixoX, lblEixoY;
    private JButton btCreate, btRead, btDelete, btSearch, btUpdate, btquickSort, btBubble;
    private JTextField tfId, tfNome, tfEspecie, tfIdade, tfGenero, tfEixoY, tfEixoX;
    private JTable table = new JTable();
    private JScrollPane scrollPane;
    private Tartarugas tartarugas;
    String caminho = "c:/temp/APS";
    
    /* ESSE MÉTODO É UTILIZADO PARA INICIALIZAR OS COMPONENTES NA TELA 
     * E DEFINIR OS EVENTOS USADOS NOS BOTÕES E NA TABLE
    */

    public Tela() {
        inicializarComponentes();
        definirEventos();
    }

    // AQUI É DEFINIDO AS PROPRIEDADES DOS COMPONENTES ADICIONADOS NA TELA
    public void inicializarComponentes() {
        setTitle ("APS");
        setBounds(250,50,550,458);
        setBackground(new Color(150,150,150));
        lblId = new JLabel("ID");
        lblId.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNome = new JLabel("Nome");
        lblNome.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblIdade = new JLabel("Idade");
        lblIdade.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblEspecie = new JLabel("Esp\u00E9cie");
        lblEspecie.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblGenero = new JLabel("Genero");
        lblGenero.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblEixoY = new JLabel("Eixo Y");
        lblEixoY.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblEixoX = new JLabel("Eixo X");
        lblEixoX.setFont(new Font("Tahoma", Font.BOLD, 11));
        btCreate = new JButton ("Create");
        btCreate.setFont(new Font("Tahoma", Font.BOLD, 11));
        btCreate.setForeground(new Color(0, 0, 0));
        btCreate.setBackground(new Color(0, 255, 153));
        btRead = new JButton ("Read");
        btRead.setForeground(new Color(0, 0, 0));
        btRead.setFont(new Font("Tahoma", Font.BOLD, 11));
        btRead.setBackground(new Color(0, 255, 153));
        btDelete = new JButton ("Delete");
        btDelete.setForeground(new Color(0, 0, 0));
        btDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
        btDelete.setBackground(new Color(0, 255, 153));
        btSearch = new JButton ("Search");
        btSearch.setForeground(new Color(0, 0, 0));
        btSearch.setFont(new Font("Tahoma", Font.BOLD, 11));
        btSearch.setBackground(new Color(0, 255, 153));
        btUpdate = new JButton("Update");
        btUpdate.setForeground(new Color(0, 0, 0));
        btUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
        btUpdate.setBackground(new Color(0, 255, 153));
        btquickSort = new JButton("QuickSort");
        btquickSort.setForeground(Color.BLACK);
        btquickSort.setFont(new Font("Tahoma", Font.BOLD, 11));
        btquickSort.setBackground(new Color(0, 255, 153));
        btBubble = new JButton("Bubble");
        btBubble.setForeground(Color.BLACK);
        btBubble.setFont(new Font("Tahoma", Font.BOLD, 11));
        btBubble.setBackground(new Color(0, 255, 153));
        
        tfId = new JTextField();
        tfNome = new JTextField();
        tfEspecie = new JTextField();
        tfIdade = new JTextField();
        tfGenero = new JTextField();
        scrollPane = new JScrollPane();
        tfEixoY = new JTextField();
        tfEixoX = new JTextField();
        getContentPane().setLayout(null);
        lblId.setBounds(10,15,40,20);
        lblNome.setBounds(10,40,45,20);
        lblEspecie.setBounds(10,65,45,20);
        lblIdade.setBounds(10, 90, 45, 20);
        lblGenero.setBounds(10, 115, 46, 14);
        lblEixoY.setBounds(10, 140, 46, 14);
        lblEixoX.setBounds(10, 165, 46, 14);
        btCreate.setBounds(10,200,75,20);
        btRead.setBounds(95,200,75,20);
        btDelete.setBounds(180,200,75,20);
        btSearch.setBounds(350, 200, 75, 20);
        tfId.setBounds(60,15,55,20);
        tfNome.setBounds(60,40,255,20);
        tfEspecie.setBounds(60,65,255,20);
        tfIdade.setBounds(60, 90, 55, 20);
        tfGenero.setBounds(60, 115, 86, 20);
        tfEixoY.setBounds(60, 140, 86, 20);
        tfEixoX.setBounds(60, 165, 86, 20);
        btUpdate.setBounds(265, 200, 75, 20);
        btquickSort.setBounds(350, 169, 99, 20);
        btBubble.setBounds(265, 169, 75, 20);
        scrollPane.setBounds(10, 231, 500, 177);

        getContentPane().add(lblId);
        getContentPane().add(lblNome);
        getContentPane().add(lblEspecie);
        getContentPane().add(lblIdade);
        getContentPane().add(btCreate);
        getContentPane().add(btRead);
        getContentPane().add(btDelete);
        getContentPane().add(btSearch);
        getContentPane().add(tfId);
        getContentPane().add(tfNome);
        getContentPane().add(tfEspecie);
        getContentPane().add(tfIdade);
        getContentPane().add(btUpdate);
        getContentPane().add(btquickSort);
        getContentPane().add(btBubble);
        getContentPane().add(scrollPane);
        getContentPane().add(lblEixoY);
        getContentPane().add(lblEixoX);
        getContentPane().add(tfEixoX);
        getContentPane().add(lblGenero);
        getContentPane().add(tfEixoY);
        getContentPane().add(tfGenero);

        getTable().setForeground(new Color(0, 0, 0));
        getTable().setFont(new Font("Tahoma", Font.BOLD, 11));
        getTable().setModel(new DefaultTableModel(
        	new Object[][] {
        		},
        	new String[] {
        		"ID", "Nome", "Esp\u00E9cie", "Idade", "G\u00EAnero", "Eixo Y", "Eixo X"
        	}
        ));
        scrollPane.setViewportView(getTable());
        tartarugas = new Tartarugas();
        
    }	
    
    // O MÉTODO definirEventos AGRUPA OS EVENTOS DE TODOS OS BOTÕES
	public void definirEventos() {
	/* AQUI É AÇÃO DO BOTÃO DELETE, NESSE MÉTODO FAZEMOS A CHAMADA DO MÉTODO PRESENTE NA CLASSE TARTARUGA
	 * APÓS A AÇÃO DO MÉTODO DELETAR, OS TEXTFIELDS SÃO DEFINIDOS COMO VAZIOS, LIMPANDO AS INFORMAÇÕES QUE FORAM DELETADAS
	 */
	btDelete.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			tartarugas.deletar();
			btRead.doClick();
			tfId.setText("");
            tfNome.setText("");
            tfEspecie.setText("");
            tfIdade.setText("");
            tfGenero.setText("");
            tfEixoY.setText("");
            tfEixoX.setText("");
		}
	});
	/* BOTÃO CREATE! PARA QUE POSSAMOS CRIAR OS REGISTROS NO TXT
	 * FAZEMOS UMA SÉRIE DE VERIFICAÇÕES, COMO EXEMPLO: NENHUM DOS TEXTFIELDS PODEM ESTAR VAZIOS PARA CRIAÇÃO
	 * APÓS VERIFICAR QUE TODOS OS TEXTFIELDS, OS DADOS SÃO ENVIADOS PARA O MÉTODO GRAVAR DA CLASSE TARTARUGA
	 * PARA QUE O NOVO REGISTRO SEJA ADICIONADO NO TXT.
	 */
	btCreate.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (tfId.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "O ID não pode estar vazio!");
				tfId.requestFocus();
			} else if (tfId.getText().length() > 3) {
					JOptionPane.showMessageDialog(null, "O ID não pode ter mais que 3 caracteres!");
					tfId.requestFocus();	
			} else if (tfNome.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "O nome não pode estar vazio!");
				tfNome.requestFocus();
			} else if (tfEspecie.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "A espécie não pode estar vazio!");
				tfEspecie.requestFocus();					
			} else if (tfIdade.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "A idade não pode estar vazio!");
				tfIdade.requestFocus();
			} else if (tfGenero.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "A gênero não pode estar vazio!");
				tfGenero.requestFocus(); 
			} else if (tfEixoY.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "O Eixo Y e não pode estar vazio!");
				tfEixoY.requestFocus();
			} else if (tfEixoX.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "O Eixo X não pode estar vazio!");
				tfEixoX.requestFocus();
			} else {
				
				tartarugas.setId(tfId.getText()); 
				tartarugas.setNome(tfNome.getText());
				tartarugas.setEspecie(tfEspecie.getText());
				tartarugas.setGenero(tfGenero.getText());
				tartarugas.setIdade(tfIdade.getText());
				tartarugas.setEixoY(tfEixoY.getText());
				tartarugas.setEixoX(tfEixoX.getText());
				tartarugas.gravar();
			}
		}
	});
	
	/*NO BOTÃO READ, TEMOS UM MÉTODO PARA DEFINIR 
 	 *QUANTIDADE DE LINHAS QUE SERÃO NECESSÁRIAS PARA OCUPAR TODOS OS DADOS DO TXT NA TABELA,
 	 *ALÉM DE LER OS DADOS NO TXT E ORGANIZAR NAS COLUNAS DA TABELA
 	 *COMO TAMBÉM TEMOS PARA APAGAR OS DADOS QUE ESTÃO NA TABELA, PARA QUE NÃO FIQUE DUPLICANDO OS DADOS DO TXT NA TABELA
 	 *TODA VEZ QUE O BOTÃO É ACIONADO.
	*/
	btRead.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try {
                DefaultTableModel otm = (DefaultTableModel) table.getModel();
                int l=otm.getRowCount(); 
                 while(l>0) {
                     ((DefaultTableModel) table.getModel()).removeRow(l-1);
                     l--;
                }
                Charset cs = Charset.forName("UTF-8");
                BufferedReader br = new BufferedReader(new FileReader(caminho, cs));
                Object [] vetorLinhas = br.lines().toArray();

                for(int i = 0; i <vetorLinhas.length; i++) {
                    String linha = vetorLinhas[i].toString().trim();
                    String [] coluna = linha.split(";");
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.addRow(coluna);
                }
            
                br.close();

            } catch (IOException erro) {
            return;
            }
        }
    });
	
	/*BOTÃO SEARCH!
	 * NESSE BOTÃO PRIMEIRAMENTE PEDIMOS QUE FORNEÇA O ID QUE DESEJA BUSCAR,
	 * APÓS ISSO, É FEITO UMA VERIFICAÇÃO PARA CHECAR SE O ID EXISTE NO NOSSOS REGISTROS
	 * SE O ID EXISTIR NOS REGISTRO, COLOCAMOS TODAS AS INFORMAÇÕES RELACIONADAS AO ID NOS RESPECTIVOS TEXTFIELD
	 * CASO NÃO EXISTA, É RETORNADO UMA MENSAGEM ALEGANDO QUE O ID NÃO EXISTE.
	 */
     btSearch.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             try {
        	 File originalFile = new File(caminho);
        	 String pID = JOptionPane.showInputDialog(null, "Forneça o ID para pesquisar:");
        	 Charset cs = Charset.forName("UTF-8");
             BufferedReader br = new BufferedReader(new FileReader(originalFile, cs));
             Object [] vetorLinhas = br.lines().toArray();
             boolean aux = false;

             for(int i = 0; i <vetorLinhas.length; i++) {
            	 String linha = vetorLinhas[i].toString().trim();
                 String [] coluna = linha.split(";");
                 if (coluna[0].equals(pID)) {
                	 tfId.setText(coluna[0]);
     				tfNome.setText(coluna[1]);
     				tfEspecie.setText(coluna[2]);
     				tfIdade.setText(coluna[3]);
     				tfGenero.setText(coluna[4]);
     				tfEixoY.setText(coluna[5]);
     				tfEixoX.setText(coluna[6]);
     				aux = true;
                     }
             }
             if (aux == false) {
            	 JOptionPane.showMessageDialog(null, "Pessoa não encontrada");
             }
             br.close();
         } catch (IOException erro) {
        	 System.out.println("Código invalido");
             return;
         }
         
         }
     });
     
     /*NO BOTÃO UPDATE, SEGUIMOS O MESMO EXEMPLO DO BOTÃO CREATE, SENDO OBRIGATORIO O PREENCHIMENTO DE TODOS OS CAMPOS
      * COM ISSO DITO, É FEITO A VERIFICAÇÃO SE TODOS OS CAMPOS ESTÃO PREENCHIDOS. 
      * APÓS ESSA VERIFICAÇÃO, OS DADOS FORNECIDOS SÃO ENVIADOS AO MÉTODO UPDATE DA CLASSE TARTARUGA
      * ONDE SERÁ EXECUTADO A ATUALIZAÇÃO DO REGISTRO.
      */
     btUpdate.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 if (tfId.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "O código não pode estar vazio!");
				tfId.requestFocus();
			} else if (tfNome.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "O nome não pode estar vazio!");
				tfNome.requestFocus();
			} else if (tfEspecie.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "A espécie não pode estar vazio!");
				tfEspecie.requestFocus();					
			} else if (tfIdade.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "A idade não pode estar vazio!");
				tfIdade.requestFocus();
			} else if (tfGenero.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "A gênero não pode estar vazio!");
				tfGenero.requestFocus(); 
			} else if (tfEixoY.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "O Eixo Y e não pode estar vazio!");
				tfEixoY.requestFocus();
			} else if (tfEixoX.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "O Eixo X não pode estar vazio!");
				tfEixoX.requestFocus();
			} else {
				tartarugas.setId(tfId.getText()); 
				tartarugas.setNome(tfNome.getText());
				tartarugas.setEspecie(tfEspecie.getText());
				tartarugas.setGenero(tfGenero.getText());
				tartarugas.setIdade(tfIdade.getText());
				tartarugas.setEixoY(tfEixoY.getText());
				tartarugas.setEixoX(tfEixoX.getText());
				tartarugas.atualizar();
				btRead.doClick();
			}
		}
     });
     /* NO BOTÃO QUICKSORT INICIALIZAMOS A CLASSE QUICKSORT
      * E É CHAMADO O MÉTODO SORT RESPONSÁVEL PELA ORDENAÇÃO DO TXT
      * APÓS A EXECUÇÃO DO MÉTODO, É EXIBIDO UMA MENSAGEM AO USUÁRIO 
      * COM O TEMPO QUE FOI NECESSÁRIO PARA A EXECUÇÃO DA ORDENAÇÃO
      */
     btquickSort.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 QuickSort sort = new QuickSort();
        	 try {
        		 long tempoInicial = System.currentTimeMillis();
        		 sort.ordenarSort();
        		 long tempoFinal = System.currentTimeMillis();
        		 JOptionPane.showMessageDialog(null,"Arquivo ordenado com sucesso!\n"
        				 + "Executado em = " + (tempoFinal - tempoInicial) + " ms");
        	 } catch (IOException error) {
        		 error.printStackTrace();
        	 }
         }
     });
     /* NO BOTÃO BUBBLE INICIALIZAMOS A CLASSE BUBBLE
      * E É CHAMADO O MÉTODO SORT RESPONSÁVEL PELA ORDENAÇÃO DO TXT
      * APÓS A EXECUÇÃO DO MÉTODO, É EXIBIDO UMA MENSAGEM AO USUÁRIO 
      * COM O TEMPO QUE FOI NECESSÁRIO PARA A EXECUÇÃO DA ORDENAÇÃO
      */
     btBubble.addActionListener(new ActionListener() {
    	 public void actionPerformed(ActionEvent e) {
    		 BubbleSort sort = new BubbleSort();
    		 try {
    			 long tempoInicial = System.currentTimeMillis();
    			 sort.ordenarBubble();
    			 long tempoFinal = System.currentTimeMillis();
    			 JOptionPane.showMessageDialog(null,"Arquivo ordenado com sucesso!\n"
    					 + "Executado em = " + (tempoFinal - tempoInicial) + " ms");
    		 } catch (IOException error) {
    			 error.printStackTrace();
    		 }
    	 }
     });

	}
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
}
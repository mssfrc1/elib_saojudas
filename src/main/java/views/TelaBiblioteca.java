/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */    
package views;  

import controllers.LivroController;
import controllers.UserController;
import models.Livro;

import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

/**
 *
 * @author USER
 */
public class TelaBiblioteca extends javax.swing.JFrame {

    static String DIR_PAI_IMAGEM = "teste";
    /**
     * Creates new form TelaBiblioteca
     */
    public TelaBiblioteca() {
        super("E-Library");
        initComponents();
        setLocationRelativeTo(null);
    }

    public static List<Livro> getLivros( ) {
        return LivroController.getAllLivros();
    }

    public static void RenderizaLivros() {
        var livros = getLivros();
        jframe_info.setLayout(new GridLayout(0, 3));

        for (Livro livro : livros) {
            // Cria o painel e define a orientação dele
            JPanel bookPanel = new JPanel();
            bookPanel.setLayout(new BoxLayout(bookPanel, BoxLayout.Y_AXIS));

            // Label responsável pela Imagem
            JLabel imageLabel = new JLabel();

            // Atribuição de imagem ao Label
            ImageIcon icon = new ImageIcon(DIR_PAI_IMAGEM + "/" + livro.getCapa());
            icon = new ImageIcon(icon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
            imageLabel.setIcon(icon);

            // Label responsável pelo nome do Livro
            JLabel titleLabel = new JLabel(livro.getNome());

            // Centralização dos Elementos
            imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

            // Borda da Imagem para o título
            imageLabel.setBorder(new EmptyBorder(0, 0, 5, 0));

            // Adicionar os Componentes(Imagem + Título) ao Painel
            bookPanel.add(imageLabel);
            bookPanel.add(titleLabel);

            bookPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    JFrame frame = new JFrame("Descrição do Livro " + livro.getNome());
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setSize(600, 400);

                    // Cria um painel para colocar os componentes
                    JPanel panel = new JPanel(new GridBagLayout());
                    frame.add(panel);

                    // Label de título
                    JLabel labelTitulo = new JLabel(livro.getNome());
                    labelTitulo.setFont(new Font("Arial", Font.BOLD, 20));
                    labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);

                    // Adiciona o rótulo do título ao topo do JFrame
                    frame.add(labelTitulo, BorderLayout.PAGE_START);

                    // Label de imagem
                    ImageIcon imagem = new ImageIcon("D:/Programacao/Java/facu_elib/src/main/java/views/images/duna.jpeg");
                    JLabel labelImagem = new JLabel(imagem);
                    panel.add(labelImagem);

                    // Área de texto para a descrição
                    JTextArea textAreaDescricao = new JTextArea("Sinopse: " + livro.getSinopse());
                    textAreaDescricao.setWrapStyleWord(true);
                    textAreaDescricao.setLineWrap(true);
                    textAreaDescricao.setOpaque(false);
                    textAreaDescricao.setEditable(false);
                    textAreaDescricao.setFocusable(false);

                    // Crie um painel para a descrição com fundo cinza
                    JPanel descricaoPanel = new JPanel();
                    descricaoPanel.setBackground(new Color(242, 242, 242));
                    descricaoPanel.setLayout(new BorderLayout());
                    descricaoPanel.add(textAreaDescricao, BorderLayout.CENTER);

                    // Use GridBagConstraints para fazer o painel da descrição ocupar todo o espaço
                    // horizontal
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.fill = GridBagConstraints.BOTH;
                    gbc.weightx = 1.0;
                    gbc.gridwidth = GridBagConstraints.REMAINDER;
                    panel.add(descricaoPanel, gbc);

                    // Botão para abrir o arquivo PDF local
                    JButton botaoAbrirPDF = new JButton("Abrir PDF do Livro");
                    botaoAbrirPDF.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                File arquivoPDF = new File("Caminho PDF"); 
                                Desktop.getDesktop().open(arquivoPDF);
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }
                    });
                    panel.add(botaoAbrirPDF);
                    // Exibe o JFrame
                    frame.setVisible(true);
                }
            });

            // Adicionar o Painel no FrameVisual
            jframe_info.add(
                    bookPanel);
        }
        // Tamanho do FrameVisual e atualização após cada Loop
        jframe_info.setPreferredSize(new Dimension(800, 600));
        jframe_info.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jframe_info = new javax.swing.JInternalFrame();
        menu = new javax.swing.JMenuBar();
        itemBiblioteca = new javax.swing.JMenu();
        menuLivro_ver = new javax.swing.JMenuItem();
        menuLivro_Pesquisar = new javax.swing.JMenuItem();
        menuLivro_Cadastro = new javax.swing.JMenuItem();
        itemClientes = new javax.swing.JMenu();
        menuCliente_Pesquisar = new javax.swing.JMenuItem();
        menuCliente_Cadastro = new javax.swing.JMenuItem();
        itemAvaliacao = new javax.swing.JMenu();
        menuAvalia_Fazer = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jframe_info.setVisible(true);

        javax.swing.GroupLayout jframe_infoLayout = new javax.swing.GroupLayout(jframe_info.getContentPane());
        jframe_info.getContentPane().setLayout(jframe_infoLayout);
        jframe_infoLayout.setHorizontalGroup(
            jframe_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
        );
        jframe_infoLayout.setVerticalGroup(
            jframe_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 351, Short.MAX_VALUE)
        );

        itemBiblioteca.setText("Biblioteca");
        itemBiblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemBibliotecaActionPerformed(evt);
            }
        });

        menuLivro_ver.setText("Ver Livros");
        menuLivro_ver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLivro_verActionPerformed(evt);
            }
        });
        itemBiblioteca.add(menuLivro_ver);

        menuLivro_Pesquisar.setText("Pesquisar Livros");
        menuLivro_Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLivro_PesquisarActionPerformed(evt);
            }
        });
        itemBiblioteca.add(menuLivro_Pesquisar);

        menuLivro_Cadastro.setText("Cadastrar Livros");
        menuLivro_Cadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLivro_CadastroActionPerformed(evt);
            }
        });
        itemBiblioteca.add(menuLivro_Cadastro);

        menu.add(itemBiblioteca);

        itemClientes.setText("Clientes");

        menuCliente_Pesquisar.setText("Pesquisar Cliente");
        menuCliente_Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCliente_PesquisarActionPerformed(evt);
            }
        });
        itemClientes.add(menuCliente_Pesquisar);

        if (UserController.verificacaoUsuarioAdmin(views.TelaLogin.passarUser())) {
            menuCliente_Cadastro.setText("Cadastrar Cliente");
            menuCliente_Cadastro.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    menuCliente_CadastroActionPerformed(evt);
                }
            });
            itemClientes.add(menuCliente_Cadastro);
        }

        menu.add(itemClientes);

        itemAvaliacao.setText("Avaliações");

        menuAvalia_Fazer.setText("Fazer Avaliação");
        menuAvalia_Fazer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAvalia_FazerActionPerformed(evt);
            }
        });
        itemAvaliacao.add(menuAvalia_Fazer);

        menu.add(itemAvaliacao);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jframe_info)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jframe_info, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        RenderizaLivros();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void menuLivro_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLivro_PesquisarActionPerformed
        var TelaEditLivros = new TelaEditLivros();
        TelaEditLivros.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuLivro_PesquisarActionPerformed

    private void itemBibliotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemBibliotecaActionPerformed
        
    }//GEN-LAST:event_itemBibliotecaActionPerformed

    private void menuLivro_CadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLivro_CadastroActionPerformed
        var TelaCadastroLivro = new TelaCadastroLivro();
        TelaCadastroLivro.setVisible(true);
    }//GEN-LAST:event_menuLivro_CadastroActionPerformed

    private void menuCliente_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCliente_PesquisarActionPerformed
        var TelaEditClient = new TelaEditClient();
        TelaEditClient.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuCliente_PesquisarActionPerformed

    private void menuCliente_CadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCliente_CadastroActionPerformed
        var TelaCadastroClient = new TelaCadastroClient();
        TelaCadastroClient.setVisible(true);
    }//GEN-LAST:event_menuCliente_CadastroActionPerformed

    private void menuAvalia_FazerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAvalia_FazerActionPerformed
        var TelaAvaliacao = new TelaAvaliacao();
        TelaAvaliacao.setVisible(true);
        dispose();
    }//GEN-LAST:event_menuAvalia_FazerActionPerformed

    private void menuLivro_verActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        var TelaBiblioteca = new TelaBiblioteca();
        TelaBiblioteca.setVisible(true);
        dispose();        
    }                                                                           

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaBiblioteca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu itemAvaliacao;
    private javax.swing.JMenu itemBiblioteca;
    private javax.swing.JMenu itemClientes;
    private static javax.swing.JInternalFrame jframe_info;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenuItem menuAvalia_Fazer;
    private javax.swing.JMenuItem menuCliente_Cadastro;
    private javax.swing.JMenuItem menuCliente_Pesquisar;
    private javax.swing.JMenuItem menuLivro_Cadastro;
    private javax.swing.JMenuItem menuLivro_Pesquisar;
    private javax.swing.JMenuItem menuLivro_ver;
    // End of variables declaration//GEN-END:variables
}
package views.livro;

import controllers.LivroController;
import controllers.UserController;
import models.Livro;
import models.User;
import views.avaliacao.TelaAvaliacao;
import views.usuario.TelaCadastroClient;
import views.usuario.TelaEditClient;
import views.usuario.TelaUsuario;

import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.net.*;

/**
 *
 * @author USER
 */
public class TelaBiblioteca extends javax.swing.JFrame {
    
    private User usuarioLogado = UserController.usuarioLogado;

    /**
     * Creates new form TelaBiblioteca
     */
    public TelaBiblioteca() {
        super("E-Library");
        initComponents();
        setLocationRelativeTo(null);
    }

    public static List<Livro> getLivros() {
        return LivroController.getAllLivros();

    }

    private static ImageIcon loadImagemFromUrl(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            return new ImageIcon(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void RenderizaLivros() {
        
        var livros = getLivros();

        // Crie um JPanel com GridLayout para alinhar os livros em 3 colunas
        JPanel jPanel1 = new JPanel(new GridLayout(0, 3)); // 0 significa que o número de linhas é determinado automaticamente

        // Calcule o tamanho máximo para a imagem
        Dimension frameSize = jScrollPane1.getSize(); // Obtém o tamanho do JScrollPane (assumindo que seja igual ao tamanho do JFrame)
        int maxImageWidth = (int) (frameSize.getWidth() * 0.2); // 20% do tamanho do JFrame
        int maxImageHeight = (int) (frameSize.getHeight() * 0.4); // 40% do tamanho do JFrame

        for (Livro livro : livros) {
            // Crie um JPanel para cada livro com BoxLayout e alinhamento central
            JPanel livroPanel = new JPanel();
            livroPanel.setLayout(new BoxLayout(livroPanel, BoxLayout.Y_AXIS));
            livroPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Espaçamento de 10px em todas as direções
            livroPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centralize horizontalmente

            ImageIcon icon = null;

            if (livro.getCapa() != null) {
                icon = loadImagemFromUrl(livro.getCapa());
            } else {
                icon = new ImageIcon("src/main/java/views/media/images/capaBranca.jpeg");
            }
            // Redimensione a imagem para o tamanho máximo
            Image scaledImage = icon.getImage().getScaledInstance(maxImageWidth, maxImageHeight, Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaledImage);

            // Crie um JLabel com o ícone de imagem redimensionado e espaçamento entre a
            // imagem e o JLabel
            JLabel labelComIcon = new JLabel(icon);
            labelComIcon.setAlignmentX(Component.CENTER_ALIGNMENT); // Centralize horizontalmente
            labelComIcon.setBorder(new EmptyBorder(0, 0, 5, 0)); // Espaçamento de 5px na parte inferior

            // Crie um JLabel com o título do livro e centralize-o horizontalmente
            JLabel tituloLabel = new JLabel(livro.getNome());
            tituloLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centralize horizontalmente

            JLabel mediaLabel = new JLabel("Média: " + livro.getMedia());
            mediaLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centralize horizontalmente

            livroPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    DescricaoLivro livroFrame = new DescricaoLivro(livro);
                    livroFrame.setVisible(true);
                }
            });
            // Adicione os componentes ao JPanel do livro
            livroPanel.add(labelComIcon);
            livroPanel.add(tituloLabel);
            livroPanel.add(mediaLabel);

            // Adicione o JPanel do livro ao JPanel principal
            jPanel1.add(livroPanel);
            
        }
        jScrollPane1.setViewportView(jPanel1);
        jScrollPane1.revalidate();
        jScrollPane1.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        btn_usuario = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btn_refresh = new javax.swing.JButton();
        menu = new javax.swing.JMenuBar();
        itemBiblioteca = new javax.swing.JMenu();
        menuLivro_Pesquisar = new javax.swing.JMenuItem();
        menuLivro_Cadastro = new javax.swing.JMenuItem();
        itemClientes = new javax.swing.JMenu();
        menuCliente_Pesquisar = new javax.swing.JMenuItem();
        menuCliente_Cadastro = new javax.swing.JMenuItem();
        itemAvaliacao = new javax.swing.JMenu();
        menuAvalia_Fazer = new javax.swing.JMenuItem();

        if (usuarioLogado.getAdmin() != true) {
            itemClientes.setVisible(false);
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btn_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/media/images/usuario.jpg"))); // NOI18N
        btn_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_usuarioActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Seja Bem Vindo (a), " + usuarioLogado.getNome());
        jLabel2.setToolTipText("");

        btn_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/media/images/refresh.jpg"))); // NOI18N
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        itemBiblioteca.setText("Biblioteca");
        itemBiblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemBibliotecaActionPerformed(evt);
            }
        });

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

        menuCliente_Cadastro.setText("Cadastrar Cliente");
        menuCliente_Cadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCliente_CadastroActionPerformed(evt);
            }
        });
        menuCliente_Cadastro.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                menuCliente_CadastroPropertyChange(evt);
            }
        });
        itemClientes.add(menuCliente_Cadastro);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_usuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 3, Short.MAX_VALUE)
                        .addComponent(btn_usuario))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btn_refresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_usuarioActionPerformed
        var TelaUsuario = new TelaUsuario();
        TelaUsuario.setVisible(true);
    }//GEN-LAST:event_btn_usuarioActionPerformed

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        // TODO add your handling code here:
        // Metodo Redenrizar livros novamente
        RenderizaLivros();       
        JOptionPane.showMessageDialog(null, "Atualizado") ;
    }//GEN-LAST:event_btn_refreshActionPerformed

    protected void menuCliente_CadastroPropertyChange(PropertyChangeEvent evt) {
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowOpened
        RenderizaLivros();
    }// GEN-LAST:event_formWindowOpened

    private void menuLivro_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuLivro_PesquisarActionPerformed
        var TelaEditLivros = new TelaEditLivros();
        TelaEditLivros.setVisible(true);
        dispose();
    }// GEN-LAST:event_menuLivro_PesquisarActionPerformed

    private void itemBibliotecaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_itemBibliotecaActionPerformed

    }// GEN-LAST:event_itemBibliotecaActionPerformed

    private void menuLivro_CadastroActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuLivro_CadastroActionPerformed
        var TelaCadastroLivro = new TelaCadastroLivro();
        TelaCadastroLivro.setVisible(true);
    }// GEN-LAST:event_menuLivro_CadastroActionPerformed

    private void menuCliente_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuCliente_PesquisarActionPerformed
        var TelaEditClient = new TelaEditClient();
        TelaEditClient.setVisible(true);
        dispose();
    }// GEN-LAST:event_menuCliente_PesquisarActionPerformed

    private void menuCliente_CadastroActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuCliente_CadastroActionPerformed
        var TelaCadastroClient = new TelaCadastroClient();
        TelaCadastroClient.setVisible(true);
    }// GEN-LAST:event_menuCliente_CadastroActionPerformed

    private void menuAvalia_FazerActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuAvalia_FazerActionPerformed
        var TelaAvaliacao = new TelaAvaliacao();
        TelaAvaliacao.setVisible(true);
        dispose();
    }// GEN-LAST:event_menuAvalia_FazerActionPerformed

    private void menuLivro_verActionPerformed(java.awt.event.ActionEvent evt) {
        var TelaBiblioteca = new TelaBiblioteca();
        TelaBiblioteca.setVisible(true);
        dispose();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaBiblioteca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_refresh;
    private javax.swing.JButton btn_usuario;
    private javax.swing.JMenu itemAvaliacao;
    private javax.swing.JMenu itemBiblioteca;
    private javax.swing.JMenu itemClientes;
    private javax.swing.JLabel jLabel2;
    private static javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenuItem menuAvalia_Fazer;
    private javax.swing.JMenuItem menuCliente_Cadastro;
    private javax.swing.JMenuItem menuCliente_Pesquisar;
    private javax.swing.JMenuItem menuLivro_Cadastro;
    private javax.swing.JMenuItem menuLivro_Pesquisar;
    // End of variables declaration//GEN-END:variables
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views.Usuarios;

import views.Livro.TelaBiblioteca;
import views.Livro.TelaEditEmprest;
import views.Livro.TelaEditLivros;

/**
 *
 * @author USER
 */
public class TelaMenuAdmin extends javax.swing.JFrame {

    /**
     * Creates new form TelaMenuUsuario
     */
    public TelaMenuAdmin() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_editCLiente = new javax.swing.JButton();
        btn_editLivros = new javax.swing.JButton();
        btn_editEmprest = new javax.swing.JButton();
        btn_voltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(550, 350));
        setSize(new java.awt.Dimension(550, 350));

        btn_editCLiente.setText("Edição de Cliente");
        btn_editCLiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editCLienteActionPerformed(evt);
            }
        });

        btn_editLivros.setText("Editar Livros");
        btn_editLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editLivrosActionPerformed(evt);
            }
        });

        btn_editEmprest.setText("Edição de Empréstimo");
        btn_editEmprest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editEmprestActionPerformed(evt);
            }
        });

        btn_voltar.setText("VOLTAR");
        btn_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_editCLiente)
                .addGap(18, 18, 18)
                .addComponent(btn_editLivros)
                .addGap(18, 18, 18)
                .addComponent(btn_editEmprest)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_voltar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_editCLiente)
                    .addComponent(btn_editLivros)
                    .addComponent(btn_editEmprest))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(btn_voltar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_editCLienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editCLienteActionPerformed
        var TelaEditClient = new TelaEditClient();
        TelaEditClient.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_editCLienteActionPerformed

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        var TelaBiblioteca = new TelaBiblioteca();
        TelaBiblioteca.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_voltarActionPerformed

    private void btn_editLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editLivrosActionPerformed
        var TelaEditLivros = new TelaEditLivros();
        TelaEditLivros.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_editLivrosActionPerformed

    private void btn_editEmprestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editEmprestActionPerformed
        var TelaEditEmprest = new TelaEditEmprest();
        TelaEditEmprest.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_editEmprestActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel btn_editCLiente //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
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
            java.util.logging.Logger.getLogger(TelaMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMenuAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_editCLiente;
    private javax.swing.JButton btn_editEmprest;
    private javax.swing.JButton btn_editLivros;
    private javax.swing.JButton btn_voltar;
    // End of variables declaration//GEN-END:variables
}
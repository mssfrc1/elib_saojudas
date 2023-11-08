package views.Livro;

import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import models.Livro;

public class DescricaoLivro extends JFrame {
    public static final String DIR_PAI_IMAGEM = "/Users/macbookpro/Desktop";
    public DescricaoLivro(Livro livro) {
        setTitle("Detalhes do Livro");
        setSize(600, 450);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento interno

        // Crie um JLabel centralizado para o título
        JLabel titleLabel = new JLabel(livro.getNome());
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Ocupa duas colunas
        panel.add(titleLabel, gbc);

        // Crie um JLabel para a imagem
        ImageIcon icon = new ImageIcon(DIR_PAI_IMAGEM + "/" + livro.getCapa());
        int desiredWidht = (int) (getWidth() * 0.4);
        Image scaledImage = icon.getImage().getScaledInstance(desiredWidht, -1, Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(icon);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1; // Volta a ocupar apenas uma coluna
        panel.add(imageLabel, gbc);

        // Crie um JTextArea para a descrição
        JTextArea descricaoTextArea = new JTextArea(livro.getSinopse());
        descricaoTextArea.setWrapStyleWord(true);
        descricaoTextArea.setLineWrap(true);
        descricaoTextArea.setOpaque(false);
        descricaoTextArea.setEditable(false);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0; // Expande horizontalmente
        gbc.fill = GridBagConstraints.BOTH; // Expande em ambas as direções
        panel.add(new JScrollPane(descricaoTextArea), gbc);

        // Crie um botão para abrir o PDF
        JButton pdfButton = new JButton("Abrir PDF");
        pdfButton.addActionListener(new ActionListener() {
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
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2; // Ocupa duas colunas
        gbc.weightx = 0.0; // Não expande horizontalmente
        gbc.fill = GridBagConstraints.HORIZONTAL; // Expande horizontalmente
        panel.add(pdfButton, gbc);

        setContentPane(panel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}

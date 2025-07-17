package br.edu.ifpr.Busca;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BuscaView {
    private static void showView(){
        JFrame janela = new JFrame();
        janela.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JPanel contentPane = new JPanel();
        janela.setContentPane(contentPane);
        addSearchComponents(janela, contentPane);
        janela.pack();
        janela.setVisible(true);
    }

    private static void addSearchComponents(JFrame frame, JPanel panel){
        // Configurações de grid do panel
        panel.setLayout(new GridBagLayout());
        GridBagConstraints grid = new GridBagConstraints();

        ImageIcon backImage = new ImageIcon("br/edu/ifpr/resources/images/right-arrow.png");
        JButton back = new JButton(backImage);
        grid.gridx = 0;
        grid.gridy = 0;
        panel.add(back, grid);


        JLabel title = new JLabel("Busca");
        grid.gridx = 1;
        panel.add(title, grid);


        JLabel text =  new JLabel("Texto");
        grid.gridx = 0;
        grid.gridy = 1;
        panel.add(text, grid);

        JTextField textInput = new JTextField();
        textInput.setPreferredSize(new Dimension(50, 10));
        grid.gridx = 1;
        panel.add(textInput, grid);

        JLabel content = new JLabel("Conteúdo");
        String contentOptions[] = {"Animal", "Pessoa", "Adoção"};
        JComboBox contentCombo = new JComboBox(contentOptions);

        JButton search = new JButton("Buscar");

        // Tratamento do evento no botão de retorno
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        // Tratamento do evento do combobox
        contentCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textInput.setText("Máscara de dados");
            }
        });

        // Tratamento do evento do botão de busca
        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.out.print("BUSQUE CONHECIMENTO");
            }
        });

        // Posiciona
        panel.add(text);
        panel.add(textInput);
        panel.add(content);
        panel.add(contentCombo, BorderLayout.PAGE_END);

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                showView();
            }
        });

    }
}

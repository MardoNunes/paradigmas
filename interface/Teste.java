import javax.swing.*;
import java.awt.*;

public class Teste extends JFrame {
    
    public Teste() {
        // Configurações da janela
        setTitle("Minha Primeira Janela");
        setSize(400, 300); // Largura x Altura
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fechar ao clicar no 'X'

        // Definindo o layout da janela (FlowLayout é simples)
        setLayout(new java.awt.FlowLayout());

        //cor de fundo
        getContentPane().setBackground(Color.cyan);

        // Criando componentes
        JLabel label = new JLabel("Bem-vindo ao Java Swing!");
        JButton botao = new JButton("Clique aqui");


        // Adicionando uma ação ao botão
        botao.addActionListener(e -> JOptionPane.showMessageDialog(this, "Botão clicado!"));

        // Adicionando componentes à janela
        add(label);
        add(botao);

        // Tornando a janela visível`
        setVisible(true);
    }

    public static void main(String[] args) {
        // Criando e exibindo a janela na thread de interface gráfica
        SwingUtilities.invokeLater(Teste::new);
    }
}

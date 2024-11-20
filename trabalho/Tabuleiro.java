import javax.swing.*;
import java.awt.*;

public class Tabuleiro {
    public JPanel criarTelaTabuleiro() {
        JPanel painelTabuleiro = new JPanel();
        painelTabuleiro.setLayout(new GridLayout(1, 1));

        // Aqui você pode adicionar componentes para o tabuleiro, como imagens ou botões
        JLabel labelTabuleiro = new JLabel("Tabuleiro de Jogo", JLabel.CENTER);
        labelTabuleiro.setFont(new Font("Arial", Font.BOLD, 24));

        painelTabuleiro.add(labelTabuleiro);
        
        return painelTabuleiro;
    }
}

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Jogo {
    private JPanel painelJogo;  // Painel do jogo
    private CardLayout layout; // Gerencia as telas internas do jogo


    public Jogo() {
        painelJogo = new JPanel();
        layout = new CardLayout();
        painelJogo.setLayout(layout);

        // Adicionando telas internas do jogo
        painelJogo.add(criarTelaTabuleiro(), "TelaTabuleiro");
    }

    // Tela do tabuleiro
    private JPanel criarTelaTabuleiro() {
        JPanel painelTabuleiro = new JPanel();
        painelTabuleiro.setBackground(Color.GREEN); // Cor do fundo representando o tabuleiro
        painelTabuleiro.setLayout(new BorderLayout());

        JLabel labelTabuleiro = new JLabel("Tabuleiro do Jogo");
        labelTabuleiro.setHorizontalAlignment(SwingConstants.CENTER);
        labelTabuleiro.setFont(new Font("Arial", Font.BOLD, 24));
        painelTabuleiro.add(labelTabuleiro, BorderLayout.CENTER);

        return painelTabuleiro;
    }

    // Métodos para acessar o painel e o layout
    public JPanel getPainelJogo() {
        return painelJogo;
    }

    public CardLayout getLayout() {
        return layout;
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Jogo {
    private JFrame janela;
    private CardLayout cardLayout;
    private JPanel painelPrincipal;
    private Tabuleiro tabuleiro;
    private Jogador jogador;

    public Jogo() {
        janela = new JFrame("Banco Imobiliário");
        cardLayout = new CardLayout();
        painelPrincipal = new JPanel(cardLayout);

        // Inicializa os componentes
        tabuleiro = new Tabuleiro();
        jogador = new Jogador("Jogador 1");

        // Adiciona telas
        painelPrincipal.add(tabuleiro.criarTelaTabuleiro(), "Tabuleiro");
        painelPrincipal.add(criarTelaAcoes(), "Ações");

        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(1280, 720);
        janela.add(painelPrincipal);
        janela.setVisible(true);
    }

    // Método para acessar o CardLayout e painelPrincipal
    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getPainelPrincipal() {
        return painelPrincipal;
    }

    public void iniciarJogo() {
        cardLayout.show(painelPrincipal, "Tabuleiro"); // Mostra o tabuleiro primeiro
    }

    // Método para criar a tela de ações do jogador
    private JPanel criarTelaAcoes() {
        JPanel painelAcoes = new JPanel();
        painelAcoes.setLayout(new BorderLayout());

        // Botão para jogar os dados
        JButton jogarDadosButton = new JButton("Jogar Dados");
        jogarDadosButton.addActionListener(e -> {
            // Logica para jogar os dados e mudar o turno ou a tela
            JOptionPane.showMessageDialog(janela, "Dados jogados!");
            cardLayout.show(painelPrincipal, "Tabuleiro"); // Vai para a tela do tabuleiro
        });

        painelAcoes.add(jogarDadosButton, BorderLayout.CENTER);

        return painelAcoes;
    }

}

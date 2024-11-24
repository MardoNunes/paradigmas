import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Jogo {
    private JPanel painelJogo;  // Painel do jogo
    private CardLayout layout; // Gerencia as telas internas do jogo
    private Image imagemFundo;
    private int jogador1X, jogador1Y; // Posições do Jogador 1
    private int jogador2X, jogador2Y; // Posições do Jogador 2
    private int jogador1Passos, jogador2Passos; // Contador de passos para saber onde o jogador está

    private final int LARGURA_TABULEIRO = 800;  // Largura do tabuleiro
    private final int ALTURA_TABULEIRO = 650;  // Altura do tabuleir
    private final int TAMANHO_CASA = 74; // Tamanho de cada casa
    private final int DIMENSOES_CASA = 120;

    public Jogo() {
        painelJogo = new JPanel();
        layout = new CardLayout();
        painelJogo.setLayout(layout);

        // Posições iniciais dos jogadores
        jogador1X = 790;
        jogador1Y = 50;
        jogador2X = 100;
        jogador2Y = 50;

        // Contadores de passos
        jogador1Passos = 0;
        jogador2Passos = 0;

        // Adicionando telas internas do jogo
        painelJogo.add(criarTelaTabuleiro(), "TelaTabuleiro");
    }

    // Tela do tabuleiro
    private JPanel criarTelaTabuleiro() {
        JPanel painelTabuleiro = new JPanel();
        painelTabuleiro.setLayout(new BorderLayout());
        painelTabuleiro.setBackground(Color.GREEN);
    
        // Cria o painel central do tabuleiro
        JPanel painelCentralTabuleiro = new JPanel();
        painelCentralTabuleiro.setBackground(Color.GREEN);
        painelCentralTabuleiro.setLayout(new BorderLayout());
    
        // Cria o tabuleiro e adiciona ao painel central
        Tabuleiro tabuleiro = new Tabuleiro();
        painelCentralTabuleiro.add(tabuleiro, BorderLayout.CENTER);
    
        // Painel de informações dos jogadores (no topo à direita)
        JPanel painelInfoJogadores = criarPainelInfoJogadores();
    
        // Painel de informações do tabuleiro (no rodapé à direita)
        JPanel painelInfoTabuleiro = criarPainelInfoTabuleiro();
    
        // Painel lateral direito (contendo as informações)
        JPanel painelLateralDireito = new JPanel();
        painelLateralDireito.setLayout(new BorderLayout());
        painelLateralDireito.setBackground(Color.WHITE);
        painelLateralDireito.setPreferredSize(new Dimension(500, 500));
    
        painelLateralDireito.add(painelInfoJogadores, BorderLayout.NORTH);
        painelLateralDireito.add(painelInfoTabuleiro, BorderLayout.CENTER);
    
        // Adiciona os painéis ao layout principal
        painelTabuleiro.add(painelCentralTabuleiro, BorderLayout.CENTER); // Painel com o tabuleiro
        painelTabuleiro.add(painelLateralDireito, BorderLayout.EAST);     // Painéis de informação
    
        return painelTabuleiro;
    }
    

    // Função para criar o painel de informações dos jogadores
    private JPanel criarPainelInfoJogadores() {
        JPanel painelInfoJogadores = new JPanel();
        painelInfoJogadores.setLayout(new BoxLayout(painelInfoJogadores, BoxLayout.Y_AXIS));
        painelInfoJogadores.setBorder(BorderFactory.createTitledBorder("Informações dos Jogadores"));
        painelInfoJogadores.setBackground(Color.BLUE);
        painelInfoJogadores.setPreferredSize(new Dimension(200, 450));

        // Exemplo de informações de jogadores
        JLabel jogador1 = new JLabel("Jogador 1: 1500$");
        jogador1.setFont(new Font("Arial", Font.PLAIN, 16));
        JLabel jogador2 = new JLabel("Jogador 2: 1500$");
        jogador2.setFont(new Font("Arial", Font.PLAIN, 16));

        painelInfoJogadores.add(jogador1);
        painelInfoJogadores.add(jogador2);

        return painelInfoJogadores;
    }

    // Função para criar o painel de informações do tabuleiro
    private JPanel criarPainelInfoTabuleiro() {
        JPanel painelInfoTabuleiro = new JPanel();
        painelInfoTabuleiro.setLayout(new BoxLayout(painelInfoTabuleiro, BoxLayout.Y_AXIS));
        painelInfoTabuleiro.setBorder(BorderFactory.createTitledBorder("Informações do Tabuleiro"));
        painelInfoTabuleiro.setBackground(Color.GRAY);
        painelInfoTabuleiro.setPreferredSize(new Dimension(200, 250));

        // Exemplo de informações do tabuleiro
        JLabel info1 = new JLabel("Rodada Atual: 1");
        info1.setFont(new Font("Arial", Font.PLAIN, 16));
        JLabel info2 = new JLabel("Propriedades Compradas: Nenhuma");
        info2.setFont(new Font("Arial", Font.PLAIN, 16));

        painelInfoTabuleiro.add(info1);
        painelInfoTabuleiro.add(info2);

        // Botão de rolar os dados
        JButton btnRodarDados = new JButton("Rodar Dados");
        btnRodarDados.addActionListener(e -> rodarDados());

        painelInfoTabuleiro.add(btnRodarDados); // Adiciona o botão no painel de informações do tabuleiro

        return painelInfoTabuleiro;
    }

    // Função para mover os jogadores
    public void moverJogador(int jogador, int passos) {
        if (jogador == 1) {
            jogador1Passos += passos;
            // Atualiza a posição com base nos passos
            if (jogador1X <= LARGURA_TABULEIRO - TAMANHO_CASA) {
                //borda superiros
                jogador1X += passos * TAMANHO_CASA;
                jogador1Y = 50; // Posição fixa na borda superior
            } else if ((jogador1X > LARGURA_TABULEIRO - TAMANHO_CASA) && (jogador1Y < ALTURA_TABULEIRO - TAMANHO_CASA)) {
                //jogador1X = LARGURA_TABULEIRO - 50; // Borda direita
                System.out.println("Borda Direita");
                System.out.println(jogador1Y);
                jogador1Y += (passos * TAMANHO_CASA);
            } else if ((jogador1Y > ALTURA_TABULEIRO - TAMANHO_CASA) && (jogador1X <= LARGURA_TABULEIRO - TAMANHO_CASA)) {
                System.out.println("Borda de Baixo");
                System.out.println(jogador1Y);
                jogador1X -= (passos * TAMANHO_CASA);
                jogador1Y = ALTURA_TABULEIRO - 50; // Borda inferior
                System.out.println(jogador1Y);
            } else {
                System.out.println("Entrou aqui");
                jogador1X = 790; // Borda esquerda
                jogador1Y -= (passos * TAMANHO_CASA);
            }
        } else if (jogador == 2) {
            jogador2Passos += passos;
            // Lógica de movimento similar ao Jogador 1
            // Pode-se ajustar a posição de forma similar para o Jogador 2.
        }
        
        // Redesenha o painel após a movimentação
        painelJogo.repaint();
    }

    // Função que simula o lançamento de dados e move o jogador
    private void rodarDados() {
        // Gerar um número aleatório de 1 a 6 (como se fosse um dado)
        Random rand = new Random();
        int dados = 1; //rand.nextInt(6) + 1;
        
        // Exibir o valor do dado
        JOptionPane.showMessageDialog(painelJogo, "Você rolou: " + dados);
        
        // Mover o Jogador 1 (pode ser alterado para Jogador 2 ou alternar entre eles)
        moverJogador(1, dados);  // Jogador 1 é movido pela quantidade do dado
    }

    // Métodos para acessar o painel e o layout
    public JPanel getPainelJogo() {
        return painelJogo;
    }

    public CardLayout getLayout() {
        return layout;
    }
}

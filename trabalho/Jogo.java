import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.util.Vector;


public class Jogo {
    private JPanel painelJogo;  // Painel do jogo
    private CardLayout layout; // Gerencia as telas internas do jogo
    private Vector<Jogador> jogadores; // Vetor de jogadores
    private JogoModel jogoModel; 
   

    public Jogo() {
        painelJogo = new JPanel();
        layout = new CardLayout();
        painelJogo.setLayout(layout);

        //inciando vetor de jogadores
        jogadores = new Vector<Jogador>();
        
        


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
        painelCentralTabuleiro.setLayout(null); // Define layout absoluto para controle total
    
        // Cria o tabuleiro e adiciona ao painel central
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.setBounds(0, 0, 1200, 1080); // Define o tamanho e posição do tabuleiro
        painelCentralTabuleiro.add(tabuleiro); // Adiciona o tabuleiro ao painel

        // Cria os jogadores
        Jogador jogador1 = new Jogador("Mardo", 5000, Color.RED, 1);
        Jogador jogador2 = new Jogador("Professor", 5000, Color.BLUE, 0);



        // Adiciona os jogadores ao vetor
        jogadores.add(jogador1);
        jogadores.add(jogador2);

        // Adicionar jogadores ao tabuleiro
        tabuleiro.adicionarJogador(jogador1);
        tabuleiro.adicionarJogador(jogador2);

    
        // Cria o dado
        Dado dado = new Dado(600, 510);
        dado.setBounds(600, 510, 80, 80); // Define posição central do dado
        dado.setBackground(Color.WHITE);
        painelCentralTabuleiro.add(dado);
        dado.repaint(); // Desenha o dado
    
        // Botão para rolar o dado
        JButton botaoJogar = new JButton("Jogar Dado");
        botaoJogar.setBounds(600, 600, 120, 40); // Posiciona o botão abaixo do dado
        painelCentralTabuleiro.add(botaoJogar);
    
      

        // Painel de informações dos jogadores (no topo à direita)
        JPanel painelInfoJogadores = criarPainelInfoJogadores( jogador1, jogador2);
    
        // Painel de informações do tabuleiro (no rodapé à direita)
        JPanel painelInfoTabuleiro = criarPainelInfoTabuleiro();
    
        // Painel lateral direito (contendo as informações)
        JPanel painelLateralDireito = new JPanel();
        painelLateralDireito.setLayout(new BorderLayout());
        painelLateralDireito.setBackground(Color.WHITE);
        painelLateralDireito.setPreferredSize(new Dimension(730, 500));
    
        painelLateralDireito.add(painelInfoJogadores, BorderLayout.NORTH);
        painelLateralDireito.add(painelInfoTabuleiro, BorderLayout.CENTER);
    
        // Adiciona os painéis ao layout principal
        painelTabuleiro.add(painelCentralTabuleiro, BorderLayout.CENTER); // Painel com o tabuleiro
        painelTabuleiro.add(painelLateralDireito, BorderLayout.EAST);     // Painéis de informação

        jogador1.setVez(1); // Começa com o jogador 1
        jogador2.setVez(0);

        jogoModel = new JogoModel(jogadores, tabuleiro, dado);
        jogoModel.iniciarLoopJogo(botaoJogar, dado, tabuleiro, painelInfoJogadores);

        return painelTabuleiro;
        }
        
    

// Função para criar o painel de informações dos jogadores
private JPanel criarPainelInfoJogadores(Jogador jogador1, Jogador jogador2) {
    // Painel principal que contém os dois painéis dos jogadores
    JPanel painelInfoJogadores = new JPanel();
    painelInfoJogadores.setLayout(new GridLayout(1, 2, 10, 0)); // 1 linha, 2 colunas com espaçamento horizontal
    painelInfoJogadores.setBorder(BorderFactory.createTitledBorder("Informações dos Jogadores"));
    painelInfoJogadores.setBackground(Color.WHITE);
    painelInfoJogadores.setPreferredSize(new Dimension(600, 300)); // Largura e altura ajustadas

    // Painel para o jogador 1
    JPanel painelJogador1 = new JPanel();
    painelJogador1.setLayout(new BoxLayout(painelJogador1, BoxLayout.Y_AXIS));
    
    TitledBorder borderJogador1 = BorderFactory.createTitledBorder("Jogador 1");
    borderJogador1.setTitleColor(Color.RED); // Define a cor do título
    borderJogador1.setTitleFont(new Font("Arial", Font.BOLD, 14)); // Define o estilo do título
    painelJogador1.setBorder(borderJogador1);
    
    painelJogador1.setBackground(Color.LIGHT_GRAY); // Cor de fundo para destaque
    painelJogador1.setPreferredSize(new Dimension(300, 300));

    String dinheiro1 = String.valueOf(jogador1.getDinheiro());
    String nome1 = jogador1.getNome();
    JLabel labelJogador1 = new JLabel(nome1 + ": $" + dinheiro1);
    labelJogador1.setFont(new Font("Arial", Font.PLAIN, 16));
    painelJogador1.add(labelJogador1);

    // Painel para o jogador 2
    JPanel painelJogador2 = new JPanel();
    painelJogador2.setLayout(new BoxLayout(painelJogador2, BoxLayout.Y_AXIS));
    
    TitledBorder borderJogador2 = BorderFactory.createTitledBorder("Jogador 2");
    borderJogador2.setTitleColor(Color.BLUE); // Define a cor do título
    borderJogador2.setTitleFont(new Font("Arial", Font.BOLD, 14)); // Define o estilo do título
    painelJogador2.setBorder(borderJogador2);

    painelJogador2.setBackground(Color.LIGHT_GRAY); // Cor de fundo para destaque
    painelJogador2.setPreferredSize(new Dimension(300, 300));

    String dinheiro2 = String.valueOf(jogador2.getDinheiro());
    String nome2 = jogador2.getNome();
    JLabel labelJogador2 = new JLabel(nome2 + ": $" + dinheiro2);
    labelJogador2.setFont(new Font("Arial", Font.PLAIN, 16));
    painelJogador2.add(labelJogador2);

    // Adiciona os dois painéis ao painel principal
    painelInfoJogadores.add(painelJogador1);
    painelInfoJogadores.add(painelJogador2);

    return painelInfoJogadores;
}



    // Função para criar o painel de informações do tabuleiro
    private JPanel criarPainelInfoTabuleiro() {
        JPanel painelInfoTabuleiro = new JPanel();
        painelInfoTabuleiro.setLayout(new BoxLayout(painelInfoTabuleiro, BoxLayout.Y_AXIS));
        painelInfoTabuleiro.setBorder(BorderFactory.createTitledBorder("Informações do Tabuleiro"));
        painelInfoTabuleiro.setBackground(Color.WHITE);
        painelInfoTabuleiro.setPreferredSize(new Dimension(300, 250));

        // Exemplo de informações do tabuleiro
        JLabel info1 = new JLabel("Rodada Atual: 1");
        info1.setFont(new Font("Arial", Font.PLAIN, 16));
        JLabel info2 = new JLabel("Propriedades Compradas: Nenhuma");
        info2.setFont(new Font("Arial", Font.PLAIN, 16));

        painelInfoTabuleiro.add(info1);
        painelInfoTabuleiro.add(info2);


        return painelInfoTabuleiro;
    }


    // Métodos para acessar o painel e o layout
    public JPanel getPainelJogo() {
        return painelJogo;
    }

    public CardLayout getLayout() {
        return layout;
    }

    


}

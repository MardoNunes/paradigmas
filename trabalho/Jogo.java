import javax.swing.*;
import java.awt.*;


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
        Jogador jogador1 = new Jogador("Jogador 1", 1500, Color.RED);
        Jogador jogador2 = new Jogador("Jogador 2", 1500, Color.BLUE);

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
    
        botaoJogar.addActionListener(e -> {
            dado.rollDice(); // Rola o dado
            dado.repaint(); // Atualiza a exibição do dado
        });


        
    
        // Painel de informações dos jogadores (no topo à direita)
        JPanel painelInfoJogadores = criarPainelInfoJogadores();
    
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
    
        return painelTabuleiro;
        }
        
    

    // Função para criar o painel de informações dos jogadores
    private JPanel criarPainelInfoJogadores() {
        JPanel painelInfoJogadores = new JPanel();
        painelInfoJogadores.setLayout(new BoxLayout(painelInfoJogadores, BoxLayout.Y_AXIS));
        painelInfoJogadores.setBorder(BorderFactory.createTitledBorder("Informações dos Jogadores"));
        painelInfoJogadores.setBackground(Color.BLUE);
        painelInfoJogadores.setPreferredSize(new Dimension(300, 450));

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
        painelInfoTabuleiro.setBackground(Color.YELLOW);
        painelInfoTabuleiro.setPreferredSize(new Dimension(300, 250));


        //apenas mostrar a casa que o jogador caiu e as informações dela
        //depois dar a opção de comprar ou não
        //se comprar, adicionar ao array de propriedades do jogador
        //se não, passar a vez



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


     //função que retorna a imagem da casa
    // //retornando a imagem de uma casa
    // CasaTabuleiro casa = tabuleiro.getCasasTabuleiro()[0];
    // System.out.println(casa.getNome());
    // System.out.println(casa.getValor());
    // System.out.println(casa.getAluguel());
    // System.out.println(casa.getCasa());

    // //desenhando a imagem da casa
    // ImageIcon image = new ImageIcon(casa.getImagem());
    // JLabel label = new JLabel(image);
    // painelCentralTabuleiro.add(label);
}

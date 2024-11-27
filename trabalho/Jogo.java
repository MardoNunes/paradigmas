import javax.swing.*;
import java.awt.*;
import java.util.Random;

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
        painelCentralTabuleiro.setLayout(new BorderLayout());
    
        // Cria o tabuleiro e adiciona ao painel central
        Tabuleiro tabuleiro = new Tabuleiro();
        painelCentralTabuleiro.add(tabuleiro, BorderLayout.CENTER);

        
        //Botao de rodar o dado
       //passar o dado para a função de criar o painel de informações do tabuleiro



    
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

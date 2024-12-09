import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.util.Vector;


public class Jogo {
    private JPanel painelJogo;  // Painel do jogo
    private CardLayout layout; // Gerencia as telas internas do jogo
    private Vector<Jogador> jogadores; // Vetor de jogadores
   

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
        Jogador jogador1 = new Jogador("Mardo", 1500, Color.RED, 1);
        Jogador jogador2 = new Jogador("Professor", 1500, Color.BLUE, 0);



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
   
        iniciarLoopJogo(botaoJogar, dado, tabuleiro, painelInfoJogadores);
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

    private void iniciarLoopJogo(JButton botaoJogar, Dado dado, Tabuleiro tabuleiro, JPanel painelInfoJogadores) {
        botaoJogar.addActionListener(e -> {
            // Determina o jogador atual com base na vez
            Jogador jogadorAtual = jogadores.stream().filter(j -> j.getVez() == 1).findFirst().orElse(null);
    
            if (jogadorAtual != null) {
                // Rola o dado
                dado.rollDice();
                int valorDado = dado.getValor();
    
                // Move o jogador atual no tabuleiro
                jogadorAtual.mover(valorDado, 
                    tabuleiro.getCasasTabuleiro().length, 
                    tabuleiro.getPosicao(jogadorAtual.getPosicaoAtual(), valorDado));
                
                // Obtém a casa onde o jogador caiu
                CasaTabuleiro casaAtual = tabuleiro.getCasasTabuleiro()[jogadorAtual.getPosicaoAtual()];
                atualizarPainelInfoTabuleiro(
                    (JPanel) painelInfoJogadores.getParent().getComponent(1), // Painel de informações do tabuleiro
                    jogadorAtual, 
                    casaAtual
                );
                
    
                // Atualiza informações visuais dos jogadores
                atualizarPainelInfoJogadores(painelInfoJogadores);
    
                // Passa a vez para o próximo jogador
                jogadores.forEach(j -> j.setVez(0)); // Zera todas as jogadas
                int indiceAtual = jogadores.indexOf(jogadorAtual);
                jogadores.get((indiceAtual + 1) % jogadores.size()).setVez(1);
    
                // Atualiza o dado na interface
                dado.repaint();
            }
        });
    }
    
  
    
    private void atualizarPainelInfoJogadores(JPanel painelInfoJogadores) {
        painelInfoJogadores.removeAll(); // Remove todos os componentes antigos
    
        // Recria o layout com as informações atualizadas
        jogadores.forEach(jogador -> {
            JPanel painelJogador = new JPanel();
            painelJogador.setLayout(new BoxLayout(painelJogador, BoxLayout.Y_AXIS));
            painelJogador.setBorder(BorderFactory.createTitledBorder(jogador.getNome()));
            
            JLabel labelDinheiro = new JLabel("Dinheiro: $" + jogador.getDinheiro());
            labelDinheiro.setFont(new Font("Arial", Font.PLAIN, 16));
            painelJogador.add(labelDinheiro);
    
            JLabel labelPosicao = new JLabel("Posição: " + jogador.getPosicaoAtual());
            labelPosicao.setFont(new Font("Arial", Font.PLAIN, 16));
            painelJogador.add(labelPosicao);
    
            // Indica de quem é a vez
            JLabel labelVez = new JLabel(jogador.getVez() == 1 ? "Sua vez!" : "");
            labelVez.setFont(new Font("Arial", Font.BOLD, 14));
            labelVez.setForeground(jogador.getVez() == 1 ? Color.RED : Color.BLACK);
            painelJogador.add(labelVez);
    
            painelInfoJogadores.add(painelJogador);
        });
    
        painelInfoJogadores.revalidate(); // Atualiza o layout
        painelInfoJogadores.repaint();   // Redesenha o painel
    }
    

    private void atualizarPainelInfoTabuleiro(JPanel painelInfoTabuleiro, Jogador jogadorAtual, CasaTabuleiro casaAtual) {
        painelInfoTabuleiro.removeAll(); // Limpa o painel
        
        painelInfoTabuleiro.setLayout(new BoxLayout(painelInfoTabuleiro, BoxLayout.Y_AXIS));
        painelInfoTabuleiro.setBorder(BorderFactory.createTitledBorder("Informações da Casa Atual"));
        painelInfoTabuleiro.setBackground(Color.WHITE);
        
        // Exibe o nome da casa
        JLabel labelNomeCasa = new JLabel("Casa: " + casaAtual.getNome());
        labelNomeCasa.setFont(new Font("Arial", Font.BOLD, 16));
        painelInfoTabuleiro.add(labelNomeCasa);
    
        // Exibe o valor da casa
        JLabel labelValorCasa = new JLabel("Valor: $" + casaAtual.getValor());
        labelValorCasa.setFont(new Font("Arial", Font.PLAIN, 14));
        painelInfoTabuleiro.add(labelValorCasa);
    
        // Exibe o aluguel da casa
        JLabel labelAluguelCasa = new JLabel("Aluguel: $" + casaAtual.getAluguel());
        labelAluguelCasa.setFont(new Font("Arial", Font.PLAIN, 14));
        painelInfoTabuleiro.add(labelAluguelCasa);
    
        // Adiciona a imagem da casa, se houver
        if (casaAtual.getImagem() != null) {
            ImageIcon imagemCasa = new ImageIcon(casaAtual.getImagem());
            JLabel labelImagemCasa = new JLabel(imagemCasa);
            painelInfoTabuleiro.add(labelImagemCasa);
        }
        
        // Adiciona opções de interação
        JPanel painelOpcoes = new JPanel();
        painelOpcoes.setLayout(new FlowLayout());
        painelOpcoes.setBackground(Color.WHITE);
    
        // Opção de comprar a casa, se disponível
        if (!casaAtual.isComprada()) {
            JButton botaoComprar = new JButton("Comprar");
            botaoComprar.addActionListener(e -> {
                if (jogadorAtual.getDinheiro() >= casaAtual.getValor()) {
                    jogadorAtual.setDinheiro(jogadorAtual.getDinheiro() - casaAtual.getValor());
                    casaAtual.setProprietario(jogadorAtual);
                    casaAtual.setComprada(true);
                    atualizarPainelInfoTabuleiro(painelInfoTabuleiro, jogadorAtual, casaAtual);
                    atualizarPainelInfoJogadores((JPanel) painelInfoTabuleiro.getParent().getComponent(0));
                    JOptionPane.showMessageDialog(painelInfoTabuleiro, "Você comprou a casa: " + casaAtual.getNome());
                } else {
                    JOptionPane.showMessageDialog(painelInfoTabuleiro, "Você não tem dinheiro suficiente para comprar esta casa.");
                }
            });
            painelOpcoes.add(botaoComprar);
        } else if (!casaAtual.getProprietario().equals(jogadorAtual)) {
            // Opção de pagar aluguel, se a casa pertence a outro jogador
            JButton botaoPagarAluguel = new JButton("Pagar Aluguel");
            botaoPagarAluguel.addActionListener(e -> {
                int aluguel = casaAtual.getAluguel();
                if (jogadorAtual.getDinheiro() >= aluguel) {
                    jogadorAtual.setDinheiro(jogadorAtual.getDinheiro() - aluguel);
                    Jogador proprietario = casaAtual.getProprietario();
                    proprietario.setDinheiro(proprietario.getDinheiro() + aluguel);
                    atualizarPainelInfoTabuleiro(painelInfoTabuleiro, jogadorAtual, casaAtual);
                    atualizarPainelInfoJogadores((JPanel) painelInfoTabuleiro.getParent().getComponent(0));
                    JOptionPane.showMessageDialog(painelInfoTabuleiro, "Você pagou $" + aluguel + " de aluguel para " + proprietario.getNome());
                } else {
                    JOptionPane.showMessageDialog(painelInfoTabuleiro, "Você não tem dinheiro suficiente para pagar o aluguel!");
                }
            });
            painelOpcoes.add(botaoPagarAluguel);
        }
    
        // Opção de passar a vez
        JButton botaoPassarVez = new JButton("Passar a Vez");
        botaoPassarVez.addActionListener(e -> {
            JOptionPane.showMessageDialog(painelInfoTabuleiro, "Você passou a vez!");
        });
        painelOpcoes.add(botaoPassarVez);
    
        painelInfoTabuleiro.add(painelOpcoes);
    
        painelInfoTabuleiro.revalidate(); // Atualiza o layout
        painelInfoTabuleiro.repaint();   // Redesenha o painel
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

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class JogoModel {

    private List<Jogador> jogadores;

    // Construtor
    public JogoModel(List<Jogador> jogadores, Tabuleiro tabuleiro, Dado dado) {
        this.jogadores = jogadores;
    }


    public void iniciarLoopJogo(JButton botaoJogar, Dado dado, Tabuleiro tabuleiro, JPanel painelInfoJogadores) {
        botaoJogar.addActionListener(e -> {
            // Determina o jogador atual com base na vez
            Jogador jogadorAtual = jogadores.stream().filter(j -> j.getVez() == 1).findFirst().orElse(null);
            
            if(jogadorAtual.isPrisao() == true){
                JOptionPane.showMessageDialog(painelInfoJogadores, "Você está preso, perdeu a vez!");
                jogadorAtual.setPrisao(false);
                jogadores.forEach(j -> j.setVez(0)); // Zera todas as jogadas
                int indiceAtual = jogadores.indexOf(jogadorAtual);
                jogadores.get((indiceAtual + 1) % jogadores.size()).setVez(1);
            }
            else if(jogadorAtual.isFerias() == true){
                JOptionPane.showMessageDialog(painelInfoJogadores, "Você está de férias, perdeu a vez!");
                jogadorAtual.setFerias(false);
                jogadores.forEach(j -> j.setVez(0)); // Zera todas as jogadas
                int indiceAtual = jogadores.indexOf(jogadorAtual);
                jogadores.get((indiceAtual + 1) % jogadores.size()).setVez(1);
            }
            else{

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
    
            // Adiciona as propriedades do jogador
            JLabel labelPropriedades = new JLabel("Propriedades:");
            labelPropriedades.setFont(new Font("Arial", Font.BOLD, 14));
            painelJogador.add(labelPropriedades);
    
            DefaultListModel<String> modeloPropriedades = new DefaultListModel<>();
            for (String propriedade : jogador.getPropriedades()) {
                modeloPropriedades.addElement(propriedade);
            }
    
            JList<String> listaPropriedades = new JList<>(modeloPropriedades);
            listaPropriedades.setFont(new Font("Arial", Font.PLAIN, 12));
            listaPropriedades.setVisibleRowCount(5); // Limita o número de linhas visíveis
            JScrollPane scrollPane = new JScrollPane(listaPropriedades);
            scrollPane.setPreferredSize(new Dimension(250, 100));
            painelJogador.add(scrollPane);
    
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
        painelOpcoes.setAlignmentX(Component.RIGHT_ALIGNMENT);
        painelOpcoes.setLayout(new FlowLayout());
        painelOpcoes.setBackground(Color.WHITE);

    


        //casas nao compráveis
        if(casaAtual.getCasa() == 1){
            jogadorAtual.setDinheiro(jogadorAtual.getDinheiro() + 200);
        }
        else if(casaAtual.getCasa() == 5){
            jogadorAtual.setDinheiro(jogadorAtual.getDinheiro() - 100);
        }
        else if(casaAtual.getCasa() == 10){
            jogadorAtual.setPrisao(true);
        }
        else if(casaAtual.getCasa() == 7){
            jogadorAtual.setFerias(true);
        }
        else if(casaAtual.getCasa() == 6 || casaAtual.getCasa() == 4){
            //faço nada
        }
        else{
        
            if (!casaAtual.isComprada()) {
                // Exibe botão de compra se a casa não está comprada
                JButton botaoComprar = new JButton("Comprar");
                botaoComprar.addActionListener(e -> {
                    if (jogadorAtual.getDinheiro() >= casaAtual.getValor()) {
                        jogadorAtual.setDinheiro(jogadorAtual.getDinheiro() - casaAtual.getValor());
                        jogadorAtual.adicionarPropriedade(casaAtual.getNome());
                        casaAtual.setNomeProprietario(jogadorAtual.getNome());
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
            } else if (!casaAtual.getProprietario().equals(jogadorAtual) && casaAtual.getProprietario() != null) {
                // Exibe botão de pagar aluguel se a casa pertence a outro jogador
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
            // JButton botaoPassarVez = new JButton("Passar a Vez");
            // botaoPassarVez.addActionListener(e -> {
            //     JOptionPane.showMessageDialog(painelInfoTabuleiro, "Você passou a vez!");
            // });
            // painelOpcoes.add(botaoPassarVez);
        
            painelInfoTabuleiro.add(painelOpcoes);
        
            painelInfoTabuleiro.revalidate(); // Atualiza o layout
            painelInfoTabuleiro.repaint();   // Redesenha o painel
        }
    }
    

}

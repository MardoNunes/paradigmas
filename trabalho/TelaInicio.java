import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicio {
    private JFrame telaInicio;  // Mantém a tela inicial
    private JFrame telaEscolha;  // Mantém a tela de escolha de jogadores
    private JPanel painelPrincipal;  // Painel principal que conterá as diferentes "telas"
    private CardLayout layout;  // Layout que gerencia as trocas de telas
    private JButton jogar;
    private JButton sair;
    private Image imagemFundo;

    public TelaInicio() {
        // Configurando a janela principal
        this.telaInicio = new JFrame();  // Mantém a variável telaInicio para a janela principal
        telaInicio.setTitle("Banco Imobiliário");
        telaInicio.setSize(1280, 720);
        telaInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaInicio.setLayout(new BorderLayout());

        // Inicializar o CardLayout e o painel principal
        layout = new CardLayout();
        painelPrincipal = new JPanel(layout);

        // Adiciona a primeira tela (tela inicial)
        painelPrincipal.add(criarTelaInicial(), "TelaInicial");

        // Adiciona a tela de escolha de jogadores
        painelPrincipal.add(criarTelaEscolha(), "EscolhaJogadores");

        // Adiciona o painel principal ao JFrame
        telaInicio.add(painelPrincipal);
        telaInicio.setVisible(true);
    }

    // Método para criar a tela inicial
    private JPanel criarTelaInicial() {
        JPanel panelFundo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Carregar a imagem de fundo (substitua pelo caminho correto da sua imagem)
                imagemFundo = new ImageIcon("BancoImobiliario.png").getImage();
                g.drawImage(imagemFundo, 0, 0, getWidth(), getHeight(), this);  // Desenha a imagem de fundo redimensionada
            }
        };
        panelFundo.setLayout(new BorderLayout());  // Usa BorderLayout para organizar componentes

        // Painel para os botões
        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new BoxLayout(panelBotoes, BoxLayout.Y_AXIS));  // Organiza os botões verticalmente
        panelBotoes.setOpaque(false);  // Deixa o painel transparente para exibir o fundo

        // Adicionando espaçamento entre os botões
        panelBotoes.setBorder(BorderFactory.createEmptyBorder(400, 50, 200, 50));  // Margens ao redor do painel

        // Botão "Jogar"
        jogar = new JButton("Jogar");
        jogar.setFont(new Font("Arial", Font.BOLD, 18));
        jogar.setAlignmentX(Component.CENTER_ALIGNMENT);  // Centraliza o botão
        jogar.setPreferredSize(new Dimension(200, 50));  // Define um tamanho fixo para o botão
        jogar.setMaximumSize(new Dimension(200, 50));  // Impede que ele cresça além disso
        jogar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.show(painelPrincipal, "EscolhaJogadores");  // Troca para a tela de escolha de jogadores
            }
        });
        panelBotoes.add(jogar);  // Adiciona botão "Jogar" ao painel

        // Adicionar espaço entre os botões
        panelBotoes.add(Box.createRigidArea(new Dimension(0, 20)));  // Espaço de 20px entre os botões

        // Botão "Sair"
        sair = new JButton("Sair");
        sair.setFont(new Font("Arial", Font.BOLD, 18));
        sair.setPreferredSize(new Dimension(200, 50));  // Define um tamanho fixo para o botão
        sair.setMaximumSize(new Dimension(200, 50));  // Impede que ele cresça além disso
        sair.setAlignmentX(Component.CENTER_ALIGNMENT);  // Centraliza o botão
        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);  // Sai do programa
            }
        });
        panelBotoes.add(sair);  // Adiciona botão "Sair" ao painel

        // Adicionar o painel de botões ao centro do painel de fundo
        panelFundo.add(panelBotoes, BorderLayout.CENTER);

        return panelFundo;
    }


    // Método para criar a tela de escolha de jogadores
    private JPanel criarTelaEscolha() {
        JPanel panelEscolha = new JPanel();
        panelEscolha.setLayout(new BoxLayout(panelEscolha, BoxLayout.Y_AXIS));  // Organiza verticalmente
        panelEscolha.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));  // Margens ao redor do painel

        JPanel panelNomes = new JPanel();  // Painel para os campos de nomes
        panelNomes.setLayout(new BoxLayout(panelNomes, BoxLayout.Y_AXIS));  // Organização vertical

        JLabel labelJogadores = new JLabel("Selecione o número de jogadores:");
        labelJogadores.setFont(new Font("Arial", Font.PLAIN, 18));
        labelJogadores.setAlignmentX(Component.CENTER_ALIGNMENT);  // Centraliza o label
        panelEscolha.add(labelJogadores);

        Integer[] opcoes = {2, 3, 4, 5, 6};  // Opções de número de jogadores
        JComboBox<Integer> comboBox = new JComboBox<>(opcoes);
        comboBox.setFont(new Font("Arial", Font.PLAIN, 18));
        comboBox.setMaximumSize(new Dimension(100, 30));
        comboBox.setAlignmentX(Component.CENTER_ALIGNMENT);  // Centraliza o comboBox
        panelEscolha.add(comboBox);

        panelEscolha.add(Box.createRigidArea(new Dimension(0, 20)));  // Espaço

        JLabel labelNomes = new JLabel("Insira os nomes dos jogadores:");
        labelNomes.setFont(new Font("Arial", Font.PLAIN, 18));
        labelNomes.setAlignmentX(Component.CENTER_ALIGNMENT);  // Centraliza o label
        panelEscolha.add(labelNomes);

        panelEscolha.add(panelNomes);

        // Atualiza os campos de texto conforme o número de jogadores selecionado
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelNomes.removeAll();  // Remove os campos existentes

                int numeroJogadores = (Integer) comboBox.getSelectedItem();
                for (int i = 1; i <= numeroJogadores; i++) {
                    JPanel panelNomeJogador = new JPanel();
                    panelNomeJogador.setLayout(new BoxLayout(panelNomeJogador, BoxLayout.X_AXIS));

                    JLabel label = new JLabel("Jogador " + i + ": ");
                    label.setFont(new Font("Arial", Font.PLAIN, 16));
                    JTextField campoNome = new JTextField();
                    campoNome.setFont(new Font("Arial", Font.PLAIN, 16));
                    campoNome.setMaximumSize(new Dimension(200, 30));

                    panelNomeJogador.add(label);
                    panelNomeJogador.add(Box.createRigidArea(new Dimension(10, 0)));  // Espaço entre label e campo
                    panelNomeJogador.add(campoNome);

                    panelNomes.add(panelNomeJogador);
                    panelNomes.add(Box.createRigidArea(new Dimension(0, 10)));  // Espaço entre os jogadores
                }

                panelEscolha.revalidate();  // Atualiza o layout
                panelEscolha.repaint();
            }
        });

        // Botão para confirmar
        JButton confirmar = new JButton("Confirmar");
        confirmar.setFont(new Font("Arial", Font.BOLD, 18));
        confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numeroJogadores = (Integer) comboBox.getSelectedItem();
                StringBuilder nomes = new StringBuilder("Nomes dos jogadores:\n");

                Component[] componentes = panelNomes.getComponents();
                for (Component componente : componentes) {
                    if (componente instanceof JPanel) {
                        JPanel panel = (JPanel) componente;
                        for (Component subComponente : panel.getComponents()) {
                            if (subComponente instanceof JTextField) {
                                JTextField campo = (JTextField) subComponente;
                                String nome = campo.getText().trim();
                                if (nome.isEmpty()) {
                                    JOptionPane.showMessageDialog(telaInicio, "Todos os jogadores devem ter um nome.");
                                    return;
                                }
                                nomes.append(nome).append("\n");
                            }
                        }
                    }
                }

                Jogo jogo = new Jogo();

                // Acessar o painelPrincipal e o CardLayout dentro de Jogo
                CardLayout layout = jogo.getCardLayout();
                JPanel painelPrincipal = jogo.getPainelPrincipal();
                JOptionPane.showMessageDialog(telaInicio, nomes.toString());
                layout.show(painelPrincipal, "TelaInicial");  // Volta para a tela inicial
            }
        });

        // Botão para voltarx
        JButton voltar = new JButton("Voltar");
        voltar.setFont(new Font("Arial", Font.BOLD, 18));
        voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.show(painelPrincipal, "TelaInicial");
            }
        });

        JPanel panelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panelBotoes.add(confirmar);
        panelBotoes.add(voltar);

        panelEscolha.add(Box.createRigidArea(new Dimension(0, 20)));  // Espaço
        panelEscolha.add(panelBotoes);

        return panelEscolha;
    }

}

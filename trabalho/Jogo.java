import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Jogo {
    private JFrame telaInicio;  // Mantém a tela inicial
    private JFrame telaEscolha;  // Mantém a tela de escolha de jogadores
    private JPanel painelPrincipal;  // Painel principal que conterá as diferentes "telas"
    private CardLayout layout;  // Layout que gerencia as trocas de telas
    private JButton jogar;
    private JButton sair;
    private Image imagemFundo;

    public Jogo() {
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

        // Label para escolher o número de jogadores
        JLabel label = new JLabel("Selecione o número de jogadores:");
        label.setFont(new Font("Arial", Font.PLAIN, 18));
        panelEscolha.add(label);

        Integer[] opcoes = {2, 3, 4, 5, 6};  // Opções de número de jogadores
        JComboBox<Integer> comboBox = new JComboBox<>(opcoes);
        panelEscolha.add(comboBox);

        // Botão para confirmar escolha de número de jogadores
        JButton confirmar = new JButton("Confirmar");
        confirmar.setFont(new Font("Arial", Font.BOLD, 18));
        confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numeroJogadores = (Integer) comboBox.getSelectedItem();
                JOptionPane.showMessageDialog(telaInicio, "Número de jogadores: " + numeroJogadores);
                layout.show(painelPrincipal, "TelaInicial");  // Volta para a tela inicial
            }
        });
        panelEscolha.add(Box.createRigidArea(new Dimension(0, 20)));  // Espaço
        panelEscolha.add(confirmar);

        return panelEscolha;
    }

}

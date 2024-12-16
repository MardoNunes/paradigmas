import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Vector;

public class TelaInicio {
    private static TelaInicio instancia; // Instância única da classe

    private JFrame telaInicio;  // Mantém a tela inicial
    private JPanel painelPrincipal;  // Painel principal que conterá as diferentes "telas"
    private CardLayout layout;  // Layout que gerencia as trocas de telas
    private JButton jogar;
    private JButton sair;
    private Image imagemFundo;
    private Jogo jogo;

    // Construtor privado para evitar criação externa
    private TelaInicio() {
        // Configurando a janela principal
        this.telaInicio = new JFrame();  // Mantém a variável telaInicio para a janela principal
        telaInicio.setTitle("Banco Imobiliário");
        telaInicio.setSize(1920, 1080);
        telaInicio.setExtendedState(JFrame.MAXIMIZED_BOTH);  // Maximiza a janela
        telaInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaInicio.setLayout(new BorderLayout());

        // Inicializar o CardLayout e o painel principal
        layout = new CardLayout();
        painelPrincipal = new JPanel(layout);

        jogo = new Jogo();

        // Adiciona a primeira tela (tela inicial)
        painelPrincipal.add(criarTelaInicial(), "TelaInicial");

        // Adiciona o painel principal ao JFrame
        telaInicio.add(painelPrincipal);
        telaInicio.setVisible(true);
    }

    // Método estático para obter a instância única
    public static TelaInicio getInstance() {
        if (instancia == null) {
            instancia = new TelaInicio();
        }
        return instancia;
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
                painelPrincipal.add(jogo.getPainelJogo(), "TelaJogo");
                layout.show(painelPrincipal, "TelaJogo");  // Volta para a tela do jogo
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
}

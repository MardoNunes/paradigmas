import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Jogo {
    private JFrame telaInicio;
    private JButton jogar;
    private JButton sair;
    private Image imagemFundo;

    public void telaInicial() {
        // Configurando a janela principal
        this.telaInicio = new JFrame();
        telaInicio.setTitle("Banco Imobiliário"); // nome da aba
        telaInicio.setSize(1280, 720);
        telaInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // fechar o jogo no X da janela
        telaInicio.setLayout(new BorderLayout());

        
        // Carregar a imagem de fundo
        imagemFundo = new ImageIcon("BancoImobiliario.png").getImage(); // Substitua pelo caminho da sua imagem

        // Painel principal para exibir a imagem de fundo
        JPanel panelFundo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imagemFundo, 0, 0, getWidth(), getHeight(), this); // Desenha a imagem de fundo redimensionada
            }
        };
        panelFundo.setLayout(new BorderLayout());  // Usa BorderLayout para organizar componentes

        // Painel para os botões
        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new BoxLayout(panelBotoes, BoxLayout.Y_AXIS));  // Organiza os botões verticalmente
        panelBotoes.setOpaque(false);  // Deixa o painel transparente para exibir o fundo

        // Adicionando espaçamento entre os botões
        panelBotoes.setBorder(BorderFactory.createEmptyBorder(400, 50, 200, 50)); // Margens ao redor do painel

        // Botão "Jogar"
        jogar = new JButton("Jogar");
        jogar.setFont(new Font("Arial", Font.BOLD, 18));
        jogar.setAlignmentX(Component.CENTER_ALIGNMENT);  // Centraliza o botão horizontalmente
        jogar.setPreferredSize(new Dimension(200, 50));  // Define um tamanho fixo para o botão
        jogar.setMaximumSize(new Dimension(200, 50));    // Impede que ele cresça além disso
        panelBotoes.add(jogar);  // Adiciona botão "Jogar" ao painel

        // Adicionar espaço entre os botões
        panelBotoes.add(Box.createRigidArea(new Dimension(0, 20)));  // Espaço de 20px entre os botões

        // Botão "Sair"
        sair = new JButton("Sair");
        sair.setFont(new Font("Arial", Font.BOLD, 18));
        sair.setPreferredSize(new Dimension(200, 50));  // Define um tamanho fixo para o botão
        sair.setMaximumSize(new Dimension(200, 50));    // Impede que ele cresça além disso
        sair.setAlignmentX(Component.CENTER_ALIGNMENT);  // Centraliza o botão horizontalmente
        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);  // Sai do programa
            }
        });
        panelBotoes.add(sair);  // Adiciona botão "Sair" ao painel

        // Adicionar o painel de botões ao centro do painel de fundo
        panelFundo.add(panelBotoes, BorderLayout.CENTER);

        // Adiciona o painel de fundo (com os botões) ao centro da janela
        telaInicio.add(panelFundo, BorderLayout.CENTER);

        // Mostrar a tela
        telaInicio.setVisible(true);
}

}
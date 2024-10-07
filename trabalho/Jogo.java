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
        telaInicio.setVisible(true);    // deixa a tela visível
        telaInicio.setLayout(new BorderLayout());

        // Carregar a imagem de fundo
        imagemFundo = new ImageIcon("BancoImobiliario.png").getImage(); // Substitua pelo caminho da sua imagem

        // Painel principal para organizar os componentes
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));  // Organiza os componentes verticalmente

        // Alinhar os botões ao centro
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Adicionando espaçamento entre os botões
        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50)); // Margens ao redor do painel

        // Botão "Jogar"
        jogar = new JButton("Jogar");
        jogar.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(jogar);  // Adiciona botão "Jogar" ao painel

        // Adicionar espaço entre os botões
        panel.add(Box.createRigidArea(new Dimension(0, 20)));  // Espaço de 20px entre os botões

        // Botão "Sair"
        sair = new JButton("Sair");
        sair.setFont(new Font("Arial", Font.BOLD, 18));
        sair.setPreferredSize(new Dimension(120, 40));  // Definir tamanho personalizado
        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);  // Sai do programa
            }
        });
        panel.add(sair);  // Adiciona botão "Sair" ao painel

        // Contêiner para centralizar o painel dos botões na tela
        JPanel centralizador = new JPanel(new GridBagLayout());  // Usando GridBagLayout para centralizar
        centralizador.add(panel);  // Adiciona o painel com os botões ao centro

        // Adiciona o painel centralizado ao centro da janela
        telaInicio.add(centralizador, BorderLayout.CENTER);
    }

    // @Override
    // public void paint(Graphics g) {
    //     super.paint(g);
    //     int largura = getWidth();
    //     int altura = getHeight();
        
    //     // Desenhar a imagem de fundo
    //     g.drawImage(imagemFundo, 0, 0, largura, altura, this);
    // }
}


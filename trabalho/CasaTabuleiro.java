import javax.swing.*;
import java.awt.*;

public class CasaTabuleiro extends JPanel {
    private String imagePath; // Caminho para a imagem da casa
    private int valor; // Valor da casa
    private int aluguel;
    private int casa; // Número de casas construídas
    private String nome; // Nome da casa
    private String proprietario;

    private Image imagem; // Imagem da casa

    // Construtor para inicializar a casa com propriedades e posição
    public CasaTabuleiro(int x, int y, int largura, int altura, int valor, int aluguel, int casa, String nome, String proprietario, String imagePath) {
        this.imagePath = imagePath;
        this.valor = valor;
        this.aluguel = aluguel;
        this.casa = casa;
        this.nome = nome;
        this.proprietario = proprietario;

        // Configurações do painel
        this.setBounds(x, y, largura, altura); // Define posição e tamanho
        this.imagem = new ImageIcon(imagePath).getImage(); // Carrega a imagem
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Desenha a imagem no tamanho do componente
        g.drawImage(imagem, 0, 0, getWidth(), getHeight(), this);

        // Opcional: desenhar informações sobre a casa
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 12));
        //g.drawString(nome, 10, 20); // Exibe o nome da casa
    }
}

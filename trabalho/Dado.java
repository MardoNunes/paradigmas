
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;


import javax.swing.JPanel;


public class Dado extends JPanel {
	private Image[] imagens;
	private int valor;
	private int x;	// Posição x do dado
	private int y;	// Posição y do dado
	private int largura;
	private int altura;

	// Construtor para inicializar o dado com propriedades e posição
	public Dado(int x, int y) {
		this.x = x;
		this.y = y;
		this.largura = 80;
		this.altura = 80;
		this.valor = 1;
		this.imagens = new Image[6];
		this.imagens[0] = new javax.swing.ImageIcon("./Dados/Dado1.png").getImage();
		this.imagens[1] = new javax.swing.ImageIcon("./Dados/Dado2.png").getImage();
		this.imagens[2] = new javax.swing.ImageIcon("./Dados/Dado3.png").getImage();
		this.imagens[3] = new javax.swing.ImageIcon("./Dados/Dado4.png").getImage();
		this.imagens[4] = new javax.swing.ImageIcon("./Dados/Dado5.png").getImage();
		this.imagens[5] = new javax.swing.ImageIcon("./Dados/Dado6.png").getImage();
	}

	// Método para rolar o dado
	public void rollDice() {
		Random random = new Random();
		this.valor = random.nextInt(6) + 1;
	}

	// Método para desenhar o dado
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imagens[valor - 1], x, y, largura, altura, this);
	}

	

}
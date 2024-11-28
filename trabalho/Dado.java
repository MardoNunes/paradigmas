import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class Dado extends JPanel {
    private Image[] imagens;
    private int valor;
    private int largura;
    private int altura;

    // Construtor para inicializar o dado com propriedades
    public Dado(int x, int y) {
        this.setBounds(x, y, 80, 80); // Define posição e tamanho
        this.largura = 80;
        this.altura = 80;
        this.valor = 1; // Valor inicial do dado
        this.imagens = new Image[6];

        // Carregando imagens dos dados
        for (int i = 0; i < imagens.length; i++) {
            String caminhoImagem = "./Dados/Dado" + (i + 1) + ".png";
            this.imagens[i] = new ImageIcon(caminhoImagem).getImage();
            if (this.imagens[i] == null) {
                System.err.println("Erro ao carregar imagem: " + caminhoImagem);
            }
        }
    }

    // Método para rolar o dado
    public void rollDice() {
        Random random = new Random();
        this.valor = random.nextInt(6) + 1; // Valor entre 1 e 6
    }

    // Método para desenhar o dado
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (valor >= 1 && valor <= 6 && imagens[valor - 1] != null) {
            g.drawImage(imagens[valor - 1], 0, 0, largura, altura, this);
        } else {
            g.drawString("Erro no dado", 10, 40);
        }
    }

	//getters
	public int getValor() {
		return valor;
	}

	
}

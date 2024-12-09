import javax.swing.*;
import java.awt.*;

public class CasaTabuleiro extends JPanel {
    private String imagePath; // Caminho para a imagem da casa
    private int valor; // Valor da casa
    private int aluguel;
    private int casa; // Número de casas construídas
    private String nome; // Nome da casa
    private Jogador proprietario;

    private Image imagem; // Imagem da casa

    // Construtor para inicializar a casa com propriedades e posição
    public CasaTabuleiro(int x, int y, int largura, int altura, int valor, int aluguel, int casa, String nome, Jogador proprietario, String imagePath) {
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

    public CasaTabuleiro(){}

    //setters
    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setAluguel(int aluguel) {
        this.aluguel = aluguel;
    }

    public void setCasa(int casa) {
        this.casa = casa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setProprietario(Jogador proprietario) {
        this.proprietario = proprietario;
    }

    //getters
    public int getValor() {
        return valor;
    }

    public int getAluguel() {
        return aluguel;
    }

    public int getCasa() {
        return casa;
    }

    public String getNome() {
        return nome;
    }

    public Jogador getProprietario() {
        return proprietario;
    }

    public Image getImagem() {
        return imagem;
    }

    public String getImagePath() {
        return imagePath;
    }

    //verifica se a casa esta comprada
    public boolean isComprada() {
        return proprietario != null;
    }

    public void setComprada(Boolean comprada) {
        if (comprada) {
            proprietario = null;
        } else {
            proprietario = new Jogador("Banco", 1000000, Color.BLACK, 0);
        }
    }

}

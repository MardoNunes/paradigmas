import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Jogador extends JPanel {
    private String nome;
    private int posicaoAtual; // Índice da casa no tabuleiro
    private int dinheiro; // Dinheiro do jogador
    private boolean falido; // Status de falência
    private ArrayList<String> propriedades; // Lista de propriedades do jogador
    private Color cor; // Cor do jogador no tabuleiro
    private int tamanho = 30; // Tamanho do jogador no tabuleiro

    public Jogador(String nome, int dinheiroInicial, Color cor) {
        this.nome = nome;
        this.dinheiro = dinheiroInicial;
        this.posicaoAtual = 0; // Começa na casa inicial
        this.falido = false;
        this.propriedades = new ArrayList<>();
        this.cor = cor;

        // Configuração do JPanel
        this.setOpaque(false); // Torna o fundo transparente
        this.setBounds(0, 0, tamanho, tamanho); // Define o tamanho inicial do jogador
    }

    public String getNome() {
        return nome;
    }

    public int getPosicaoAtual() {
        return posicaoAtual;
    }

    public int getDinheiro() {
        return dinheiro;
    }

    public boolean isFalido() {
        return falido;
    }

    public void mover(int passos, int totalCasas, Point novaPosicao) {
        posicaoAtual = (posicaoAtual + passos) % totalCasas; // Movimenta no tabuleiro circular
        this.setLocation(novaPosicao); // Atualiza a posição visual no tabuleiro
        repaint();
    }

    public void ajustarDinheiro(int valor) {
        dinheiro += valor;
        if (dinheiro < 0) falido = true; // Marca como falido se saldo for negativo
    }

    public void adicionarPropriedade(String propriedade) {
        propriedades.add(propriedade);
    }

    public ArrayList<String> getPropriedades() {
        return propriedades;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(cor);
        g.fillOval(0, 0, tamanho, tamanho); // Desenha o jogador como um círculo
        g.setColor(Color.BLACK);
        g.drawOval(0, 0, tamanho, tamanho); // Borda preta
    }
}

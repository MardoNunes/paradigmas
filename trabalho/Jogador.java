import java.util.ArrayList;

public class Jogador {
    private String nome;
    private int posicaoAtual; // Índice da casa no tabuleiro
    private int dinheiro; // Dinheiro do jogador
    private boolean falido; // Status de falência
    private ArrayList<String> propriedades; // Lista de propriedades do jogador

    public Jogador(String nome, int dinheiroInicial) {
        this.nome = nome;
        this.dinheiro = dinheiroInicial;
        this.posicaoAtual = 0; // Começa na casa inicial
        this.falido = false;
        this.propriedades = new ArrayList<>();
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

    public void mover(int passos, int totalCasas) {
        posicaoAtual = (posicaoAtual + passos) % totalCasas; // Movimenta no tabuleiro circular
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
}

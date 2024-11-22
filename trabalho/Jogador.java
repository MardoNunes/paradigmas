public class Jogador {
    private String nome;
    private int posX, posY; // Posições no tabuleiro
    private int passos; // Passos no tabuleiro

    public Jogador(String nome) {
        this.nome = nome;
        this.posX = 0;
        this.posY = 0;
        this.passos = 0;
    }

    public void mover(int passos, int colunas, int tamanhoCasa) {
        this.passos += passos;
        int novaLinha = this.passos / colunas;
        int novaColuna = this.passos % colunas;

        this.posX = novaColuna * tamanhoCasa;
        this.posY = novaLinha * tamanhoCasa;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public String getNome() {
        return nome;
    }

    public int getPassos() {
        return passos;
    }
}

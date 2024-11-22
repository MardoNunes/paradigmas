import javax.swing.*;
import java.awt.*;

public class Tabuleiro extends JPanel {
    private CasaTabuleiro[][] casasTabuleiro;
    private final int LINHAS;
    private final int COLUNAS;
    private final int TAMANHO_CASA;

    public Tabuleiro(int linhas, int colunas, int tamanhoCasa) {
        this.LINHAS = linhas;
        this.COLUNAS = colunas;
        this.TAMANHO_CASA = tamanhoCasa;
        this.casasTabuleiro = new CasaTabuleiro[linhas][colunas];
        carregarCasas();
    }

    private void carregarCasas() {
        for (int i = 0; i < LINHAS; i++) {
            for (int j = 0; j < COLUNAS; j++) {
                // Substitua pelo caminho correto das imagens de cada casa
                String caminhoImagem = "./Tabuleiro/1.png";
                casasTabuleiro[i][j] = new CasaTabuleiro(caminhoImagem, j * TAMANHO_CASA, i * TAMANHO_CASA);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Desenhar as casas do tabuleiro
        for (int i = 0; i < LINHAS; i++) {
            for (int j = 0; j < COLUNAS; j++) {
                if (casasTabuleiro[i][j] != null) {
                    casasTabuleiro[i][j].desenhar(g, TAMANHO_CASA);
                }
            }
        }
    }
}

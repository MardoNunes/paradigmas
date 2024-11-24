import javax.swing.*;
import java.awt.*;

public class Tabuleiro extends JPanel {
    private CasaTabuleiro[] casasTabuleiro;

    public Tabuleiro() {
        // Configuração inicial do painel do tabuleiro
        this.setLayout(null); // Usa layout absoluto para posicionar as casas
        this.setPreferredSize(new Dimension(960, 960)); // Tamanho do tabuleiro
        this.setBackground(Color.GRAY); // Cor de fundo do tabuleiro

        inicializa(); // Inicializa as casas do tabuleiro
    }

    public void inicializa() {
        // Array para armazenar as casas
        casasTabuleiro = new CasaTabuleiro[20];

        //casas de cima
        CasaTabuleiro casa00 = new CasaTabuleiro(0, 0, 120, 120, 0, 0, 0, "Início", "Banco", "./Tabuleiro/1.png");
        casasTabuleiro[0] = casa00;
        // Adiciona a casa ao painel do tabuleiro
        this.add(casa00);

        CasaTabuleiro casa01 = new CasaTabuleiro(120, 0, 120, 120, 0, 0, 0, "Casa 1", "Banco", "./Tabuleiro/2.png");
        casasTabuleiro[1] = casa01;
        this.add(casa01);

        CasaTabuleiro casa02 = new CasaTabuleiro(240, 0, 120, 120, 0, 0, 0, "Casa 2", "Banco", "./Tabuleiro/3.png");
        casasTabuleiro[2] = casa02;
        this.add(casa02);

        CasaTabuleiro casa03 = new CasaTabuleiro(360, 0, 120, 120, 0, 0, 0, "Casa 3", "Banco", "./Tabuleiro/4.png");
        casasTabuleiro[3] = casa03;
        this.add(casa03);

        CasaTabuleiro casa04 = new CasaTabuleiro(480, 0, 120, 120, 0, 0, 0, "Casa 4", "Banco", "./Tabuleiro/5.png");
        casasTabuleiro[4] = casa04;
        this.add(casa04);

        CasaTabuleiro casa05 = new CasaTabuleiro(600, 0, 120, 120, 0, 0, 0, "Casa 5", "Banco", "./Tabuleiro/6.png");
        casasTabuleiro[5] = casa05;
        this.add(casa05);

        CasaTabuleiro casa06 = new CasaTabuleiro(720, 0, 120, 120, 0, 0, 0, "Casa 6", "Banco", "./Tabuleiro/7.png");
        casasTabuleiro[6] = casa06;
        this.add(casa06);

        //casas da direita
        CasaTabuleiro casa07 = new CasaTabuleiro(720, 120, 120, 120, 0, 0, 0, "Casa 7", "Banco", "./Tabuleiro/8.png");
        casasTabuleiro[7] = casa07;
        this.add(casa07);

        CasaTabuleiro casa08 = new CasaTabuleiro(720, 240, 120, 120, 0, 0, 0, "Casa 8", "Banco", "./Tabuleiro/9.png");
        casasTabuleiro[8] = casa08;
        this.add(casa08);

        CasaTabuleiro casa09 = new CasaTabuleiro(720, 360, 120, 120, 0, 0, 0, "Casa 9", "Banco", "./Tabuleiro/10.png");
        casasTabuleiro[9] = casa09;
        this.add(casa09);

        CasaTabuleiro casa10 = new CasaTabuleiro(720, 480, 120, 120, 0, 0, 0, "Casa 10", "Banco", "./Tabuleiro/11.png");
        casasTabuleiro[10] = casa10;
        this.add(casa10);

        CasaTabuleiro casa11 = new CasaTabuleiro(720, 600, 120, 120, 0, 0, 0, "Casa 11", "Banco", "./Tabuleiro/12.png");
        casasTabuleiro[11] = casa11;
        this.add(casa11);

        //casas de baixo
        CasaTabuleiro casa12 = new CasaTabuleiro(600, 600, 120, 120, 0, 0, 0, "Casa 12", "Banco", "./Tabuleiro/13.png");
        casasTabuleiro[12] = casa12;
        this.add(casa12);

        CasaTabuleiro casa13 = new CasaTabuleiro(480, 600, 120, 120, 0, 0, 0, "Casa 13", "Banco", "./Tabuleiro/14.png");
        casasTabuleiro[13] = casa13;
        this.add(casa13);

        CasaTabuleiro casa14 = new CasaTabuleiro(360, 600, 120, 120, 0, 0, 0, "Casa 14", "Banco", "./Tabuleiro/15.png");
        casasTabuleiro[14] = casa14;
        this.add(casa14);
    }
}

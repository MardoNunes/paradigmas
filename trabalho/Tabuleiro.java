    import javax.swing.*;
    import java.awt.*;


    public class Tabuleiro extends JPanel {
        private CasaTabuleiro[] casasTabuleiro;
        private final int TAM_CASA = 170;
        private Image imagemFundo;

        public Tabuleiro() {
            // Configuração inicial do painel do tabuleiro
            this.setLayout(null); // Usa layout absoluto para posicionar as casas
            this.setPreferredSize(new Dimension(1200, 1080)); // Tamanho do tabuleiro
            this.setBackground(Color.WHITE); // Cor de fundo do tabuleiro

            // Carrega a imagem de fundo
        //     this.imagemFundo = new ImageIcon("FundoTabuleiro.png").getImage();
            
        
        inicializa(); // Inicializa as casas do tabuleiro
        // }

        // @Override
        // protected void paintComponent(Graphics g) {
        //     super.paintComponent(g);

        //     // Desenha a imagem de fundo
        //     g.drawImage(imagemFundo, 0, 0, 1200, 1080, this);
        // }
        }

        public void inicializa() {
            // Array para armazenar as casas
            casasTabuleiro = new CasaTabuleiro[22];

            //casas de cima
            // CasaTabuleiro casa00 = new CasaTabuleiro(0, 0, TAM_CASA, TAM_CASA, 0, 0, 0, "Início", "Banco", "./Tabuleiro/1.png");
            // casasTabuleiro[0] = casa00;
            // // Adiciona a casa ao painel do tabuleiro
            // this.add(casa00);

            CasaTabuleiro casa01 = new CasaTabuleiro(170, 0, TAM_CASA, TAM_CASA, 0, 0, 0, "Casa 1", "Banco", "./Tabuleiro/2.png");
            casasTabuleiro[1] = casa01;
            this.add(casa01);

            CasaTabuleiro casa02 = new CasaTabuleiro(340, 0, TAM_CASA, TAM_CASA, 0, 0, 0, "Casa 2", "Banco", "./Tabuleiro/3.png");
            casasTabuleiro[2] = casa02;
            this.add(casa02);

            CasaTabuleiro casa03 = new CasaTabuleiro(510, 0, TAM_CASA, TAM_CASA, 0, 0, 0, "Casa 3", "Banco", "./Tabuleiro/4.png");
            casasTabuleiro[3] = casa03;
            this.add(casa03);

            CasaTabuleiro casa04 = new CasaTabuleiro(680, 0, TAM_CASA, TAM_CASA, 0, 0, 0, "Casa 4", "Banco", "./Tabuleiro/19.png");
            casasTabuleiro[4] = casa04;
            this.add(casa04);

            CasaTabuleiro casa05 = new CasaTabuleiro(850, 0, TAM_CASA, TAM_CASA, 0, 0, 0, "Casa 5", "Banco", "./Tabuleiro/20.png");
            casasTabuleiro[5] = casa05;
            this.add(casa05);

            CasaTabuleiro casa06 = new CasaTabuleiro(1020, 0, TAM_CASA, TAM_CASA, 0, 0, 0, "Casa 6", "Banco", "./Tabuleiro/5.png");
            casasTabuleiro[6] = casa06;
            this.add(casa06);

            //casas da direita
            CasaTabuleiro casa07 = new CasaTabuleiro(1020, 170, TAM_CASA, TAM_CASA, 0, 0, 0, "Casa 7", "Banco", "./Tabuleiro/8.png");
            casasTabuleiro[7] = casa07;
            this.add(casa07);

            CasaTabuleiro casa08 = new CasaTabuleiro(1020, 340, TAM_CASA, TAM_CASA, 0, 0, 0, "Casa 8", "Banco", "./Tabuleiro/9.png");
            casasTabuleiro[8] = casa08;
            this.add(casa08);

            CasaTabuleiro casa09 = new CasaTabuleiro(1020, 510, TAM_CASA, TAM_CASA, 0, 0, 0, "Casa 9", "Banco", "./Tabuleiro/6.png");
            casasTabuleiro[9] = casa09;
            this.add(casa09);

            CasaTabuleiro casa10 = new CasaTabuleiro(1020, 680, TAM_CASA, TAM_CASA, 0, 0, 0, "Casa 10", "Banco", "./Tabuleiro/21.png");
            casasTabuleiro[10] = casa10;
            this.add(casa10);

            CasaTabuleiro casa11 = new CasaTabuleiro(1020, 850, TAM_CASA, TAM_CASA, 0, 0, 0, "Casa 11", "Banco", "./Tabuleiro/7.png");
            casasTabuleiro[11] = casa11;
            this.add(casa11);

            // //casas de baixo
            CasaTabuleiro casa12 = new CasaTabuleiro(850, 850, TAM_CASA, TAM_CASA, 0, 0, 0, "Casa 12", "Banco", "./Tabuleiro/14.png");
            casasTabuleiro[12] = casa12;
            this.add(casa12);

            CasaTabuleiro casa13 = new CasaTabuleiro(680, 850, TAM_CASA, TAM_CASA, 0, 0, 0, "Casa 13", "Banco", "./Tabuleiro/15.png");
            casasTabuleiro[13] = casa13;
            this.add(casa13);

            CasaTabuleiro casa14 = new CasaTabuleiro(510, 850, TAM_CASA, TAM_CASA, 0, 0, 0, "Casa 14", "Banco", "./Tabuleiro/4.png");
            casasTabuleiro[14] = casa14;
            this.add(casa14);

            CasaTabuleiro casa15 = new CasaTabuleiro(340, 850, TAM_CASA, TAM_CASA, 0, 0, 0, "Casa 15", "Banco", "./Tabuleiro/16.png");
            casasTabuleiro[15] = casa15;
            this.add(casa15);

            CasaTabuleiro casa16 = new CasaTabuleiro(170, 850, TAM_CASA, TAM_CASA, 0, 0, 0, "Casa 16", "Banco", "./Tabuleiro/17.png");
            casasTabuleiro[16] = casa16;
            this.add(casa16);

            CasaTabuleiro casa17 = new CasaTabuleiro(0, 850, TAM_CASA, TAM_CASA, 0, 0, 0, "Casa 17", "Banco", "./Tabuleiro/10.png");
            casasTabuleiro[17] = casa17;
            this.add(casa17);

            // //casas da esquerda
            CasaTabuleiro casa18 = new CasaTabuleiro(0, 680, TAM_CASA, TAM_CASA, 0, 0, 0, "Casa 18", "Banco", "./Tabuleiro/11.png");
            casasTabuleiro[18] = casa18;
            this.add(casa18);

            CasaTabuleiro casa19 = new CasaTabuleiro(0, 510, TAM_CASA, TAM_CASA, 0, 0, 0, "Casa 19", "Banco", "./Tabuleiro/12.png");
            casasTabuleiro[19] = casa19;
            this.add(casa19);

            CasaTabuleiro casa20 = new CasaTabuleiro(0, 340, TAM_CASA, TAM_CASA, 0, 0, 0, "Casa 20", "Banco", "./Tabuleiro/13.png");
            casasTabuleiro[20] = casa20;
            this.add(casa20);

            CasaTabuleiro casa21 = new CasaTabuleiro(0, 170, TAM_CASA, TAM_CASA, 0, 0, 0, "Casa 21", "Banco", "./Tabuleiro/6.png");
            casasTabuleiro[21] = casa21;
            this.add(casa21);

        }

        public CasaTabuleiro[] getCasasTabuleiro() {
            return casasTabuleiro;
        }

        public void adicionarJogador(Jogador jogador) {
            this.add(jogador); // Adiciona o jogador ao painel
            jogador.setSize(jogador.getPreferredSize());
            
            CasaTabuleiro casaInicial = casasTabuleiro[0]; // Define a posição inicial
            jogador.setLocation(
                casaInicial.getX() + (TAM_CASA - jogador.getWidth()) / 2,
                casaInicial.getY() + (TAM_CASA - jogador.getHeight()) / 2
            );
        
            this.revalidate(); // Atualiza o layout
            this.repaint();    // Força a renderização
        }

        public void moverJogador(Jogador jogador, int novaPosicao) {
            if (novaPosicao >= 0 && novaPosicao < casasTabuleiro.length) {
                CasaTabuleiro novaCasa = casasTabuleiro[novaPosicao];
                jogador.setLocation(novaCasa.getX() + (TAM_CASA - jogador.getWidth()) / 2,
                                    novaCasa.getY() + (TAM_CASA - jogador.getHeight()) / 2);
                this.repaint(); // Atualiza a exibição do tabuleiro
            }
        }
        
    }

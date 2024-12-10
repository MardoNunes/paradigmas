    import javax.swing.*;
    import java.awt.*;


    public class Tabuleiro extends JPanel {
        private CasaTabuleiro[] casasTabuleiro;
        private final int TAM_CASA = 170;
       private Image casa; 

        public Tabuleiro() {
            // Configuração inicial do painel do tabuleiro
            this.setLayout(null); // Usa layout absoluto para posicionar as casas
            this.setPreferredSize(new Dimension(1200, 1080)); // Tamanho do tabuleiro
            this.setBackground(Color.WHITE); // Cor de fundo do tabuleiro
            casasTabuleiro = new CasaTabuleiro[22]; // Inicializa o array de casas
            inicializaCasas();
        
    
        }
        @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
    
            for (CasaTabuleiro casa : casasTabuleiro) {
                if (casa != null) {
                    Image img = new ImageIcon(casa.getImagePath()).getImage();
                    g.drawImage(img, casa.getX(), casa.getY(), TAM_CASA, TAM_CASA, this);
                }
            }
            
            }

        public void inicializaCasas() {
            Jogador banco = new Jogador("Banco", 1000000, Color.BLACK, 0);

            // casas de cima
            casa = new ImageIcon("./Tabuleiro/1.png").getImage();
            casasTabuleiro[0] = new CasaTabuleiro(0, 0, TAM_CASA, TAM_CASA, 0, 0, 1, "Início", banco, "./Tabuleiro/1.png");

            casa = new ImageIcon("./Tabuleiro/2.png").getImage();
            casasTabuleiro[1] = new CasaTabuleiro(170, 0, TAM_CASA, TAM_CASA, 800, 75, 2, "Casa 1", banco, "./Tabuleiro/2.png");
            
            casa = new ImageIcon("./Tabuleiro/3.png").getImage();
            casasTabuleiro[2] = new CasaTabuleiro(340, 0, TAM_CASA, TAM_CASA, 900,80, 3, "Casa 2", banco, "./Tabuleiro/3.png");
            
            casa = new ImageIcon("./Tabuleiro/4.png").getImage();
            casasTabuleiro[3]= new CasaTabuleiro(510, 0, TAM_CASA, TAM_CASA, 0, 0, 4, "Casa 3", banco, "./Tabuleiro/4.png");
    

            casa = new ImageIcon("./Tabuleiro/19.png").getImage();
            casasTabuleiro[4] = new CasaTabuleiro(680, 0, TAM_CASA, TAM_CASA, 1000, 120, 19, "Casa 4", banco, "./Tabuleiro/19.png"); //19->5
            
            casa = new ImageIcon("./Tabuleiro/20.png").getImage();
            casasTabuleiro[5] = new CasaTabuleiro(850, 0, TAM_CASA, TAM_CASA, 950, 110, 20, "Casa 5", banco, "./Tabuleiro/20.png"); //20->6
            
            casa = new ImageIcon("./Tabuleiro/5.png").getImage();
            casasTabuleiro[6] = new CasaTabuleiro(1020, 0, TAM_CASA, TAM_CASA, 0, 100, 5, "Casa 6", banco, "./Tabuleiro/5.png") ; //5->7
            
            //casas da direita
            casa = new ImageIcon("./Tabuleiro/8.png").getImage();
            casasTabuleiro[7] = new CasaTabuleiro(1020, 170, TAM_CASA, TAM_CASA, 750, 80, 8, "Casa 7", banco, "./Tabuleiro/8.png");
            
            casa = new ImageIcon("./Tabuleiro/9.png").getImage();
            casasTabuleiro[8] = new CasaTabuleiro(1020, 340, TAM_CASA, TAM_CASA, 750, 80, 9, "Casa 8", banco, "./Tabuleiro/9.png");
            
            casa = new ImageIcon("./Tabuleiro/6.png").getImage();
            casasTabuleiro[9]= new CasaTabuleiro(1020, 510, TAM_CASA, TAM_CASA, 0, 0, 6, "Casa 9", banco, "./Tabuleiro/6.png");   //6->10
            
            casa = new ImageIcon("./Tabuleiro/21.png").getImage();
            casasTabuleiro[10] = new CasaTabuleiro(1020, 680, TAM_CASA, TAM_CASA, 5000, 700, 21, "Casa 10", banco, "./Tabuleiro/21.png"); //21->11
           
            casa = new ImageIcon("./Tabuleiro/7.png").getImage();
            casasTabuleiro[11] = new CasaTabuleiro(1020, 850, TAM_CASA, TAM_CASA, 0, 0, 7, "Casa 11", banco, "./Tabuleiro/7.png");  //7->12
            
            //casas de baixo
            casa = new ImageIcon("./Tabuleiro/14.png").getImage();
            casasTabuleiro[12] = new CasaTabuleiro(850, 850, TAM_CASA, TAM_CASA, 1050, 200, 14, "Casa 12", banco, "./Tabuleiro/14.png");
            
            casa = new ImageIcon("./Tabuleiro/15.png").getImage();
            casasTabuleiro[13] = new CasaTabuleiro(680, 850, TAM_CASA, TAM_CASA, 1100, 250, 15, "Casa 13", banco, "./Tabuleiro/15.png");
           
            casa = new ImageIcon("./Tabuleiro/4.png").getImage();
            casasTabuleiro[14] = new CasaTabuleiro(510, 850, TAM_CASA, TAM_CASA, 0, 0, 4, "Casa 14", banco, "./Tabuleiro/4.png");
            
            casa = new ImageIcon("./Tabuleiro/16.png").getImage();
            casasTabuleiro[15] = new CasaTabuleiro(340, 850, TAM_CASA, TAM_CASA, 1100, 200, 16, "Casa 15", banco, "./Tabuleiro/16.png");
           
            casa = new ImageIcon("./Tabuleiro/17.png").getImage();
            casasTabuleiro[16] = new CasaTabuleiro(170, 850, TAM_CASA, TAM_CASA, 1100, 200, 17, "Casa 16", banco, "./Tabuleiro/17.png");
            
            casa = new ImageIcon("./Tabuleiro/10.png").getImage();
            casasTabuleiro[17] = new CasaTabuleiro(0, 850, TAM_CASA, TAM_CASA, 0, 0, 10, "Casa 17", banco, "./Tabuleiro/10.png");
         
            //casas da esquerda
            casa = new ImageIcon("./Tabuleiro/11.png").getImage();
            casasTabuleiro[18] = new CasaTabuleiro(0, 680, TAM_CASA, TAM_CASA, 750, 80, 11, "Casa 18", banco, "./Tabuleiro/11.png");
            
            casa = new ImageIcon("./Tabuleiro/12.png").getImage();
            casasTabuleiro[19] = new CasaTabuleiro(0, 510, TAM_CASA, TAM_CASA, 600, 70, 12, "Casa 19", banco, "./Tabuleiro/12.png");
            
            casa = new ImageIcon("./Tabuleiro/13.png").getImage();
            casasTabuleiro[20] = new CasaTabuleiro(0, 340, TAM_CASA, TAM_CASA, 999, 100, 13, "Casa 20", banco, "./Tabuleiro/13.png");
            
            casa = new ImageIcon("./Tabuleiro/6.png").getImage();
            casasTabuleiro[21] = new CasaTabuleiro(0, 170, TAM_CASA, TAM_CASA, 0, 0, 6, "Casa 21", banco, "./Tabuleiro/6.png");
          
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

        public Point getPosicao(int posicaoAtual, int passos) {
            int novaPosicao = (posicaoAtual + passos) % casasTabuleiro.length;
            return new Point(casasTabuleiro[novaPosicao].getX() + (TAM_CASA - 80) / 2,
                             casasTabuleiro[novaPosicao].getY() + (TAM_CASA - 80) / 2);
        }
        
    }


/*fazer um programa em java que execute um sorteio entre 5 pessoas usando o método
int sorteio = (int)(Math.random()*5) e imprima o nome do vencedor*/

import java.util.Scanner;

public class Ex1{
    public static void main(String args[]){
        String[] nomes = new String[5]; //assim se declara um array vazio de 5 pocicoes!
        Scanner input = new Scanner(System.in);

        //ler 5 nome
        for(int i = 0; i < 5; i++){
            System.out.println("Entre com o nome: ");
            nomes[i] = input.nextLine();
        }

        //sortear um nome
        int sorteio = (int)(Math.random()*5);

        System.out.println(nomes[sorteio]);
        input.close();
    }
}
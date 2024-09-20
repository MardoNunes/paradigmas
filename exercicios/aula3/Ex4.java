/*Construa um programa em java que leia 10 nomes e a seguir guarde-os em um array e leia
um nome e verifique se ele faz parte da lista*/

import java.util.Scanner;

public class Ex4 {
    public static void main(String args[]){
        String[] nomes = new String[10];
        Scanner input = new Scanner(System.in);

        //ler os 10 nomes
        for(int i = 0; i < nomes.length; i++){
            System.out.println("Entre com o nome: ");
            nomes[i] = input.nextLine();
        }

        //entrar com um nome para buscar
        System.out.println("Qual nome voce quer bsucar: ");
        String nome = input.nextLine();
    
        short flag = 0;
        int pos = -1;
        for(int j = 0; j < nomes.length; j++){
            if(nome.equals(nomes[j])){
                flag = 1;
                pos = j;
            }
        }


        if(flag == 1)
            System.out.println("Achou na posição "+pos+"!");
        else   
            System.out.println("Não achou!");
        input.close();
    }
}

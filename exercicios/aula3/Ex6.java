

/*Fazer um programa em Java que leia uma frase e conte e escreva quantas palavras existem .*/


import java.util.Scanner;


public class Ex6 {
    public static void main(String args[]){

        Scanner input = new Scanner(System.in);
        String frase = new String();
        int cont = 0;

        System.out.println("Entre com a frase: ");
        frase = input.nextLine();

        for(int i = 0; i < frase.length(); i++){
            if(frase.charAt(i) == ' '){
                cont = cont + 1;
            }

        }

        System.out.println("A frase há "+cont+" espaços!");

        input.close();
    }

}

//Construa um programa em Java que leia um número e diga se ele é par ou impar.

import java.util.Scanner;

public class Ex5{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float num;

        System.out.println("Entre com um valor: ");
        num = input.nextFloat();

        if(num % 2 == 0)
            System.out.println("É par!");
        else  
            System.out.println("É impar!");

        input.close();
        
    }
}
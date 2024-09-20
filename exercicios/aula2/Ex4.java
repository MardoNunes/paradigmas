//Construa um programa em Java que leia um número e diga se ele é positivo

import java.util.Scanner;

public class Ex4 {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        float num;

        System.out.println("Entre com um numero: ");
        num = input.nextFloat();

        if(num >= 0)
            System.out.println(num+" é positivo!");
        else
            System.out.println(num+" é negativo!");
        
        input.close();
    } 
}

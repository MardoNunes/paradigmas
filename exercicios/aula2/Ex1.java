//fazer um programa em java que calcule e imprima a tabuada de 6




public class Ex1{
    public static void main(String args[]){
        int valor;
        valor = 6;

        for(int i = 0; i <= 10; i++){
            int result;
            result = i * valor;
            System.out.printf("%d x %d = %d \n", valor, i, result);
        }
    }
} 
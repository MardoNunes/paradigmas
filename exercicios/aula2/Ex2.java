//fazer um programa em java que calcule e imprima as raízes da equação x^2 +x -6 =0



public class Ex2{
    public static void main(String args[]){
        float a, b, c;
        float result, x1, x2;
        a = 1;
        b = 1;
        c = -6;

        result = (b*b) - (4*a*c);
        x1 = (float)((-b + Math.pow(result, 0.5))/(2*a));
        x2 = (float)((-b - Math.pow(result, 0.5))/(2*a));
        System.out.printf("As raizes são : %.2f e %.2f\n", x1, x2);

    }
}
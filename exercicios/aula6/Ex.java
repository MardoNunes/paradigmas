import java.util.*;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Ex{
    public static void main(String args[]){
        
  
        Scanner input = new Scanner(System.in);

        Aluno[] alunos = new Aluno[2];

        //inicializando cada aluno
        for(int i = 0 ; i < 2; i++){
            alunos[i] = new Aluno();
        }


        //lendo informaçẽos do aluno
        for(int i = 0; i < 2; i++){
            System.out.println("Entre com o nome : ");
            alunos[i].setNome(input.nextLine());

            System.out.println("Entre com o endereço : ");
            alunos[i].setEndereco(input.nextLine());

            System.out.println("Entre com o Email : ");
            alunos[i].setEmail(input.nextLine());

            System.out.println("Entre com o telefone : ");
            alunos[i].setTelefone(input.nextLine());

            System.out.println("Entre com a idade : ");
            alunos[i].setIdade(input.nextInt());

            //lendo notas e fazend medeias
            System.out.println("Nota 1: ");
            alunos[i].setNota(input.nextInt(), 0);
            System.out.println("Nota 2: ");
            alunos[i].setNota(input.nextInt(), 1);
            input.nextLine();
        }

        for(int i = 0; i < 2; i++){
            alunos[i].medias();
        }
    

        //impressão de tudo
        for(int i = 0; i < 2; i++){
            System.out.println("nome: "+ alunos[i].getNome());
            
            System.out.println("idade: "+alunos[i].getIdade());
            
            System.out.println("endereço : "+alunos[i].getEndereco());

            System.out.println("Email : "+alunos[i].getEmail());

            System.out.println("telefone : "+alunos[i].getTelefone());

            System.out.println("Media: "+alunos[i].getMedia());
        }
        input.close();

        try (FileOutputStream fileOut = new FileOutputStream("alunos.dat"); //criando o arquivo

            //salvando no arquivo
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            objectOut.writeObject(alunos); // Escrevendo o vetor no arquivo
            System.out.println("Vetor de alunos foi salvo com sucesso!");

        } catch (IOException e) {
            e.printStackTrace();
        }
        

    }
}
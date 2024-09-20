
import java.io.Serializable;


public class Aluno extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L; // Identificador de versão
  
    private float notas[] = new float[2];
    private float media;

    public void setNota(float nota, int i){
        this.notas[i] = nota;
    }

    public float getNota(int i){
        return this.notas[i];
    }

    public void medias(){
        float soma = 0;
        for(int j = 0; j < 2; j++){
            soma = soma + notas[j];
        }

        setMedia(soma/4);
    }

    public void setMedia(float media) {
        this.media = media;
    }

    public float getMedia() {
        return media;
    }
    @Override
    public String toString() {
        return "Aluno{nome='" + getNome() + "', idade=" + getIdade() + "',media=" + getMedia() + "'}";
    }
}

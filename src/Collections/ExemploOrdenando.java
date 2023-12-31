package Collections;

import java.util.*;

public class ExemploOrdenando {
    public static void main(String[] args) {

        List<Gato> meusGatos = new ArrayList<>() {{
        add(new Gato("Galileu","cinza",8));
        add(new Gato("Pantera", "preto", 4));
        add(new Gato("Darwin", "tigrado", 5));
        }};
        System.out.println("Ordem de inserção");
        System.out.println(meusGatos);
        System.out.println("ordem aleatória");
        Collections.shuffle(meusGatos);
        System.out.println(meusGatos);
        System.out.println("Ordem natural");
        Collections.sort(meusGatos);
        System.out.println(meusGatos);
        System.out.println("Ordem Idade");
        meusGatos.sort(new ComparatorIdade());
        System.out.println(meusGatos);
        System.out.println("Comparando Cor");
        meusGatos.sort(new ComparatorCor());
        System.out.println(meusGatos);
        System.out.println("Ordenar por Nome, Cor e Idade");
        meusGatos.sort(new ComparatorNomeCorIdade());
        System.out.println(meusGatos);



    }
}

 class Gato implements Comparable<Gato> {
    private String nome;
    private String cor;
    private Integer idade;

     public Gato(String nome, String cor, int idade) {
         this.nome = nome;
         this.cor = cor;
         this.idade = idade;
     }

     public String getNome() {
         return nome;
     }

     public void setNome(String nome) {
         this.nome = nome;
     }

     public String getCor() {
         return cor;
     }

     public void setCor(String cor) {
         this.cor = cor;
     }

     public int getIdade() {
         return idade;
     }

     public void setIdade(int idade) {
         this.idade = idade;
     }

     @Override
     public String toString() {
         return "Gato{" +
                 "nome='" + nome + '\'' +
                 ", cor='" + cor + '\'' +
                 ", idade=" + idade +
                 '}';
     }

     @Override
     public int compareTo(Gato gato) {
         return this.getNome().compareToIgnoreCase(gato.getNome());
     }
 }

 class ComparatorIdade implements Comparator<Gato>{


     @Override
     public int compare(Gato o1, Gato o2) {
         return Integer.compare(o1.getIdade(),o2.getIdade());
     }
 }

 class ComparatorCor implements Comparator<Gato>{

     @Override
     public int compare(Gato o1, Gato o2) {
         return o1.getNome().compareToIgnoreCase(o2.getCor());
     }
 }

 class ComparatorNomeCorIdade implements Comparator<Gato>{

     @Override
     public int compare(Gato o1, Gato o2) {
         int nome = o1.getNome().compareToIgnoreCase(o2.getNome());
         if(nome != 0){
             return nome;
         }
         int cor = o1.getCor().compareToIgnoreCase(o2.getCor());
         if(cor !=0) {
             return cor;
         }
         return Integer.compare(o1.getIdade(),o2.getIdade());
     }
 }

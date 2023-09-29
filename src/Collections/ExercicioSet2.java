package Collections;

import java.util.*;

public class ExercicioSet2 {
    public static void main(String[] args) {

        Set<LinguagemFavorita> minhasLinguagensFav = new HashSet<>(){{
            add(new LinguagemFavorita("Java",1990,"Intelij"));
            add(new LinguagemFavorita("Pyhton", 1991, "VsCode"));
            add(new LinguagemFavorita("Flutter", 2015 , "AndroidStudio"));
        }};
        System.out.println(minhasLinguagensFav);
        System.out.println("Ordem de inserção:");
        Set<LinguagemFavorita> minhasLinguagensFav2 = new LinkedHashSet<>(){{
            add(new LinguagemFavorita("Java",1990,"Intelij"));
            add(new LinguagemFavorita("Pyhton", 1991, "VsCode"));
            add(new LinguagemFavorita("Flutter", 2015 , "AndroidStudio"));
        }};
        System.out.println(minhasLinguagensFav2);
        System.out.println("Ordem natural(nome)");
        Set<LinguagemFavorita> minhasLinguagensFav3 = new TreeSet<>(minhasLinguagensFav);
        System.out.println(minhasLinguagensFav3);
        System.out.println("Ordem IDE");
        Set<LinguagemFavorita> minhasLinguagensFav4 = new TreeSet<>(new ComparatorIDE());
        for (LinguagemFavorita linguagem : minhasLinguagensFav4) System.out.println(linguagem);
        System.out.println("Ordem Ano e Nome");
        Set<LinguagemFavorita> minhasLinguagensFav5 = new TreeSet<>(new ComparatorAnoeNome());
        for (LinguagemFavorita linguagem : minhasLinguagensFav5) System.out.println(linguagem);
        System.out.println("Ordem Nome, Ano e IDE");
        Set<LinguagemFavorita> minhasLinguagensFav6 = new TreeSet<>(new ComparatorNomeAnoIDE());
        for (LinguagemFavorita linguagem : minhasLinguagensFav6) System.out.println(linguagem);


    }
}

class LinguagemFavorita implements Comparable<LinguagemFavorita>{
    public String nome;
    public Integer anoDeCriacao;
    public String ide;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinguagemFavorita that = (LinguagemFavorita) o;
        return Objects.equals(nome, that.nome) && Objects.equals(anoDeCriacao, that.anoDeCriacao) && Objects.equals(ide, that.ide);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, anoDeCriacao, ide);
    }

    @Override
    public String toString() {
        return "LinguagemFavorita{" +
                "nome='" + nome + '\'' +
                ", anoDeCriacao=" + anoDeCriacao +
                ", ide='" + ide + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoDeCriacao() {
        return anoDeCriacao;
    }

    public void setAnoDeCriacao(Integer anoDeCriacao) {
        this.anoDeCriacao = anoDeCriacao;
    }

    public String getIde() {
        return ide;
    }

    public void setIde(String ide) {
        this.ide = ide;
    }

    public LinguagemFavorita(String nome, Integer anoDeCriacao, String ide) {
        this.nome = nome;
        this.anoDeCriacao = anoDeCriacao;
        this.ide = ide;
    }

    @Override
    public int compareTo(LinguagemFavorita o) {
        return this.getNome().compareTo(o.getNome());
    }
}

class ComparatorIDE implements Comparator<LinguagemFavorita>{
    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {

        return o1.ide.compareToIgnoreCase(o2.ide);
    }
}

class ComparatorAnoeNome implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        int anoDeCriacao = Integer.compare(o1.anoDeCriacao,o2.anoDeCriacao);
        if(anoDeCriacao != 0) return anoDeCriacao;
        return o1.nome.compareToIgnoreCase(o2.nome);
    }
}

class ComparatorNomeAnoIDE implements Comparator<LinguagemFavorita>{
    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        int nome = o1.nome.compareTo(o2.nome);
        if (nome != 0) {
            return nome;
        }
        int genero = o1.ide.compareTo(o2.ide);
        if (genero != 0) {
            return genero;
        }
        return Integer.compare(o1.anoDeCriacao, o2.anoDeCriacao);
    }
}
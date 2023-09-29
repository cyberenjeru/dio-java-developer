package Collections;

import java.util.*;

public class OrdenacaoSet {
    public static void main(String[] args) {
        System.out.println("Ordem aleatória");
        Set<Serie> minhasSeries = new HashSet<>(){{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "ficção", 60));
            add(new Serie("that 70s show", "comédia", 25));
        }};
        for (Serie serie : minhasSeries) System.out.println(serie.getNome()+ " - "
        + serie.getGenero() + " - " + serie.getTempoEpisodio());

        System.out.println("Ordem de inserção");
        Set<Serie> minhasSeries1 = new LinkedHashSet<>(){{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "ficção", 60));
            add(new Serie("that 70s show", "comédia", 25));
        }};
        for (Serie serie : minhasSeries1) System.out.println(serie.getNome() + " - " + serie.getGenero()
        + " - " + serie.getTempoEpisodio());

        System.out.println("Ordem natural (por tempo de episodio)");
        Set<Serie> minhasSeries2 = new TreeSet<>(minhasSeries);
        for (Serie serie : minhasSeries2) System.out.println(serie.getNome() + " - " + serie.getGenero()
                + " - " + serie.getTempoEpisodio());

        System.out.println("Ordem nome, genero, tempo");
        Set<Serie> minhasSeries3 = new TreeSet<>(new ComparatorNomeGeneroTempoEpisodio());
        minhasSeries3.addAll(minhasSeries);
        for (Serie serie : minhasSeries3) System.out.println(serie.getNome() + " - " + serie.getGenero()
                + " - " + serie.getTempoEpisodio());

        System.out.println("Ordem genero");
        Set<Serie> minhasSeries4 = new TreeSet<>(new ComparatorGenero());
        minhasSeries4.addAll(minhasSeries);
        for (Serie serie : minhasSeries4) System.out.println(serie.getNome() + " - " + serie.getGenero()
                + " - " + serie.getTempoEpisodio());

        System.out.println("Ordem tempo");
        Set<Serie> minhasSeries5 = new TreeSet<>(new ComparatorTempo());
        minhasSeries5.addAll(minhasSeries);
        for (Serie serie : minhasSeries5) System.out.println(serie.getNome() + " - " + serie.getGenero()
                + " - " + serie.getTempoEpisodio());


    }
}

class Serie implements Comparable<Serie> {
    private String nome;
    private String genero;
    private Integer tempoEpisodio;

    public Serie(String nome, String genero, Integer tempoEpisodio) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return Objects.equals(nome, serie.nome) && Objects.equals(genero, serie.genero) && Objects.equals(tempoEpisodio, serie.tempoEpisodio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoEpisodio);
    }

    @Override
    public String toString() {
        return "Serie{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempoEpisodio=" + tempoEpisodio +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getTempoEpisodio() {
        return tempoEpisodio;
    }

    public void setTempoEpisodio(Integer tempoEpisodio) {
        this.tempoEpisodio = tempoEpisodio;
    }

    @Override
    public int compareTo(Serie serie) {

        int tempoEpisodio = Integer.compare(this.getTempoEpisodio(), serie.getTempoEpisodio());
        if (tempoEpisodio != 0) {
            return tempoEpisodio;
        } else {
            return this.getGenero().compareTo(serie.getGenero());
        }
    }
}

class ComparatorNomeGeneroTempoEpisodio implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {
        int nome = s1.getNome().compareTo(s2.getNome());
        if (nome != 0) return nome;
        int genero = s1.getGenero().compareTo(s2.getGenero());
        if (genero != 0) return genero;
        return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
    }
}

class ComparatorGenero implements Comparator<Serie>{
    @Override
    public int compare(Serie o1, Serie o2) {
        return o1.getGenero().compareTo(o2.getGenero());
    }
}

class ComparatorTempo implements Comparator<Serie>{
    @Override
    public int compare(Serie o1,Serie o2) {
        int genero = o1.getGenero().compareTo(o2.getGenero());
        if (genero != 0) return genero;
        return Integer.compare(o1.getTempoEpisodio(),o2.getTempoEpisodio());
    }
}

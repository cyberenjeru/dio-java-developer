package Collections;
import java.util.*;

public class ExemploOrdenacaoMap {
    public static void main(String[] args) {
        System.out.println("Ordem Aleatória");
        System.out.println();
        Map<String,Livro> bibliotecaLivros = new HashMap<>(){{
            put("Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
            put("Duhing, Charles", new Livro("O Poder do Hábito", 408));
            put("Hahari, Yuval", new Livro("21 uma lições do século 21", 432));
        }};


        for (Map.Entry<String, Livro> livro : bibliotecaLivros.entrySet()){
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        }

        System.out.println();
        System.out.println("Ordem de Inserção");
        System.out.println();
        Map<String,Livro> bibliotecaLivros1 = new LinkedHashMap<>() {{
            put("Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
            put("Duhing, Charles", new Livro("O Poder do Hábito", 408));
            put("Hahari, Yuval", new Livro("21 uma lições do século 21", 432));
        }};
        for (Map.Entry<String, Livro> livro : bibliotecaLivros1.entrySet()){
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        }
        System.out.println();
        System.out.println("Ordem Alfabética dos autores");
        System.out.println();
        Map<String,Livro> bibliotecaLivros2 = new TreeMap<>(bibliotecaLivros) {{
        }};
        for (Map.Entry<String, Livro> livro : bibliotecaLivros2.entrySet()){
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        }
        System.out.println();
        System.out.println("Ordem Alfabética dos Livros");
        System.out.println();
        Set<Map.Entry<String,Livro>> bibliotecaLivros3 = new TreeSet<>(new ComparatorNome());
        bibliotecaLivros3.addAll(bibliotecaLivros.entrySet());
        for (Map.Entry<String, Livro> livro : bibliotecaLivros3){
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        }


    }
}

class Livro {
    private String nome;
    private Integer paginas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", paginas=" + paginas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(nome, livro.nome) && Objects.equals(paginas, livro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }
}

class ComparatorNome implements Comparator<Map.Entry<String,Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> o1, Map.Entry<String, Livro> o2) {
        return o1.getValue().getNome().compareToIgnoreCase(o2.getValue().getNome());
    }
}

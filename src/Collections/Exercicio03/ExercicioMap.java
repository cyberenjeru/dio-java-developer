package Collections.Exercicio03;

import java.util.*;

import java.util.HashMap;

public class ExercicioMap {
    public static void main(String[] args) {
        System.out.println("Ordem aleatória");
        Map<Integer, Contato> agenda = new HashMap<>(){{
            put(1,new Contato("Haru", 12345));
            put(2,new Contato("Prizza", 99999));
            put(3,new Contato("Cymye", 123790));
        }};
        System.out.println(agenda);
        for(Map.Entry<Integer,Contato> entry: agenda.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("Ordem de Inserção");
        Map<Integer, Contato> agenda1 = new LinkedHashMap<>(){{
            put(1,new Contato("Haru", 12345));
            put(2,new Contato("Prizza", 99999));
            put(3,new Contato("Cymye", 123790));
        }};
        System.out.println(agenda1);
        for(Map.Entry<Integer,Contato> entry: agenda1.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("Ordem de id");
        Map<Integer, Contato> agenda2 = new TreeMap<>(agenda);
        System.out.println(agenda2);
        for(Map.Entry<Integer,Contato> entry: agenda2.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("Ordem de número de telefone");
       Set<Map.Entry<Integer, Contato>> agenda3 = new TreeSet<>(new ComparatorOrdemNumerica());
        agenda3.addAll(agenda.entrySet());
        for(Map.Entry<Integer,Contato> entry: agenda3){
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome() + " : " + entry.getValue().getNumero());
        }

        System.out.println("Ordem nome contato");
        Set<Map.Entry<Integer,Contato>> agenda4 = new TreeSet<>(new ComparatorOrdemNomeContato());
        agenda4.addAll(agenda.entrySet());
        for(Map.Entry<Integer,Contato> entry: agenda4){
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome() + " : " + entry.getValue().getNumero());
        }

    }
}
class ComparatorOrdemNumerica implements Comparator<Map.Entry<Integer,Contato>>{

    @Override
    public int compare(Map.Entry<Integer, Contato> o1, Map.Entry<Integer, Contato> o2) {
        return Integer.compare(o1.getValue().getNumero(),o2.getValue().getNumero());
    }
}

class ComparatorOrdemNomeContato implements Comparator<Map.Entry<Integer,Contato>>{
    @Override
    public int compare(Map.Entry<Integer, Contato> o1, Map.Entry<Integer, Contato> o2) {
        return o1.getValue().getNome().compareToIgnoreCase(o2.getValue().getNome());
    }
}

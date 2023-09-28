package Collections;

import java.util.*;

public class ExemploSet {
    public static void main(String[] args) {
        System.out.println("Crie um conunto e adicione as notas: ");
        Set<Double> notas = new HashSet<>(Arrays.asList(7d,8.5,5d,7d,0d,3.6));
        System.out.println(notas);
        System.out.println("Confira se a nota 5.0 está no conjunto: " + notas.contains(5d));
        System.out.println("Exiba a menor nota: " + Collections.min(notas));
        System.out.println("Exiba a maior nota:  " + Collections.max(notas));
        System.out.println("Exiba a soma dos valores: ");
        Iterator<Double> iterator= notas.iterator();
        Double soma = 0.0;
        while(iterator.hasNext()){
            Double next = iterator.next();
            soma += next;
        }
        System.out.println(soma);
        System.out.println("Exiba a média das notas: " + (soma/notas.size()));
        notas.remove(0d);
        System.out.println(notas);

    }
}

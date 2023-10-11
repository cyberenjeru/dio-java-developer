package Collections;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ExerciciosStreamAPI {
    public static void main(String[] args) {
        List<String> numerosAleatorios =
                Arrays.asList("1","0","4","1","2","3","9","9","6","5");

        System.out.println("Imprima todos os elementos dessa lsita de String:");
        numerosAleatorios.forEach(System.out::println);

        System.out.println("Pege os 5 primeiros números e coloque dentro de um Set:");
        numerosAleatorios.stream().limit(5).collect(Collectors.toSet()).forEach(System.out::println);

        System.out.println("Transforme esta lista de String em uma lista de números inteiros");
        List<Integer> numerosAleatorios1 = new java.util.ArrayList<>(numerosAleatorios.stream().map(Integer::parseInt).toList());

        System.out.println("Pegue os números pares e maiores que 2 e coleque em uma lista");
        numerosAleatorios.stream().map(Integer::parseInt).filter(i -> i % 2 == 0 && i > 2).toList().forEach(System.out::println);

        System.out.println("Mostre a média dos números");
        numerosAleatorios.stream().mapToInt(Integer::parseInt).average().ifPresent(System.out::println);

        System.out.println("Remova os números ímpares");
        numerosAleatorios1.removeIf(i -> (i % 2 != 0));
        System.out.println(numerosAleatorios1);
    }
}

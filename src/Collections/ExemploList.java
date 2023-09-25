package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExemploList {
    public static void main(String[] args) {

        System.out.println("Crie uma lista e adicione as sete notas: ");
        List<Double> notas = new ArrayList<>();
        notas.add(10.0);
        notas.add(8.5);
        notas.add(9.5);
        notas.add(7.0);
        notas.add(6.5);
        notas.add(8.0);
        notas.add(7.5);
        System.out.println(notas);
        System.out.println("Exiba a posição da nota 8: " + notas.indexOf(8.0));
        System.out.println("Adicione na lista a nota 8 na posição 4: ");
        notas.add(4,8.0);
        System.out.println(notas);
        System.out.println("Substitua a nota 8.5 por 9: ");
        notas.set(1,9.0);
        System.out.println(notas);
        System.out.println("Confira se a nota 5 está na lista: " + notas.contains(5.0));
        System.out.println("Exiba a menor nota: " + Collections.min(notas));

    }
}

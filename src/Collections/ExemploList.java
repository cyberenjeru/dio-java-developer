package Collections;

import java.util.ArrayList;
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

    }
}

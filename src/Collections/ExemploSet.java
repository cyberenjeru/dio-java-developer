package Collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ExemploSet {
    public static void main(String[] args) {
        System.out.println("Crie um conunto e adicione as notas: ");
        Set<Double> notas = new HashSet<>(Arrays.asList(7d,8.5,5d,7d,0d,3.6));
        System.out.println(notas);

    }
}

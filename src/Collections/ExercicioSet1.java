package Collections;

import java.util.*;

public class ExercicioSet1 {
    public static void main(String[] args) {
        Set<String> coresArcoIris = new HashSet<>();
        coresArcoIris.add("Amarelo");
        coresArcoIris.add("Vermelho");
        coresArcoIris.add("Azul");
        coresArcoIris.add("Violeta");
        coresArcoIris.add("Verde");
        coresArcoIris.add("Laranja");
        coresArcoIris.add("Indigo");
        System.out.println(coresArcoIris);

        System.out.println("Exiba todas as cores uma abaixo da outra: ");
        for (String cores : coresArcoIris) System.out.println(cores);

        System.out.println("A quantidade de cores que o arco-íris tem: " + coresArcoIris.size());

        Set<String> coresArcoIris2 = new TreeSet<>(coresArcoIris);
        System.out.println(coresArcoIris2);
        List<String> mylist = new ArrayList<String>(coresArcoIris);
        Collections.reverse(mylist);
        System.out.println(mylist);
        System.out.println("Exiba todas as cores que começam com a letra v:");
        for (String cores : coresArcoIris){
            if(cores.startsWith("V")) System.out.println(cores);
        }
        System.out.println("Remova todas as cores que não começam com a tera v:");
        Iterator<String> iterator = coresArcoIris.iterator();
        while(iterator.hasNext()){
            if(!iterator.next().startsWith("V")) iterator.remove();;
        }
        System.out.println(coresArcoIris);
        System.out.println("Limpe o conjunto.");
        coresArcoIris.clear();
        System.out.println("Confira se o conjunto está vazio: " + coresArcoIris.isEmpty());
    }
}


package Collections;
import java.util.*;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Double> temperaturas = new ArrayList<Double>();

        int count = 0;
        while(true){
            if(count == 6) break;

            System.out.println("Entre com a temperatura:");
            double temp = scan.nextDouble();
            temperaturas.add(temp);
            count++;
        }
        System.out.println("Todas as temperaturas:");
        temperaturas.forEach(t -> System.out.println(t + " "));

        double media = temperaturas.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
        System.out.printf("\nMédia das temperaturas: %.1f\n", media);

        System.out.println("Temperaturas acima da média: ");
        temperaturas.stream().filter(t ->t>media).forEach(t-> System.out.printf("%.1f ", t));

        System.out.println("Meses em que a temperatura ficou acima da média: ");
        Iterator<Double> iterator = temperaturas.iterator();
        count = 0;
        while (iterator.hasNext()){
            Double temp = iterator.next();
            if(temp > media){
                switch (count){
                    case (0):
                        System.out.println("1 - Janeiro: " + temp);
                        break;
                    case(1):
                        System.out.println("2 - Fevereiro: " + temp);
                        break;
                    case (2):
                        System.out.println("3 - Março: " + temp);
                        break;
                    case (3):
                        System.out.println("4 - Abril: " + temp);
                        break;
                    case (4):
                        System.out.println("5 - Maio " + temp);
                        break;
                    case (5):
                        System.out.println("6 - Junho: " + temp);
                        break;
                    default:
                        System.out.println("Não houve temperatura acima da média.");
                }
            }
            count++;
        }
    }
}
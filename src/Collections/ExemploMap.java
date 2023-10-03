package Collections;

import java.util.*;

public class ExemploMap {
    public static void main(String[] args) {
        System.out.println("Crie um dicionario que relacione os modelos e seus respectivos valores:");
        Map<String, Double> carrosPopulares = new HashMap<>(){{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares.toString());
        System.out.println("Substitua o consumo do gol por 15,2 km/l : ");
        carrosPopulares.put("gol", 15.2);
        System.out.println(carrosPopulares.toString());
        System.out.println("Confira se o o modelo tucso está no dicionário: " + carrosPopulares.containsKey("tucson"));
        System.out.println("Exiba o consumo do uno: " + carrosPopulares.get("uno"));
        System.out.println("Exiba os modelos: " + carrosPopulares.keySet());
        System.out.println("Exiba os consumos dos carros: " + carrosPopulares.values());
        System.out.println("Exiba o modelo mais econômico e seu consumo: ");
        Double max = Collections.max(carrosPopulares.values());
        Set<Map.Entry<String,Double>> entries = carrosPopulares.entrySet();
        String modeloMaisEficiente = " ";
        for (Map.Entry<String,Double> entry : entries){
            if (entry.getValue().equals(max)) modeloMaisEficiente = entry.getKey();
        }
        System.out.println("Modelo mais eficiente: " + modeloMaisEficiente + " - " + max);
        System.out.println("Exiba o modelo menos econômico e seu consumo: ");
        Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
        Set<Map.Entry<String,Double>> entries1 = carrosPopulares.entrySet();
        String modeloMenossEficiente = " ";
        for(Map.Entry<String,Double> entry1 : entries1){
            if (entry1.getValue().equals(consumoMenosEficiente)) modeloMenossEficiente = entry1.getKey();
        }
        System.out.println("Modelo menos eficiente: " + modeloMenossEficiente + " - " + consumoMenosEficiente);
        System.out.println("Exiba a soma dos consumos: ");
        Iterator<Double> iterator = carrosPopulares.values().iterator();
        Double soma = 0.0;
        while(iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.println(soma);
        System.out.println("Exiba a média dos consumos deste dicionário de carros: " + (soma/carrosPopulares.size()));
        System.out.println("Remova os modelos com o consumo igual a 15.6 km/l : ");
        String consumoIgual = " ";
        Iterator<Double> iterator1 = carrosPopulares.values().iterator();
        while(iterator1.hasNext()){
            if(iterator1.next().equals(15.6)) iterator1.remove();
        }
        System.out.println(carrosPopulares.toString());
        System.out.println("Exiba todos os carros an ordem em que foram informados: ");
        Map<String, Double> carrosPopulares1 = new LinkedHashMap<>(){{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares1.toString());
        System.out.println("Exiba o dicionário ordenado pelo modelo: ");
        Map<String,Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);
        System.out.println(carrosPopulares2.toString());
        System.out.println("Apague o dicionário de carros: ");
        carrosPopulares.clear();
        System.out.println("Confira se o dicionário está vazio: " + carrosPopulares.isEmpty());


    }
}

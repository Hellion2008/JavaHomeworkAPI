package HomeWork3;

import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        String[] planets = {
                "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto"};
        List<String> list = createSolarSystem(10, planets);
        System.out.println(list);
        showStrangeSolarSystem(list);

    }

    static List<String> createSolarSystem(int countPlanet, String[] solarSystem){
        Random random = new Random();
        List<String> planets = new ArrayList<>();
        for (int i = 0; i < countPlanet; i++) {
            planets.add(solarSystem[random.nextInt(0, solarSystem.length)]);
        }
        return planets;
    }

    static int planetCount(List<String> list, String planet){
        int count = 0;
        for(String x: list){
            if (x.equalsIgnoreCase(planet))
                count++;
        }
        return count;
    }

    static void showStrangeSolarSystem(List<String> list){
        List<String> tempList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (!tempList.contains(list.get(i))){
                tempList.add(list.get(i));
                int count = planetCount(list, list.get(i));
                System.out.printf("Planet %s - %s\n", list.get(i),count);
            }
        }
    }
}

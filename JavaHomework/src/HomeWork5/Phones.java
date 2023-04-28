package HomeWork5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phones {
    private Map<String, List<Integer>> map = new HashMap();

    void add(String lastName, int number){
        if (map.containsKey(lastName)){
            map.get(lastName).add(number);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(number);
            map.put(lastName, list);
        }
    }
    String getNumber(String lastName){
        StringBuilder res = new StringBuilder();
        if (map.containsKey(lastName)){
            res.append(lastName + ":\n");
            for (int i = 0; i < map.get(lastName).size(); i++) {
                res.append((i+1) + ") " + map.get(lastName).get(i) + "\n");
            }
        } else{
            res.append("This person is not in the phone book");
        }
        return res.toString();
    }

    String getByNumber(int number){
        String res = "No such number\n";
        for(Map.Entry<String,List<Integer>> entry: map.entrySet()){
            if (entry.getValue().contains(number)){
                res = entry.getKey() + " has number " + number + "\n";
                return res;
            }
        }
        return res;
    }

    String print(){
        return map.toString();
    }
}

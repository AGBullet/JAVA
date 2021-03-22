package HomeWork_3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("-----------------EX.1-----------------");
        String [] words = {
                "Apple", "Orange", "Apple", "Pineapple", "Banana", "Apple", "Grapes", "Mango", "Cherry", "Mango",};
        Map<String,Integer> map = new HashMap<>();
        for (String word :words)
        {
         map.put(word, map.getOrDefault(word,0)+1);
        }
        for(Map.Entry<String, Integer> entry : map.entrySet())
        {
            System.out.println(entry.getKey()+ "-"+ entry.getValue());
        }
        Set<String> uniq = new HashSet<>(Arrays.asList(words));
        System.out.println(uniq);
        // ex.2
        PhoneBookk phone = new PhoneBookk();

        phone.add("Иванов","123456789");
        phone.add("Петров","123456789");
        phone.add("Пушкин","12351589");
        phone.add("Стрельцов","121416789");
        phone.add("Клачков","1232422789");
        phone.add("Смирнов","987654321");

        System.out.println("-----------------EX.2-----------------");

        System.out.println(phone.get("Иванов"));



    }
}

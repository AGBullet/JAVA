package HomeWork_3;


import jdk.nashorn.internal.ir.IfNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBookk {
    private Map<String, HashSet<String>> map;

    PhoneBookk()
    {
        this.map = new HashMap<>();
    }
    void add(String LastName,String phone)
    {
        HashSet<String> numbers;

        if (map.containsKey(LastName))
        {
            numbers=map.get(LastName);

        }else
            {
                numbers = new HashSet<>();
            }
        numbers.add(phone);
        map.put(LastName, numbers);
    }
    Set<String> get(String LastName)
    {
        return map.get(LastName);
    }


}


package org.example;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Map<String,Integer> map = new HashMap<>();
        map.put("помидор", 5);
        map.put("помидор", 15);
        map.put("огурцы",10);
        map.put("бананы",15);


        System.out.println(map.get("помидор"));


        Collection<Integer> values = map.values();
        List<Integer> list = new ArrayList<>(values);
        System.out.println(list);


        System.out.println();
        Set<String> strings = map.keySet();
        System.out.println(strings);

        Set<Map.Entry<String,Integer>> entries = map.entrySet();

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }







    }
}

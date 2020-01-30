package programs.strings;

import java.util.*;
import java.lang.*;

public class KthLargestOccuringChar {

    public static void main(String[] args)  {
        String s = "aabcdeeee";
       // a-2,b-1,c-1,d-1,e-4
       // 4,2,1,1,1

        Map<Character, Integer> hm = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!hm.containsKey(cur)) {
                hm.put(cur, 1);
            }else {
                hm.put(cur, hm.get(cur) + 1);
            }
        }
        // the trick is to sort based on key which i missed.
        Map<Character,Integer> sortedMap = sorted(hm);
        int key = 4;
     /*   int key = 4;
        if(!sortedMap.containsValue(key)){
            System.out.println(-1);
        }else {*/
            int d = 0;
            boolean found = false;
            for (Map.Entry<Character,Integer>entry : sortedMap.entrySet()) {
                Character x = entry.getKey();
                if (d == (key-1)) {
                    found = true;
                    System.out.println("Value"+entry.getValue()+" "+x);
                    break;
                }
                d++;
            }

            if(!found){
                System.out.println(-1);
            }


        /*TreeMap<Integer, Character> tm = new TreeMap<>();

        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
            int x = entry.getValue();
            char cur = entry.getKey();
            if (!tm.containsKey(x)) {
                tm.put(x, cur);
            } else {
                if (cur < tm.get(x))
                    tm.put(x, cur);
            }

        }

        int k = 1; // print the kth most frequent character. If there are multiple, print the one with lesser value
        int tar = tm.size() - k;
        if (tar < 0) System.out.println("-1");
        else {
            int d = 0;
            for (Map.Entry<Integer, Character> entry : tm.entrySet()) {

                int x = entry.getKey();
                char cur = entry.getValue();
                if (d++ == tar) {
                    System.out.println(cur);
                    break;
                }
            }

        }
*/
    }

    private static Map<Character,Integer> sorted(Map<Character, Integer> hm) {

        // Create a list from elements of HashMap
        List<Map.Entry<Character, Integer> > list =
                new LinkedList<Map.Entry<Character, Integer> >(hm.entrySet());

        // Sort the list
        list.sort((o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));

        // put data from sorted list to hashmap
        HashMap<Character, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> aa : list) {
            if(!temp.containsValue(aa.getValue())) {
                temp.put(aa.getKey(), aa.getValue());
            }
        }
        return temp;
    }
}
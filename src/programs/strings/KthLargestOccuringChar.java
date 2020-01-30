package programs.strings;

import java.util.*;
import java.lang.*;

public class KthLargestOccuringChar {

    public static void main(String[] args)  {
        String s = "aabcd";
       // a-2,b-1,c-1,d-1

        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!hm.containsKey(cur)) {
                hm.put(cur, 1);
            }
            hm.put(cur, hm.get(cur) + 1);
        }
        // the trick is to sort based on key which i missed.
        TreeMap<Integer, Character> tm = new TreeMap<>();

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

    }
}
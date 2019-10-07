package programs;

import java.util.*;

public class Test {

    public static void main(String[] args) {

        new Test();
    }

    public Test() {


        ArrayList<Integer> a = new ArrayList<>();

        a.add(1);
        a.add(2);
        a.add(2);
        a.add(3);
        a.add(1);
        NavigableMap<Integer, Integer> map = new TreeMap<>();
        for (Integer integer : a)
            if (!map.containsKey(integer)) {
                map.put(integer, integer);
            } else {
                map.remove(integer, integer);
            }


        System.out.println(map.firstEntry().getValue().intValue());


    }


}

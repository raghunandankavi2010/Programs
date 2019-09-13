package programs;

import java.util.*;

public class Test {

    public static void main(String[] args) {

        new Test();
    }

    public Test(){




        ArrayList<Integer> a = new ArrayList<>();

        a.add(1);
        a.add(2);
        a.add(2);
        a.add(3);
        a.add(1);
        NavigableMap<Integer,Integer> map = new TreeMap<>();
        for(int i=0;i<a.size();i++)
        if(!map.containsKey(a.get(i)))
        {
            map.put(a.get(i),a.get(i));
        }else{
            map.remove(a.get(i),a.get(i));
        }


       System.out.println( map.firstEntry().getValue().intValue());



    }



}

package programs.lrucache;

import java.util.*;

public class LRUCacheTest {
    public static void main(String... args) {
        Map<Integer, String> cache = new LRUCache<>(5);

        for (int i = 0; i < 5; i++) {
            cache.put(i, "hi");
        }
        cache.put(6,"hi");
        cache.put(7,"hi");

        Iterator<Map.Entry<Integer, String>> it = cache.entrySet().iterator();
        for (Map.Entry<Integer,String> entry : cache.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
        Map.Entry<Integer, String> next = it.next();
        System.out.println("Item : "+next.getKey()+" Deleted : "+cache.remove(next.getKey()));
    }
}

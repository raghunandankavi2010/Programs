package programs.strings;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Given 10 Strings each of different length print
 * them in descending order
 */
public class SortListofStrings {

    public static void main(String[] args) {
        // Use LinkedList and you can sort while inserting
        // which is better cause ArrayList is backed by Array.
        // so when size increases it creates new array and copies old data
        // back to new array.
        List<String> mList = new ArrayList<>();
        String s = "a";
        for(int i=0;i<10;i++){
             s = s+i;
            mList.add(s);
        }
        mList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length()-o1.length();
            }
        });

        mList.forEach(System.out::println);
    }
}

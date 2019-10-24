package programs.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class WordBreak {

    private static Map<String,String> map = new HashMap<>();

    private static HashSet<String> set = new HashSet<>();

    public static void main(String[] args){

        String[] favArray= {"314","49","9001","15926535897",
                "14","9323","84626433","4",
                "793"};

        // add all @favArray elements to map
        for (String fav :favArray) {
            map.put(fav,fav);
            set.add(fav);

        }

       // System.out.println(check("samice"));
        System.out.println(SegmentString("314159265358979323846264338327",set));


    }

    public static boolean  check(String s){
        if(s.length()==0){
            return true;
        }
        // check if map contains the substring ie prefix
        // check if suffix also exists in map
        // if both prefix and suffix exists return true
        for(int i=1;i<=s.length();i++){
            if(map.containsValue(s.substring(0,i)) && check(s.substring(i,s.length()))){
                return true;
            }
        }
        return false;

    }

    private static String SegmentString(String input, Set<String> dict) {
        int len = input.length();
        for (int i = 1; i < len; i++) {
            String prefix = input.substring(0, i);
            if (dict.contains(prefix)) {
                String suffix = input.substring(i, len);
                if (dict.contains(suffix)) {
                    return prefix + " " + suffix;
                }
            }
        }
        return null;
    }

}




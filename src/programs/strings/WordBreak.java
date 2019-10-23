package programs.strings;

import java.util.HashMap;
import java.util.Map;


public class WordBreak {

    private static  Map<String,String> map = new HashMap<>();

    public static void main(String[] args){

        String[] favArray= {"mobile","samsung","sam","sung",
                "man","mango","icecream","and",
                "go","i","like","ice","cream"};

        // add all @favArray elements to map
        for (String fav :favArray) {
            map.put(fav,fav);

        }

        System.out.println(check("samice"));


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
}




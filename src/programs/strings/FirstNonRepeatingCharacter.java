package programs.strings;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given a string, find the first non-repeating character in it.
 * For example, if the input string is “GeeksforGeeks”,
 * then output should be ‘f’
 * and if input string is “GeeksQuiz”,then output should be ‘G’.
 */
public class FirstNonRepeatingCharacter {

    public static void main(String[] args){
        Map<String,Integer> map = new HashMap<>();
        String str = "aabcc";
        for(int i=0;i<str.length();i++){
            String value = Character.toString(str.charAt(i));
             if(map.containsKey(value)){
               map.put(value,map.get(value)+1);
            }else{
                 map.put(value,1);
             }
        }

        for(Map.Entry<String,Integer> entry: map.entrySet()){
            if(entry.getValue()==1){
                System.out.println(entry.getKey());
                break;
            }
        }
    }
}

package programs.strings;

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
        Map<String,Integer> map = new LinkedHashMap<>();
        String str = "GeeksQuiz";
        for(int i=0;i<str.length();i++){
            String value = Character.toString(str.charAt(i));
             if(map.containsKey(value)){
               map.put(value,map.get(value)+1);
            }else{
                 map.put(value,1);
             }
        }

        String result = null;
        for (int i = 0; i < str.length();  i++) {
            String value = Character.toString(str.charAt(i));
            if (map.get(value) == 1){
                result = value;
                break;
            }
        }
        System.out.println(result);
    }
}

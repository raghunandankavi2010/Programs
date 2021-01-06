package programs.strings;

/**
 *  Aaditya
 *  a - occurs 3
 *  while D occurs only once
 *  While comparing case is ignored but while printing
 *  print original character
 */
public class FirstNonRepeatingCharacterIgnoringCase {

    public static void main(String[] args)  {
        String input1 = "AaDitya";
        for(int i =0; i<input1.length(); i++) { //1
            boolean flag = false;
            char first = input1.charAt(i); // a
            for (int j = 0; j < input1.length(); j++) {
                if(i!=j) {// if you are at second position D ignore comparing it with itself
                    char second = input1.charAt(j);
                    if (Character.toLowerCase(first) == Character.toLowerCase(second)) { // ignore case and compare
                        flag = true;
                        break;
                    }
                }
            }
            if(!flag){
                System.out.println(first);
                break;
            }
        }
    }
}

package programs.strings;

public class RemoveDuplicatesString {

    public static void main(String[] args){
        String input = "aabbbcc";
        StringBuilder sb = new StringBuilder();
        boolean[] mod = new boolean[256];
        for(int i=0;i<input.length();i++){
            char val = input.charAt(i);
            if(!mod[val]){
                sb.append(val);
                mod[val]=true;
            }
        }
        System.out.println(sb.toString());
    }
}

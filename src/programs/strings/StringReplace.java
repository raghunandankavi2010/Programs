package programs.strings;

public class StringReplace {

    public static void main(String[] args) {
        String source = "Hello World   ".trim();
        source = source.replaceAll("\\s","%20");
        StringBuilder stringBuilder = new StringBuilder();
        char[] sourceChar = source.toCharArray();
        for(int i=0;i<sourceChar.length;i++){

            if(sourceChar[i]== ' '){
              stringBuilder.append("%20");
            }else {
                stringBuilder.append(sourceChar[i]);
            }
        }

        System.out.println(stringBuilder.toString());
        new StringReplace().repalce(sourceChar,source.length());
    }

    public void repalce(char[] s,int length){
        int spacecount=0,index;

        for(int i=0;i<length;i++){

            if(s[i]== ' '){
                spacecount++;
            }
        }
        index = length+ spacecount *2;

        for(int i = length-1;i>=0;i--){
            if(s[i]== ' '){
                s[index-1]='0';
                s[index-2]='2';
                s[index-3]='%';
                index= index -3;
            }else{
                s[index-1]= s[i];
                index--;
            }
        }

        System.out.println(s);
    }
}

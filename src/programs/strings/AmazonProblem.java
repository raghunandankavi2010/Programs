package programs.strings;

public class AmazonProblem {

    public AmazonProblem() {

    }

    public static void main(String[] args) {

        System.out.println(orignial("cbdae"));

    }


    private static StringBuilder sb;
    private static StringBuilder stringBuilder = new StringBuilder();


    private static String orignial(String input1) {

        sb = getString(new StringBuilder(input1));
        return sb.toString();

    }


    private static StringBuilder getString(StringBuilder source) {

        stringBuilder.append(source.charAt(0));
        source.deleteCharAt(0);
        while (source.length() > 0)

        {

            if (source.length() % 2 == 0) {
                stringBuilder.insert(0, Character.toString(source.charAt(0)));
                source.deleteCharAt(0);
            } else {
                stringBuilder.append(Character.toString(source.charAt(0)));
                source.deleteCharAt(0);
            }

        }

        return stringBuilder;

    }


}

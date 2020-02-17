package programs.others;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Patternmatching {

    public static void main(String[] args) {
        String input = "4nnnnnf";

        Patternmatching patternmatching = new Patternmatching();
        patternmatching.filter(input);
    }

    protected boolean filter(String input) {
        String regex = "^[a-zA-Z0-9]*$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
}

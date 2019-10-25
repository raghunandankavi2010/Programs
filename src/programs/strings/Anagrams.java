package programs.strings;

import java.util.stream.IntStream;

/**
 * Anagram -
 * Given String1 and String2
 * If String2 can be formed by re-arranging chars of String1
 * its a anagram else not a anagram
 */
public class Anagrams {

    public static void main(String[] args) {
        String s1 = "abcf";
        String s2 = "cabf";
        anagram(s1, s2);
    }

    private static void anagram(String s1, String s2) {

        StringBuilder sb = new StringBuilder(s2);
        char[] s = s1.toCharArray();

        for (char ch : s) {
            int index = sb.indexOf("" + ch);
            if (index != -1) {

                sb.deleteCharAt(index);

            }
        }

        if (sb.length() == 0) {
            System.out.println("Anagram");
        } else {
            System.out.println("Not an Anagram");

        }
    }

    private static void anagram2(String s1, String s2) {

        StringBuilder sb1 = new StringBuilder(s1);
        StringBuilder sb2 = new StringBuilder(s2);

        for (int i = 0; i < sb1.length(); i++) {
            int index = sb2.indexOf("" + sb1.charAt(i));
            if (index != -1) {

                sb1.deleteCharAt(index);
                sb2.deleteCharAt(index);

            }
        }

        int count = 0;
        for (int i = 0; i < sb1.length() + sb2.length(); i++) {

            count++;
        }
        System.out.println("Count " + count);
    }

    private static void numberNeeded(String first, String second) {
        int[] lettercounts = new int[26];
        for (char c : first.toCharArray()) {
            lettercounts[c - 'a']++;
        }
        for (char c : second.toCharArray()) {
            lettercounts[c - 'a']--;
        }
        int result = 0;
        for (int i : lettercounts) {
            result += Math.abs(i);
        }
        System.out.println("Count " + result);
    }

    private static void numberNeeded2(String one, String two) {
        int[] letters = new int[26];
        one.chars().forEach(c -> {
            letters[c - 'a']++;
        });
        two.chars().forEach(c -> {
            letters[c - 'a']--;
        });
        System.out.println("Count " + IntStream.of(letters).map(Math::abs).sum());
    }
}

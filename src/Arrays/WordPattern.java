package Arrays;

import java.util.*;

public class WordPattern {

    public static boolean wordPattern(String pattern, String s) {
        if (pattern == null || s == null) return false;

        char[] charr = pattern.toCharArray();
        String[] sarr = s.split(" ");

        if (sarr.length != charr.length) return false;

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < charr.length; i++) {
            char c = charr[i];
            String w = sarr[i];

            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(w)) return false;
            } else {
                if (wordToChar.containsKey(w)) return false;

                charToWord.put(c, w);
                wordToChar.put(w, c);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abba";
        String t = "dog dog dog dog";
        wordPattern(s, t);
    }
}

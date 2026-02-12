package Backtracking;

public class Permutation {

    public static void permutations(String str, String permutation) {
        if (str.isEmpty()) {
            System.out.println(permutation);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            permutations(newStr, permutation + currChar);
        }
    }

    public static void main(String[] args) {
        String str = "ABC";
        permutations(str, "");
    }
}

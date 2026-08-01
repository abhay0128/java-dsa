package ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Problem: Given an ArrayList of integers, remove duplicate values while
 * preserving the order of each value's first occurrence.
 *
 * Example: [4, 2, 4, 1, 2, 3] -> [4, 2, 1, 3]
 *
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class RemoveDuplicates {

    public static ArrayList<Integer> removeDuplicates(List<Integer> numbers) {
        return new ArrayList<>(new LinkedHashSet<>(numbers));
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(
                Arrays.asList(4, 2, 4, 1, 2, 3, 1));

        System.out.println("Original list: " + numbers);
        System.out.println("Without duplicates: " + removeDuplicates(numbers));
    }
}

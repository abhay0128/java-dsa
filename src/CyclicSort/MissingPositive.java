package CyclicSort;
import java.util.Arrays;

public class MissingPositive {

    public static int firstMissingPositiveInteger(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctSpot = nums[i] - 1;
            if (correctSpot >= 0 && correctSpot < nums.length && nums[i] != nums[correctSpot]) {
                int temp = nums[i];
                nums[i] = nums[correctSpot];
                nums[correctSpot] = temp;
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (j + 1 != nums[j]) {
                return j + 1;
            }
        }

        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 3, 4},
                {-1, 3, 5, 7, 1},
                {1, 5, 4, 3, 2},
                {-1, 0, 2, 1, 4},
                {1, 4, 3}
        };
        for (int i = 0; i < A.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tThe first missing positive integar in the list " + Arrays.toString(A[i]) + " is:");
            System.out.println("\t" + firstMissingPositiveInteger(A[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}

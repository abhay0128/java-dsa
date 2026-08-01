package CyclicSort;

public class MissingNumber {

    public static int findMissingNumber(int[] nums) {
        int lenNums = nums.length;
        int index = 0;
        int value = 0;

        while (index < lenNums) {
            value = nums[index];

            if (value < lenNums && value != nums[value]) {
                int temp = nums[index];
                nums[index] = nums[value];
                nums[value] = temp;
            }

            else if (value >= lenNums) {
                index += 1;
            }

            else {
                index += 1;
            }
        }

        for (int x = 0; x < lenNums; x++) {
            if (x != nums[x]) {
                return x;
            }
        }
        return lenNums;
    }

    public static void main(String[] args) {
        int[][] inputNumbers = {
                {4, 0, 3, 1},
                {8, 3, 5, 2, 4, 6, 0, 1},
                {1, 2, 3, 4, 6, 7, 8, 9, 10, 5},
                {0},
                {1, 2, 3, 0, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 23}
        };

        for (int i = 0; i < inputNumbers.length; i++) {
            System.out.print(i + 1 + ".\tnums: [");

            for (int j = 0; j < inputNumbers[i].length - 1; j++) {
                System.out.print(inputNumbers[i][j]);
                System.out.print(", ");
            }

            System.out.println(inputNumbers[i][inputNumbers[i].length - 1] + "]");

            System.out.println("\n\tMissing number: " + findMissingNumber(inputNumbers[i]));
        }
    }
}

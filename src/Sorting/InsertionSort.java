package Sorting;

public class InsertionSort {
    public static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {7, 8, 1, 3, 2};

        //insertion sort
        for(int i=1; i<arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > current) {
                //Keep swapping
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = current;
            for (int value : arr) {
                System.out.println(value + " ");
            }
        }

        printArray(arr);
    }
}

/*
Time Complexity:
worst case- O(n^2)
avg case - Θ(n^2)
best case - Ω(n)

Space complexity: O(1)
*/
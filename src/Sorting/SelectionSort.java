package Sorting;

public class SelectionSort {

    public static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {7, 8, 1, 3, 2};

        //selection sort
        for(int i=0; i<arr.length-1; i++) {
            int smallest = i;
            for(int j=i+1; j<arr.length; j++) {
                if(arr[j] < arr[smallest]) {
                    smallest = j;
                }
            }
            //swap
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
            System.out.println(arr[i]);
        }

        printArray(arr);
    }
}
/*
Time Complexity
worst case - O(n^2)
average case - Θ(n^2)
best case - Ω(n^2)

Space complexity: O(1)

*/

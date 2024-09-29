package Sorting;

public class QuickSort {

    public static void main(String[] args){
        int[] arr = {6,3,9,5,2,8};
        int n = arr.length;
        quickSort(arr,0,n-1);
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    public static void quickSort(int[] arr, int low, int high){
        if(low<high){
            int pidx= partition(arr, low, high);
            System.out.println("pivot index: "+pidx);
            System.out.println("1st recursive call."+"low index: "+low+" high index: "+high);
            quickSort(arr, low, pidx-1);
            System.out.println("2nd recursive call."+"low index: "+low+" high index: "+high);
            quickSort(arr, pidx+1, high);
        } else {
            System.out.println("low index is greater than high");
        }
    }

    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low-1;
        for(int j=low; j<high; j++){
            if(arr[j]<pivot){
                i++;
                //swapping
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //swap with pivot
        i++;
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i; //pivot index
    }
}

/*
Time Complexity
worst case - O(n^2)
average case - Θ(n log(n))
best case - Ω(n log(n))

Space complexity: O(n log(n))

*/
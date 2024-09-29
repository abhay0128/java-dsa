package Sorting;

public class MergeSort {
    public static int[] divide(int[] arr, int si, int ei){
        if(si>=ei){
            return null;
        }
        int mid = si+(ei-si)/2;
        divide(arr,si, mid);
        divide(arr,mid+1,ei);
        return conquer(arr,si,mid,ei);
    }

    public static int[] conquer(int[] arr, int si, int mid, int ei){
        int[] merged = new int[ei-si+1];
        int idx1 = si;
        int idx2 = mid+1;
        int x=0;
        while(idx1<=mid && idx2<=ei){
            if(arr[idx1]<arr[idx2]) {
                merged[x++] = arr[idx1++];
            } else{
                merged[x++] = arr[idx2++];
            }
        }
        while(idx1<=mid){
            merged[x++] = arr[idx1++];
        }
        while(idx2<=ei){
            merged[x++]  =arr[idx2++];
        }

        for(int i=0, j=si; i<merged.length; i++, j++){
            arr[j] = merged[i];
        }
        return merged;
    }

    public static void main(String[] args) {
        int[] arr = {1,6,7,3,5,8,9};
        int ei = arr.length-1;
        int[] sorted = divide(arr,0, ei);
        assert sorted != null;
        for(int p: sorted){
            System.out.print(p+" ");
        }
        System.out.println();
    }
}

/*
Time Complexity
worst case - O(n log(n))
average case - Θ(n log(n))
best case - Ω(n log(n))

Space complexity: O(n)

*/
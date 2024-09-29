package arrays;

public class ArrayRemoveDup {

    public static void main(String[] args) {
        int [] arr = {1,1,2,2,3,6,4,45,23,14,2,3,4,6,8,78,89,90};
        int end = arr.length;

        for (int i = 0; i < end; i++) {
            for (int j = i + 1; j < end; j++) {
                if (arr[i] == arr[j]) {
	                /*int shiftLeft = j;
	                for (int k = j+1; k < end; k++, shiftLeft++) {
	                    arr[shiftLeft] = arr[k];
	                }*/
                    arr[j] = arr[end-1];
                    end--;
                    j--;
                }
            }
        }

        int[] whitelist = new int[end];

        System.arraycopy(arr, 0, whitelist, 0, end);
        for(int i = 0; i < end; i++){
            System.out.print(whitelist[i]+" ");
        }
    }
}

// O(n^2)
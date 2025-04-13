package Arrays;

public class MergeTwoSortedArray {

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 7, 9, 11};
        int[] arr2 = {2, 3, 5, 6, 8, 10, 12};
        int[] m = mergeArray(arr1, arr2);
        double median = 0;
        if (m.length % 2 != 0) {
            median = m[m.length / 2];
        } else {
            double e1 = m[(m.length / 2) - 1];
            double e2 = m[m.length / 2];
            median = (e1 + e2) / 2;
        }
        System.out.println("median: " + median);
    }

    private static int[] mergeArray(int[] arr1, int[] arr2) {
        int n = arr1.length + arr2.length;
        int[] merged = new int[n];
        int idx1 = 0, idx2 = 0;
        int x = 0;
        while (idx1 < arr1.length && idx2 < arr2.length) {
            if (arr1[idx1] <= arr2[idx2]) {
                merged[x++] = arr1[idx1++];
            } else {
                merged[x++] = arr2[idx2++];
            }
        }
        while (idx1 < arr1.length) {
            merged[x++] = arr1[idx1++];
        }
        while (idx2 < arr2.length) {
            merged[x++] = arr2[idx2++];
        }
        for (int k = 0; k < merged.length; k++) {
            System.out.print(merged[k] + " ");
        }
        return merged;
    }

}

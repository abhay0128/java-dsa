package Arrays;

public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        /*int[] merged = new int[m+n];
        int idx=0, idx1=0, idx2=0;
        while(idx1<m && idx2<n) {
            if(nums1[idx1]<=nums2[idx2]) {
                merged[idx++] = nums1[idx1++];
            } else {
                merged[idx++] = nums2[idx2++];
            }
        }
        while(idx1<m) {
            merged[idx++] = nums1[idx1++];
        }
        while(idx2<n) {
            merged[idx++] = nums2[idx2++];
        }
        for (int k = 0; k < merged.length; k++) {
            System.out.print(merged[k] + " ");
        }*/

        int i = m - 1; // Last element in nums1's actual content
        int j = n - 1; // Last element in nums2
        int k = m + n - 1; // Last position in nums1 (with buffer)

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // Only need to check if nums2 has leftovers
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
        for (int p = 0; p < nums1.length; p++) {
            System.out.print(nums1[p] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,0,0,0};
        int[] arr2 = {2, 5, 6};
        merge(arr1, 3, arr2, 3);
    }
}

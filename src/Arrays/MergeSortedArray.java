package Arrays;

public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

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

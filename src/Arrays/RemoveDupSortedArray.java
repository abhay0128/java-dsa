package Arrays;

public class RemoveDupSortedArray {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        int i = 0;
        int n = nums.length;
        for (int j = 1; j < n; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        for(int p = 0; p < n; p++){
            System.out.print(nums[p]+" ");
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int [] arr = {0,0,0,0,1,1,1,2,2,3,3,4};
        removeDuplicates(arr);

    }
}

package Arrays;

/* Problem : LeetCode 169. Majority Element
* Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times.
* You may assume that the majority element always exists in the array.
* */
public class MooreAlgoMajorityElement {

    public static int majorityElement(int[] nums) {
        int freq = 0;
        int result = 0;

        for (int n : nums) {
            if (freq == 0) {
                result = n;
            }
            if (result == n) {
                freq++;
            } else {
                freq--;
            }
        }
        System.out.println("ans:"+result+" freq: "+freq);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,4,5,3,7,8,9,2,1,1,1,1,1,1};
        majorityElement(nums);
    }
}

/**
 * https://leetcode.com/problems/maximum-subarray/submissions/
 * Daily Coding Problem #524
 */
public class MaxSumSubarray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int curr_max = nums[0];

        for(int i = 1 ; i < nums.length ; i++) {
            if(curr_max < 0) {
                curr_max = nums[i];
            }
            else {
                curr_max += nums[i];
            }

            max = Math.max(max, curr_max);
        }

        return max;
    }
}

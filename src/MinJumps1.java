/**
 * https://leetcode.com/problems/jump-game/
 * Daily Coding Problem #512
 */
public class MinJumps1 {

    /**
     * Time complexity - O(n)
     * Space complexity - O(1)
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int maxReachableIndex = 0;
        int n = nums.length;

        int j = 0;
        while (j < n) {
            if (j > maxReachableIndex) {
                return false;
            }

            maxReachableIndex = Math.max(maxReachableIndex, nums[j] + j);
            j++;
        }

        return true;
    }
}

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/jump-game-ii/">Min Jump Problem/</a>
 * Daily Coding Problem #511
 */
public class MinimumJumps {

    /**
     * Solution#1 =>
     * Time complexity: O(n^2)
     * Space complexity: O(n)
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int n = nums.length;
        int[] minJumps = new int[n];
        Arrays.fill(minJumps, Integer.MAX_VALUE);

        minJumps[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= nums[i] && i + j < n; j++) {
                if (minJumps[i] != Integer.MAX_VALUE)
                    minJumps[i + j] = Math.min(minJumps[i + j], minJumps[i] + 1);
            }
        }
        return minJumps[n - 1];
    }

    /**
     * Solution#2 =>
     * Space complexity: O(n1)
     *
     * @param nums
     * @return
     */
    public int jump1(int[] nums) {
        int n = nums.length;
        int minReachableIndex = 0;
        int maxReachableIndex = 0;
        int jumps = 0;

        int j = 0;
        while(maxReachableIndex < n - 1) {
            int min = maxReachableIndex;
            int max = maxReachableIndex;
            for(int k = minReachableIndex ; k <= maxReachableIndex && k < n ; k++) {
                max = Math.max(max, k + nums[k]);
            }
            minReachableIndex = min + 1;
            maxReachableIndex = Math.max(maxReachableIndex, max);
            jumps++;
        }
        return jumps;
    }
}

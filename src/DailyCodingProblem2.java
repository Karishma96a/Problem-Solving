/**
 * https://leetcode.com/problems/product-of-array-except-self/
 */
public class DailyCodingProblem2 {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = product;
            product *= nums[i];
        }

        product = 1;

        for (int i = n - 1; i >= 0; i--) {
            res[i] *= product;
            product *= nums[i];
        }

        return res;
    }
}

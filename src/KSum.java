import java.util.*;

/**
 * https://leetcode.com/problems/3sum/
 * Daily Coding Problem #518
 */
public class KSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                addIfZero(nums, nums[i], i + 1, res);
            }
        }
        return res;
    }

    public void addIfZero(int[] nums, int x, int index, List<List<Integer>> res) {
        int n = nums.length;
        int total = -1 * x;

        Set<Integer> lows = new HashSet<>();
        int low = index, high = n - 1;
        while (low < high) {
            if (nums[low] + nums[high] == total) {
                if (!lows.contains(nums[low])) {
                    List<Integer> partialRes = Arrays.asList(x, nums[low], nums[high]);
                    res.add(partialRes);
                    lows.add(nums[low]);
                }
                low++;
                high--;
            } else if (nums[low] + nums[high] < total) {
                low++;
            } else {
                high--;
            }
        }
    }
}

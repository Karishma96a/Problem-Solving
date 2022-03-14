/**
 * Daily Coding Problem #565
 */
public class JumpsPossible {
    public boolean canJump(int[] nums) {
        int maxPossible = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxPossible) {
                return false;
            }

            if (maxPossible >= nums.length - 1) {
                return true;
            }

            maxPossible = Math.max(maxPossible, i + nums[i]);
        }

        return true;
    }
}

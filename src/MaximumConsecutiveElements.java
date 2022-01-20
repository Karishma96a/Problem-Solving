import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://www.interviewbit.com/problems/longest-consecutive-sequence/#
 * Problem #514
 */
public class MaximumConsecutiveElements {
    /**
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     *
     * @param A
     * @return
     */
    public int longestConsecutive(final List<Integer> A) {
        Set<Integer> s = new HashSet<>(A);
        int n = s.size();
        if (n == 0 || n == 1) return n;

        int maxLength = 1;
        for (Integer curr : s) {
            int currMaxLength = 1;
            if (s.contains(curr + 1)) continue;

            int search = curr - 1;
            while (s.contains(search)) {
                currMaxLength++;
                search--;
            }
            maxLength = Math.max(maxLength, currMaxLength);
        }

        return maxLength;
    }
}

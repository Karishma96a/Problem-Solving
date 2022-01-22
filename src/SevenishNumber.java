/**
 * Idea - https://www.geeksforgeeks.org/find-nth-magic-number/
 * Daily Coding Problem #516
 */
public class SevenishNumber {

    public static int findNthSevenishNumber(int n) {
        int res = 0;
        int power = 0;

        while (n > 0) {
            if (n % 2 != 0) {
                res += Math.pow(7, power);
            }
            power++;
            n /= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findNthSevenishNumber(10));
    }
}

/**
 * https://leetcode.com/problems/zigzag-conversion/
 * Daily Coding Problem #521
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;

        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i = 0 ; i < numRows ; i++)
            sb[i] = new StringBuilder();

        int n = s.length();
        boolean down = true;
        int row = 0;

        for(int i = 0 ; i < n ; i++) {
            sb[row].append(s.charAt(i));

            if(row == numRows - 1) {
                down = false;
            }
            if(row == 0) {
                down = true;
            }

            if(down) row++;
            else row--;
        }

        StringBuilder res = new StringBuilder();
        for(int i = 0; i < numRows ; i++) {
            res.append(sb[i].toString());
        }
        return res.toString();
    }
}

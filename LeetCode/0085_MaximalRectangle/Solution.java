class Solution {
    public int maximalRectangle(char[][] matrix) {

        int rl = matrix.length;
        int cl = matrix[0].length;
        int[] dp = new int[cl];
        int ret = 0;
        for (int r = 0; r < rl; r++) {
            for (int c = 0; c < cl; c++) {
                if (matrix[r][c] == '0') {
                    dp[c] = 0;
                } else {
                    dp[c]++;
                    int idx = c;
                    int min = dp[c];
                    while (idx >= 0 && dp[idx] > 0) {
                        min = Integer.min(min, dp[idx]);
                        ret = Integer.max(ret, (c - idx + 1) * min);
                        idx--;
                    }
                }

            }
        }
        return ret;

    }
}

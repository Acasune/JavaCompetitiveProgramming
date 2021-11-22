class Solution {
    public int numTrees(int n) {
        int[] memo = new int[n + 1];
        memo[1] = 1;
        return recursive(memo, 0, n - 1);
    }

    private int recursive(int[] memo, int left, int right) {
        if (right - left <= 0) {
            return 1;
        }
        if (memo[right - left + 1] != 0) {
            return memo[right - left + 1];
        }
        for (int m = left; m <= right; m++) {
            memo[right - left + 1] += recursive(memo, left, m - 1) * recursive(memo, m + 1, right);
        }
        return memo[right - left + 1];
    }
}

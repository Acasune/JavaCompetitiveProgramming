class Solution {
    public int largestRectangleArea(int[] heights) {
        int ret = heights[0];
        int[] memo = new int[heights.length];
        memo[0] = -1;

        for (int i = 0; i < heights.length; i++) {
            int k = i - 1;
            while (k >= 0 && heights[k] >= heights[i]) {
                ret = Math.max(ret, heights[k] * (i - 1 - memo[k]));
                k = memo[k];
            }
            memo[i] = k;
        }
        int k = heights.length - 1;
        while (k > -1) {
            ret = Math.max(ret, heights[k] * (heights.length - memo[k] - 1));
            k = memo[k];
        }
        return ret;
    }
}

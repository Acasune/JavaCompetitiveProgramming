class Solution {
    public int minPathSum(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        int[][] memo = new int[height][width];
        memo[0][0] = grid[0][0];
        for (int i = 1; i < width; i++) {
            memo[0][i] = memo[0][i - 1] + grid[0][i];
        }
        for (int j = 1; j < height; j++) {
            memo[j][0] = memo[j - 1][0] + grid[j][0];
        }
        for (int w = 1; w < width; w++) {
            for (int h = 1; h < height; h++) {
                memo[h][w] = Math.min(memo[h - 1][w], memo[h][w - 1]) + grid[h][w];
            }
        }
        return memo[height - 1][width - 1];

    }
}

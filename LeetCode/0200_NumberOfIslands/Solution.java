class Solution {
    public int numIslands(char[][] grid) {
        int[][] DYX = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int height = grid.length, width = grid[0].length;
        int cntIsland = 0;
        Stack<int[]> stk = new Stack<>();
        int[][] visited = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                visited[i][j] = -1;
            }
        }
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (visited[y][x] != -1 || grid[y][x] == '0')
                    continue;
                cntIsland += 1;
                stk.push(new int[] { y, x });
                while (!stk.isEmpty()) {
                    int[] target = stk.pop();
                    int j = target[0], i = target[1];
                    if (visited[j][i] != -1 || grid[j][i] == '0')
                        continue;
                    visited[j][i] = cntIsland;

                    for (var dyx : DYX) {
                        int dy = dyx[0], dx = dyx[1];
                        if (0 <= j + dy && j + dy < height && 0 <= i + dx && i + dx < width
                                && grid[j + dy][i + dx] == '1') {
                            stk.push(new int[] { j + dy, i + dx });
                        }
                    }

                }

            }
        }
        return cntIsland;
    }

}

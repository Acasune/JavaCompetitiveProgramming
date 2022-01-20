class Solution {
    public boolean exist(char[][] board, String word) {
        int v = board[0].length;
        int h = board.length;
        char[] cs = word.toCharArray();
        int len = word.length();
        boolean[][] visited = new boolean[h][v];

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < h; j++) {
                if (board[j][i] == cs[0]) {
                    visited[j][i] = true;
                    if (dfs(v, h, board, cs, len, j, i, 1, visited)) {
                        return true;
                    }
                    visited[j][i] = false;
                }
            }
        }
        return false;

    }

    boolean dfs(int v, int h, char[][] board, char[] cs, int len, int y, int x, int i, boolean[][] visited) {
        if (i == len) {
            return true;
        }
        int[][] dyx = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        boolean flg = false;
        for (var d : dyx) {
            int ny = y + d[0];
            int nx = x + d[1];
            if (0 <= ny && ny < h && 0 <= nx && nx < v) {
                if (board[ny][nx] == cs[i] && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    flg |= dfs(v, h, board, cs, len, ny, nx, i + 1, visited);
                    visited[ny][nx] = false;
                }
            }
        }
        return flg;
    }
}

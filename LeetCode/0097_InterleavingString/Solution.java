class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length(), l2 = s2.length();
        if (l1 + l2 != s3.length()) {
            return false;
        }
        boolean[][] visited = new boolean[l1 + 1][l2 + 1];

        return dfs(s1, s2, s3, l1, l2, 0, 0, visited);

    }

    private boolean dfs(String s1, String s2, String s3, int l1, int l2, int i, int j, boolean[][] visited) {
        if (i == l1 && j == l2) {
            return true;
        }
        visited[i][j] = true;

        boolean flg = false;
        if (i < l1 && s1.charAt(i) == s3.charAt(i + j) && !visited[i + 1][j]) {
            flg |= dfs(s1, s2, s3, l1, l2, i + 1, j, visited);
        }
        if (flg) {
            return flg;
        }
        if (j < l2 && s2.charAt(j) == s3.charAt(i + j) && !visited[i][j + 1]) {
            flg |= dfs(s1, s2, s3, l1, l2, i, j + 1, visited);
        }
        return flg;

    }
}

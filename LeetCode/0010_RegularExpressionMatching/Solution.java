class Solution {
    public boolean isMatch(String s, String p) {
        return dfs(s.toCharArray(), p.toCharArray(), s.length(), p.length());
    }

    boolean dfs(char[] a, char[] b, int i, int j) {
        if (i == 0 && j == 0) {
            return true;
        }
        if (i != 0 && j == 0) {
            return false;
        }
        if (i == 0 && j != 0) {
            if (b[j - 1] == '*') {
                return dfs(a, b, i, j - 2);
            }
            return false;
        }

        if (a[i - 1] == b[j - 1] || b[j - 1] == '.') {
            return dfs(a, b, i - 1, j - 1);
        } else if (b[j - 1] == '*') {
            if (dfs(a, b, i, j - 2))
                return true;
            if (b[i - 2] == a[i - 1] || b[j - 2] == '.') {
                return dfs(a, b, i - 1, j);
            }
        }
        return false;
    }
}

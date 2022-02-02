class Solution {
  public int maximalSquare(char[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] memo = new int[m][n];
    int ret = 0;
    for (int i = 0; i < m; i++) {
      if (matrix[i][0] == '1') {
        ret = 1;
      }
      memo[i][0] = matrix[i][0] - '0';
    }
    for (int i = 0; i < n; i++) {
      if (matrix[0][i] == '1') {
        ret = 1;
      }
      memo[0][i] = matrix[0][i] - '0';
    }
    for (int j = 1; j < m; j++) {
      for (int i = 1; i < n; i++) {
        if (matrix[j][i] == '0') {
          continue;

        }
        int vMax = 0;
        int hMax = 0;
        for (int k = j - 1; k >= 0; k--) {
          if (matrix[k][i] == '0') {
            break;
          }
          vMax++;
        }
        for (int k = i - 1; k >= 0; k--) {
          if (matrix[j][k] == '0') {
            break;
          }
          hMax++;
        }
        int edgeLen = Math.min(memo[j - 1][i - 1], Math.min(vMax, hMax)) + 1;
        memo[j][i] = edgeLen;
        ret = Math.max(edgeLen * edgeLen, ret);
      }
    }
    return ret;
  }
}

class NumMatrix {
  int[][] cumMatrix;

  public NumMatrix(int[][] matrix) {
    int rl = matrix.length;
    int cl = matrix[0].length;
    cumMatrix = new int[rl + 1][cl + 1];
    for (int y = 1; y < rl + 1; y++) {
      for (int x = 1; x < cl; x++) {
        cumMatrix[y][x] = cumMatrix[y][x - 1] + matrix[y - 1][x - 1];
      }
    }
    for (int x = 1; x < cl + 1; x++) {
      for (int y = 1; y < rl; y++) {
        cumMatrix[y][x] += cumMatrix[y - 1][x];
      }
    }

  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    return cumMatrix[row2 + 1][col2 + 1] - cumMatrix[row2][col1 + 1] - cumMatrix[row1 + 1][col2]
        + cumMatrix[row1][col1];

  }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

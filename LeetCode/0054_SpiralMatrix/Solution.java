import java.util.LinkedList;

class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> ret = new LinkedList<>();
    int cnt = 0;
    int i = 0, j = 0;
    int h = matrix.length, v = matrix[0].length;
    Command state = Command.RIGHT;
    while (cnt < h * v) {
      switch (state) {
        case RIGHT:
          if (i < v && matrix[j][i] != 1_000) {
            ret.add(matrix[j][i]);
            matrix[j][i] = 1_000;
            i++;
          } else {
            i--;
            j++;
            ret.add(matrix[j][i]);
            matrix[j][i] = 1_000;
            j++;
            state = Command.DOWN;
          }
          break;
        case DOWN:
          if (j < h && matrix[j][i] != 1_000) {
            ret.add(matrix[j][i]);
            matrix[j][i] = 1_000;
            j++;
          } else {
            i--;
            j--;
            ret.add(matrix[j][i]);
            matrix[j][i] = 1_000;
            i--;
            state = Command.LEFT;
          }
          break;
        case LEFT:
          if (0 <= i && matrix[j][i] != 1_000) {
            ret.add(matrix[j][i]);
            matrix[j][i] = 1_000;
            i--;
          } else {
            i++;
            j--;
            ret.add(matrix[j][i]);
            matrix[j][i] = 1_000;
            j--;
            state = Command.UP;
          }
          break;
        case UP:
          if (0 <= j && matrix[j][i] != 1_000) {
            ret.add(matrix[j][i]);
            matrix[j][i] = 1_000;
            j--;
          } else {
            i++;
            j++;
            ret.add(matrix[j][i]);
            matrix[j][i] = 1_000;
            i++;
            state = Command.RIGHT;
          }
          break;
      }
      cnt++;
    }
    return ret;
  }

  enum Command {
    RIGHT,
    DOWN,
    LEFT,
    UP
  }
}

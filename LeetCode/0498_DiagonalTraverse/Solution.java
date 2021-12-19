import java.util.LinkedList;
import java.util.List;

class Solution {
  public int[] findDiagonalOrder(int[][] mat) {
    int rl = mat.length - 1;
    int cl = mat[0].length - 1;
    int i = 0, j = 0;
    List<Integer> ret = new LinkedList<>();
    boolean isUpperRight = true;
    while (true) {
      ret.add(mat[i][j]);
      if (i == rl && j == cl) {
        break;
      }
      if (isUpperRight) {
        if (j == cl) {
          isUpperRight = false;
          i++;
        } else if (i == 0) {
          isUpperRight = false;
          j++;
        } else {
          i--;
          j++;
        }
      } else {
        if (i == rl) {
          isUpperRight = true;
          j++;
        } else if (j == 0) {
          isUpperRight = true;
          i++;
        } else {
          i++;
          j--;
        }
      }
    }
    return ret.stream()
        .mapToInt(Integer::intValue)
        .toArray();
  }
}

import java.util.Arrays;

class Solution {
  public int[][] kClosest(int[][] points, int k) {
    return Arrays.stream(points).sorted((a, b) -> a[0] * a[0] + a[1] * a[1] - (b[0] * b[0] + b[1] * b[1]))
        .limit(k)
        .toArray(int[][]::new);
  }
}

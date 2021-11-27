import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public int[][] updateMatrix(int[][] mat) {
    int[][] dd = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    int h = mat.length, w = mat[0].length;
    int[][] memo = new int[h][w];
    Queue<Bean> que = new LinkedList<>();
    for (int y = 0; y < h; y++) {
      for (int x = 0; x < w; x++) {
        if (mat[y][x] == 0) {
          que.add(new Bean(y, x, 0));
        } else {
          memo[y][x] = 100000000;
        }
      }
    }

    while (!que.isEmpty()) {
      Bean bean = que.poll();
      if (bean.val < memo[bean.y][bean.x]) {
        memo[bean.y][bean.x] = bean.val;
      }

      for (int[] d : dd) {
        int ny = bean.y + d[0];
        int nx = bean.x + d[1];
        if (0 <= ny && ny < h && 0 <= nx && nx < w && bean.val + 1 < memo[ny][nx]) {
          que.add(new Bean(ny, nx, bean.val + 1));
        }
      }
    }
    return memo;
  }

  static class Bean {
    int y, x, val;

    Bean(int y, int x, int val) {
      this.y = y;
      this.x = x;
      this.val = val;

    }
  }
}

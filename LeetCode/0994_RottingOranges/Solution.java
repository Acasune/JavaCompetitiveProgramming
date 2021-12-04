import java.util.Queue;

class Solution {
  public int orangesRotting(int[][] grid) {
    int ans = 0;
    int h = grid.length, w = grid[0].length;
    int[] DYX = new int[] { -2, -1, 1, 2 };
    int[][] visited = new int[h][w];
    Queue<int[]> que = new LinkedList<>();
    for (int i = 0; i < h; i++)
      for (int j = 0; j < w; j++) {
        if (grid[i][j] == 2) {
          que.add(new int[] { i, j, 0 });
        }
        visited[i][j] = 1_000_000_000;
      }
    while (!que.isEmpty()) {
      int[] elem = que.poll();
      int y = elem[0];
      int x = elem[1];
      int time = elem[2];
      if (visited[y][x] < time)
        continue;
      visited[y][x] = time;
      ans = Math.max(ans, time);
      for (var dyx : DYX) {
        int ny = y + dyx / 2;
        int nx = x + dyx % 2;
        if (0 <= ny && ny < h && 0 <= nx && nx < w) {
          if (grid[ny][nx] != 1)
            continue;
          que.add(new int[] { ny, nx, time + 1 });
        }
      }
    }
    for (int i = 0; i < h; i++)
      for (int j = 0; j < w; j++) {
        if (grid[i][j] == 1 && visited[i][j] == 1_000_000_000) {
          return -1;
        }
      }

    return ans;

  }
}

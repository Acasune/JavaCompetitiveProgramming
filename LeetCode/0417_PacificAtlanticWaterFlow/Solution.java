import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    List<List<Integer>> ret = new LinkedList<>();
    boolean[][] isOk = new boolean[heights.length][heights[0].length];
    for (int j = 0; j < heights.length; j++) {
      for (int i = 0; i < heights[0].length; i++) {
        if (bfs(heights, j, i, isOk)) {
          ret.add(List.of(j, i));
        }
      }
    }
    return ret;

  }

  boolean bfs(int[][] heights, int j, int i, boolean[][] isOk) {
    int[][] D = new int[][] { { 1, 0, }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    boolean hasReachedAtlantic = false;
    boolean hasReachedPacific = false;
    int H = heights.length;
    int W = heights[0].length;
    boolean[][] visited = new boolean[H][W];
    Queue<int[]> que = new LinkedList<>();
    que.add(new int[] { j, i });
    while (!que.isEmpty()) {
      int[] pos = que.poll();
      int h = pos[0];
      int w = pos[1];
      if (h == 0 || w == 0) {
        hasReachedAtlantic = true;
      }
      if (h == H - 1 || w == W - 1) {
        hasReachedPacific = true;
      }
      if (hasReachedAtlantic && hasReachedPacific || isOk[h][w]) {
        isOk[j][i] = true;
        isOk[h][w] = true;
        return true;
      }
      visited[h][w] = true;
      for (var d : D) {
        int ny = h + d[0];
        int nx = w + d[1];
        if (0 <= ny && ny < H && 0 <= nx && nx < W) {
          if (!visited[ny][nx] && heights[ny][nx] <= heights[h][w]) {
            que.add(new int[] { ny, nx });
          }
        }
      }
    }
    return false;
  }
}

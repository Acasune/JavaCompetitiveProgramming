import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
  public int networkDelayTime(int[][] times, int n, int k) {
    int MAX = Integer.MAX_VALUE;
    int[] dist = new int[n];
    Arrays.fill(dist, MAX);

    Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
    for (int[] time : times) {
      map.putIfAbsent(time[0] - 1, new HashMap<>());
      map.get(time[0] - 1).put(time[1] - 1, time[2]);
    }

    PriorityQueue<int[]> pque = new PriorityQueue<>(10, (a, b) -> Integer.compare(a[0], b[0]));
    dist[k - 1] = 0;
    boolean[] visited = new boolean[n + 1];
    int res = 0;

    pque.add(new int[] { 0, k - 1 });
    while (!pque.isEmpty()) {
      int[] cur = pque.remove();
      int curNode = cur[1];
      int curDist = cur[0];
      if (visited[curNode])
        continue;
      visited[curNode] = true;
      res = curDist;
      n--;
      if (map.containsKey(curNode)) {
        for (int next : map.get(curNode).keySet()) {
          pque.add(new int[] { curDist + map.get(curNode).get(next), next });
        }
      }
    }
    return n == 0 ? res : -1;
  }
}

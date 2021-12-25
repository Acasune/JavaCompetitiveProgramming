import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
  public List<String> findItinerary(List<List<String>> tickets) {
    LinkedList<String> ret = new LinkedList<>();
    Map<String, PriorityQueue<String>> mp = new HashMap<>();
    for (var ticket : tickets) {
      mp.putIfAbsent(ticket.get(0), new PriorityQueue<>());
      mp.get(ticket.get(0)).add(ticket.get(1));
    }
    dfs("JFK", ret, mp);
    return ret;
  }

  void dfs(String s, LinkedList<String> ret, Map<String, PriorityQueue<String>> mp) {
    PriorityQueue<String> que = mp.get(s);
    while (que != null && !que.isEmpty())
      dfs(que.poll(), ret, mp);
    ret.addFirst(s);
  }
}

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
  public List<String> wordBreak(String s, List<String> wordDict) {

    Map<Character, List<Map<String, Integer>>> wm = new HashMap<>();
    for (String w : wordDict) {
      Map<String, Integer> tmp = new HashMap<>();
      tmp.put(w, w.length());
      if (!wm.containsKey(w.charAt(0))) {
        wm.put(w.charAt(0), new LinkedList<>());
      }
      List<Map<String, Integer>> tmpList = wm.get(w.charAt(0));
      tmpList.add(tmp);
      wm.put(w.charAt(0), tmpList);
    }
    List<String> ret = new LinkedList<>();
    dfs(s, new StringBuilder(), 0, wm, ret);
    return ret;
  }

  private void dfs(String s, StringBuilder sb, int idx, Map<Character, List<Map<String, Integer>>> wm,
      List<String> ans) {
    if (idx == s.length()) {
      ans.add(sb.toString().trim());
      return;
    }
    if (idx > s.length()) {
      return;
    }
    if (!wm.containsKey(s.charAt(idx))) {
      return;
    }
    for (Map<String, Integer> mp : wm.get(s.charAt(idx))) {
      for (Map.Entry<String, Integer> es : mp.entrySet()) {
        int lenOfWord = es.getValue();
        String word = es.getKey();
        if (idx + lenOfWord <= s.length() && s.substring(idx, idx + lenOfWord).equals(word)) {
          sb.append(word + " ");
          dfs(s, sb, idx + lenOfWord, wm, ans);
          sb.replace(sb.length() - lenOfWord - 1, sb.length(), "");
        }
      }
    }
  }
}

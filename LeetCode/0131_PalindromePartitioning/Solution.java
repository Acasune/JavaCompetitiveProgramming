import java.util.LinkedList;
import java.util.List;

class Solution {
  public List<List<String>> partition(String s) {
    List<List<String>> ret = new LinkedList<>();
    rec(0, s.length(), s, ret, new LinkedList<>());
    return ret;

  }

  void rec(int i, int n, String s, List<List<String>> ret, List<String> tmp) {
    if (n <= i) {
      ret.add(new ArrayList<String>(tmp));
      return;
    }
    int j = i + 1;
    while (j <= n) {
      if (isPalindrome(s.substring(i, j))) {
        tmp.add(s.substring(i, j));
        rec(j, n, s, ret, tmp);
        tmp.remove(tmp.size() - 1);
      }
      j++;
    }
  }

  boolean isPalindrome(String s) {
    char[] cs = s.toCharArray();
    int n = cs.length;
    int l = 0, r = n - 1;
    while (l < r) {
      if (cs[l++] != cs[r--])
        return false;
    }
    return true;
  }
}

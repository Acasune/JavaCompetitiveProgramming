import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

class Solution {
  public String[] reorderLogFiles(String[] logs) {
    Comparator<String> cmp = (s1, s2) -> {
      boolean s1IsDigit = s1.split("\\s")[1].matches("[0-9]+");
      boolean s2IsDigit = s2.split("\\s")[1].matches("[0-9]+");
      if (s1IsDigit && s2IsDigit) {
        return 0;
      } else if (!s1IsDigit && s2IsDigit) {
        return -1;
      } else if (s1IsDigit && !s2IsDigit) {
        return 1;
      } else {
        Iterator<String> itr1 = Arrays.asList(s1.split("\\s")).iterator();
        Iterator<String> itr2 = Arrays.asList(s2.split("\\s")).iterator();
        String identifier1 = itr1.next();
        String identifier2 = itr2.next();
        String w1 = "", w2 = "";
        while (itr1.hasNext() && itr2.hasNext()) {
          w1 = itr1.next();
          w2 = itr2.next();
          if (!w1.equals(w2)) {
            return w1.compareTo(w2);
          }
        }

        if (!itr1.hasNext() && !itr2.hasNext()) {
          return identifier1.compareTo(identifier2);
        } else if (!itr1.hasNext()) {
          return -1;
        } else if (!itr2.hasNext()) {
          return 1;
        }
        return 0;
      }
    };
    Arrays.sort(logs, cmp);
    return logs;
  }
}

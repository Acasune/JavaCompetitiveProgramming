import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

class Solution {
  public List<String> topKFrequent(String[] words, int k) {
    LinkedHashMap<String, Integer> mp = new LinkedHashMap<>();
    for (String word : words) {
      if (!mp.containsKey(word)) {
        mp.put(word, 1);
      } else {
        mp.put(word, mp.get(word) + 1);
      }
    }

    var ret = mp.entrySet().stream().sorted((e1, e2) -> {
      if (e1.getValue() != e2.getValue()) {
        return -e1.getValue().compareTo(e2.getValue());
      } else {
        return e1.getKey().compareTo(e2.getKey());
      }
    }).limit(k).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    return new ArrayList(ret.keySet());
  }
}

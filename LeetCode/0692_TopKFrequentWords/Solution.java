import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

class Solution {
  public List<String> topKFrequent(String[] words, int k) {
    LinkedHashMap<String, Integer> mp = new LinkedHashMap<>();
    for (String word : words) {
      mp.put(word, mp.getOrDefault(word, 0) + 1);
    }
    Comparator<Map.Entry<String, Integer>> comparator = Comparator.comparing(Map.Entry<String, Integer>::getValue)
        .reversed().thenComparing(Map.Entry<String, Integer>::getKey);

    var ret = mp.entrySet().stream().sorted(comparator).limit(k)
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    return new ArrayList(ret.keySet());
  }
}

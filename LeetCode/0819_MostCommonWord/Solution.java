import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Solution {
  public String mostCommonWord(String paragraph, String[] banned) {

    Map<String, Integer> mp = new LinkedHashMap<>();
    for (String s : paragraph.split("\\W+")) {
      String w = s.toLowerCase().replaceAll("[!?',;.]", "");
      mp.put(w, mp.getOrDefault(w, 0) + 1);
    }
    String ret = mp.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .filter(x -> !Arrays.asList(banned).contains(x.getKey())).limit(1).map(x -> x.getKey())
        .collect(Collectors.joining(""));
    return ret;
  }
}

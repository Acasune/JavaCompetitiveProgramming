import javax.xml.stream.events.StartDocument;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int min = 1000000000;
        if (strs[0].equals("")) {
            return "";
        }
        char c = strs[0].charAt(0);
        for (var s : strs) {
            min = Math.min(min, s.length());
            if (s.equals("") || c != s.charAt(0)) {
                return "";
            }
        }
        for (int i = 1; i < min; i++) {
            for (var s : strs) {
                if (s.charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }

            }
        }
        return strs[0].substring(0, min);
    }
}

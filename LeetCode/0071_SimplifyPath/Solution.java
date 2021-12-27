import java.util.List;

class Solution {
    public String simplifyPath(String path) {
        String[] separated = path.split("/+");
        List<String> lst = new LinkedList<>();
        for (var s : separated) {
            if (s.equals(".") || s.isEmpty()) {
                continue;
            } else if (s.equals("..")) {
                if (lst.size() == 0) {
                    continue;
                }
                lst.remove(lst.size() - 1);
            } else {
                lst.add(s);
            }
        }
        StringBuilder sb = new StringBuilder("/");
        for (var s : lst) {
            sb.append(s).append("/");
        }
        if (sb.length() == 1) {
            return "/";
        }
        sb.replace(sb.length() - 1, sb.length(), "");
        return sb.toString();

    }
}

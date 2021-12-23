import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<>();
        ret.add(0);
        ret.add(1);
        int base = 2;
        n -= 1;
        while (n > 0) {
            for (int i = ret.size(); 0 <= i; i--) {
                ret.add(base + ret.get(i));
            }
            n--;
            base *= 2;
        }
        return ret;
    }
}

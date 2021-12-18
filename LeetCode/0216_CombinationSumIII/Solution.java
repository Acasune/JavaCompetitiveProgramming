import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new LinkedList<>();
        if (n < ((k + 1) * k) / 2 || 45 < n) {
            return ret;
        }
        dfs(ret, new LinkedList<>(), 0, n, k, 0, 10);
        return ret;

    }

    private void dfs(List<List<Integer>> ret, List<Integer> tmp, int cumsum, int n, int k, int size, int idx) {
        if (size > k || cumsum > n) {
            return;
        }
        if (size == k && cumsum == n) {
            ret.add(new LinkedList<>(tmp));
            return;
        }
        for (int i = idx - 1; 1 <= i; i--) {
            tmp.add(i);
            dfs(ret, tmp, cumsum + i, n, k, size + 1, i);
            tmp.remove(tmp.size() - 1);
        }

    }
}

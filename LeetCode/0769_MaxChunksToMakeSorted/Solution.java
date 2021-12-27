import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int cnt = 0;
        int[] sortedArr = Arrays.copyOf(arr, n);
        Arrays.sort(sortedArr);
        Map<Integer, Queue<Integer>> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            mp.putIfAbsent(num, new LinkedList<>());
            mp.get(num).add(i);
        }
        int r = -1;
        for (int i = 0; i < n; i++) {
            int num = sortedArr[i];
            int j = mp.get(num).poll();
            r = Math.max(r, j);
            if (r == i) {
                cnt++;
            }
        }
        return cnt;

    }
}

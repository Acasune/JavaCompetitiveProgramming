import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Set<List<Integer>> ret = new HashSet<>();
        int N = arr.length;
        if (N <= 2) {
            return new ArrayList<>();
        }

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                int thirdNum = -arr[i] - arr[j];
                int l = j + 1;
                int r = N;
                while (r - l - 1 > 0) {
                    int m = (r + l) / 2;
                    if (arr[m] <= thirdNum) {
                        l = m;
                    } else {
                        r = m;
                    }
                }
                if (l > N - 1) {
                    continue;
                }
                if (arr[l] == thirdNum) {
                    ret.add(List.of(arr[i], arr[j], arr[l]));
                }

            }
        }
        List<List<Integer>> res = new ArrayList<>(ret);

        return res;

    }
}

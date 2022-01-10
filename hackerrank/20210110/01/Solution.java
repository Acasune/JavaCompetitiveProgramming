import java.util.List;

class Result {

    /*
     * Complete the 'maxSubarrayValue' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static long maxSubarrayValue(List<Integer> arr) {
        // Write your code here
        long[] memo = new long[arr.size()];
        long[] largest = new long[arr.size() + 1];
        long[] smallest = new long[arr.size() + 1];
        int n = arr.size();
        memo[0] = arr.get(0);
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                memo[i] = memo[i - 1] + arr.get(i);
            } else {
                memo[i] = memo[i - 1] - arr.get(i);
            }
        }
        largest[n] = memo[n - 1];
        smallest[n] = memo[n - 1];
        for (int i = n - 2; 0 <= i; i--) {
            largest[i + 1] = Math.max(largest[i + 2], memo[i]);
            smallest[i + 1] = Math.min(smallest[i + 2], memo[i]);
        }
        long ans = -1;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (largest[i + 1] - smallest[i]) * (largest[i + 1] - smallest[i]));
            ans = Math.max(ans, (largest[i] - smallest[i + 1]) * (largest[i] - smallest[i + 1]));
        }
        return ans;

    }

}

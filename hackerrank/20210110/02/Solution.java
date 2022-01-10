import java.util.List;

class Result {

    /*
     * Complete the 'taskOfPairing' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER_ARRAY freq as parameter.
     */

    public static long taskOfPairing(List<Long> freq) {
        // Write your code here
        long ans = 0;
        long[] memo = new long[freq.size()];
        for (int i = 0; i < freq.size(); i++) {
            memo[i] = freq.get(i);
        }

        for (int i = 0; i < freq.size(); i++) {
            if (memo[i] % 2 == 1) {
                ans += memo[i] / 2;
                memo[i] = 1;
            }
        }
        for (int i = 0; i < freq.size(); i++) {
            if (memo[i] % 2 == 1) {
                if (memo[i + 1] > 0) {
                    memo[i + 1]--;
                    memo[i]--;
                    ans++;
                }
            }
        }
        for (int i = 0; i < freq.size(); i++) {
            if (memo[i] > 1) {
                ans += memo[i] / 2;
            }
        }
        return ans;
    }
}

import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public boolean canPartition(int[] nums) {
    boolean[] memo = new boolean[200_010];
    memo[0] = true;
    Queue<Integer> que = new LinkedList<>();
    int sum = Arrays.stream(nums).sum();
    if (sum % 2 == 1) {
      return false;
    }
    for (int i = 0; i < nums.length; i++) {
      que.clear();
      for (int j = 0; j < 200_005; j++) {
        if (memo[j]) {
          que.add(j + nums[i]);
        }
      }
      while (!que.isEmpty()) {
        memo[que.poll()] = true;
      }
    }
    return memo[sum / 2];
  }
}

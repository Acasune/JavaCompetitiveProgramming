import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        int len = nums.length;
        if (len < 4) {
            return ans;
        }
        Arrays.sort(nums);
        Set<LinkedList<Integer>> hs = new HashSet<>();
        for (int i = 0; i < len - 3; i++) {
            for (int j = i + 1; j < len - 2; j++) {
                int k = j + 1;
                int l = len - 1;
                do {
                    if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                        hs.add(new LinkedList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[l])));
                    }
                    if (target < nums[i] + nums[j] + nums[k] + nums[l]) {
                        l--;
                    } else {
                        k++;
                    }
                } while (k < l);

            }
        }
        ans = new LinkedList<>(hs);
        return ans;
    }
}

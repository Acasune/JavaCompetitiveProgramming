class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans = 10_000;
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 1; i < len - 1; i++) {
            for (int j = 0; j < i; j++) {
                int tmp_sum = nums[i] + nums[j];
                int third = binarySearch(nums, target - tmp_sum, i + 1);
                if (Math.abs(ans - target) > Math.abs(target - tmp_sum - nums[third])) {
                    ans = tmp_sum + nums[third];
                }
                if (third < len - 1) {
                    if (Math.abs(ans - target) > Math.abs(target - tmp_sum - nums[third + 1])) {
                        ans = tmp_sum + nums[third + 1];
                    }
                }

            }
        }

        return ans;
    }

    private int binarySearch(int[] nums, int target, int left) {

        int l = left, r = nums.length - 1;
        if (target <= nums[l]) {
            return left;
        }
        if (nums[r] <= target) {
            return r;
        }
        while (r - l > 1) {
            int mid = (l + r) / 2;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return l;
    }
}

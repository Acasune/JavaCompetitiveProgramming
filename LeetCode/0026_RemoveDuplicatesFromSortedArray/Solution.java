class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int idx = 0;
        int nUnique = 0;
        int cnt = 1;
        int tmp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != tmp) {
                nums[idx] = tmp;
                idx++;
                nUnique++;
                tmp = nums[i];
            }
        }

        nums[idx] = tmp;
        nUnique++;
        return nUnique;

    }
}

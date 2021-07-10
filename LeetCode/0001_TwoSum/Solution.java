class Solution {
  public int[] twoSum(int[] nums, int target) {
      var l = nums.length;
      boolean flg=false;
      int left=-1, right=-1;
      for (int i=0;i<l;i++) {
          for (int j=0; j<l;j++) {
              if (nums[i]+nums[j]==target) {
                  if (i==j) continue;
                  left=i;
                  right=j;
                  flg=true;
                  break;
              }
          }
          if (flg) break;
      }
      return new int[]{left,right};
  }
}

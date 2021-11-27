class Solution {
  public int[] twoSum(int[] numbers, int target) {
    int i = 0, j = numbers.length - 1;
    while (i < j) {
      int total = numbers[i] + numbers[j];
      if (total == target) {
        return new int[] { i + 1, j + 1 };
      }
      if (total < target) {
        i++;
      } else {
        j--;
      }
    }

    return null;
  }
}

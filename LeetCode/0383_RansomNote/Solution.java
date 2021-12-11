class Solution {
  public boolean canConstruct(String ransomNote, String magazine) {
    boolean ret = true;
    int[] memo = new int[26];
    for (var c : magazine.toCharArray()) {
      memo[(c - 'a')]++;
    }
    for (var c : ransomNote.toCharArray()) {
      if (memo[(c - 'a')] == 0) {
        ret = false;
        break;
      }
      memo[(c - 'a')]--;
    }
    return ret;

  }
}

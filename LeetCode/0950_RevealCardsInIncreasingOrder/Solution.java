class Solution {
  public int[] deckRevealedIncreasing(int[] deck) {
    Arrays.sort(deck);
    int n = deck.length;
    int[] ret = new int[n];
    int i = 0, j = 0, base = 1;
    boolean isSkip = false;
    while (i < n) {
      if (ret[j] != 0) {
        j = (j + 1) % n;
        continue;
      }
      if (isSkip) {
        isSkip = false;
      } else {
        ret[j] = deck[i++];
        isSkip = true;
      }
      j = (j + 1) % n;
    }
    return ret;
  }
}

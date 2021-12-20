/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * 
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
  public int rand10() {
    int n1 = 7, n2 = 7;
    while (n1 >= 6) {
      n1 = rand7();
    }
    while (n2 >= 7) {
      n2 = rand7();
    }
    n2 = (n2 - 1) / 3 - 1;
    return n1 + n2 * 5;

  }
}

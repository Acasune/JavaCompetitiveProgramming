/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
  int listSize;
  ListNode root;
  Random rand;

  public Solution(ListNode head) {
    listSize = getListLength(head);
    root = head;
    rand = new Random();

  }

  public int getRandom() {
    int pos = rand.nextInt(listSize);
    ListNode temp = root;
    if (pos == 0)
      return root.val;
    for (int i = 0; i < pos; i++)
      temp = temp.next;

    return temp.val;

  }

  public int getListLength(ListNode head) {
    int count = 0;
    while (head != null) {
      count++;
      head = head.next;
    }
    return count;
  }
}
/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(head); int param_1 = obj.getRandom();
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null)
      return head;
    ListNode prev = null, slow = head, fast = head;
    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    prev.next = null;

    ListNode l1 = sortList(head);
    ListNode l2 = sortList(slow);

    return merge(l1, l2);

  }

  ListNode merge(ListNode l1, ListNode l2) {
    ListNode head = null;
    ListNode tmpL1 = l1, tmpL2 = l2;
    if (l1.val <= l2.val) {
      head = l1;
      l1 = l1.next;
    } else {
      head = l2;
      l2 = l2.next;
    }
    ListNode top = head;
    while (l1 != null || l2 != null) {
      if (l1 == null) {
        top.next = l2;
        l2 = l2.next;
      } else if (l2 == null) {
        top.next = l1;
        l1 = l1.next;
      } else {
        if (l1.val <= l2.val) {
          top.next = l1;
          l1 = l1.next;
        } else {
          top.next = l2;
          l2 = l2.next;
        }
      }
      top = top.next;
    }
    return head;

  }
}

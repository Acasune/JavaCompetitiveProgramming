/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int total = 0;
        ListNode tmp = head;
        while (tmp != null) {
            total++;
            tmp = tmp.next;
        }
        int target = total - n; // 0-indexed

        if (target == 0) {
            head = head.next;
            return head;
        }
        tmp = head;
        int idx = 0;
        while (tmp != null) {
            if (idx + 1 == target) {
                if (tmp.next == null) {
                    // n == list.size
                    tmp.next = null;
                } else if (tmp.next.next == null) {
                    tmp.next = null;
                } else {
                    tmp.next = tmp.next.next;
                }
                break;
            }
            idx++;
            tmp = tmp.next;
        }
        return head;
    }
}

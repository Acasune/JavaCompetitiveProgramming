/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode();
        ListNode tmp = ret;
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        while (tmp1 != null || tmp2 != null) {
            if (tmp1 == null) {
                tmp.next = new ListNode(tmp2.val);
                tmp2 = tmp2.next;
            } else if (tmp2 == null) {
                tmp.next = new ListNode(tmp1.val);
                tmp1 = tmp1.next;
            } else {
                if (tmp1.val < tmp2.val) {
                    tmp.next = new ListNode(tmp1.val);
                    tmp1 = tmp1.next;
                } else {
                    tmp.next = new ListNode(tmp2.val);
                    tmp2 = tmp2.next;
                }
            }
            tmp = tmp.next;
        }
        return ret.next;
    }
}

import java.util.LinkedList;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
  public Node copyRandomList(Node head) {
    if (head == null) {
      return null;
    }
    Node newHead = new Node(head.val);
    Node newPast = newHead;
    Node newNow = null;
    Node now = head.next;
    Map<Node, Node> mp1 = new HashMap<>();
    Map<Node, Node> mp2 = new HashMap<>();
    mp1.put(head, head.random);
    mp2.put(head, newHead);

    while (now != null) {
      newNow = new Node(now.val);
      newPast.next = newNow;
      if (now.random != null) {
        mp1.put(now, now.random);
      }
      mp2.put(now, newNow);
      newPast = newNow;
      now = now.next;
    }
    newNow = newHead;
    now = head;
    while (now != null) {
      if (mp1.get(now) != null) {
        newNow.random = mp2.get(mp1.get(now));
      }
      newNow = newNow.next;
      now = now.next;
    }
    return newHead;

  }
}

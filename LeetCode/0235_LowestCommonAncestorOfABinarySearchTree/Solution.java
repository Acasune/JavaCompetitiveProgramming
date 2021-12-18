/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    TreeNode now = root;
    TreeNode left, right;
    if (p.val < q.val) {
      left = p;
      right = q;
    } else {
      left = q;
      right = p;
    }
    if (now.val == p.val || now.val == q.val) {
      return now;
    }
    while (true) {
      if (left.val < now.val && now.val < right.val) {
        return now;
      }
      if (left.val == now.val || right.val == now.val) {
        return now;
      }
      if (right.val < now.val) {
        now = now.left;
      } else {
        now = now.right;
      }
    }
  }
}

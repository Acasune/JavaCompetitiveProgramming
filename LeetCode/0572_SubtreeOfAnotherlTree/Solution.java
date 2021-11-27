/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (root == null ^ subRoot == null) {
      return false;
    }

    if (isSame(root, subRoot) || (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot))) {
      return true;
    } else {
      return false;
    }
  }

  private boolean isSame(TreeNode l, TreeNode r) {
    if (l == null && r == null) {
      return true;
    } else if (l == null || r == null) {
      return false;
    }
    if (l.val != r.val) {
      return false;
    }
    if (l == null && r == null) {
      return true;
    }
    return isSame(l.left, r.left) && isSame(l.right, r.right);
  }
}

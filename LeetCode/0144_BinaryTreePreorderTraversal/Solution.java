import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> ret = new LinkedList<>();
    if (root == null) {
      return ret;
    }
    preorder(root, ret);
    return ret;

  }

  void preorder(TreeNode now, List<Integer> ret) {
    ret.add(now.val);
    if (now.left != null) {
      preorder(now.left, ret);
    }
    if (now.right != null) {
      preorder(now.right, ret);
    }
  }
}

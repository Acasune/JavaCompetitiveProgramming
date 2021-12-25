import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

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
  int id = 1;

  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    Map<Integer, Integer> count = new HashMap<>();
    Map<String, Integer> register = new HashMap<>();
    List<TreeNode> ret = new LinkedList<>();
    postOrder(root, count, register, ret);
    return ret;
  }

  private int postOrder(TreeNode root, Map<Integer, Integer> count, Map<String, Integer> register, List<TreeNode> ret) {
    if (root == null) {
      return 0;
    }
    int l = postOrder(root.left, count, register, ret);
    int r = postOrder(root.right, count, register, ret);
    String serial = l + "#" + root.val + "#" + r;
    int localId = register.getOrDefault(serial, id);
    if (localId == id) {
      id++;
    }
    register.put(serial, localId);
    if (count.getOrDefault(localId, 0) == 1) {
      ret.add(root);
    }
    count.put(localId, count.getOrDefault(localId, 0) + 1);
    return localId;
  }
}

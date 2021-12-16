import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ret = new LinkedList<>();
        List<Integer> pastNodes = new LinkedList<>();
        if (root == null) {
            return ret;
        }
        pastNodes.add(root.val);
        dfs(root, targetSum, root.val, pastNodes, ret);
        return ret;
    }

    void dfs(TreeNode root, int targetSum, int sum, List<Integer> pastNodes, List<List<Integer>> ret) {
        if (root.left == null && root.right == null) {
            if (targetSum == sum) {
                ret.add(new LinkedList<Integer>(pastNodes));
            }
            return;
        }
        if (root.left != null) {
            pastNodes.add(root.left.val);
            dfs(root.left, targetSum, sum + root.left.val, pastNodes, ret);
            pastNodes.remove(pastNodes.size() - 1);
        }
        if (root.right != null) {
            pastNodes.add(root.right.val);
            dfs(root.right, targetSum, sum + root.right.val, pastNodes, ret);
            pastNodes.remove(pastNodes.size() - 1);
        }
    }
}

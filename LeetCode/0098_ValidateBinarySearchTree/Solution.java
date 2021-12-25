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
    public boolean isValidBST(TreeNode root) {
        return recursive(root, -2147483650L, 2147483650L);

    }

    boolean recursive(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        if (node.val <= min || max <= node.val) {
            return false;
        }
        return recursive(node.left, min, node.val) && recursive(node.right, node.val, max);
    }
}

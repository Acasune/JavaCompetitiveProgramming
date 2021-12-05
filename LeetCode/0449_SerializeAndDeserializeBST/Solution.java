import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    List<int[]> list = new LinkedList<>();
    Queue<TreeNode> que = new LinkedList<>();
    Queue<Integer> que2 = new LinkedList<>();
    que.add(root);
    que2.add(0);
    int nNodes = 0;
    while (!que.isEmpty()) {
      TreeNode tmp = que.poll();
      Integer tmp2 = que2.poll();
      nNodes = tmp2;
      list.add(new int[] { tmp.val, tmp2 });
      if (tmp.left != null) {
        que.add(tmp.left);
        que2.add(tmp2 * 2 + 1);
      }
      if (tmp.right != null) {
        que.add(tmp.right);
        que2.add(tmp2 * 2 + 2);
      }
    }
    int[] ret = new int[nNodes];
    for (int[] node : list) {
      ret[node[1]] = ret[node[0]];
    }
    return Arrays.toString(ret);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    String[] datas = data.substring(1, data.length() - 1).split(",");
    if (datas[0].equals("")) {
      return null;
    }
    TreeNode[] nodes = new TreeNode[datas.length];
    for (int i = 0; i < datas.length; i++) {
      if (datas[i].equals("null"))
        continue;
      nodes[i] = new TreeNode(Integer.parseInt(datas[i]));
    }
    for (int i = 0; i < datas.length / 2 - 1; i++) {
      if (nodes[i] == null) {
        continue;
      }
      if (nodes[i * 2 + 1] != null) {
        nodes[i].left = nodes[i * 2 + 1];
      }
      if (nodes[i * 2 + 2] != null) {
        nodes[i].left = nodes[i * 2 + 2];
      }
    }
    return nodes[0];
  }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;

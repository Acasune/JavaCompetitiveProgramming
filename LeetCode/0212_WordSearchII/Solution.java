import java.util.LinkedList;

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ret = new LinkedList<>();
        TrieNode root = buildTree(words);
        for (int j = 0; j < board.length; j++) {
            for (int i = 0; i < board[0].length; i++) {
                dfs(board, j, i, root, ret);
            }
        }
        return ret;

    }

    void dfs(char[][] board, int j, int i, TrieNode p, List<String> ret) {
        char c = board[j][i];
        if (c == '#' || p.next[c - 'a'] == null)
            return;
        p = p.next[c - 'a'];
        if (p.word != null) {
            ret.add(p.word);
            p.word = null;
        }
        board[j][i] = '#';
        if (j > 0)
            dfs(board, j - 1, i, p, ret);
        if (i > 0)
            dfs(board, j, i - 1, p, ret);
        if (j < board.length - 1)
            dfs(board, j + 1, i, p, ret);
        if (i < board[0].length - 1)
            dfs(board, j, i + 1, p, ret);
        board[j][i] = c;

    }

    TrieNode buildTree(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null)
                    p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = word;
        }
        return root;
    }
}

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    String word;
}

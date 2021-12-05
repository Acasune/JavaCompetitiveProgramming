import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
  public void solveSudoku(char[][] board) {
    boolean[] isReachGoal = new boolean[1];
    isReachGoal[0] = false;
    boolean flg = true;
    while (flg) {
      flg = false;
      for (int j = 0; j < 9; j++) {
        for (int i = 0; i < 9; i++) {
          if (board[j][i] != '.') {
            continue;
          }
          Set<Character> elemNotUsed = new HashSet(Set.of('1', '2', '3', '4', '5', '6', '7', '8', '9'));
          Set<Character> used = elemUsed(board, j, i);
          elemNotUsed.removeAll(used);
          if (elemNotUsed.size() == 1) {
            board[j][i] = elemNotUsed.stream().findFirst().get();
            flg = true;
          }
        }
      }
    }
    recursive(board, 0, 0, isReachGoal);

  }

  void recursive(char[][] board, int h, int w, boolean[] isReachGoal) {
    if (isReachGoal[0]) {
      return;
    }
    if (h == 8 && w == 9) {
      isReachGoal[0] = true;
      return;
    } else if (w == 9) {
      w = 0;
      h++;
    }
    if (board[h][w] != '.') {
      recursive(board, h, w + 1, isReachGoal);
    } else {
      Set<Character> elemNotUsed = new HashSet(Set.of('1', '2', '3', '4', '5', '6', '7', '8', '9'));
      Set<Character> used = elemUsed(board, h, w);
      elemNotUsed.removeAll(used);
      if (elemNotUsed.isEmpty()) {
        return;
      }
      for (Character c : elemNotUsed) {

        board[h][w] = c;
        recursive(board, h, w + 1, isReachGoal);
        if (isReachGoal[0]) {
          break;
        }
        board[h][w] = '.';
      }
    }
  }

  Set<Character> elemUsed(char[][] board, int h, int w) {
    Set<Character> st = new HashSet<>();
    int j = (h / 3) * 3;
    int i = (w / 3) * 3;
    for (int k = 0; k < 3; k++) {
      for (int l = 0; l < 3; l++) {
        if (j + k == h && w + l == w) {
          continue;
        }
        if (board[j + k][i + l] != '.') {
          st.add(board[j + k][i + l]);
        }
      }
    }
    for (i = 0; i < 9; i++) {
      if (i != w && board[h][i] != '.') {
        st.add(board[h][i]);
      }
      if (i != h && board[i][w] != '.') {
        st.add(board[i][w]);
      }
    }
    return st;
  }

}

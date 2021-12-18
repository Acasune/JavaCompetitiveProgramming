class Solution {
  public boolean validTicTacToe(String[] board) {
    int nX = 0, nO = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[i].charAt(j) == 'O') {
          nO++;
        } else if (board[i].charAt(j) == 'X') {
          nX++;
        }
      }
    }
    if (nO > nX || nO + 1 < nX) {
      return false;
    }
    boolean xWin = isWinState(board, 'X');
    boolean oWin = isWinState(board, 'O');
    if (xWin && oWin) {
      return false;
    }
    if (xWin && (nX <= nO)) {
      return false;
    }
    if (oWin && (nO < nX)) {
      return false;
    }
    return true;
  }

  boolean isWinState(String[] board, char c) {
    if (board[0].charAt(0) == c && board[0].charAt(1) == c && board[0].charAt(2) == c) {
      return true;
    }
    if (board[1].charAt(0) == c && board[1].charAt(1) == c && board[1].charAt(2) == c) {
      return true;
    }
    if (board[2].charAt(0) == c && board[2].charAt(1) == c && board[2].charAt(2) == c) {
      return true;
    }
    if (board[0].charAt(0) == c && board[1].charAt(0) == c && board[2].charAt(0) == c) {
      return true;
    }
    if (board[0].charAt(1) == c && board[1].charAt(1) == c && board[2].charAt(1) == c) {
      return true;
    }
    if (board[0].charAt(2) == c && board[1].charAt(2) == c && board[2].charAt(2) == c) {
      return true;
    }
    if (board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c) {
      return true;
    }
    if (board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c) {
      return true;
    }
    return false;
  }
}

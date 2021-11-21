class Solution {
    enum Direction {
        RIGHT, LEFT, UP, DOWN;
    }

    public int[][] generateMatrix(int n) {
        if (n == 1) {
            return new int[][] { { 1 } };
        }
        int[][] ret = new int[n][n];
        int[] cord = new int[] { 0, 0 };
        int val = 1;
        Direction cmd = Direction.RIGHT;
        while (true) {
            if (ret[cord[0]][cord[1]] != 0) {
                break;
            }
            ret[cord[0]][cord[1]] = val;
            val++;
            cmd = getNextDirection(cmd, cord, ret, n);
            cord = getNextCord(cmd, cord);

        }

        return ret;
    }

    private Direction getNextDirection(Direction cmd, int[] nowCord, int[][] ret, int n) {
        int y = nowCord[0], x = nowCord[1];
        switch (cmd) {
        case RIGHT:
            if (x + 1 < n && ret[y][x + 1] == 0) {
                return Direction.RIGHT;
            } else {
                return Direction.DOWN;
            }

        case DOWN:
            if (y + 1 < n && ret[y + 1][x] == 0) {
                return Direction.DOWN;
            } else {
                return Direction.LEFT;
            }

        case LEFT:
            if (x - 1 >= 0 && ret[y][x - 1] == 0) {
                return Direction.LEFT;
            } else {
                return Direction.UP;
            }

        case UP:
            if (y - 1 >= 0 && ret[y - 1][x] == 0) {
                return Direction.UP;
            } else {
                return Direction.RIGHT;
            }
        default:
            return cmd;
        }

    }

    private int[] getNextCord(Direction cmd, int[] nowCord) {
        int y = nowCord[0], x = nowCord[1];
        switch (cmd) {
        case UP:
            return new int[] { y - 1, x };
        case DOWN:
            return new int[] { y + 1, x };
        case RIGHT:
            return new int[] { y, x + 1 };
        case LEFT:
            return new int[] { y, x - 1 };
        default:
            return new int[] { 0, 0 };
        }
    }
}

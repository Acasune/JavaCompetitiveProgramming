class Solution {
  public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
    int union = 0, intersect = 0;
    union = (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1);
    boolean isIntersect = true;
    if (bx2 < ax1 || ax2 < bx1 || by2 < ay1 || ay2 < by1) {
      isIntersect = false;
    }
    if (isIntersect) {
      intersect = (Math.min(by2, ay2) - Math.max(ay1, by1)) * (Math.min(bx2, ax2) - Math.max(ax1, bx1));
      union -= intersect;
    }

    return union;
  }
}

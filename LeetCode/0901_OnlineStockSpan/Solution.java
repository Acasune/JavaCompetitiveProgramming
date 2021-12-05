import java.util.ArrayDeque;
import java.util.Deque;

class StockSpanner {
  Deque<Integer> prices;
  Deque<Integer> cnts;
  int days;

  public StockSpanner() {
    days = 0;
    prices = new ArrayDeque<>();
    cnts = new ArrayDeque<>();

  }

  public int next(int price) {
    days++;
    int interval = 0;
    while (!prices.isEmpty()) {
      int tmp = prices.pollLast();
      int tmp2 = cnts.pollLast();
      if (tmp > price) {
        prices.addLast(tmp);
        cnts.addLast(tmp2);
        interval = tmp2;
        break;
      }
    }
    prices.addLast(price);
    cnts.addLast(days);
    return days - interval;

  }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

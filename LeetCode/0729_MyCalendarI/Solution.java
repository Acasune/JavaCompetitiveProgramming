import java.util.LinkedList;
import java.util.SortedMap;
import java.util.TreeMap;

class MyCalendar {
    SortedMap<Integer, Integer> startEnd;
    SortedMap<Integer, Integer> endStart;

    public MyCalendar() {
        startEnd = new TreeMap<>();
        endStart = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        for (var ks : startEnd.subMap(Integer.MIN_VALUE, end).entrySet()) {
            if (start <= ks.getValue()) {
                return false;
            }
        }
        for (var ks : endStart.subMap(start + 1, Integer.MAX_VALUE).entrySet()) {
            if (ks.getValue() < end) {
                return false;
            }
        }
        startEnd.put(start, end);
        endStart.put(end, start);
        return true;

    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */

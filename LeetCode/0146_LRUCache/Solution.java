import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {
  int capacity;
  LinkedHashMap<Integer, Integer> cache;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    cache = new LinkedHashMap<>() {

      protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
      }
    };
  }

  public int get(int key) {
    int ret = cache.getOrDefault(key, -1);
    if (ret != -1) {
      cache.remove(key);
      cache.put(key, ret);
    }
    return ret;
  }

  public void put(int key, int value) {
    cache.remove(key);
    cache.put(key, value);
  }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

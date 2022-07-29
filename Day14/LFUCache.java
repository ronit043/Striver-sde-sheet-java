package Day14;
import java.util.*;

public class LFUCache {
   int cap, min = -1;
   Map<Integer, Integer> cache = new HashMap<>(), keyCount = new HashMap<>();
   Map<Integer, LinkedHashSet<Integer>> freqMap = new HashMap<>();

   public LFUCache(int capacity) {
      cap = capacity;
      freqMap.put(1, new LinkedHashSet<>());
   }

   public int get(int key) {
      if (!cache.containsKey(key)) return -1;
      int count = keyCount.get(key);
      keyCount.put(key, count + 1);
      freqMap.get(count).remove(key);
      if (count == min && freqMap.get(count).size() == 0) min++;
      if (!freqMap.containsKey(count + 1))
         freqMap.put(count + 1, new LinkedHashSet<>());
      freqMap.get(count + 1).add(key);
      return cache.get(key);
   }

   public void put(int key, int value) {
      if (cap <= 0) return;
      if (cache.containsKey(key)) {
         cache.put(key, value);
         get(key);
         return;
      }
      if (cache.size() >= cap) {
         int evict = freqMap.get(min).iterator().next();
         freqMap.get(min).remove(evict);
         cache.remove(evict);
         keyCount.remove(evict);
      }
      cache.put(key, value);
      keyCount.put(key, 1);
      min = 1;
      freqMap.get(1).add(key);
   }
}
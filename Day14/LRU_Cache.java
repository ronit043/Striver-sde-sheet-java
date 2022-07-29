package Day14;

import java.util.LinkedHashMap;
import java.util.Map;
/*
LRU cache is basically an ordered HashMap with a capacity limit. LinkedHashMap keeps the insertion order. So,
that's all we need. We can handle it like a Queue, we insert to the end and remove from the beginning of the
list. Also, we need to move elements to the end of the list when they are read or overwritten.

. PUT: Every time we put a value, it will naturally go to the end of the list.
. PUT: If the value already exits we need to delete it from wherever it was and put it to the end.
. PUT: When doing a put, we check the capacity. If are over the limit, we delete the first element.
. GET: When we read a value, we have to move it from wherever it was and put it to the end.
. GET: If the value doesn't exist, return -1;
 */
class LRU_Cache {
   Map<Integer, Integer> cache = new LinkedHashMap<>();
   int cap = 0;

   LRU_Cache(int capacity) {
      cap = capacity;
   }

   public int get(int key) {
      if (cache.containsKey(key)) {
         int value = cache.get(key);
         cache.remove(key);
         cache.put(key, value);
         return value;
      }
      return -1;
   }

   public void put(int key, int value) {
      if (cache.containsKey(key)) {
         cache.remove(key);
         cache.put(key, value);
      } else if (cache.size() == cap)
         cache.remove(cache.entrySet().iterator().next().getKey());

      cache.put(key, value);
   }
}
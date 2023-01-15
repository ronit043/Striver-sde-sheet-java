package Day23;
import java.util.ArrayDeque;
import java.util.Queue;

class Detect_cycle_DG_DFS {
   public boolean canFinish(int numCourses, int[][] prerequisites) {
      int[] indegree = new int[numCourses];
      Queue<Integer> q = new ArrayDeque<>();

      for (var pair : prerequisites)
         indegree[pair[1]]++;

      for (int i = 0; i < indegree.length; i++)
         if (indegree[i] == 0) q.add(i);

      while (!q.isEmpty()) {
         numCourses--;
         int course = q.poll();
         for (var pair : prerequisites) {
            if (pair[0] == course) {
               indegree[pair[1]]--;
               if (indegree[pair[1]] == 0)
                  q.add(pair[1]);
            }
         }
      }

      return numCourses == 0;
   }
}

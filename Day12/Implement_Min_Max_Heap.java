package Day12;

class Implement_Min_Max_Heap {
   // Max heap from Array
   void buildHeap(int[] arr, int n) {
      // Index of last non-leaf node  [parent of last leaf node]
      int startIdx = (n / 2) - 1;

      // Perform reverse level order traversal
      // from last non-leaf node and heapify each node
      for (int i = startIdx; i >= 0; i--)
         heapify(arr, n, i);
   }

   void heapify(int[] arr, int n, int i) {
      int largest = i, // Initialize largest as root
      l = 2 * i + 1, // left = 2 * i + 1
      r = 2 * i + 2; // right = 2 * i + 2

      // If left child is larger than root
      if (l < n && arr[l] > arr[largest]) largest = l;

      // If right child is larger than largest so far
      if (r < n && arr[r] > arr[largest]) largest = r;

      // If largest is not root
      if (largest != i) {
         swap(arr, i, largest);
         // Recursively heapify the affected sub-tree
         heapify(arr, n, largest);
      }
   }

   public void swap(int[] nums, int i, int j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
   }
}
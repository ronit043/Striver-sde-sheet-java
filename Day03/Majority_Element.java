package Day03;

/*    TC : O(n), SC : O(1)

Majority element occurs more than floor('N' / 2) times, its frequency will be greater than combined frequencies
of all other candidates.

We maintain a count/vote of the candidate having potential of being majority.
If next candidate is the same increment the vote, else decrement the vote. If vote becomes 0, then update
majority to current candidate.
 */
class Majority_Element {
   public int majorityElement(int[] election) {
      int vote = 0, majority = 0;

      for (int candidate : election) {
         if (vote == 0) majority = candidate;
         vote += (majority == candidate) ? 1 : -1;
      }

      return majority;
   }
}
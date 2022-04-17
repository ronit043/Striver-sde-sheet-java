package Day22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Distinct_Numbers_in_every_window_of_size_k {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> al = new ArrayList<>();
        if (B > A.size()) return al;
        Map<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < B; i++)
            hm.put(A.get(i), hm.getOrDefault(A.get(i), 0) + 1);

        al.add(hm.size());

        for (int i = B; i < A.size(); i++) {
            if (hm.get(A.get(i - B)) == 1) hm.remove(A.get(i - B));
            else hm.put(A.get(i - B), hm.get(A.get(i - B)) - 1);
            
            hm.put(A.get(i), hm.getOrDefault(A.get(i), 0) + 1);
            al.add(hm.size());
        }

        return al;
    }
}
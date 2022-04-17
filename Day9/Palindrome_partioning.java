package Day9;

import java.util.List;
import java.util.ArrayList;

public class Palindrome_partioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        help(res, new ArrayList<>(), s);
        return res;
    }

    void help(List<List<String>> ans, List<String> al, String s) {
        if (s.isEmpty()) ans.add(new ArrayList<>(al));

        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s.substring(0, i + 1))) { // checking if the prefix is palindrome
                al.add(s.substring(0, i + 1));         // add the remaining of the string
                help(ans, al, s.substring(i + 1));
                al.remove(al.size() - 1);
            }
        }
    }

    boolean isPalindrome(String str) {
        int l = 0, r = str.length() - 1;

        while (l < r)
            if (str.charAt(l++) != str.charAt(r--)) return false;

        return true;
    }
}
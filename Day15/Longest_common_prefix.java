package Day15;

/*
    TC : O(n * k), k : Length of common prefix
    SC : O(1)

    Solution

    We assume first item to have the longest common prefix, we compare whether other array items begin with
    prefix or not. If not we decrease the length of the prefix till it's present in every other string
 */

public class Longest_common_prefix {
    public String longestCommonPrefix(String[] arr) {
        int n = arr.length;
        if (n == 0) return "";
        String prefix = arr[0];

        for (int i = 1; i < n; i++) {
            while (!arr[i].startsWith(prefix))
                prefix = prefix.substring(0, prefix.length() - 1);
        }

        return prefix.isEmpty()? "" : prefix;
    }
}
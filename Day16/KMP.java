package Day16;

class KMP {
    int KMPSearch(String text, String pattern) {
        if (pattern.isEmpty()) return 0;
        int[] lps = computeKMPTable(pattern);
        int n = text.length(), m = pattern.length();

        // i -> text index, j -> pattern index
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) j = lps[j - 1];
            if (text.charAt(i) == pattern.charAt(j))
                if (++j == m) return i - m + 1; // found solution
        }
        return -1;
    }

    int[] computeKMPTable(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];
        for (int i = 1, j = 0; i < n; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) j = lps[j - 1];
            if (pattern.charAt(i) == pattern.charAt(j)) lps[i] = ++j;
        }
        return lps;
    }
}
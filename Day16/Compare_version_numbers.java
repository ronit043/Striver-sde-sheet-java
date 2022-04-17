package Day16;

public class Compare_version_numbers {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\."), v2 = version2.split("\\.");
        int n = Math.max(v1.length, v2.length);

        for (int i = 0; i < n; i++) {
            int k = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int j = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            return (k > j) ? 1 : -1;
        }

        return 0;
    }
}
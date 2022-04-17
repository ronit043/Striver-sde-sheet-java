package Day2;

public class Repeat_and_missing_number {
    public int[] repeatedNumber(int[] A) {
        long sum = 0, actsum = 0, sqsum = 0, actsqsum = 0;

        for (long i : A) {
            actsum += i;
            actsqsum += i * i;
        }

        long n = A.length;
        sum = (n * (n + 1)) / 2;
        sqsum = (n * (n + 1) * (2 * n + 1)) / 6;

        long x = sum - actsum;
        long y = (sqsum - actsqsum) / x;
        long a = (x + y) / 2;
        long b = a - x;

        return new int[]{(int) b, (int) a};
    }
}
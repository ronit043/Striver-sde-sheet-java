package Day3;

public class Pow_x_n {
    public double myPow(double x, int n) {
        long pow = Math.abs((long) n);
        double res = 1;

        while (pow > 0) {
            if ((pow & 1) > 0)
                res *= x;
            pow >>= 1;
            x *= x;
        }

        return n >= 0 ? res : 1 / res;
    }
}
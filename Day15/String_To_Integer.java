package Day15;

public class String_To_Integer {
    public int myAtoi(String s) {
        int i = 0, sign = 1;
        long base = 0L;

        while (i < s.length() && s.charAt(i) == ' ') i++; // Skip whitespaces
        if (i >= s.length()) return 0;

        switch (s.charAt(i)) {
            case '-': sign = -1; // Negative number, flip sign
            case '+': i++; // Positive number, increment index
            default:  break;
        }

        for (; i < s.length() && Character.isDigit(s.charAt(i)); i++) {
            base = base * 10 + (s.charAt(i) - '0');
            if (base > Integer.MAX_VALUE)
                return (sign > 0) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        return sign * (int) base;
    }
}
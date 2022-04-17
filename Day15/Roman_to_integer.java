package Day15;

public class Roman_to_integer {
    public int romanToInt(String s) {
        int number = 0, len = s.length();

        for (int i = 0; i < len - 1; i++) {
            int d1 = getValue(s.charAt(i)), d2 = getValue(s.charAt(i + 1));
            // Each time a numeral is smaller than it's next one
            // store a negative value
            if (d1 < d2) number -= d1;
                // Otherwise, keep on adding, +ve and -ve values will add to correct result
            else number += d1;
        }

        // Add the last numeral
        number += getValue(s.charAt(len - 1));
        return number;
    }

//    int getValue(char c) {
//        switch(c) {
//            case 'I' : return 1;
//            case 'V' : return 5;
//            case 'X' : return 10;
//            case 'L' : return 50;
//            case 'C' : return 100;
//            case 'D' : return 500;
//            case 'M' : return 1000;
//            default : return 0;
//        }
//    }

    int getValue(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}
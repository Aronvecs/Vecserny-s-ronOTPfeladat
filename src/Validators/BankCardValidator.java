package Validators;

import static java.lang.Long.parseLong;

public class BankCardValidator extends ValidatorBase{
    @Override
    public boolean Validate(String line) {
        long newline = parseLong(line);
        return (thesize(newline) >= 13 && thesize(newline) <= 16) && (prefixmatch(newline, 4)
                || prefixmatch(newline, 5) || prefixmatch(newline, 37) || prefixmatch(newline, 6))
                && ((sumdoubleeven(newline) + sumodd(newline)) % 10 == 0);
    }
    // Get the result from Step 2
     int sumdoubleeven(long cnumber) {
        int sum = 0;
        String num = cnumber + "";
        for (int i = thesize(cnumber) - 2; i >= 0; i -= 2)
            sum += getDigit(Integer.parseInt(num.charAt(i) + "") * 2);
        return sum;
    }
    // Return this cnumber if it is a single digit, otherwise,
    // return the sum of the two digits
    int getDigit(int cnumber) {
        if (cnumber < 9)
            return cnumber;
        return cnumber / 10 + cnumber % 10;
    }
    // Return sum of odd-place digits in cnumber
    int sumodd(long cnumber) {
        int sum = 0;
        String num = cnumber + "";
        for (int i = thesize(cnumber) - 1; i >= 0; i -= 2)
            sum += Integer.parseInt(num.charAt(i) + "");
        return sum;
    }
    // Return true if the digit d is a prefix for cnumber
    boolean prefixmatch(long cnumber, int d) {
        return getprefx(cnumber, thesize(d)) == d;
    }
    // Return the number of digits in d
    int thesize(long d) {
        String num = d + "";
        return num.length();
    }
    // Return the first k number of digits from
    // number. If the number of digits in number
    // is less than k, return number.
    long getprefx(long cnumber, int k) {
        if (thesize(cnumber) > k) {
            String num = cnumber + "";
            return parseLong(num.substring(0, k));
        }
        return cnumber;
    }
}

package Validators;

import Classes.Payment;

import java.util.Objects;

import static java.lang.Long.parseLong;

public class BankCardValidator extends PaymentValidatorBase {
    @Override
    public boolean Validate(Payment payment) {
        if (Objects.equals(payment.getBankCardNum(), "none")){
            return false;
        }
        long newline = parseLong(payment.getBankCardNum());
        return  (thesize(newline) >= 13 && thesize(newline) <= 16) && (prefixmatch(newline, 4)
                || prefixmatch(newline, 5) || prefixmatch(newline, 37) || prefixmatch(newline, 6))
                && ((sumdoubleeven(newline) + sumodd(newline)) % 10 == 0);
    }

    @Override
    public String NotValid(Payment line) {
        return "This " + line.getBankCardNum() +" is not a valid ID";
    }

    int sumdoubleeven(long cnumber) {
        int sum = 0;
        String num = cnumber + "";
        for (int i = thesize(cnumber) - 2; i >= 0; i -= 2)
            sum += getDigit(Integer.parseInt(num.charAt(i) + "") * 2);
        return sum;
    }
    int getDigit(int cnumber) {
        if (cnumber < 9)
            return cnumber;
        return cnumber / 10 + cnumber % 10;
    }
    int sumodd(long cnumber) {
        int sum = 0;
        String num = cnumber + "";
        for (int i = thesize(cnumber) - 1; i >= 0; i -= 2)
            sum += Integer.parseInt(num.charAt(i) + "");
        return sum;
    }
    boolean prefixmatch(long cnumber, int d) {
        return getprefx(cnumber, thesize(d)) == d;
    }
    int thesize(long d) {
        String num = d + "";
        return num.length();
    }
    long getprefx(long cnumber, int k) {
        if (thesize(cnumber) > k) {
            String num = cnumber + "";
            return parseLong(num.substring(0, k));
        }
        return cnumber;
    }
}

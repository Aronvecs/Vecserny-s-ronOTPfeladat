package Classes;

import java.util.Date;

public class Payment {
    public String getWebshopID() {
        return WebshopID;
    }

    public String getCostumerId() {
        return CostumerId;
    }

    public String getPayingMethod() {
        return PayingMethod;
    }

    public String getSum() {
        return Sum;
    }

    public String getBankszamla() {
        return bankszamla;
    }

    public String getBankCardNum() {
        return BankCardNum;
    }

    public Date getDate() {
        return date;
    }

    public Payment(String webshopID, String costumerId, String payingMethod, String sum, String bankszamla, String bankCardNum, Date date) {
        WebshopID = webshopID;
        CostumerId = costumerId;
        PayingMethod = payingMethod;
        Sum = sum;
        this.bankszamla = bankszamla;
        BankCardNum = bankCardNum;
        this.date = date;
    }

    private String WebshopID;
    private String CostumerId;
    private String PayingMethod;
    private String Sum;
    private String bankszamla;
    private String BankCardNum;
    private Date date;
}

package Classes;

import java.util.Date;

public class Payment {
    public String getCostumerId() {
        return CostumerId;
    }

    public void setCostumerId(String costumerId) {
        CostumerId = costumerId;
    }

    public String getWebshopID() {
        return WebshopID;
    }

    public void setWebshopID(String webshopID) {
        WebshopID = webshopID;
    }

    public String getPayingMethod() {
        return PayingMethod;
    }

    public void setPayingMethod(String payingMethod) {
        PayingMethod = payingMethod;
    }

    public String getSum() {
        return Sum;
    }

    public void setSum(String sum) {
        Sum = sum;
    }

    public String getBankszamla() {
        return bankszamla;
    }

    public void setBankszamla(String bankszamla) {
        this.bankszamla = bankszamla;
    }

    public String getBankCardNum() {
        return BankCardNum;
    }

    public void setBankCardNum(String bankCardNum) {
        BankCardNum = bankCardNum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

package net.riverSoft.model;


public class DebtRow {
    private Integer paymentNumber; // номер платежа
    private String paymentDate; // дата платежа
    private String amountPayment; // сумма платежа
    private String inPrimaryLoanRedemption; // в погашение тела кредита
    private String inPercentsRedemption; // в погашение процентов по кредиту
    private String balanceDebt; // остаток долга

    public Integer getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(Integer paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }


    public String getAmountPayment() {
        return amountPayment;
    }

    public void setAmountPayment(String amountPayment) {
        this.amountPayment = amountPayment;
    }

    public String getInPrimaryLoanRedemption() {
        return inPrimaryLoanRedemption;
    }

    public void setInPrimaryLoanRedemption(String inPrimaryLoanRedemption) {
        this.inPrimaryLoanRedemption = inPrimaryLoanRedemption;
    }

    public String getInPercentsRedemption() {
        return inPercentsRedemption;
    }

    public void setInPercentsRedemption(String inPercentsRedemption) {
        this.inPercentsRedemption = inPercentsRedemption;
    }


    public String getBalanceDebt() {
        return balanceDebt;
    }

    public void setBalanceDebt(String balanceDebt) {
        this.balanceDebt = balanceDebt;
    }
}

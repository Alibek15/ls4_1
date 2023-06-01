package model;

import java.math.BigDecimal;

public abstract class BankAccount {
    private BigDecimal balance;
    private String accountNumber;
    private String pinCode;

    public BankAccount(BigDecimal balance, String accountNumber, String pinCode) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.pinCode = pinCode;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                ", accountNumber='" + accountNumber + '\'' +
                ", pinCode='" + pinCode + '\'' +
                '}';
    }
}

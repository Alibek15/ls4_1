package model;

import java.math.BigDecimal;

public class NationalBankAccountI extends BankAccount {
    private String fullname;


    public NationalBankAccountI(final String fullname, final BigDecimal balance,
                                final String accountNumber, final String pinCode) {
        super(balance,pinCode,accountNumber);
        this.fullname = fullname;

    }

    public String getFullname() {
        return fullname;
    }

    @Override
    public String toString() {
        return "NationalBankAccountI{" +
                "fullname='" + fullname + '\'' +
                super.toString() +
                '}';
    }
}

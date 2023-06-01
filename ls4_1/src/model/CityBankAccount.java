package model;

import java.math.BigDecimal;

public class CityBankAccount extends BankAccount {
    private String name;
    private String surname;


    public CityBankAccount(
            final String name,final String surname, final BigDecimal balance,
            final String accountNumber, final String pincode) {
        super(balance,accountNumber,pincode);
        this.name = name;
        this.surname = surname;

    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "CityBankAccount{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +super.toString()+
                '}';
    }

}

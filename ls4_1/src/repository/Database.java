package repository;

import model.BankAccount;
import model.CityBankAccount;
import model.NationalBankAccountI;


import java.math.BigDecimal;

public class Database {


    private static BankAccount[] bankAccounts = new BankAccount[10];

static {
    bankAccounts[0] = new CityBankAccount("Alex","Smith", BigDecimal.valueOf(25_000),"KZ112233","7777");
    bankAccounts[1] = new CityBankAccount("Dave","Davidson",BigDecimal.valueOf(65_000),"KZ552233","1234");
    bankAccounts[2] = new CityBankAccount("Ivan","Ivanov",BigDecimal.valueOf(2_000),"KZ432158","0505");
    bankAccounts[3] = new NationalBankAccountI("Danil Karamazov",BigDecimal.valueOf(2_000),"KZ432158","0505");
    bankAccounts[4] = new NationalBankAccountI("Erbol Zhakishev",BigDecimal.valueOf(2_000),"KZ432158","0505");
}
public static BankAccount[] getBankAccounts() {
        return bankAccounts;
    }
}
//ISO20022

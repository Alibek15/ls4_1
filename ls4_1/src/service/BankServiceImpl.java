package service;

import model.BankAccount;
import repository.Database;

import java.math.BigDecimal;

public class BankServiceImpl implements BankService {


    @Override
    public BankAccount getClient(String accountNumber, String pinCode) {
        BankAccount client = null;
        for(BankAccount account : Database.getBankAccounts()) {
          if(account.getAccountNumber().equals(accountNumber)
                  && account.getPinCode().equals(pinCode)){
              client = account;
              break;
          }
        }

        return client;
    }

    @Override
    public String getAccountNumber(BankAccount account) {
        return account.getAccountNumber();
    }

    @Override
    public String getPinCode(BankAccount account) {
        return account.getPinCode();
    }

    @Override
    public void setPincode(BankAccount account, String pincode) {
account.setPinCode(pincode);
    }

    @Override
    public BigDecimal totalBalance(BankAccount account) {
        return account.getBalance();
    }

    @Override
    public void withdrawCash(final BigDecimal amount, BankAccount account) {
       var balance = account.getBalance();
       if(amount.compareTo(balance) < 0){
           account.setBalance(balance.subtract(amount));

       }else{
           System.out.println("Insufficient funds on the account");
       }

    }

    @Override
    public void replenishment(BigDecimal amount,BankAccount account) {

        var balance = account.getBalance().add(amount);
        account.setBalance(balance);
    }

    @Override
    public String accountData(BankAccount account) {
        return account.toString();
    }
}

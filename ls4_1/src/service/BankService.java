package service;

import model.BankAccount;

import java.math.BigDecimal;

public interface BankService {
    BankAccount getClient(String accountNumber, String pinCode);
    String getAccountNumber(BankAccount account);

    String getPinCode(BankAccount account);


    void setPincode(BankAccount account, String pincode);



    BigDecimal totalBalance(BankAccount account);



    void withdrawCash(BigDecimal amount, BankAccount account);




    void replenishment(BigDecimal amount, BankAccount account);

    String accountData(BankAccount account);
}
//клиент который использует интерфейс, не будут знать о реализации.
//дает возможность использовать но не менять реализацию.

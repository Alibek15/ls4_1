package service;

import model.BankAccount;

public interface MenuService {
    void showMenu(BankAccount client);//интерфейс без тела маркер, с 1 методом функциональный интерфейс


    void viewBalance(BankAccount client);

    void withdraw(BankAccount client);

    void nationalBankMenu(BankAccount client);

    void cityBankMenu(BankAccount client);

    void viewData(BankAccount client);
    void cashIn(BankAccount client);
    void setPincode(BankAccount client);


}

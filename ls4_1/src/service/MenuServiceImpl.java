package service;

import model.BankAccount;
import model.CityBankAccount;

import java.util.Scanner;

public class MenuServiceImpl implements MenuService {
    private Integer tax;
    private BankService bankservice; //depedency injection

    private Scanner scanner = new Scanner(System.in);
    private Integer selector;//то что выбирает клиент


    public MenuServiceImpl(Integer tax, BankService bankservice) {
        this.tax = tax;
        this.bankservice = bankservice;
    }

    public MenuServiceImpl() {

    }

    public Integer getTax() {
        return tax;
    }

    public void setTax(Integer tax) {
        this.tax = tax;
    }

    public BankService getBankservice() {
        return bankservice;
    }

    @Override
    public void showMenu(BankAccount client) {
        if(client instanceof CityBankAccount){
            cityBankMenu(client);
        }else{
            nationalBankMenu(client);
        }
    }

    @Override public void nationalBankMenu(final BankAccount client) {
        while(true){
            printNationalBankMenu();
            selector = scanner.nextInt();
            if(selector.equals(1)){
                withdraw(client);
            }
            else if(selector.equals(2)){
                viewBalance(client);
            }
            else if(selector.equals(3)){
                exit();
                break;
            }
        }
    }

    @Override public void cityBankMenu(BankAccount client) {
        while(true){
            printCityBankMenu();
            selector = scanner.nextInt();
            if(selector.equals(1)){
                withdraw(client);
            }
            else if(selector.equals(2)){
                viewBalance(client);
            }
            else if(selector.equals(3)){
                setPincode(client);
            }
            else if(selector.equals(4)){
                cashIn(client);
            }
            else if(selector.equals(5)){
                viewData(client);

            }
            else if(selector.equals(6)){
                exit();
                break;
            }

        }
    }

    private void exit() {
        System.exit(0);
    }
@Override
    public void viewData(final BankAccount client) {
        System.out.println(bankservice.accountData(client));
    }

   @Override public void cashIn(final BankAccount client) {
        System.out.println("Write sum to cash in");
        var value = scanner.nextBigDecimal();
        bankservice.replenishment(value,client);
    }

    @Override public void setPincode(final BankAccount client) {
        System.out.println("Type new Pin Code");
        String pin = scanner.nextLine();
        bankservice.setPincode(client,pin);
    }

    @Override  public void viewBalance(final BankAccount client) {
        System.out.println("Total balance" + bankservice.totalBalance(client));
    }

    @Override
    public void withdraw(final BankAccount client) {
        System.out.println("Insert amount");
        var amount = scanner.nextBigDecimal();
        bankservice.withdrawCash(amount, client);
    }

    private void printCityBankMenu() {
        System.out.println("\nPRESS [1] TO CASH WITHDRAWAL\n" +
                "PRESS [2] TO VIEW BALANCE\n" +
                "PRESS [3] TO CHANGE PIN CODE\n" +
                "PRESS [4] TO CASH IN ACCOUNT\n" +
                "PRESS [5] TO VIEW ACCOUNT DATA\n" +
                "PRESS [6] TO EXIT");
    }
    private void printNationalBankMenu(){
        System.out.println("\nPRESS [1] TO CASH WITHDRAWAL\n" +
                "PRESS [2] TO VIEW BALANCE\n" +
                "PRESS [3] TO EXIT");
    }

}

//final - невозможно изменить обьект в дальнейшем
// static - используют с переменными и методами, то есть принадлежит только к классу и вызвать тот или иной метод
// можно через класс
//abstract - метод или класс от которого будут наследоваться
//public - Поля и методы, объявленные с модификатором  видны другим классам из текущего пакета и из внешних пакетов
//private -  Закрытый класс или член класса доступен только из кода в том же классе
//protected - поля и методы будут видны: в пределах всех классов, находящихся в том же пакете, что и наш;
//в пределах всех классов-наследников нашего класса.

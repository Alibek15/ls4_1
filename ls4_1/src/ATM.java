import model.BankAccount;
import model.CityBankAccount;

import service.BankService;
import service.BankServiceImpl;
import service.MenuService;
import service.MenuServiceImpl;

import java.math.BigDecimal;
import java.util.Scanner;

public class ATM {
    public static final BankService bankService = new BankServiceImpl();
    public static void main(String[] args) {



        //Java standart edition
        // Примитивы, ссылочные типы
        // Ссылочные хранятся в Heap, примитивы в стеке
        // Scaner class next(); - возвращаемый тип строка
        //nextline(); - возвращаемый тип строка с пробелами
       /* String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello"); // обход pull string
        System.out.println(s1.equals(s2));

        System.out.println(s1 == s2);

        System.out.println(s1==s3);

        s1 += " World";
        s2 += " World";

        System.out.println(s1.equals(s2));

        System.out.println(s1 == s2);*/

        /*
        * приложение банкомат
        * ПМ:
        * 1) снять деньги
        * 2) просмотр баланса
        * 3) изменить пин-код
        * 4) добавить деньги в счет
        * 5)просмотр данные счета
        * 6) выход
        * СМ:
        * 1)снять деньги
        * 2)просмотр баланса
        * 3)выход*/


   /*     Boolean cycle = true;
        BigDecimal sum;
        System.out.println("1)Введите номер аккаунта и пинкод");
        Scanner scanner = new Scanner(System.in);
        String numberAndCode[] = scanner.nextLine().split(" ");
        BankServiceImpl BSI = new BankServiceImpl();
        BankAccount acc= BSI.checkClient(numberAndCode[0].toString(), numberAndCode[1].toString());

        if(acc instanceof CityBankAccount){
            acc = (CityBankAccount)acc;

            while (cycle){
                System.out.println("1)Снять деньги");
                System.out.println("2) Просмотр баланса");
                System.out.println("3)Изменить пин-код");
                System.out.println("4)Добавить деньги в счет");
                System.out.println("5)Просмотр данных счета");
                System.out.println("6)Выход");
                Scanner scan = new Scanner(System.in);
                Integer num = scan.nextInt();
                switch(num){
                    case 1:
                        System.out.println("Введите сумму");
                        sum=scan.nextBigDecimal();
                        acc.withdrawCash(sum);
                        System.out.println("Cнялась " + sum + " со счета.");
                        break;
                    case 2:
                        System.out.println(acc.totalBalance());
                        break;
                    case 4:
                        System.out.println("Введите сумму");
                        sum=scan.nextBigDecimal();
                        acc.debitBalance(sum);
                        System.out.println("Добавилась " + sum + " денег.");
                        break;
                    case 3:
                        System.out.println("Введите новый пин-код");
                        String PC=scan.nextLine();
                        acc.setPincode(PC);
                        System.out.println("Пинкод изменен.");
                        break;
                    case 5:
                        System.out.println(acc.accountData());
                        break;
                    case 6:
                        cycle = false;
                        System.out.println("Выход");
                        break;
                    default:
                }
            }
        }
        else{
            while(cycle){
                System.out.println("1)Снять деньги");
                System.out.println("2)Просмотр баланса");
                System.out.println("3)Выход");
                Scanner scan = new Scanner(System.in);
                Integer num = scan.nextInt();
                switch (num){
                    case 1:
                        System.out.println("Введите сумму");
                        sum = scan.nextBigDecimal();
                        acc.withdrawCash(sum);
                        System.out.println("Снялась " + sum + " денег");
                        break;
                    case 2:
                        System.out.println(acc.totalBalance());
                        break;
                    case 3:
                        cycle = false;
                        break;
                    default:
                }
            }
        }*/

        System.out.println("Enter your account number");
        Scanner scanner1 = new Scanner(System.in);//создавать что то когда это уже используется
        String accountNumber = scanner1.next();
        System.out.println("Enter your pincode");
        String pincode = scanner1.next();
        BankAccount client = bankService.getClient(accountNumber, pincode);
        MenuService menuService = new MenuServiceImpl();

        if(client == null){
            System.out.println("Incorrect account number or pincode");
        }
        else{
            menuService.showMenu(client);
        }

    }
}
//kiss - Keep it simple, stupid
// DRY - dont repeat yourself
// WET - write everything twice
// SOLID - Single responsibility, Open-closed, Liskov substitution, Interface segregation, Dependency inversion
//model - поля, конструктор, getter and setter
//repository - data access object (в основном)
//service - архитектуры (domain-driven design), (model- view - controller),  (android- dagger)
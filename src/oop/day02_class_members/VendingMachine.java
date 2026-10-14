package oop.day02_class_members;

import java.util.Scanner;

public class VendingMachine {
    public static Scanner sc = new Scanner(System.in);
    private int price;//商品的价格
    private int balance;//余额
    private int total;//总销售额
    public VendingMachine(int price)
    {
        this.price = price;
    }
    void showPrompt()
    {
        System.out.println("Welcome");
    }
    void showPrice()
    {
        System.out.println("Price is "+price);
    }
    void insertMoney(int amount)
    {
        balance += amount;
    }
    void showBalance()
    {
        System.out.println("Now Balance="+balance);
    }
    void getFood()
    {
        while( balance < price ){
            System.out.println("Not enough money. Please insert "+(price - balance)+" more");
            int reim = sc.nextInt();
            balance += reim;
        }
        if( balance >= price ){
            System.out.println("Here you are.");
            balance -= price;
            total += price;
        }
    }
    int continuePurchase()
    {
        int ret;
        System.out.println("Continue purchase?\nYes(1) No(0)");
        ret = sc.nextInt();
        return ret;
    }
    public static void main(String[] args){
        int price = VendingMachine.sc.nextInt();
        VendingMachine vm = new VendingMachine(price);
        vm.showPrompt();
        int again;
        again = 1;
        do {
            vm.showPrice();
            vm.showBalance();
            System.out.println("Please pay money:");
            int im = vm.sc.nextInt();
            vm.insertMoney(im);
            vm.getFood();
            vm.showBalance();
            again = vm.continuePurchase();
        }while( again == 1 );
        System.out.println("Please take you change:"+vm.balance+". Please come again.");
        System.out.println("Total:"+vm.total);
    }
}

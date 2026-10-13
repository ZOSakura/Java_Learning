package oop.day01_basics;

import java.util.Scanner;

public class VendingMachine {
    int price = 50;//商品的价格(可修改)
    int balance = 0;//余额
    int total = 0;//总销售额
    void ShowPrompt()
    {
        System.out.println("Welcome");
    }
    void ShowPrice()
    {
        System.out.println("Price is "+price);
    }
    void InsertMoney(int amount)
    {
        balance += amount;
    }
    void ShowBalance()
    {
        System.out.println("Now Balance="+balance);
    }
    void GetFood()
    {
        Scanner sc = new Scanner(System.in);
        while( balance < price ){
            System.out.println("Not enough money. Please insert more");
            int reim = sc.nextInt();
            balance += reim;
        }
        if( balance >= price ){
            System.out.println("Here you are.");
            balance -= price;
            total += price;
        }
    }
    int Change()
    {
        return balance;
    }
    int total()
    {
        return total;
    }
    int Continue_Purchase()
    {
        Scanner sc = new Scanner(System.in);
        int yn;
        System.out.println("Continue purchase?\nYes(1) No(0)");
        yn = sc.nextInt();
        return yn;
    }
    public static void main(String[] args){
        VendingMachine vm = new VendingMachine();
        Scanner sc = new Scanner(System.in);
        int again = 1;
        vm.ShowPrompt();
        do {
            vm.ShowPrice();
            vm.ShowBalance();
            System.out.println("请付款:");
            int im = sc.nextInt();
            vm.InsertMoney(im);
            vm.GetFood();
            vm.ShowBalance();
            again = vm.Continue_Purchase();
        }while( again == 1 );
        int change = vm.Change();
        int total = vm.total();
        System.out.println("Please take you change:"+change+". Please come again.");
        System.out.println("Total:"+total);
    }
}

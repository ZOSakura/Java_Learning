package oop.day05_collections_and_hashmap;

import java.util.HashMap;
import java.util.Scanner;

public class Coin {
    static Scanner sc = new Scanner(System.in);
    private HashMap<Integer, String> coinNames = new HashMap<Integer, String>();
    public Coin(){
        coinNames.put(1, "penny");
        coinNames.put(10, "dime");
        coinNames.put(25, "quarter");
        coinNames.put(50, "half-dollar");
    }
    public void list(){
        for( Integer key : coinNames.keySet() ){
            System.out.printf("%d\n", key);
        }
    }
    public String getName(int amount){
        if( coinNames.containsKey(amount) ) {
            System.out.println("找到了，它的名字是:");
            return coinNames.get(amount);
        }else return "NOT FOUND(没找到这种硬币的名字)";
    }
    public static void main(String[] args)
    {
        Coin coin = new Coin();
        System.out.println("目前一共支持输出"+coin.coinNames.keySet().size()+"种硬币的名字");
        System.out.println("它们是:");
        coin.list();
        System.out.println("请输入硬币的面值:");
        int amount = Coin.sc.nextInt();
        System.out.println(coin.getName(amount));
    }
}

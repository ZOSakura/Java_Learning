package oop.day08_polymorphism_and_object;

import java.util.ArrayList;

public class Database {
    private ArrayList<Item> listItems = new ArrayList<Item>();
    public void list(){
        for( Item item : listItems){
            item.print();
        }
    }
    public void add(Item item){
        listItems.add(item);
    }
    public static void main(String[] args)
    {
        Database database = new Database();
        database.add(new CD("Rainbow Chaser(2021 Remake)", "Plum", 1, (4*60+15), false, "Replay?"));
        database.add(new CD("热爱105°C的你", "早稻叽", 1, (3*60+15), false, "2021"));
        database.add(new DVD("dvd", "director", (120*60), false, "comment"));
        database.list();
    }
}
package oop.day10_refactoring_and_extensibility;

import java.util.ArrayList;

public class Database {
    private ArrayList<Item> listItems = new ArrayList<Item>();
    public void list(){
        for( Item item : listItems){
            item.print();
            System.out.printf("\n");
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
        database.add(new DVD("DVD", "director", (120*60), false, "comment"));
        database.add(new VideoGame("VideoGame", 3600, false, "comment", 4, "PC"));
        database.add(new MP3("Fledgling", "Sot-C", 8, (4*40+49), false, "Brutiful ~凶悪美~", 44.1, 1010));
        database.list();
    }
}
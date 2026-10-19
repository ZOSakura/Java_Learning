package oop.day08_polymorphism_and_object;

public class DVD extends Item {
    private String director;
    public DVD(String title, String director, int playingTime, boolean gotIt, String comment){
        super(title, playingTime, gotIt, comment);
        this.director = director;
    }
    @Override
    public void print(){
        System.out.println("DVD");
        System.out.println("Director:"+director);
        super.print();
        System.out.printf("\n");
    }
}
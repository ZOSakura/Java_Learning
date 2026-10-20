package oop.day09_week03_and_week04_exercises;

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
    }
}
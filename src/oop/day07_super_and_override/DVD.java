package oop.day07_super_and_override;

public class DVD extends Item {
    private String director;
    public DVD(String title, String director, int playingTime, boolean gotIt, String comment){
        super(title, playingTime, gotIt, comment);
        this.director = director;
    }
    public void print(){
        System.out.println("DVD");
        System.out.printf("Title:");
        super.printTitle();
        System.out.println("Director:"+director);
        System.out.printf("PlayingTime:");
        super.printPlayingTime();
        System.out.printf("gotIt:");
        super.printGotIt();
        System.out.printf("Comment:");
        super.printComment();
        System.out.printf("\n");
    }
}
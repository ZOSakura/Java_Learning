package oop.day06_media_inheritance;

public class DVD extends Item {
    private String title;
    private String director;
    private int playTime;
    private boolean gotIt = false;
    private String comment;
    public DVD(String title, String director, int playTime, boolean gotIt, String comment){
        //super();
        this.title = title;
        this.director = director;
        this.playTime = playTime;
        this.gotIt =gotIt;
        this.comment = comment;
    }
    public void print(){
        System.out.println("DVD");
        System.out.println("Title:"+title);
        System.out.println("Director:"+director);
        System.out.println("PlayTime:"+playTime+"min");
        System.out.println("gotIt:"+gotIt);
        System.out.println("Comment:"+comment);
        System.out.printf("\n");
    }
}
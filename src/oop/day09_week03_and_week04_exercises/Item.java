package oop.day09_week03_and_week04_exercises;

public class Item {
    private String title;
    private int playingTime;
    private boolean gotIt = false;
    private String comment;

    public Item(String title, int playingTime, boolean gotIt, String comment) {
        super();
        this.title = title;
        this.playingTime = playingTime;
        this.gotIt = gotIt;
        this.comment = comment;
    }
    public void print(){
        System.out.println("Title:"+title);
        System.out.println("PlayingTime:"+playingTime+"s");
        System.out.println("GotIt:"+gotIt);
        System.out.println("Comment:"+comment);
    }
    public String getTitle(){ return title; }
    public int getPlayingTime(){ return playingTime; }
    public boolean getGotIt(){ return gotIt; }
    public String getComment(){ return comment; }
}

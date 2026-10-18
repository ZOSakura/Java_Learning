package oop.day07_super_and_override;

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

    }
    public void printTitle() {
        System.out.println(title);
    }
    public void printPlayingTime() {
        System.out.println(playingTime+"s");
    }
    public void printGotIt() {
        System.out.println(gotIt);
    }
    public void printComment() {
        System.out.println(comment);
    }
}

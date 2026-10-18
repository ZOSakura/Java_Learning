package oop.day07_super_and_override;

public class CD extends Item {
    private String artist;
    private int numofTracks;

    public CD(String title, String artist, int numofTracks, int playingTime, boolean gotIt, String comment){
        super(title, playingTime, gotIt, comment);
        this.artist = artist;
        this.numofTracks = numofTracks;
    }
    public void print(){
        System.out.println("CD");
        System.out.printf("Title:");
        super.printTitle();
        System.out.println("Artist:"+artist);
        System.out.println("NumofTracks:"+numofTracks);
        System.out.printf("PlayingTime:");
        super.printPlayingTime();
        System.out.printf("gotIt:");
        super.printGotIt();
        System.out.printf("Comment:");
        super.printComment();
        System.out.printf("\n");
    }
}

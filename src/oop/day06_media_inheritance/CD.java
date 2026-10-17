package oop.day06_media_inheritance;

public class CD extends Item {
    private String title;
    private String artist;
    private int numofTracks;
    private int playTime;
    private boolean gotIt = false;
    private String comment;
    public CD(String title, String artist, int numofTracks, int playTime, boolean gotIt, String comment){
        //super();
        this.title = title;
        this.artist = artist;
        this.numofTracks = numofTracks;
        this.playTime = playTime;
        this.gotIt =gotIt;
        this.comment = comment;
    }
    public void print(){
        System.out.println("CD");
        System.out.println("Title:"+title);
        System.out.println("Artist:"+artist);
        System.out.println("NumofTracks:"+numofTracks);
        System.out.println("PlayTime:"+playTime+"s");
        System.out.println("gotIt:"+gotIt);
        System.out.println("Comment:"+comment);
        System.out.printf("\n");
    }
}

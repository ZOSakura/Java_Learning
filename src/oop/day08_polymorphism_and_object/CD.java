package oop.day08_polymorphism_and_object;

public class CD extends Item {
    private String artist;
    private int numOfTracks;

    public CD(String title, String artist, int numofTracks, int playingTime, boolean gotIt, String comment){
        super(title, playingTime, gotIt, comment);
        this.artist = artist;
        this.numOfTracks = numofTracks;
    }
    @Override
    public void print(){
        System.out.println("CD");
        System.out.println("Artist:"+artist);
        super.print();
        System.out.println("NumofTracks:"+numOfTracks);
        System.out.printf("\n");
    }
}

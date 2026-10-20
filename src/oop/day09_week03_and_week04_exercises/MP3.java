package oop.day09_week03_and_week04_exercises;

public class MP3 extends Item {
    private String artist;
    private int numOfTracks;
    private double sampleRate;
    private int bitDepth;

    public MP3(String title, String artist, int numofTracks, int playingTime, boolean gotIt, String comment, double sampleRate, int bitDepth){
        super(title, playingTime, gotIt, comment);
        this.artist = artist;
        this.numOfTracks = numofTracks;
        this.sampleRate = sampleRate;
        this.bitDepth = bitDepth;
    }
    @Override
    public void print(){
        System.out.println("MP3");
        System.out.println("Artist:"+artist);
        super.print();
        System.out.println("NumofTracks:"+numOfTracks);
        System.out.println("SampleRate:"+sampleRate+"kHz");
        System.out.println("BitDepth:"+bitDepth+"kbps");
    }
}

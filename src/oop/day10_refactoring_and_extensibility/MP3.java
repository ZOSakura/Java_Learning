package oop.day10_refactoring_and_extensibility;

public class MP3 extends CD{
    private double sampleRate;
    private int bitDepth;

    public MP3(String title, String artist, int numofTracks, int playingTime, boolean gotIt, String comment, double sampleRate, int bitDepth){
        super(title, artist, numofTracks, playingTime, gotIt, comment);
        this.sampleRate = sampleRate;
        this.bitDepth = bitDepth;
    }
    @Override
    public void print(){
        super.print();
        System.out.println("SampleRate:"+sampleRate+"kHz");
        System.out.println("BitDepth:"+bitDepth+"kbps");
    }
}

package oop.day10_refactoring_and_extensibility;

public class VideoGame extends Item {
    private int numOfPlayers;
    private String platform;
    public VideoGame(String title, int playingTime, boolean gotIt, String comment, int numOfPlayers, String platform) {
        super(title, playingTime, gotIt, comment);
        this.numOfPlayers = numOfPlayers;
        this.platform = platform;
    }
    @Override
    public void print() {
        System.out.println("VideoGame");
        super.print();
        System.out.println("NumofPlayers:"+numOfPlayers);
        System.out.println("Platform:"+platform);
    }
}

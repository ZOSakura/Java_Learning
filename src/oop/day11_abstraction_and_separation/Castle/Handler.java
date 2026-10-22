package oop.day11_abstraction_and_separation.Castle;

public abstract class Handler {
    protected Game game;
    public Handler(Game game){
        this.game = game;
    }
    public abstract void doCmd(String word);

    public boolean isBye(){
        return false;
    }
    public boolean isGo(){
        return false;
    }
    public boolean isHelp(){
        return false;
    }
}

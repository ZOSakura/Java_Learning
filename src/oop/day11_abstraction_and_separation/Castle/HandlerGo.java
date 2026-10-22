package oop.day11_abstraction_and_separation.Castle;

public class HandlerGo extends Handler{
    public HandlerGo(Game game) {
        super(game);
    }

    @Override
    public void doCmd(String word) {
        game.goRoom(word);
    }
}

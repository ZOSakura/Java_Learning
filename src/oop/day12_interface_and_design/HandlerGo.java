package oop.day12_interface_and_design;

public class HandlerGo implements Handler {
    @Override
    public String doCmd(Game game, String word) {
        game.goRoom(word);
        return "";
    }

    @Override
    public boolean isBye() {
        return false;
    }
}

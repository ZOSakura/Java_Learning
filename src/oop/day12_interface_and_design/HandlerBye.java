package oop.day12_interface_and_design;

public class HandlerBye implements Handler {
    @Override
    public String doCmd(Game game, String word) {
        return "";
    }

    @Override
    public boolean isBye() {
        return true;
    }
}

package oop.day12_interface_and_design;

public interface Handler {
    String doCmd(Game game, String word);
    boolean isBye();
}

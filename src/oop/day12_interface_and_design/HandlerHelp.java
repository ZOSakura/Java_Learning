package oop.day12_interface_and_design;

public class HandlerHelp implements Handler {

    @Override
    public String doCmd(Game game, String word) {
        return "迷路了吗？你可以做的命令有：go bye help\n如：\tgo east";
    }

    @Override
    public boolean isBye() {
        return false;
    }
}

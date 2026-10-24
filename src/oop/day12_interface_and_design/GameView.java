package oop.day12_interface_and_design;

import java.util.HashMap;
import java.util.Scanner;

public class GameView {
    private final Game game;
    private final Scanner in = new Scanner(System.in);
    private HashMap<String, Handler> handlers = new HashMap<String, Handler>();
    public GameView(Game game) {
        handlers.put("go", new HandlerGo());
        handlers.put("help", new HandlerHelp());
        handlers.put("bye", new HandlerBye());
        this.game = game;
    }

    public void printExit(){
        System.out.print("出口有：");
        System.out.println(game.getCurrentRoomExitDesc());
        System.out.println();
    }

    public void printWelcome() {
        System.out.println();
        System.out.println("欢迎来到城堡！");
        System.out.println("这是一个超级无聊的游戏。");
        System.out.println("如果需要帮助，请输入 'help' 。");
        System.out.println();
        System.out.println("现在你在" + game.getCurrentRoomName());
        printExit();
    }

    public void play() {
        while (true) {
            String line = in.nextLine();
            String[] words = line.split(" ");
            Handler handler = handlers.get(words[0]);
            String value = "";
            if( words.length > 1 ){
                value = words[1];
            }
            if ( handler != null ) {
                String str = handler.doCmd(game, value);
                if ( !str.isEmpty() ) {
                    System.out.println(str);
                    printExit();
                }
                if ( handler.isBye() ) break;
            } else {
                System.out.println("不存在这个指令！");
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        GameView gv = new GameView(game);
        gv.printWelcome();
        gv.play();
        System.out.println("感谢您的光临。再见！");
        gv.in.close();
    }
}

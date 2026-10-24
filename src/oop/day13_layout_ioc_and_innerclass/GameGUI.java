package oop.day13_layout_ioc_and_innerclass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Scanner;

public class GameGUI {
    private final Game game;
    private final Scanner in = new Scanner(System.in);
    private JFrame frame = new JFrame("Window");
    private JButton buttonNorth = new JButton("go North");
    private JButton buttonSouth = new JButton("go South");
    private JButton buttonWest = new JButton("go West");
    private JButton buttonEast = new JButton("go East");
    private JButton buttonHelp = new JButton("help");
    private JButton buttonExit = new JButton("Exit");
    private JPanel panel = new JPanel();
    public GameGUI(Game game) {
        this.game = game;
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buttonNorth.addActionListener(e -> {System.out.println(game.goRoom("north")); printExit();});
        buttonSouth.addActionListener(e -> {System.out.println(game.goRoom("south")); printExit();});
        buttonWest.addActionListener(e -> {System.out.println(game.goRoom("west")); printExit();});
        buttonEast.addActionListener(e -> {System.out.println(game.goRoom("east")); printExit();});
        buttonHelp.addActionListener(e -> System.out.println("迷路了吗？你可以点击窗口中的按钮：go xxx, exit, help\n如：\t点击 'go east' \n退出游戏请点击右上角的 'X' 或者点击按钮 'Exit' "));
        buttonExit.addActionListener(e -> {
                    int choice = JOptionPane.showConfirmDialog(
                            null,
                            "你确定要退出游戏吗",
                            "退出确认",
                            JOptionPane.YES_NO_CANCEL_OPTION
                    );
                    if( choice == JOptionPane.YES_OPTION ){
                        System.out.println("感谢您的光临。再见！");
                        System.exit(0);
                    }
                });
        panel.add(buttonHelp);
        panel.add(buttonExit);
        frame.add(buttonNorth, BorderLayout.NORTH);
        frame.add(buttonSouth, BorderLayout.SOUTH);
        frame.add(buttonWest, BorderLayout.WEST);
        frame.add(buttonEast, BorderLayout.EAST);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public void printExit(){
        System.out.print("出口有：");
        System.out.println(game.getCurrentRoomExitDesc());
        System.out.println();
    }

    public void printWelcome() {
        System.out.println();
        System.out.println("欢迎来到城堡！");
        System.out.println("这是一个超级无聊的游戏");
        System.out.println("如果需要帮助，请点击 'help' ");
        System.out.println("退出游戏请按右上角的 'X' 或者点击按钮 'Exit' ");
        System.out.println();
        System.out.println("现在你在" + game.getCurrentRoomName());
        printExit();
    }

    public static void main(String[] args) {
        Game game = new Game();
        GameGUI gv = new GameGUI(game);
        gv.printWelcome();
    }
}

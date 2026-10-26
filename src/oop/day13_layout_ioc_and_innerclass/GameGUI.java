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
    private JPanel buttonPanel = new JPanel(new GridLayout(3, 3));
    private JButton buttonNorth = new JButton("go North");
    private JButton buttonSouth = new JButton("go South");
    private JButton buttonWest = new JButton("go West");
    private JButton buttonEast = new JButton("go East");
    private JButton buttonHelp = new JButton("help");
    private JButton buttonExit = new JButton("Exit");
    private JTextArea textArea = new JTextArea("114514", 7, 1);
    private JScrollPane scrollPane = new JScrollPane(textArea);
    private Timer timer = new Timer(2000, e -> System.exit(0));
    public GameGUI(Game game) {
        this.game = game;
        timer.setRepeats(false);
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buttonNorth.addActionListener(e -> {textArea.setText(game.goRoom("north")); printExit();});
        buttonSouth.addActionListener(e -> {textArea.setText(game.goRoom("south")); printExit();});
        buttonWest.addActionListener(e -> {textArea.setText(game.goRoom("west")); printExit();});
        buttonEast.addActionListener(e -> {textArea.setText(game.goRoom("east")); printExit();});
        buttonHelp.addActionListener(e -> textArea.setText("迷路了吗？你可以点击窗口中的按钮：go xxx, exit, help\n如：\t点击 'go east' \n退出游戏请点击右上角的 'X' 或者点击按钮 'Exit' "));
        buttonExit.addActionListener(e -> {
                    int choice = JOptionPane.showConfirmDialog(
                            null,
                            "你确定要退出游戏吗",
                            "退出确认",
                            JOptionPane.YES_NO_CANCEL_OPTION
                    );
                    if( choice == JOptionPane.YES_OPTION ){
                        textArea.setText("感谢您的光临。再见！");
                        timer.start();
                    }
                });
        buttonPanel.add(new JLabel(""));
        buttonPanel.add(buttonNorth);
        buttonPanel.add(buttonExit);
        buttonPanel.add(buttonWest);
        buttonPanel.add(buttonHelp);
        buttonPanel.add(buttonEast);
        buttonPanel.add(new JLabel(""));
        buttonPanel.add(buttonSouth);
        buttonPanel.add(new JLabel(""));
        frame.add(scrollPane, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        //frame.pack();
        frame.setVisible(true);
    }

    public void printExit(){
        textArea.append("出口有：" + game.getCurrentRoomExitDesc());
    }

    public void printWelcome() {
        textArea.setText("欢迎来到城堡！\n这是一个超级无聊的游戏\n如果需要帮助，请点击 'help' \n退出游戏请按右上角的 'X' 或者点击按钮 'Exit' \n\n现在你在" + game.getCurrentRoomName() + "\n");
        printExit();
    }

    public static void main(String[] args) {
        Game game = new Game();
        GameGUI gameGUI = new GameGUI(game);
        gameGUI.printWelcome();
    }
}

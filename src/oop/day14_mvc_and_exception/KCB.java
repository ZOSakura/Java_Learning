package oop.day14_mvc_and_exception;

import javax.swing.*;

public class KCB {
    public static void main(String[] args){
        JFrame frame = new JFrame();
        JTable table = new JTable(new KCBData());
        JScrollPane scrollPane = new JScrollPane(table);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scrollPane);
        frame.pack();
        frame.setVisible(true);
    }
}

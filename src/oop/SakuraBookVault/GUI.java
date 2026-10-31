package oop.SakuraBookVault;

import javax.swing.*;

public class GUI {
    private final BookVault bookVault = new BookVault();
    private JFrame frame = new JFrame();
    private JTable table = new JTable(new BookData(bookVault.getAllBooks()));
    private JScrollPane scrollPane = new JScrollPane(table);
    private JPanel panel = new JPanel();
    public GUI(){
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setVisible(true);
    }
    public void reloadBooks(BookVault bookVault) throws Exception {
        bookVault.saveBooks();
        try {
            table = new JTable(new BookData(bookVault.getAllBooks()));
        } catch (Exception e) {
            throw e;
        }
        System.gc();
    }
    public static void main(String[] args){
        GUI gui = new GUI();
        BookVault bookVM = new BookVault();
        bookVM.saveBooks();
    }
}

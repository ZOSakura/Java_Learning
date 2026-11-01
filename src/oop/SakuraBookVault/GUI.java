package oop.SakuraBookVault;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private final BookVault bookVault = new BookVault();
    private JFrame frame = new JFrame();
    private JTable table = new JTable(new BookData(bookVault.getAllBooks()));
    private JScrollPane scrollPane = new JScrollPane(table);
    private JPanel topSearchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JLabel searchIcon = new JLabel("🔍");
    private JTextField searchField = new JTextField(20);
    private JButton btnSearch = new JButton("搜索");
    private JPanel rightPanel = new JPanel();
    private JPanel centerBtns = new JPanel(new GridLayout(2, 2, 5, 5));
    private JButton btnAdd = new JButton("新增书籍");
    private JButton btnRemove = new JButton("移除书籍");
    private JButton btnBorrow = new JButton("借出书激");
    private JButton btnReturn = new JButton("归还书籍");
    private JButton btnExit = new JButton("退出程序");
    public GUI(){
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btnAdd.addActionListener(e -> {
             JOptionPane.showInputDialog(null);
        });
        topSearchPanel.add(searchIcon);
        topSearchPanel.add(searchField);
        topSearchPanel.add(btnSearch);
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        centerBtns.add(btnAdd);
        centerBtns.add(btnRemove);
        centerBtns.add(btnBorrow);
        centerBtns.add(btnReturn);
        rightPanel.add(centerBtns);
        rightPanel.add(Box.createVerticalGlue());
        rightPanel.add(btnExit);
        frame.add(topSearchPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(rightPanel, BorderLayout.EAST);
        //frame.pack();
        frame.setVisible(true);
    }
    public void reloadBooks() throws Exception {
        bookVault.saveBooks();
        table.setModel(new BookData(bookVault.getAllBooks()));
    }
    public static void main(String[] args){
        new GUI();
    }
}

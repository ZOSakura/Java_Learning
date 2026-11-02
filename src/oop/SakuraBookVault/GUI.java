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
    private JButton btnRemove = new JButton("删除书籍");
    private JButton btnBorrow = new JButton("借出书激");
    private JButton btnReturn = new JButton("归还书籍");
    private JButton btnExit = new JButton("退出程序");
    public GUI(){
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btnAdd.addActionListener(e -> {
             String[] res = showTwoInputs("新增书籍", "作者名字:", "书籍名字:");
             if( res != null ){
                 bookVault.addBook(res[0], res[1]);
                 bookVault.saveBooks();
                 try {
                     reloadBooks();
                 } catch (Exception ex) {
                     ex.printStackTrace();
                 }
             }
        });
        btnRemove.addActionListener(e->{
            JTable dialogTable = new JTable(new BookData(bookVault.getAllBooks()));
            JPanel dialogPanel = new JPanel(new BorderLayout());
            dialogPanel.add(new JScrollPane(dialogTable), BorderLayout.CENTER);
            while(true) {
                int choice = JOptionPane.showConfirmDialog(
                        null,
                        dialogPanel,
                        "选择一行以进行删除",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE
                );
                if( choice != JOptionPane.OK_OPTION ){
                    break;
                }
                int row = dialogTable.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(
                            null,
                            "你还没选中任何行!",
                            "警告",
                            JOptionPane.WARNING_MESSAGE
                    );
                    continue;
                }
                int reChoice = JOptionPane.showConfirmDialog(
                        null,
                        "确定要删除吗？(删除后不可恢复，请谨慎操作！)",
                        "警告",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE
                );
                if( reChoice == JOptionPane.YES_OPTION ){
                    int modelRow = dialogTable.convertRowIndexToModel(row);
                    bookVault.removeBook(modelRow);
                    bookVault.saveBooks();
                    try {
                        reloadBooks();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    break;
                }
            }
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
    public String[] showTwoInputs(String title, String label1, String label2){
        JTextField titleField = new JTextField("", 20);
        JTextField authorField = new JTextField("", 32);
        JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));
        panel.add(new JLabel(label1));
        panel.add(titleField);
        panel.add(new JLabel(label2));
        panel.add(authorField);
        int r = JOptionPane.showConfirmDialog(
                null,
                panel,
                title,
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );
        if( r == JOptionPane.OK_OPTION ){
            return new String[]{
                    titleField.getText(),
                    authorField.getText()
            };
        }
        return null;
    }
    public void reloadBooks() throws Exception {
        bookVault.saveBooks();
        table.setModel(new BookData(bookVault.getAllBooks()));
    }
    public static void main(String[] args){
        new GUI();
    }
}

package oop.SakuraBookVault;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class GUI {
    private final BookVault bookVault = new BookVault();
    private JFrame frame = new JFrame();
    private BookData bookData = new BookData(bookVault.getAllBooks());
    private JTable table = new JTable(bookData);
    private JScrollPane scrollPane = new JScrollPane(table);
    private JPanel topSearchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JLabel searchIcon = new JLabel("🔍");
    private JTextField searchField = new JTextField(20);
    private JButton btnSearch = new JButton("搜索");
    private JPanel rightPanel = new JPanel();
    private JPanel centerBtns = new JPanel(new GridLayout(2, 2, 5, 5));
    private JButton btnAdd = new JButton("新增书籍");
    private JButton btnRemove = new JButton("删除书籍");
    private JButton btnBorrow = new JButton("借出书籍");
    private JButton btnReturn = new JButton("归还书籍");
    private JButton btnExit = new JButton("退出程序");
    private boolean isSearching = false;//isSearching的修改一定要放在reloadBooks方法调用之前！！！不然会重复调用导致程序崩溃！！！
    public GUI(){
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        btnAdd.addActionListener(e -> {
             String[] res = showTwoInputs("新增书籍", "作者名字:", "书籍名字:");
             if( res != null ){
                 bookVault.addBook(res[0], res[1]);
                 bookVault.saveBooks();
                 reloadBooks();
             }
        });
        btnRemove.addActionListener(e->{
            showTableSelector("选择一行以进行删除", "你还没选中任何行!", "警告", "确定要删除吗？(删除后不可恢复，请谨慎操作！)", "警告", bookVault::removeBook, null, null);
        });
        btnBorrow.addActionListener(e -> {
            showTableSelector("选择一本书借出", "你还没选中任何一本书!", "警告", "借出后请记得归还! 确定借出请按YES", "注意事项", null, bookVault::setBookBorrowStatus, true);
        });
        btnReturn.addActionListener(e->{
            showTableSelector("选择一本书归还", "你还没选中任何一本书!", "警告", "阅读完了吗？确定归还请按YES", "注意事项", null, bookVault::setBookBorrowStatus, false);
        });
        btnSearch.addActionListener(e -> searchByKeyWord());
        searchField.addActionListener(e -> {
            //用户按下回车也能直接搜索，符合大众使用习惯
            searchByKeyWord();
        });
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if( !searchField.getText().trim().isEmpty() ){
                    searchByKeyWord();
                }
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                //当用户清空搜索框时自动显示所有书籍，不需要用户二次按下空格或者搜索按钮
                if( searchField.getText().trim().isEmpty() ){
                    //isSearching的修改一定要放在reloadBooks方法调用之前！！！不然会重复调用导致程序崩溃！！！
                    isSearching = false;
                    reloadBooks();
                }
            }
            @Override
            public void changedUpdate(DocumentEvent e) { }
        });
        btnExit.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(
                    null,
                    "你确定要退出吗",
                    "退出确认",
                    JOptionPane.YES_NO_CANCEL_OPTION
            );
            if( choice == JOptionPane.YES_OPTION ){
                System.exit(0);
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
        JTextField authorField = new JTextField("", 20);
        JTextField titleField = new JTextField("", 20);
        JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));
        panel.add(new JLabel(label1));
        panel.add(authorField);
        panel.add(new JLabel(label2));
        panel.add(titleField);
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
    public void showTableSelector(String panelTitle, String warningMessage, String warningTitle, String reWarningMessage, String reWarningTitle, Consumer<Integer> operation, BiConsumer<Integer, Boolean> biOperation, Boolean borrowed){
        //制造用于弹窗的表格
        JTable dialogTable = new JTable(this.bookData);
        JPanel dialogPanel = new JPanel(new BorderLayout());
        dialogPanel.add(new JScrollPane(dialogTable), BorderLayout.CENTER);
        //循环显示表格框
        while(true) {
            int choice = JOptionPane.showConfirmDialog(
                    null,
                    dialogPanel,
                    panelTitle,
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE
            );
            //当用户选择完毕按下OK
            if( choice != JOptionPane.OK_OPTION ){
                break;
            }
            //获取用户选择的行
            int row = dialogTable.getSelectedRow();
            //如果用户没有选择任何一行
            if (row == -1) {
                JOptionPane.showMessageDialog(
                        null,
                        warningMessage,
                        warningTitle,
                        JOptionPane.WARNING_MESSAGE
                );
                continue;
            }
            //转换为实际的行
            int modelRowOrId;
            if( !isSearching ){
                //不在搜索状态中正常使用modelRow
                modelRowOrId = dialogTable.convertRowIndexToModel(row);
            }else {
                //搜索中使用id来对书籍数据进行修改
                modelRowOrId = Integer.parseInt((String) dialogTable.getValueAt(dialogTable.convertRowIndexToModel(row), 0));
                --modelRowOrId;//调用id时需要-1
            }
            //借出与归还判定部分
            if(borrowed != null) {
                //获取选中的行对应的那本书
                Book selectBook = bookVault.getBook(modelRowOrId);
                //判断是否有重复借出或归还行为:
                //重复借出:
                if (selectBook.isBorrowed() == borrowed && borrowed) {
                    JOptionPane.showMessageDialog(
                            null,
                            "这本书已经被借出了!",
                            warningTitle,
                            JOptionPane.WARNING_MESSAGE
                    );
                    continue;
                }
                //重复归还:
                if (selectBook.isBorrowed() == borrowed && !borrowed) {
                    JOptionPane.showMessageDialog(
                            null,
                            "这本书还没被借出，不能归还!",
                            warningTitle,
                            JOptionPane.WARNING_MESSAGE
                    );
                    continue;
                }
            }
            //二次确定框，防止误触
            int reChoice = JOptionPane.showConfirmDialog(
                    null,
                    reWarningMessage,
                    reWarningTitle,
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.PLAIN_MESSAGE
            );
            if( reChoice == JOptionPane.YES_OPTION ){
                //在一个参数和两个参数的方法中选择调用
                if( operation != null ) {
                    operation.accept(modelRowOrId);
                }
                if( biOperation != null ){
                    biOperation.accept(modelRowOrId, borrowed);
                }
                //保存并刷新数据
                bookVault.saveBooks();
                reloadBooks();
                break;
            }else break;
        }
    }
    public void searchByKeyWord(){
        String keyword = searchField.getText().trim(); // 拿到用户输入的词
        if (keyword.isEmpty()) {
            isSearching = false;
            reloadBooks(); // 如果是空搜索，直接显示全部
            return ;
        }
        // 核心：过滤数据
        HashMap<Integer, Book> searchResults = new HashMap<Integer, Book>();//存符合要求的书对应的id-1和书的数据
        ArrayList<Integer> integersArrayList = new ArrayList<>();//存一共有多少本书符合要求
        for ( int i = 0 ; i < bookVault.getAllBooks().size() ; i++ ) {
            // 只要书名或者作者包含用户输入的词（不区分大小写）
            Book book = bookVault.getBook(i);
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.put(i, book);
                integersArrayList.add(i);
            }
        }
        //将过滤后的结果给表格
        this.bookData = new BookData(searchResults, integersArrayList);
        table.setModel(bookData);
        isSearching = true;
    }
    public void reloadBooks(){
        bookVault.saveBooks();
        if(!isSearching) {
            this.bookData = new BookData(bookVault.getAllBooks());
            table.setModel(bookData);
        }else searchByKeyWord();
    }
    public static void main(String[] args){
        new GUI();
    }
}

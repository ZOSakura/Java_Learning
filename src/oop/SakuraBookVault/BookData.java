package oop.SakuraBookVault;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.HashMap;

public class BookData implements TableModel {
    private String[] title = {
            "书籍编号", "作者名字", "书籍名字", "是否被借出"
    };
    private final int colum = 4;
    private String[][] data;
    public BookData(ArrayList<Book> library){
        data = new String[library.size()][colum];
        for( int i = 0 ; i < library.size() ; i++ ){
            String id = String.format("%04d", i+1);//此处序号为+1后的，改善观感，实际调用应-1以正常调用
            String isBorrowed = library.get(i).isBorrowed() ? "是" : "否";
            data[i][0] = id;
            data[i][1] = library.get(i).getAuthor();
            data[i][2] = library.get(i).getTitle();
            data[i][3] = isBorrowed;
        }
    }
    //用于搜索的HashMap特供版
    public BookData(HashMap<Integer, Book> library, ArrayList<Integer> integerArrayList){
        data = new String[library.size()][colum];
        for( int i = 0 ; i < library.size() ; i++ ){
            Integer integer = integerArrayList.get(i);
            String id = String.format("%04d", integer + 1);//此处序号为+1后的，改善观感，实际调用应-1以正常调用
            String isBorrowed = library.get(integer).isBorrowed() ? "是" : "否";
            data[i][0] = id;
            data[i][1] = library.get(integer).getAuthor();
            data[i][2] = library.get(integer).getTitle();
            data[i][3] = isBorrowed;
        }
    }
    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return colum;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return title[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        data[rowIndex][columnIndex] = (String)aValue;
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}

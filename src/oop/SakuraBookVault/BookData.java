package oop.SakuraBookVault;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;

public class BookData implements TableModel {
    private String[] title = {
            "书籍编号", "作者名字", "书籍名字", "是否被借出"
    };
    private final int colum = 4;
    private String[][] data;
    public BookData(ArrayList<Book> library){
        data = new String[library.size()][colum];
        for( int i = 0 ; i < library.size() ; i++ ){
            String id = String.format("%04d", i);
            String isBorrowed = library.get(i).isBorrowed() ? "是" : "否";
            data[i][0] = id;
            data[i][1] = library.get(i).getAuthor();
            data[i][2] = library.get(i).getTitle();
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

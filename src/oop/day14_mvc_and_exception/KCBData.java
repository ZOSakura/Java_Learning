package oop.day14_mvc_and_exception;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.Arrays;

public class KCBData implements TableModel {
    private String[] title = {
            "周一", "周二", "周三", "周四", "周五", "周六", "周日",
    };
    private String[][] data = new String[15][7];
    public KCBData(){
        for( int i = 0 ; i < data.length ; i++ ){
            Arrays.fill(data[i], "");
        }
    }
    @Override
    public int getRowCount() {
        return 15;
    }

    @Override
    public int getColumnCount() {
        return 7;
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
        return true;
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

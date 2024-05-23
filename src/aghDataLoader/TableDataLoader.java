/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aghDataLoader;

/**
 *
 * @author Lzy
 */

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public abstract class TableDataLoader extends DataLoader {
    protected JTable table;

    public TableDataLoader(String filePath, JTable table) {
        super(filePath);
        this.table = table;
    }

    protected abstract String[] getTableHeaders();
    protected abstract int[] getColumnIndices();

    public abstract void loadData();

    protected void populateTable(String[][] data) {
        String[] headers = getTableHeaders();
        DefaultTableModel model = new DefaultTableModel(data, headers);
        table.setModel(model);
    }
}

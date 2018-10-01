/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author leori
 */
public class CellEditor extends DefaultCellEditor implements TableCellRenderer {

    private final JComponent componet = new JCheckBox();
    private boolean value = false;

    public CellEditor() {
        super(new JCheckBox());
    }

    @Override
    public Object getCellEditorValue() {
        return ((JCheckBox) componet).isSelected();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        //((JCheckBox) componet).setBackground(new Color(200, 200, 0));
        boolean b = ((Boolean) value);
        ((JCheckBox) componet).setSelected(b);
        return (JCheckBox) componet;
    }

    @Override
    public boolean stopCellEditing() {
        value = ((Boolean)getCellEditorValue());
        ((JCheckBox)componet).setSelected(value);
        return super.stopCellEditing();
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
        if(value == null)
            return null;
        else
            return ((JCheckBox)componet);
    }
    
    
}

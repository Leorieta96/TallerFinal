/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author leori
 */
public class CellRender extends JCheckBox implements TableCellRenderer {

    private final JComponent componet = new JCheckBox();

    public CellRender() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        ((JCheckBox) componet).setBackground(new Color(167, 218, 251));
        boolean b = ((Boolean) value);
        ((JCheckBox) componet).setSelected(b);
        return ((JCheckBox) componet);
    }

}

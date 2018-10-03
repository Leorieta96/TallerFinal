/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import dao.DAOException;
import dao.MaterialDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Material;
import clases.Compra;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author leori
 */
public class MaterialEscasoTableModel extends DefaultTableModel {

    private MaterialDAO materiales;
    private Compra compras;
    private List<Material> datos = new ArrayList<>();
    Object[][] datoss = null;

    public MaterialEscasoTableModel(MaterialDAO materiales) {
        this.materiales = materiales;
    }

    public List<Material> getDatos() {
        return datos;
    }

    public void updateModel() throws DAOException {
        datos = materiales.obtenerxCantidad(4);
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID Material";
            case 1:
                return "Nombre";
            case 2:
                return "Descripcion";
            case 3:
                return "Stock";
            case 4:
                return "Precio Unitario";
            case 5:
                return "Rubro";
            case 6:
                return "Seleccionar";
            default:
                return " ";
        }
    }

    Class[] types = new Class[]{
        java.lang.Object.class, java.lang.Object.class, java.lang.Object.class,
        java.lang.Object.class, java.lang.Object.class, java.lang.Object.class,
        JCheckBox.class
    };

    @Override
    public Class getColumnClass(int columnIndex) {
        return types[columnIndex];
    }

    public void setDatoss() {
        datoss = new Object[datos.size()][7];
        int i = 0;
        for (Material m : datos) {
            datoss[i][0] = m.getidMaterial();
            datoss[i][1] = m.getNombre();
            datoss[i][2] = m.getdescripcion();
            datoss[i][3] = m.getStockMaterial();
            datoss[i][4] = m.getPrecioUnitario();
            datoss[i][5] = m.getRubro();
            datoss[i][6] = false;
            i++;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 6;
    }
    
//    Object[][] datoss = new Object[][]{
//        {true, "Víctor", "Su casa", fecha1, 1, new JButton("Clic aquí")},
//        {false, "Fernanda", "calle sin nombre #501", fecha2, 0, new JButton("Clic aquí")},
//        {true, "Julian", "Orilla del rio #014", fecha3, 0, new JButton("Clic aquí")}
//    };

//    @Override
//    public String getColumnName(int column) {
//        switch (column) {
//            case 0:
//                return "ID Material";
//            case 1:
//                return "Nombre";
//            case 2:
//                return "Descripcion";
//            case 3:
//                return "Stock";
//            case 4:
//                return "Precio Unitario";
//            case 5:
//                return "Rubro";
//            case 6:
//                return "Seleccionar";
//            default:
//                return " ";
//        }
//    }
//
//    @Override
//    public int getRowCount() {
//        return datos.size();
//    }
//
//    @Override
//    public int getColumnCount() {
//        return 7;
//    }
//
//    @Override
//    public Object getValueAt(int rowIndex, int columnIndex) {
//        Material preguntado = datos.get(rowIndex);
//        switch (columnIndex) {
//            case 0:
//                return preguntado.getidMaterial();
//            case 1:
//                return preguntado.getNombre();
//            case 2:
//                return preguntado.getdescripcion();
//            case 3:
//                return preguntado.getStockMaterial();
//            case 4:
//                return preguntado.getPrecioUnitario();
//            case 5:
//                return preguntado.getRubro();
//            case 6:
//                return JCheckBox.class;
//            default:
//                return "";
//        }
////        return null;
//    }
//
//    Class[] types = new Class[]{
//        java.lang.Object.class, java.lang.Object.class, java.lang.Object.class,
//        java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, 
//        JCheckBox.class
//    };
//
//    @Override
//    public Class getColumnClass(int columnIndex) {
//        return types[columnIndex];
//    }
//
//    @Override
//    public boolean isCellEditable(int rowIndex, int columnIndex) {
//        return columnIndex == 6;
//    }

    public Object[][] getDatoss() {
        return datoss;
    }
}

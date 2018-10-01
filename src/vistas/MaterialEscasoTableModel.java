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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author leori
 */
public class MaterialEscasoTableModel extends AbstractTableModel{

    private MaterialDAO materiales;
    private Compra compras;
    private List<Material> datos = new ArrayList<>();

    public MaterialEscasoTableModel(MaterialDAO materiales) {
        this.materiales = materiales;
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
                return "Tipo de Materia";
            case 2:
                return "descripcion";
            case 3:
                return "stock";
            case 4:
                return "Precio Unitario";
//            case 5:
//                return "Seleccionar";
            default:
                return " ";
        }
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Material preguntado = datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return preguntado.getidMaterial();
            case 1:
                return preguntado.getTipoMaterial();
            case 2:
                return preguntado.getdescripcion();
            case 3:
                return preguntado.getStockMaterial();
            case 4:
                return preguntado.getPrecioUnitario();
//            case 5:
//                return false;
            default:
               return "";
        }
//        return null;
    }

    Class[] types = new Class[]{
        java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, //java.lang.Boolean.class
    };

    @Override
    public Class getColumnClass(int columnIndex) {
        return types[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 5;
    }
}

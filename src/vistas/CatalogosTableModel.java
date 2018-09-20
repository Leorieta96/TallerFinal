/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import dao.CatalogoDAO;
import dao.DAOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Catalogo;

/**
 *
 * @author leori
 */
public class CatalogosTableModel extends AbstractTableModel{
     
    private CatalogoDAO catalogos;
    
    private List<Catalogo> datos = new ArrayList<>();

    public CatalogosTableModel(CatalogoDAO catalogos) {
        this.catalogos = catalogos;
    }

    public void updateModel() throws DAOException{
        datos = catalogos.obtenerTodos();
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "ID";
            case 1: return "fecha";
            case 2: return "cuit";
                default: return "hola";
        }
    }
    
    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Catalogo preguntado = datos.get(rowIndex);
        switch(columnIndex){
            case 0: return preguntado.getIdCatalogo();
            case 1: 
                DateFormat df = DateFormat.getDateInstance();
                return df.format(preguntado.getFecha());
            case 2: return preguntado.getCuit();
                default: return "";
        }
    }
}

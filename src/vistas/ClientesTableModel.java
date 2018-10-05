/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import dao.ClienteDAO;
import dao.DAOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelo.Cliente;

/**
 *
 * @author Lucas
 */
 public class ClientesTableModel extends AbstractTableModel{
     
     private ClienteDAO cliente;
     private List<Cliente>datos = new ArrayList<>();
     
    public ClientesTableModel(ClienteDAO cliente){
        this.cliente=cliente;
    
    
    }
    
    public void actualizar() throws DAOException{
    datos= cliente.obtenerTodos();
    
    }

    @Override
    public String getColumnName(int i) {
        
        switch(i){
            case 0: return "DNI" ;
            case 1: return "Nombre";
            case 2: return "Telefono";
            case 3: return  "Direccion";
            case 4: return "Email";
            default: return "[no]";
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
        Cliente preguntado = datos.get(rowIndex);
        switch (columnIndex){
            case 0: return preguntado.getdni();
            case 1: return preguntado.getNombre();
            case 2: return preguntado.getTelefono();
            case 3: return preguntado.getDireccion();
            case 4: return preguntado.getEmail();
            default: return "";
        
        
        }
        
}
}

package dao;

import java.util.List;
import modelo.Proveedor;

public interface ProveedorDAO extends DAO<Proveedor, Long>{
    
    public List<Proveedor> obtenerXrubros(String rubro) throws DAOException;
    
}

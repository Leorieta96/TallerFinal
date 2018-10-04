package dao;

import java.util.List;
import modelo.Material;

public interface MaterialDAO extends DAO<Material, Long>{

    public List<Material> obtenerxCantidad(int cant)throws DAOException;
    public List<Material> obtenerTodosxNombre(String nombre) throws DAOException ;
    
    
}

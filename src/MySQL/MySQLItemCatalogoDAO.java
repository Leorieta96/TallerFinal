package MySQL;

import dao.DAOException;
import dao.ItemCalatalogoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import modelo.ItemCatalogo;
import modelo.ItemCatalogo.Id;

public class MySQLItemCatalogoDAO implements ItemCalatalogoDAO {

    final String INSERT = "INSERT INTO `itemcatalogo` (`precioUnitario`, `nombre`, `marca`, `idCatalogo`) VALUES (?, ?, ?, ?)";
    
    private Connection conn;

    public MySQLItemCatalogoDAO(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public void insertar(ItemCatalogo a) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setLong(1, a.getPrecioUnitario());
            stat.setString(2, a.getNombre());
            stat.setString(3, a.getMarca());
            stat.setLong(4, a.getIdCatalogo());
            if (stat.executeUpdate() == 0) {
                System.out.println("Puede q no se haya guardado");
            }
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL", ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new DAOException("Error en SQL", e);
                }
            }
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
    }

    @Override
    public void eliminar(ItemCatalogo a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(ItemCatalogo a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ItemCatalogo> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ItemCatalogo obtener(Id id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

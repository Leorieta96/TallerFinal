package MySQL;

import dao.DAOException;
import dao.MaterialDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Material;

public class MySQLMaterialDAO implements MaterialDAO {

    final String INSERT = "INSERT INTO `material` (`nombre`, `descripcion`, `stockMaterial`, `precioUnitarioM`, `rubro`) VALUES ( ?, ?, ?, ?, ?)";
    final String UPDATE = "UPDATE catalogo SET fecha = ?";
    final String DELETE = "DELETE FROM catalogo WHERE idCatalogo = ?";
    final String GETALL = "SELECT * FROM `material`";
    final String GETONE = "SELECT *  FROM `material` WHERE `idCatalogo` = ?";
    final String GETxCANT = "SELECT * FROM `material` WHERE `stockMaterial` <= 5  ";

    private Connection conn;

    public MySQLMaterialDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(Material a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Material a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Material a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Material> obtenerTodos() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Material> materiales = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                materiales.add(convertir(rs));
            }
        } catch (SQLException e) {
            throw new DAOException("Error SQL");
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
                } catch (SQLException e) {
                    throw new DAOException("Error SQL", e);
                }
            }
        }
        return materiales;

    }

    @Override
    public Material obtener(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return @throws DAOException
     */
//    @Override
//    public List<Material> obtenerxCantidad() throws DAOException{
//        PreparedStatement stat = null;
//        ResultSet rs = null;
//        List<Material> materiales = new ArrayList<>();
//        try {
//            stat = conn.prepareStatement(GETxCANT);
//            rs = stat.executeQuery();
//            while (rs.next()) {
//                materiales.add(convertir(rs));
//            }
//        } catch (SQLException e) {
//            throw new DAOException("Error SQL");
//        } finally {
//            if (rs != null) {
//                try {
//                    rs.close();
//                } catch (SQLException e) {
//                    throw new DAOException("Error en SQL", e);
//                }
//            }
//            if (stat != null) {
//                try {
//                    stat.close();
//                } catch (SQLException e) {
//                    throw new DAOException("Error SQL", e);
//                }
//            }
//        }
//        return materiales;
//
//    }
    private Material convertir(ResultSet rs) throws SQLException {
        Long id = (long) rs.getInt("idMaterial");
        Material material = new Material(id, rs.getString("nombre"), rs.getString("descripcion"), rs.getInt("stockMaterial"), (long) rs.getInt("precioUnitarioM"), rs.getString("rubro"));
        return material;
    }

    @Override
    public List<Material> obtenerxCantidad(int cant) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Material> materiales = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETxCANT);
            //stat.setInt(4, cant);
            rs = stat.executeQuery();
            while (rs.next()) {
                materiales.add(convertir(rs));
            }
        } catch (SQLException e) {
            throw new DAOException("Error SQL");
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
                } catch (SQLException e) {
                    throw new DAOException("Error SQL", e);
                }
            }
        }
        return materiales;
    }
}

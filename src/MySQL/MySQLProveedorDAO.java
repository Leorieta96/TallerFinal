package MySQL;

import dao.DAOException;
import dao.ProveedorDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import modelo.Proveedor;

public class MySQLProveedorDAO implements ProveedorDAO {

    final String INSERT = "INSERT INTO proveedor(cuit, nombre, telefono, direccion, rubro) VALUES(?, ?, ?, ?, ?)";
    final String UPDATE = "UPDATE `proveedor` SET `nombre` = ?, "
            + "`telefono` = ?, `direccion` = ? ,`rubro` = ? "
            + "WHERE `proveedor`.`cuit` = ?";
    final String GETONE = "SELECT cuit, nombre, telefono, direccion, rubro FROM proveedor WHERE cuit = ?";

    private Connection conn;

    public MySQLProveedorDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(Proveedor a) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setLong(1, a.getCuit());
            stat.setString(2, a.getNombre());
            stat.setInt(3, a.getTelefono());
            stat.setString(4, a.getDireccion());
            stat.setString(5, a.getRubro());
            if (stat.executeUpdate() == 0) {
                throw new DAOException("Puede q no se haya guardado");
            }
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL", ex);
        } finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en sql", ex);
                }
            }
        }
    }

    @Override
    public void eliminar(Proveedor a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Proveedor a) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(UPDATE);
            stat.setString(1, a.getNombre());
            stat.setInt(2, a.getTelefono());
            stat.setString(3, a.getDireccion());
            stat.setString(4, a.getRubro());
            stat.setLong(5, a.getCuit());
            if (stat.executeUpdate() == 0) {
                throw new DAOException("Puede q no se haya guardado");
            }
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL", ex);
        } finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en sql", ex);
                }
            }
        }
    }

    @Override
    public List<Proveedor> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Proveedor obtener(Long id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Proveedor c = null;
        try {
            stat = conn.prepareStatement(GETONE);
            stat.setLong(1, id);
            rs = stat.executeQuery();
            if (rs.next()) {
                c = convertir(rs);
            } else {
                throw new DAOException("No se ha encntrado ese registro");
            }
        } catch (SQLException e) {
            throw new DAOException("Erro SQL");
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
        return c;
    }

    private Proveedor convertir(ResultSet rs) throws SQLException {
        Proveedor proveedor = new Proveedor(rs.getLong("cuit"), rs.getString("nombre"), rs.getInt("telefono"), rs.getString("direccion"), rs.getString("rubro"));
        return proveedor;
    }

    @Override
    public List<Proveedor> obtenerXrubros(String rubro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

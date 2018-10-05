package MySQL;

import dao.DAOException;
import dao.DetallePresupuestoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.DetallePresupuesto;
import modelo.DetallePresupuesto.Id;

public class MySQLDetallePresupuestoDAO implements DetallePresupuestoDAO {

    final String INSERT = "INSERT INTO `detallepresupuesto` (`idPresupuesto`, `idMaterial`, `descripcion`, `subtotal`, `cantidad`) VALUES (?, ?,?, ?, ?)";
    final String UPDATE = "UPDATE detallepresupuesto SET idPresupuesto = ?";
    final String DELETE = "DELETE FROM detallePresupuesto WHERE idPresupuesto = ? idMaterial = ?";
    final String GETALL = "SELECT idPresupuesto, idMaterial, descripcion, subtotal, cantidad";
    final String GETxIdPres = "SELECT * FROM `detallepresupuesto` WHERE `idPresupuesto` = ?";
    final String GETONE = "SELECT detallePresupuesto, codMaterial, descripcion, subtotalPedC, cantidadPedC WHERE  idPresupuesto = ? idMaterial = ? ";

    private Connection conn;

    public MySQLDetallePresupuestoDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(DetallePresupuesto a) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);

            stat.setLong(1, a.getId().getIdPresupuesto());
            stat.setLong(2, a.getId().getIdMaterial());
            stat.setString(3, a.getDescripcion());
            stat.setDouble(4, a.getSubtotal());
            stat.setInt(5, a.getCantidad());
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
    public void eliminar(DetallePresupuesto a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(DetallePresupuesto a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DetallePresupuesto> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DetallePresupuesto obtener(Id id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private DetallePresupuesto convertir(ResultSet rs) throws SQLException {
        DetallePresupuesto detalle = new DetallePresupuesto(
                rs.getLong("idPresupuesto"), rs.getLong("idMaterial"), 
                rs.getString("descripcion"), rs.getDouble("subtotal"), 
                rs.getInt("cantidad"));
        return detalle;
    }

    @Override
    public List<DetallePresupuesto> obtenerXIdPresupuesto(Long IdPresupuesto) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<DetallePresupuesto> detalles = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETxIdPres);
            stat.setLong(1, IdPresupuesto);
            rs = stat.executeQuery();
            while (rs.next()) {
                detalles.add(convertir(rs));
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
        return detalles;
    }
}

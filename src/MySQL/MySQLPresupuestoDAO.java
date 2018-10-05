package MySQL;

import dao.DAOException;
import dao.PresupuestoDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import modelo.Presupuesto;

public class MySQLPresupuestoDAO implements PresupuestoDAO {

    final String INSERT = "INSERT INTO presupuesto( fecha, total) VALUES( ?, ?)";
    final String UPDATE = "UPDATE presupuesto SET fecha = ?, total = ?  WHERE codPresupuesto = ?";
    final String DELETE = "DELETE FROM presupuesto WHERE codPresupuesto = ?";
    final String GETALL = "SELECT codPresupuesto, fecha, total FROM presupuesto = ?";
    final String GETONE = "SELECT * FROM presupuesto WHERE idPresupuesto = ?";

    private Connection conn;

    public MySQLPresupuestoDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(Presupuesto a) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            stat = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

            stat.setDate(1, a.getFecha());
            stat.setDouble(2, a.getTotal());
            if (stat.executeUpdate() == 0) {
                throw new DAOException("Puede q no se haya guardado");
            }
            rs = stat.getGeneratedKeys();
            if (rs.next()) {
                a.setIdPresupuesto(rs.getLong(1));
            } else {
                throw new DAOException("puede q no se haya generado");
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
    public void eliminar(Presupuesto a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Presupuesto a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Presupuesto convertir(ResultSet rs) throws SQLException {
        Date fecha = rs.getDate("fecha");
        Double total = rs.getDouble("total");
        Presupuesto presupuesto = new Presupuesto(fecha, total);
        presupuesto.setIdPresupuesto(rs.getLong("idPresupuesto"));
        return presupuesto;

    }

    @Override
    public List<Presupuesto> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public Presupuesto obtener(Long id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Presupuesto c = null;
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
        return c;
    }
}

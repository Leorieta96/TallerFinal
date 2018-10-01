package MySQL;

import dao.DAOException;
import dao.PresupuestoDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import modelo.Presupuesto;

public class MySQLPresupuestoDAO implements PresupuestoDAO{

    final String INSERT = "INSERT INTO presupuesto(codPresupuesto, fecha, total) VALUES(?, ?, ?)";
    final String UPDATE = "UPDATE presupuesto SET fecha = ?, total = ?  WHERE codPresupuesto = ?";
    final String DELETE = "DELETE FROM presupuesto WHERE codPresupuesto = ?";
    final String GETALL = "SELECT codPresupuesto, fecha, total FROM presupuesto = ?";
    final String GETONE = "SELECT codPresupuesto, fecha, total FROM presupuesto WHERE codPresupuesto = ?";
    
    
    private Connection conn;
    
    public MySQLPresupuestoDAO(Connection conn){ 
        this.conn = conn;
    }
    
    @Override
    public void insertar(Presupuesto a) throws DAOException{
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setLong(1, a.getIdPresupuesto());
            stat.setDate(2, a.getFecha());
            stat.setDouble(3, a.getTotal());
            if(stat.executeUpdate()== 0){
                throw new DAOException("Puede q no se haya guardado");
            }
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL", ex);
        } finally {
            if (stat != null){ 
                try {
                    stat.close();
                } catch (SQLException ex){ 
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

    private Presupuesto convertir(ResultSet rs) throws SQLException{ 
        Date fecha = rs.getDate("fecha");
        Double total = rs.getDouble("total");
        Presupuesto presupuesto = new Presupuesto(fecha,total);
        presupuesto.setIdPresupuesto(rs.getLong("codPresupuesto"));
        return presupuesto;
        
        
    }
    
    
    @Override
    public List<Presupuesto> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public Presupuesto obtener(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}

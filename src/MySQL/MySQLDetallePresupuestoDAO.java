package MySQL;

import dao.DAOException;
import dao.DetallePresupuestoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import modelo.DetallePresupuesto;
import modelo.DetallePresupuesto.Id;

public class MySQLDetallePresupuestoDAO implements DetallePresupuestoDAO{
    
     final String INSERT = "INSERT INTO `detallepresupuesto` (`idPresupuesto`, `idMaterial`, `descripcion`, `subtotal`, `cantidad`) VALUES (?, ?,?, ?, ?)";
    final String UPDATE = "UPDATE detallepresupuesto SET idPresupuesto = ?";
    final String DELETE = "DELETE FROM detallePresupuesto WHERE idPresupuesto = ? idMaterial = ?";
    final String GETALL = "SELECT idPresupuesto, idMaterial, descripcion, subtotal, cantidad";
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
}

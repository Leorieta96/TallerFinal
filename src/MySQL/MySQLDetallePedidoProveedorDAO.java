package MySQL;

import dao.DetallePedidoProveedorDAO;
import dao.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.DetallePedidoProveedor;
import modelo.DetallePedidoProveedor.Id;

public class MySQLDetallePedidoProveedorDAO implements DetallePedidoProveedorDAO{

    final String INSERT = "INSERT INTO detallePedidoProveedor (idPedidoProveedor, idMaterial, descripcion, cantidad, subtotal) VALUES (?, ?, ?, ?, ?)";
    final String UPDATE = "UPDATE detallePedidoProveedor SET fecha = ?"; ///cambiar
    final String DELETE = "DELETE FROM detallePedidoProveedor WHERE idPedidoProveedor = ? idMaterial = ?";
    final String GETALL = "SELECT idPedidoProveedor, idMaterial, descripcion, cantidad, subtotal";
    final String GETONE = "SELECT idPedidoProveedor, idMaterial, descripcion, cantidad, subtotal WHERE idPedidoProveedor = ? idMaterial = ?";
        
    private Connection conn;
    
    public MySQLDetallePedidoProveedorDAO(Connection conn){
        this.conn =conn;
        
    };
    
    @Override
    public void insertar(DetallePedidoProveedor a) throws DAOException { 
        PreparedStatement stat = null; 
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setLong(1,a.getId().getIdPedidoProveedor());
            stat.setLong(2, a.getId().getIdMaterial());
            stat.setString(3, a.getDescripcion());
            stat.setInt(4, a.getCantidad());
            stat.setDouble(5, a.getSubtotal());
            if(stat.executeUpdate() == 0){
            throw new DAOException("Puede que no se haya guardado ");
            }
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL", ex);
        } finally{
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
                
            }
        }
        
    }
    
    
    
    

    @Override
    public void eliminar(DetallePedidoProveedor a) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(DELETE);
            stat.setLong(1, a.getId().getIdPedidoProveedor());
            stat.setLong(2, a.getId().getIdMaterial());
            if(stat.executeUpdate()==0){
            throw new DAOException("Puede que el alumno no se haya borrado");
            }
        } catch (SQLException ex) {
            throw new DAOException("Error de SQL",ex);
        }finally{
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error de SQL",ex);
                }
            }       
        }
    }

    @Override
    public void modificar(DetallePedidoProveedor a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private DetallePedidoProveedor convertir(ResultSet rs )throws SQLException{
        DetallePedidoProveedor detalleProv = new DetallePedidoProveedor(null,null ,rs.getString("descripcion"),rs.getInt("cantidad"), rs.getDouble("subtotal"));
        detalleProv.setId(rs.getLong("idPedidoProveedor"),rs.getLong("idMaterial"));
        return detalleProv;
   }
    
    
    @Override
    public List<DetallePedidoProveedor> obtenerTodos() throws  DAOException{
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<DetallePedidoProveedor> detalleProv = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while(rs.next()){
                detalleProv.add(convertir(rs));
            }
         } catch (SQLException ex) {
            throw new DAOException("Error en SQL",ex);
           
        }finally{
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException  ex) {
                    new DAOException("Error en SQL", ex);
                }
            }
            if (stat!=null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    new DAOException("Error en SQL", ex);
                }
            }
       }
        return detalleProv;
      
    }

    @Override
    public DetallePedidoProveedor obtener(Id id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        DetallePedidoProveedor p = null;
        try {
            stat = conn.prepareStatement(GETONE);
            stat.setLong(1, id.getIdPedidoProveedor() );
            stat.setLong(2, id.getIdMaterial() );
            rs = stat.executeQuery();
            if(rs.next()){
                p = convertir(rs);
            }else {
            throw new DAOException("No se ha encontrado ese registro");
            }
         } catch (SQLException ex) {
            throw new DAOException("Error en SQL",ex);
           
        }finally{
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException  ex) {
                    new DAOException("Error en SQL", ex);
                }
            }
            if (stat!=null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    new DAOException("Error en SQL", ex);
                }
            }
       }
        return p;
    }
}

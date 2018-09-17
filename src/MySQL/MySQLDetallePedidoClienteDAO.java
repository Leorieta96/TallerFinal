package MySQL;

import dao.DAOException;
import dao.DetallePedidoClienteDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.DetallePedidoCliente;

public class MySQLDetallePedidoClienteDAO implements DetallePedidoClienteDAO{
    
    final String INSERT = "INSERT INTO detallePedidoCliente (idPedidoCliente, idMaterial, descripcion, subtotalPedC, cantidadPedC) VALUES (?, ?, ?, ?, ?)";
    final String UPDATE = "UPDATE detallePedidoCliente SET idPedidoCliente = ?";
    final String DELETE = "DELETE FROM detallePedidoCliente WHERE idPedidoCliente = ? idMaterial = ?";
    final String GETALL = "SELECT idPedidoCliente, codMaterial, descripcion, subtotalPedC, cantidadPedC";
    final String GETONE = "SELECT idPedidoCliente, codMaterial, descripcion, subtotalPedC, cantidadPedC WHERE codCatalogo = ?";

    private Connection conn;

    public MySQLDetallePedidoClienteDAO(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public void insertar(DetallePedidoCliente a) throws DAOException{
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setLong(1, a.getIdPedidoCliente());
            stat.setLong(2, a.getIdMaterial());
            stat.setString(3, a.getDescripcion());
            stat.setFloat(4, a.getSubtotalPedC());
            stat.setInt(5, a.getCantidadPedC());
            if(stat.executeUpdate() == 0)
            {   
                System.out.println("Puede q no se haya guardado");
            }
        } catch (SQLException ex) {
             throw new DAOException("Error en SQL", ex);
        }finally{
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
    public void eliminar(DetallePedidoCliente a) throws DAOException{
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(DELETE);
            stat.setLong(1, a.getIdPedidoCliente());
            stat.setLong(2, a.getIdMaterial());
            if(stat.executeUpdate() == 0){
                System.out.println("Puede que no se haya guardado");
            }
        } catch (SQLException ex) {
            throw new DAOException("Error delete", ex);
        }finally{
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                        throw new DAOException("Error delete", ex);

                }
            }
        }
    }

    @Override
    public void modificar(DetallePedidoCliente a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private DetallePedidoCliente convertir (ResultSet rs) throws SQLException{
       DetallePedidoCliente detalle = new DetallePedidoCliente(rs.getLong("idPedidoCliente"), rs.getLong("codMaterial"), rs.getString("descripcion"), rs.getFloat("subtotalPedC"), rs.getInt("cantidadPedC"));
        return detalle;
    }
    
    @Override
    public List<DetallePedidoCliente> obtenerTodos()throws DAOException{
        PreparedStatement stat = null;
        ResultSet rs= null;
        List<DetallePedidoCliente> detalles = new ArrayList<>();
        
        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while(rs.next()){
                detalles.add(convertir(rs));
            }
        } catch (SQLException e) {
            throw new DAOException("Erro SQL");
        }finally{
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new DAOException("Error en SQL", e);
                }
            }
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new DAOException("Error SQL", e);
                }
            }
        }
        return detalles;
    }

    @Override
    public DetallePedidoCliente obtener(Long id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs= null;
        DetallePedidoCliente c = null;
        try {
            stat = conn.prepareStatement(GETONE);
            stat.setLong(1, id);
            rs = stat.executeQuery();
            if(rs.next()){
                c = convertir(rs);
            }else{
                throw new DAOException("No se ha encntrado ese registro");
            }
        } catch (SQLException e) {
            throw new DAOException("Error SQL");
        }finally{
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new DAOException("Error en SQL", e);
                }
            }
            if(stat != null){
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


package MySQL;

import dao.DAOException;
import dao.PedidoProveedorDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.PedidoProveedor;

public class MySQLPedidoProveedorDAO implements PedidoProveedorDAO{
      final String INSERT = "INSERT INTO PedidoProveedor (fechaEmision, estado, cuit) VALUES ( ?, ?, ?)";
    final String UPDATE = "UPDATE PedidoProveedor SET idPedidoProveedor = ? fechaEmision = ? estado = ?  cuit = ?";
    final String DELETE = "DELETE FROM PedidoProveedor WHERE idPedidoProveedor = ? ";
    final String GETALL = "SELECT idPedidoProveedor, fechaEmision, estado, cuit";
    final String GETONE = "SELECT idPedidoProveedor, fechaEmision, estado, cuit WHERE idPedidoProveedor = ?";
    
    private Connection conn;

    public MySQLPedidoProveedorDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(PedidoProveedor a) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            stat = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            stat.setDate(1, a.getFechaEmision());
            stat.setBoolean(2, a.getEstado());
            stat.setLong(3, a.getCuit());
            if(stat.executeUpdate() == 0)
            {   
                System.out.println("Puede q no se haya guardado");
            }rs = stat.getGeneratedKeys();
            if (rs.next()) {
                a.setIdPedidoProveedor(rs.getLong(1));
            } else {
                throw new DAOException("Puede que no se haya generado");
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
    public void eliminar(PedidoProveedor a) throws DAOException {
       PreparedStatement stat = null;
       try {
            stat = conn.prepareStatement(DELETE);
            stat.setLong(1, a.getIdPedidoProveedor());
            
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
    public void modificar(PedidoProveedor a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    private PedidoProveedor convertir (ResultSet rs) throws SQLException{
    PedidoProveedor pedido = new PedidoProveedor (null , rs.getDate("fechaEmision"),rs.getBoolean("estado"),rs.getLong("cuit"));
    pedido.setIdPedidoProveedor(rs.getLong("idPedidoProveedor"));
    return pedido;
    
    }
    @Override
    public List<PedidoProveedor> obtenerTodos() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs= null;
        List<PedidoProveedor> pedido = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETALL);
           
            
            rs = stat.executeQuery();
            if(rs.next()){
                pedido.add(convertir(rs));
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
        return pedido;
    }

    @Override
    public PedidoProveedor obtener(Long id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs= null;
        PedidoProveedor p = null;
        try {
            stat = conn.prepareStatement(GETONE);
            stat.setLong(1, id);
            
            rs = stat.executeQuery();
            if(rs.next()){
                p = convertir(rs);
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
        return p;
    }
}


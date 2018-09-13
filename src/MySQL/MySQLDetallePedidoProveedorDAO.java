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

public class MySQLDetallePedidoProveedorDAO implements DetallePedidoProveedorDAO{

    final String INSERT = "INSERT INTO detallePedidoProveedor (codPedProv, codMaterial, descripcion, cantidad, subtotal) VALUES (?, ?, ?, ?, ?)";
    final String UPDATE = "UPDATE detallePedidoProveedor SET fecha = ?"; ///cambiar
    final String DELETE = "DELETE FROM detallePedidoProveedor WHERE codPedProv = ? codMaterial = ?";
    final String GETALL = "SELECT codPedProv, codMaterial, descripcion, cantidad, subtotal";
    final String GETONE = "SELECT codPedProv, codMaterial, descripcion, cantidad, subtotal WHERE codPedProv = ? codMaterial = ?";
        
    private Connection conn;
    
    @Override
    public void insertar(DetallePedidoProveedor a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(DetallePedidoProveedor a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(DetallePedidoProveedor a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DetallePedidoProveedor> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DetallePedidoProveedor obtener(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

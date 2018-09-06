package MySQL;

import java.sql.PreparedStatement;
import dao.ClienteDAO;
import java.sql.Connection;
import java.util.List;
import modelo.Cliente;

public class MySQLClienteDAO implements ClienteDAO{

    final String INSERT = "INSERT INTO cliente (DNI, nomCliente, telCliente, dirCliente, emailCliente) VALUES (?, ?, ?, ?)";
    final String UPDATE = "UPDATE cliente SET nomCliente = ?, telCliente = ?, dirCliente = ?, emailCliente = ? WHERE DNI = ?";
    final String DELETE = "DELETE FROM cliente WHERE DNI = ?";
    final String GETALL = "SELECT DNI, nomCliente, telCliente, dirCliente, emailCliente FROM cliente";
    final String GETONE = "SELECT DNI, nomCliente, telCliente, dirCliente, emailCliente FROM cliente WHERE DNI = ?";
        
    private Connection conn;
    
    public MySQLClienteDAO(Connection conn){
        this.conn = conn;    
    }
     
    @Override
    public void insertar(Cliente a) {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setLong(1, a.getDNI());
            stat.setString(2, a.getNomCliente());
            stat.setInt(3, a.getTelCliente());
            stat.setString(4, a.getDirCliente());
            stat.setString(5, a.getEmailCliente());
            if(stat.executeUpdate()== 0){
                System.out.println("Puede q no se haya guardado");
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        } finally{
            if(stat != null){
                try {
                    stat.close();
                } catch (Exception e) {
                    System.out.println("Error" + e);
                }
            }        
        }
    }

    @Override
    public void eliminar(Cliente a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Cliente a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente obtener(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}

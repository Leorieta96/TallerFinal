package MySQL;

import java.sql.PreparedStatement;
import dao.ClienteDAO;
import dao.DAOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;

public class MySQLClienteDAO implements ClienteDAO {

    final String INSERT = "INSERT INTO cliente (dni, nombre, telefono, direccion, email) VALUES (?, ?, ?, ?)";
    final String UPDATE = "UPDATE cliente SET nombre = ?, telefono = ?, dirrecion = ?, email = ? WHERE DNI = ?";
    final String DELETE = "DELETE FROM cliente WHERE DNI = ?";
    final String GETALL = "SELECT dni, nombre, telefono, dirrecion, email FROM cliente";
    final String GETONE = "SELECT * FROM `cliente` WHERE `dni` = ?";

    private Connection conn;

    public MySQLClienteDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(Cliente a) {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setLong(1, a.getdni());
            stat.setString(2, a.getNombre());
            stat.setInt(3, a.getTelefono());
            stat.setString(4, a.getDireccion());
            stat.setString(5, a.getEmail());
            if (stat.executeUpdate() == 0) {
                System.out.println("Puede q no se haya guardado");
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        } finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (Exception e) {
                    System.out.println("Error" + e);
                }
            }
        }
    }

    @Override
    public void eliminar(Cliente a) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(DELETE);
            stat.setLong(1, a.getdni());
            if (stat.executeUpdate() == 0) {
                System.out.println("Puede que no se haya guardado");
            }
        } catch (SQLException ex) {
            throw new DAOException("Error delete", ex);
        } finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error delete", ex);

                }
            }
        }
    }

    @Override
    public void modificar(Cliente a) {
        ;
    }

    private Cliente convertir(ResultSet rs) throws SQLException {
        Long dni = (long) rs.getInt("dni");
        Cliente cliente = new Cliente(dni, rs.getString("nombre"), rs.getInt("telefono"), rs.getString("direccion"), rs.getString("email"));
        return cliente;
    }

    @Override
    public List<Cliente> obtenerTodos() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Cliente> clientes = new ArrayList<>();

        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                clientes.add(convertir(rs));
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
        return clientes;
    }

    @Override
    public Cliente obtener(Long id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Cliente c = null;
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
    
    
    
    
    
    
    
    
        public static void main(String[] args) throws SQLException, DAOException{
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/siac", "root", "");
            ClienteDAO dao = new MySQLClienteDAO(conn);
            //Catalogo c = new Catalogo(new Date(96,12,03), 215552L);
            //dao.insertar(c);
            //dao.eliminar(c);
            List<Cliente> catalogo = dao.obtenerTodos();
            for(Cliente a: catalogo){
                System.out.println(catalogo.toString());
            }
        } finally {
            if(conn != null){
                conn.close();
            }
        }
        
    }  
}

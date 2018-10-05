package MySQL;

import dao.CatalogoDAO;
import dao.DAOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Catalogo;

public class MySQLCatalogoDAO implements CatalogoDAO {

    final String INSERT = "INSERT INTO catalogo (fecha, cuit) VALUES ( ?, ?)";
    final String UPDATE = "UPDATE catalogo SET fecha = ?";
    final String DELETE = "DELETE FROM catalogo WHERE idCatalogo = ?";
    final String GETALL = "SELECT *  FROM `catalogo`";
    final String GETONE = "SELECT *  FROM `catalogo` WHERE `idCatalogo` = ?";

    private Long IdGenerated = null;
    private Connection conn;

    public MySQLCatalogoDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(Catalogo a) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            stat = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            stat.setDate(1, a.getFecha());
            stat.setLong(2, a.getCuit());
            if (stat.executeUpdate() == 0) {
                System.out.println("Puede q no se haya guardado");
            }
            rs = stat.getGeneratedKeys();
            if (rs.next()) {
                a.setIdCatalogo(rs.getLong(1));
                IdGenerated = rs.getLong(1);
            } else {
                throw new DAOException("Puede que no se haya generado");
            }
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL", ex);
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
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
    }

    @Override
    public void eliminar(Catalogo a) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(DELETE);
            stat.setLong(1, a.getIdCatalogo());
            //stat.setLong(1, id);
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
    public void modificar(Catalogo a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Catalogo convertir(ResultSet rs) throws SQLException {
        Long id = (long) rs.getInt("idCatalogo");
        Catalogo catalogo = new Catalogo(id, rs.getDate("fecha"), (long) rs.getInt("cuit"));
        return catalogo;
    }

    @Override
    public List<Catalogo> obtenerTodos() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Catalogo> catalogos = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                catalogos.add(convertir(rs));
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
        return catalogos;
    }

    @Override
    public Catalogo obtener(Long id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Catalogo c = null;
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

//    public static void main(String[] args) throws SQLException, DAOException{
//        Connection conn = null;
//        try {
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/siac", "root", "");
//            CatalogoDAO dao = new MySQLCatalogoDAO(conn);
//            //Catalogo c = new Catalogo(new Date(96,12,03), 215552L);
//            //dao.insertar(c);
//            //dao.eliminar(c);
//            List<Catalogo> catalogo = dao.obtenerTodos();
//            for(Catalogo a: catalogo){
//                System.out.println(catalogo.toString());
//            }
//        } finally {
//            if(conn != null){
//                conn.close();
//            }
//        }
//        
//    }   
    @Override
    public Long getIdGenerated() {
        Long id = IdGenerated;
        IdGenerated = null;
        return id;
    }
}

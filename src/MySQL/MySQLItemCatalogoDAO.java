package MySQL;

import dao.DAOException;
import dao.ItemCalatalogoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.List;
import modelo.ItemCatalogo;
import modelo.ItemCatalogo.Id;

public class MySQLItemCatalogoDAO implements ItemCalatalogoDAO {

    final String INSERT = "INSERT INTO ItemCatalogo (precioUnitario, nombre, marca, idCatalogo) VALUES (?, ?, ?, ?)";
    final String UPDATE = "UPDATE ItemCatalogo SET precioUnitario = ? nombre = ? marca = ? idCatalogo = ?";
    final String DELETE = "DELETE FROM ItemCatalogo WHERE precioUnitario = ? nombre = ? marca = ?";
    final String GETALL = "SELECT recioUnitario, nombre, marca, idCatalogo";
    final String GETONE = "SELECT recioUnitario, nombre, marca, idCatalogo WHERE precioUnitario = ? nombre = ? marca = ?";

    private Connection conn;

    public MySQLItemCatalogoDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(ItemCatalogo a) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setLong(1, a.getPrecioUnitario());
            stat.setString(2, a.getNombre());
            stat.setString(3, a.getMarca());
            //stat  falta el set Catalogo ._. 

            if (stat.executeUpdate() == 0) {
                System.out.println("Puede q no se haya guardado");
            }
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL", ex);
        } finally {
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
    public void eliminar(ItemCatalogo a) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(DELETE);
            stat.setLong(1, a.getPrecioUnitario());
            stat.setString(2, a.getNombre());
            stat.setString(3, a.getMarca());
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
    public void modificar(ItemCatalogo a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private ItemCatalogo convertir(ResultSet rs) throws SQLException {
        ItemCatalogo item = new ItemCatalogo(null, rs.getString("Nombre"), rs.getString("Marca"));
        item.setPrecioUnitario(rs.getLong("precioUnitario"));
        item.setNombre("Nombre");
        item.setMarca(rs.getString("Marca"));
        return item;

    }

    @Override
    public List<ItemCatalogo> obtenerTodos() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<ItemCatalogo> item = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
               item.add(convertir(rs));
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
        return item;

    }

    @Override
    public ItemCatalogo obtener(Id id) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        ItemCatalogo i = null;
        try {
            stat = conn.prepareStatement(GETONE);
            stat.setLong(1, id.getPrecioUnitario());
            stat.setString(2, id.getNombre());
            stat.setString(3, id.getMarca());
            rs = stat.executeQuery();
            if (rs.next()) {
                i = convertir(rs);
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
        return i;

    }
}

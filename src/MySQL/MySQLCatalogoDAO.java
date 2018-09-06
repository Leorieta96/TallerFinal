package MySQL;

import dao.CatalogoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import modelo.Catalogo;

public class MySQLCatalogoDAO implements CatalogoDAO{
    
    final String INSERT = "INSERT INTO catalogo (codCatalogo, fecha, cuit) VALUES (?, ?, ?)";
    final String UPDATE = "UPDATE catalogo SET fecha = ?";
    final String DELETE = "DELETE FROM catalogo WHERE codCatalogo = ?";
    final String GETALL = "SELECT codCatalogo, fecha, cuit";
    final String GETONE = "SELECT codCatalogo, fecha, cuit WHERE codCatalogo = ?";
        
    private Connection conn;
    
    public MySQLCatalogoDAO(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insertar(Catalogo a) {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setLong(1, a.getCodCatalogo());
            stat.setDate(2, a.getFecha());
            stat.setObject(3, a.getCuit());
            if(stat.executeUpdate() == 0)
            {   
                System.out.println("Puede q no se haya guardado");
            }
        } catch (Exception e) {
             System.out.println("Error" + e);
        }finally{
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
    public void eliminar(Catalogo a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Catalogo a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Catalogo> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Catalogo obtener(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

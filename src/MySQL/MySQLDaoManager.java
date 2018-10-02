/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySQL;

import dao.CatalogoDAO;
import dao.ClienteDAO;
import dao.DAOException;
import dao.DetallePedidoClienteDAO;
import dao.DetallePedidoProveedorDAO;
import dao.DetallePresupuestoDAO;
import dao.ItemCalatalogoDAO;
import dao.MaterialDAO;
import dao.PedidoClienteDAO;
import dao.PedidoProveedorDAO;
import dao.PresupuestoDAO;
import dao.ProveedorDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import modelo.Catalogo;

/**
 *
 * @author leori
 */
public class MySQLDaoManager implements dao.DAOManager{
    
    private Connection conn;
    
    private CatalogoDAO catalogo = null;
    private ClienteDAO cliente = null;
    private DetallePedidoClienteDAO detallePedidoCliente = null;
    private DetallePedidoProveedorDAO detallePedidoProveedor = null;
    private DetallePresupuestoDAO detallePresupuesto = null;
    private ItemCalatalogoDAO itemCalatalogo = null;
    private MaterialDAO material = null;
    private PedidoClienteDAO pedidoCliente = null;
    private PedidoProveedorDAO pedidoProveedor = null;
    private PresupuestoDAO presupuesto = null;
    private ProveedorDAO proveedor = null;
    
    public MySQLDaoManager(String host, String username, String password, String database) throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database, username, password );
    }

    @Override
    public CatalogoDAO getCatalogoDAO() {
        if(catalogo == null){
            catalogo = new MySQLCatalogoDAO(conn);
        }
        return catalogo;
    }

    @Override
    public ClienteDAO getClienteDAO() {
        if(cliente == null){
            cliente = new MySQLClienteDAO(conn);
        }
        return cliente;
    }

    @Override
    public DetallePedidoClienteDAO getDetallePedidoDAO() {
        if(detallePedidoCliente == null){
            detallePedidoCliente = new MySQLDetallePedidoClienteDAO(conn);
        }
        return detallePedidoCliente;
    }

    @Override
    public DetallePedidoProveedorDAO getDetallePedidoProveedorDAO() {
        if(detallePedidoProveedor == null){
            detallePedidoProveedor = new MySQLDetallePedidoProveedorDAO();
        }
        return detallePedidoProveedor;
    }

    @Override
    public DetallePresupuestoDAO getDetallePresupuestoDAO() {
        if(detallePresupuesto == null){
            detallePresupuesto = new MySQLDetallePresupuestoDAO();
        }
        return detallePresupuesto;
    }

    @Override
    public ItemCalatalogoDAO getItemCalatalogoDAO() {
        if(itemCalatalogo == null){
            itemCalatalogo = new MySQLItemCatalogoDAO(conn);
        }
        return itemCalatalogo;
    }

    @Override
    public MaterialDAO getMaterialDAO() {
        if(material == null){
            material = new MySQLMaterialDAO(conn);
        }
        return material;
    }

    @Override
    public PedidoClienteDAO getPedidoClienteDAO() {
        if(pedidoCliente == null){
            pedidoCliente = new MySQLPedidoClienteDAO();
        }
        return pedidoCliente;
    }

    @Override
    public PedidoProveedorDAO getPedidoProveedorDAO() {
        if(pedidoProveedor == null){
            pedidoProveedor = new MySQLPedidoProveedorDAO();
        }
        return pedidoProveedor;
    }

    @Override
    public ProveedorDAO getProveedorDAO() {
        if(proveedor == null){
            proveedor = new MySQLProveedorDAO(conn);
        }
        return proveedor;
    }
//    public static void main(String[] args) throws SQLException, DAOException {
//        MySQLDaoManager man = new MySQLDaoManager("localhost", "root", "", "siac");
//        List<Catalogo> catalogos = man.getCatalogoDAO().obtenerTodos();
//        System.out.println(catalogos);
//    }
}

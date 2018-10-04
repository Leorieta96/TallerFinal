/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author leori
 */
public interface DAOManager {
    
    CatalogoDAO getCatalogoDAO();
    ClienteDAO getClienteDAO();
    DetallePedidoClienteDAO getDetallePedidoDAO();
    DetallePedidoProveedorDAO getDetallePedidoProveedorDAO();
    DetallePresupuestoDAO getDetallePresupuestoDAO();
    ItemCalatalogoDAO getItemCalatalogoDAO();
    MaterialDAO getMaterialDAO();
    PedidoClienteDAO getPedidoClienteDAO();
    PedidoProveedorDAO getPedidoProveedorDAO();
    ProveedorDAO getProveedorDAO();
    PresupuestoDAO getPresupuestoDAO();
}

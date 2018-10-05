package dao;

import java.util.List;
import modelo.DetallePresupuesto;
import modelo.DetallePresupuesto.Id;

public interface DetallePresupuestoDAO extends DAO<DetallePresupuesto, Id> {

    public List<DetallePresupuesto> obtenerXIdPresupuesto(Long IdPresupuesto) throws DAOException;

}

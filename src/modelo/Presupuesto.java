package modelo;

import java.sql.Date;

public class Presupuesto {
    private Long idPresupuesto;
    private Date fecha;
    private double total;

    public Presupuesto(Long idPresupuesto, Date fecha, double total) {
        this.idPresupuesto = idPresupuesto;
        this.fecha = fecha;
        this.total = total;
    }

    public Long getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(Long idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Presupuesto{" + "idPresupuesto=" + idPresupuesto + ", total=" + total + '}';
    }   
}

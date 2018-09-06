package modelo;

import java.sql.Date;

public class Presupuesto {
    private Long codPresupuesto;
    private Date fecha;
    private double total;

    public Presupuesto(Long codPresupuesto, Date fecha, double total) {
        this.codPresupuesto = codPresupuesto;
        this.fecha = fecha;
        this.total = total;
    }

    public Long getCodPresupuesto() {
        return codPresupuesto;
    }

    public void setCodPresupuesto(Long codPresupuesto) {
        this.codPresupuesto = codPresupuesto;
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
        return "Presupuesto{" + "codPresupuesto=" + codPresupuesto + ", total=" + total + '}';
    }   
}

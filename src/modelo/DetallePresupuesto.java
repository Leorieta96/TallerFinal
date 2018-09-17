package modelo;

public class DetallePresupuesto {
    private Presupuesto idPresupuesto;
    private Material idMaterial;
    private String descripcion;
    private double subtotal;
    private int cantidad;

    public DetallePresupuesto(Presupuesto idPresupuesto, Material idMaterial, String descripcion, double subtotal, int cantidad) {
        this.idPresupuesto = idPresupuesto;
        this.idMaterial = idMaterial;
        this.descripcion = descripcion;
        this.subtotal = subtotal;
        this.cantidad = cantidad;
    }

    public Presupuesto getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(Presupuesto idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public Material getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Material idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "DetallePresupuesto{" + "idPresupuesto=" + idPresupuesto + ", idMaterial=" + idMaterial + ", descripcion=" + descripcion + ", subtotal=" + subtotal + ", cantidad=" + cantidad + '}';
    }    
}

package modelo;

public class DetallePresupuesto {
    private Presupuesto codPresupuesto;
    private Material codMaterial;
    private String descripcion;
    private double subtotal;
    private int cantidad;

    public DetallePresupuesto(Presupuesto codPresupuesto, Material codMaterial, String descripcion, double subtotal, int cantidad) {
        this.codPresupuesto = codPresupuesto;
        this.codMaterial = codMaterial;
        this.descripcion = descripcion;
        this.subtotal = subtotal;
        this.cantidad = cantidad;
    }

    public Presupuesto getCodPresupuesto() {
        return codPresupuesto;
    }

    public void setCodPresupuesto(Presupuesto codPresupuesto) {
        this.codPresupuesto = codPresupuesto;
    }

    public Material getCodMaterial() {
        return codMaterial;
    }

    public void setCodMaterial(Material codMaterial) {
        this.codMaterial = codMaterial;
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
        return "DetallePresupuesto{" + "codPresupuesto=" + codPresupuesto + ", codMaterial=" + codMaterial + ", descripcion=" + descripcion + ", subtotal=" + subtotal + ", cantidad=" + cantidad + '}';
    }    
}

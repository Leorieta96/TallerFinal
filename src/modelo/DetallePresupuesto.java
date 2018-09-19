package modelo;

public class DetallePresupuesto {

    public class Id {

        private Presupuesto idPresupuesto;
        private Material idMaterial;

        public Id(Presupuesto idPresupuesto, Material idMaterial) {
            this.idPresupuesto = idPresupuesto;
            this.idMaterial = idMaterial;
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

    }

    private Id id;
    private String descripcion;
    private double subtotal;
    private int cantidad;

    public DetallePresupuesto(Presupuesto idPresupuesto, Material idMaterial, String descripcion, double subtotal, int cantidad) {
        this.id.idPresupuesto = idPresupuesto;
        this.id.idMaterial = idMaterial;
        this.descripcion = descripcion;
        this.subtotal = subtotal;
        this.cantidad = cantidad;
    }

    public Presupuesto getIdPresupuesto() {
        return id.idPresupuesto;
    }

    public void setIdPresupuesto(Presupuesto idPresupuesto) {
        this.id.idPresupuesto = idPresupuesto;
    }

    public Material getIdMaterial() {
        return id.idMaterial;
    }

    public void setIdMaterial(Material idMaterial) {
        this.id.idMaterial = idMaterial;
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
        return "DetallePresupuesto{" + "idPresupuesto=" + id.idPresupuesto + ", idMaterial=" + id.idMaterial + ", descripcion=" + descripcion + ", subtotal=" + subtotal + ", cantidad=" + cantidad + '}';
    }
}

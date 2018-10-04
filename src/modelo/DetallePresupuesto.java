package modelo;

public class DetallePresupuesto {

    public class Id {

        private Long idPresupuesto;
        private Long idMaterial;

        public Id(Long idPresupuesto, Long idMaterial) {
            this.idPresupuesto = idPresupuesto;
            this.idMaterial = idMaterial;
        }

        public Long getIdPresupuesto() {
            return idPresupuesto;
        }

        public void setIdPresupuesto(Long idPresupuesto) {
            this.idPresupuesto = idPresupuesto;
        }

        public Long getIdMaterial() {
            return idMaterial;
        }

        public void setIdMaterial(Long idMaterial) {
            this.idMaterial = idMaterial;
        }

    }

    private Id id;
    private String descripcion;
    private double subtotal;
    private int cantidad;

    public DetallePresupuesto(Long idPresupuesto, Long idMaterial, String descripcion, double subtotal, int cantidad) {
        this.id=new Id(idPresupuesto, idMaterial);
        this.descripcion = descripcion;
        this.subtotal = subtotal;
        this.cantidad = cantidad;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
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

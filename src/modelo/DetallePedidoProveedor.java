package modelo;

public class DetallePedidoProveedor {

    private Long idPedidoProveedor;
    private Long idMaterial;

  

    public class Id {

        private Long idPedidoProveedor;
        private Long idMaterial;

        public Id(Long idPedidoProveedor, Long idMaterial) {
            this.idPedidoProveedor = idPedidoProveedor;
            this.idMaterial = idMaterial;
        }

        public Long getIdPedidoProveedor() {
            return idPedidoProveedor;
        }

        public void setIdPedidoProveedor(Long idPedidoProveedor) {
            this.idPedidoProveedor = idPedidoProveedor;
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
    private int cantidad;
    private double subtotal;

    public DetallePedidoProveedor(Long idPedidoProveedor, Long idMaterial, String descripcion, int cantidad, double subtotal) {
        this.id = new Id(idPedidoProveedor,idMaterial);
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public Id getId() {
        return id;
    }
      public void setId(Long idPedidoProveedor, Long idMaterial) {
          this.idPedidoProveedor = idPedidoProveedor; 
          this.idMaterial = idMaterial;

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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "DetallePedidoProveedor{" + "idPedidoProveedor=" + id.getIdPedidoProveedor() + ", idMaterial=" + id.getIdMaterial() + ", descripcion=" + descripcion + ", cantidad=" + cantidad + ", subtotal=" + subtotal + '}';
    }
}

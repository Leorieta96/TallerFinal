package modelo;

public class DetallePedidoProveedor {
    private Long idPedidoProveedor;
    private Long idMaterial;
    private String descripcion;
    private int cantidad;
    private double subtotal;

    public DetallePedidoProveedor(Long idPedidoProveedor, Long idMaterial, String descripcion, int cantidad, double subtotal) {
        this.idPedidoProveedor = idPedidoProveedor;
        this.idMaterial = idMaterial;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
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
        return "DetallePedidoProveedor{" + "idPedidoProveedor=" + idPedidoProveedor + ", idMaterial=" + idMaterial + ", descripcion=" + descripcion + ", cantidad=" + cantidad + ", subtotal=" + subtotal + '}';
    }    
}

package modelo;

public class DetallePedidoProveedor {
    private PedidoProveedor codPedProv;
    private Material codMaterial;
    private String descripcion;
    private int cantidad;
    private double subtotal;

    public DetallePedidoProveedor(PedidoProveedor codPedProv, Material codMaterial, String descripcion, int cantidad, double subtotal) {
        this.codPedProv = codPedProv;
        this.codMaterial = codMaterial;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public PedidoProveedor getCodPedProv() {
        return codPedProv;
    }

    public void setCodPedProv(PedidoProveedor codPedProv) {
        this.codPedProv = codPedProv;
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
        return "DetallePedidoProveedor{" + "codPedProv=" + codPedProv + ", codMaterial=" + codMaterial + ", descripcion=" + descripcion + ", cantidad=" + cantidad + ", subtotal=" + subtotal + '}';
    }    
}

package modelo;

public class DetallePedidoCliente {
    private Long idPedidoCliente;
    private Long idMaterial;
    private String descripcion;
    private float subtotal;
    private int cantidadPedC;

    public DetallePedidoCliente(Long idPedidoCliente, Long idMaterial, String descripcion, float subtotal, int cantidadPedC) {
        this.idPedidoCliente = idPedidoCliente;
        this.idMaterial = idMaterial;
        this.descripcion = descripcion;
        this.subtotal = subtotal;
        this.cantidadPedC = cantidadPedC;
    }

    public Long getIdPedidoCliente() {
        return idPedidoCliente;
    }

    public void setIdPedidoCliente(Long idPedidoCliente) {
        this.idPedidoCliente = idPedidoCliente;
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

    public float getSubtotalPedC() {
        return subtotal;
    }

    public void setSubtotalPedC(float subtotal) {
        this.subtotal = subtotal;
    }

    public int getCantidadPedC() {
        return cantidadPedC;
    }

    public void setCantidadPedC(int cantidadPedC) {
        this.cantidadPedC = cantidadPedC;
    }

    @Override
    public String toString() {
        return "DetallePedidoCliente{" + "idPedidoCliente=" + idPedidoCliente + ", idMaterial=" + idMaterial + ", descripcion=" + descripcion + ", subtotal=" + subtotal + ", cantidadPedC=" + cantidadPedC + '}';
    }

    
    
}

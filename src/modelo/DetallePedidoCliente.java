package modelo;

public class DetallePedidoCliente {
    
    public class Id{
        
        private Long idPedidoCliente;
        private Long idMaterial;

        public  Id(Long idPedidoCliente, Long idMaterial) {
            this.idPedidoCliente = idPedidoCliente;
            this.idMaterial = idMaterial;
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
    }
    private  Id id;
    private String descripcion;
    private float subtotal;
    private int cantidadPedC;

    public DetallePedidoCliente(Long idPedidoCliente,Long idMaterial, String descripcion, float subtotal, int cantidadPedC) {
        this.id = new Id(idPedidoCliente, idMaterial);
        this.descripcion = descripcion;
        this.subtotal = subtotal;
        this.cantidadPedC = cantidadPedC;
    }

    public Id getId() {
        return id;
    }

    public void setId(Long idPedidoCliente, Long idMaterial) {
        this.id.idPedidoCliente = idPedidoCliente;
        this.id.idMaterial = idMaterial;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
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
        return "DetallePedidoCliente{" + "idPedidoCliente=" + id.getIdPedidoCliente()+ ", idMaterial=" + id.getIdMaterial() + ", descripcion=" + descripcion + ", subtotal=" + subtotal + ", cantidadPedC=" + cantidadPedC + '}';
    }

    
    
}

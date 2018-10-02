package modelo;

import java.sql.Date;

public class PedidoProveedor {
    private Long idPedidoProveedor;
    private Date fechaEmision;
    private boolean estado;
    private Long cuit;

    public PedidoProveedor(Long idPedidoProveedor, Date fechaEmision, boolean estado, Long cuit) {
        this.idPedidoProveedor = idPedidoProveedor;
        this.fechaEmision = fechaEmision;
        this.estado = estado;
        this.cuit = cuit;
    }

    public Long getIdPedidoProveedor() {
        return idPedidoProveedor;
    }

    public void setIdPedidoProveedor(Long idPedidoProveedor) {
        this.idPedidoProveedor = idPedidoProveedor;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Long getCuit() {
        return cuit;
    }

    public void setCuit(Long cuit) {
        this.cuit = cuit;
    }

    @Override
    public String toString() {
        return "PedidoProveedor{" + "idPedidoProveedor=" + idPedidoProveedor + ", estado=" + estado + ", cuit=" + cuit + '}';
    }
}

package modelo;

import java.sql.Date;

public class PedidoProveedor {
    private Long codPedProv;
    private Date fechaEmision;
    private boolean estado;
    private Proveedor cuit;

    public PedidoProveedor(Long codPedProv, Date fechaEmision, boolean estado, Proveedor cuit) {
        this.codPedProv = codPedProv;
        this.fechaEmision = fechaEmision;
        this.estado = estado;
        this.cuit = cuit;
    }

    public Long getCodPedProv() {
        return codPedProv;
    }

    public void setCodPedProv(Long codPedProv) {
        this.codPedProv = codPedProv;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Proveedor getCuit() {
        return cuit;
    }

    public void setCuit(Proveedor cuit) {
        this.cuit = cuit;
    }

    @Override
    public String toString() {
        return "PedidoProveedor{" + "codPedProv=" + codPedProv + ", estado=" + estado + ", cuit=" + cuit + '}';
    }
}

package modelo;

import java.sql.Date;

public class PedidoCliente {
    private Long codPedidoC;
    private String estadoPedidoC;
    private int totalPedidoC;
    private Date fechaEmision;
    private Date fechaRecibido;
    private Cliente DNI;

    public PedidoCliente(Long codPedidoC, String estadoPedidoC, int totalPedidoC, Date fechaEmision, Date fechaRecibido, Cliente DNI) {
        this.codPedidoC = codPedidoC;
        this.estadoPedidoC = estadoPedidoC;
        this.totalPedidoC = totalPedidoC;
        this.fechaEmision = fechaEmision;
        this.fechaRecibido = fechaRecibido;
        this.DNI = DNI;
    }

    public Long getCodPedidoC() {
        return codPedidoC;
    }

    public void setCodPedidoC(Long codPedidoC) {
        this.codPedidoC = codPedidoC;
    }

    public String getEstadoPedidoC() {
        return estadoPedidoC;
    }

    public void setEstadoPedidoC(String estadoPedidoC) {
        this.estadoPedidoC = estadoPedidoC;
    }

    public int getTotalPedidoC() {
        return totalPedidoC;
    }

    public void setTotalPedidoC(int totalPedidoC) {
        this.totalPedidoC = totalPedidoC;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaRecibido() {
        return fechaRecibido;
    }

    public void setFechaRecibido(Date fechaRecibido) {
        this.fechaRecibido = fechaRecibido;
    }

    public Cliente getDNI() {
        return DNI;
    }

    public void setDNI(Cliente DNI) {
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        return "PedidoCliente{" + "codPedidoC=" + codPedidoC + ", estadoPedidoC=" + estadoPedidoC + ", totalPedidoC=" + totalPedidoC + ", DNI=" + DNI + '}';
    }
}

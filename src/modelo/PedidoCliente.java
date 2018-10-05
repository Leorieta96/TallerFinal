package modelo;

import java.sql.Date;

public class PedidoCliente {
    private Long idPedidoCliente;
    private String estadoPedidoC;
    private Double totalPedidoC;
    private Date fechaEmision;
    private Date fechaRecibido;
    private Long dni;

    public PedidoCliente(Long idPedidoCliente, String estadoPedidoC, Double totalPedidoC, Date fechaEmision, Date fechaRecibido, Long dni) {
        this.idPedidoCliente = idPedidoCliente;
        this.estadoPedidoC = estadoPedidoC;
        this.totalPedidoC = totalPedidoC;
        this.fechaEmision = fechaEmision;
        this.fechaRecibido = fechaRecibido;
        this.dni = dni;
    }

   

    public Long getIdPedidoCliente() {
        return idPedidoCliente;
    }

    public void setIdPedidoCliente(Long idPedidoCliente) {
        this.idPedidoCliente = idPedidoCliente;
    }

    public String getEstadoPedidoC() {
        return estadoPedidoC;
    }

    public void setEstadoPedidoC(String estadoPedidoC) {
        this.estadoPedidoC = estadoPedidoC;
    }

    public Double getTotalPedidoC() {
        return totalPedidoC;
    }

    public void setTotalPedidoC(Double totalPedidoC) {
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

    public Long getdni() {
        return dni;
    }

    public void setdni(Long dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "PedidoCliente{" + "idPedidoCliente=" + idPedidoCliente + ", estadoPedidoC=" + estadoPedidoC + ", totalPedidoC=" + totalPedidoC + ", dni=" + dni + '}';
    }
}

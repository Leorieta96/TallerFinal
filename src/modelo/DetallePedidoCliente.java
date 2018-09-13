package modelo;

public class DetallePedidoCliente {
    private Long codPedidoC;
    private Long codMaterial;
    private String descPedC;
    private float subtotalPedC;
    private int cantidadPedC;

    public DetallePedidoCliente(Long codPedidoC, Long codMaterial, String descPedC, float subtotalPedC, int cantidadPedC) {
        this.codPedidoC = codPedidoC;
        this.codMaterial = codMaterial;
        this.descPedC = descPedC;
        this.subtotalPedC = subtotalPedC;
        this.cantidadPedC = cantidadPedC;
    }

    public Long getCodPedidoC() {
        return codPedidoC;
    }

    public void setCodPedidoC(Long codPedidoC) {
        this.codPedidoC = codPedidoC;
    }

    public Long getCodMaterial() {
        return codMaterial;
    }

    public void setCodMaterial(Long codMaterial) {
        this.codMaterial = codMaterial;
    }

    public String getDescPedC() {
        return descPedC;
    }

    public void setDescPedC(String descPedC) {
        this.descPedC = descPedC;
    }

    public float getSubtotalPedC() {
        return subtotalPedC;
    }

    public void setSubtotalPedC(float subtotalPedC) {
        this.subtotalPedC = subtotalPedC;
    }

    public int getCantidadPedC() {
        return cantidadPedC;
    }

    public void setCantidadPedC(int cantidadPedC) {
        this.cantidadPedC = cantidadPedC;
    }

    @Override
    public String toString() {
        return "DetallePedidoCliente{" + "codPedidoC=" + codPedidoC + ", codMaterial=" + codMaterial + ", descPedC=" + descPedC + ", subtotalPedC=" + subtotalPedC + ", cantidadPedC=" + cantidadPedC + '}';
    }

    
    
}

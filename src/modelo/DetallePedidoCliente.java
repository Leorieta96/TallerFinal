package modelo;

public class DetallePedidoCliente {
    private PedidoCliente codPedidoC;
    private Material codMaterial;
    private String descPedC;
    private int subtotalPedC;
    private int cantidadPedC;

    public DetallePedidoCliente(PedidoCliente codPedidoC, Material codMaterial, String descPedC, int subtotalPedC, int cantidadPedC) {
        this.codPedidoC = codPedidoC;
        this.codMaterial = codMaterial;
        this.descPedC = descPedC;
        this.subtotalPedC = subtotalPedC;
        this.cantidadPedC = cantidadPedC;
    }

    public PedidoCliente getCodPedidoC() {
        return codPedidoC;
    }

    public void setCodPedidoC(PedidoCliente codPedidoC) {
        this.codPedidoC = codPedidoC;
    }

    public Material getCodMaterial() {
        return codMaterial;
    }

    public void setCodMaterial(Material codMaterial) {
        this.codMaterial = codMaterial;
    }

    public String getDescPedC() {
        return descPedC;
    }

    public void setDescPedC(String descPedC) {
        this.descPedC = descPedC;
    }

    public int getSubtotalPedC() {
        return subtotalPedC;
    }

    public void setSubtotalPedC(int subtotalPedC) {
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

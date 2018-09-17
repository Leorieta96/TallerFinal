package modelo;

public class Material {
    private Long idMaterial;
    private String tipoMaterial;
    private String descripcion;
    private int stockMaterial;
    private long precioUnitario;

    public Material(Long idMaterial, String tipoMaterial, String descripcion, int stockMaterial, long precioUnitario) {
        this.idMaterial = idMaterial;
        this.tipoMaterial = tipoMaterial;
        this.descripcion = descripcion;
        this.stockMaterial = stockMaterial;
        this.precioUnitario = precioUnitario;
    }

    public Long getidMaterial() {
        return idMaterial;
    }

    public void setidMaterial(Long idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public int getStockMaterial() {
        return stockMaterial;
    }

    public void setStockMaterial(int stockMaterial) {
        this.stockMaterial = stockMaterial;
    }
    
    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public String getdescripcion() {
        return descripcion;
    }

    public void setdescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(long precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Override
    public String toString() {
        return "Material{" + "idMaterial=" + idMaterial + ", tipoMaterial=" + tipoMaterial + ", descripcion=" + descripcion + ", precioUnitario=" + precioUnitario + '}';
    }
}

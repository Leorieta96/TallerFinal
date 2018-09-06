package modelo;

public class Material {
    private Long codMaterial;
    private String tipoMaterial;
    private String descMaterial;
    private long precioUnitario;

    public Material(Long codMaterial, String tipoMaterial, String descMaterial, long precioUnitario) {
        this.codMaterial = codMaterial;
        this.tipoMaterial = tipoMaterial;
        this.descMaterial = descMaterial;
        this.precioUnitario = precioUnitario;
    }

    public Long getCodMaterial() {
        return codMaterial;
    }

    public void setCodMaterial(Long codMaterial) {
        this.codMaterial = codMaterial;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public String getDescMaterial() {
        return descMaterial;
    }

    public void setDescMaterial(String descMaterial) {
        this.descMaterial = descMaterial;
    }

    public long getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(long precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Override
    public String toString() {
        return "Material{" + "codMaterial=" + codMaterial + ", tipoMaterial=" + tipoMaterial + ", descMaterial=" + descMaterial + ", precioUnitario=" + precioUnitario + '}';
    }
}

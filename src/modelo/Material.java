package modelo;

public class Material {
    private Long idMaterial;
    private String nombre;
    private String descripcion;
    private int stockMaterial;
    private long precioUnitario;
    private String rubro;

    public Material(Long idMaterial, String nombre, String descripcion, int stockMaterial, long precioUnitario, String rubro) {
        this.idMaterial = idMaterial;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stockMaterial = stockMaterial;
        this.precioUnitario = precioUnitario;
        this.rubro = rubro;
    }

    public Long getidMaterial() {
        return idMaterial;
    }

    public void setidMaterial(Long idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getNombre() {
        return nombre;
    }

    public int getStockMaterial() {
        return stockMaterial;
    }

    public void setStockMaterial(int stockMaterial) {
        this.stockMaterial = stockMaterial;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    
    @Override
    public String toString() {
        return "Material{" + "idMaterial=" + idMaterial + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precioUnitario=" + precioUnitario + '}';
    }
}

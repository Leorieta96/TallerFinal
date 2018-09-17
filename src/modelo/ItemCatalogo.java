package modelo;

public class ItemCatalogo {
    private Long precioUnitario;
    private String nombre;
    private String marca;
    private Catalogo idCatalogo;

    public ItemCatalogo(Long precioUnitario, String nombre, String marca, Catalogo idCatalogo) {
        this.precioUnitario = precioUnitario;
        this.nombre = nombre;
        this.marca = marca;
        this.idCatalogo = idCatalogo;
    }

    public Long getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Long precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Catalogo getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(Catalogo idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    @Override
    public String toString() {
        return "ItemCatalogo{" + "precioUnitario=" + precioUnitario + ", nombre=" + nombre + ", marca=" + marca + ", idCatalogo=" + idCatalogo + '}';
    }     
}

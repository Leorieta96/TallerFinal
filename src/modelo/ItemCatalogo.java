package modelo;

public class ItemCatalogo {
    private Long precioUnitario;
    private String nombre;
    private String marca;
    private Catalogo codCatalogo;

    public ItemCatalogo(Long precioUnitario, String nombre, String marca, Catalogo codCatalogo) {
        this.precioUnitario = precioUnitario;
        this.nombre = nombre;
        this.marca = marca;
        this.codCatalogo = codCatalogo;
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

    public Catalogo getCodCatalogo() {
        return codCatalogo;
    }

    public void setCodCatalogo(Catalogo codCatalogo) {
        this.codCatalogo = codCatalogo;
    }

    @Override
    public String toString() {
        return "ItemCatalogo{" + "precioUnitario=" + precioUnitario + ", nombre=" + nombre + ", marca=" + marca + ", codCatalogo=" + codCatalogo + '}';
    }     
}

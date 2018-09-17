
package modelo;

public class Proveedor {
    private Long cuit;
    private String nombre;
    private int telefono;
    private String direccion;
    private String rubro;

    public Proveedor(Long cuit, String nombre, int telefono, String direccion, String rubro) {
        this.cuit = cuit;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.rubro = rubro;
    }

    public Long getCuit() {
        return cuit;
    }

    public void setCuit(Long cuit) {
        this.cuit = cuit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "cuit=" + cuit + ", nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion + ", rubro=" + rubro + '}';
    }
}

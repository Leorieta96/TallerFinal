
package modelo;

public class Proveedor {
    private Long cuit;
    private String nomProveedor;
    private int telProveedor;
    private String dirProveedor;
    private String rubro;

    public Proveedor(Long cuit, String nomProveedor, int telProveedor, String dirProveedor, String rubro) {
        this.cuit = cuit;
        this.nomProveedor = nomProveedor;
        this.telProveedor = telProveedor;
        this.dirProveedor = dirProveedor;
        this.rubro = rubro;
    }

    public Long getCuit() {
        return cuit;
    }

    public void setCuit(Long cuit) {
        this.cuit = cuit;
    }

    public String getNomProveedor() {
        return nomProveedor;
    }

    public void setNomProveedor(String nomProveedor) {
        this.nomProveedor = nomProveedor;
    }

    public int getTelProveedor() {
        return telProveedor;
    }

    public void setTelProveedor(int telProveedor) {
        this.telProveedor = telProveedor;
    }

    public String getDirProveedor() {
        return dirProveedor;
    }

    public void setDirProveedor(String dirProveedor) {
        this.dirProveedor = dirProveedor;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "cuit=" + cuit + ", nomProveedor=" + nomProveedor + ", telProveedor=" + telProveedor + ", dirProveedor=" + dirProveedor + ", rubro=" + rubro + '}';
    }
}

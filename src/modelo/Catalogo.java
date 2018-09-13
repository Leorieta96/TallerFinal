package modelo;

import java.sql.Date;

public class Catalogo {
    private Long codCatalogo;
    private Date fecha;
    private Long cuit;

    public Catalogo(Long codCatalogo, Date fecha, Long cuit) {
        this.codCatalogo = codCatalogo;
        this.fecha = fecha;
        this.cuit = cuit;
    }

    public Long getCodCatalogo() {
        return codCatalogo;
    }

    public void setCodCatalogo(Long codCatalogo) {
        this.codCatalogo = codCatalogo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getCuit() {
        return cuit;
    }

    public void setCuit(Long cuit) {
        this.cuit = cuit;
    }

    @Override
    public String toString() {
        return "Catalogo{" + "codCatalogo=" + codCatalogo + ", cuit=" + cuit + '}';
    }    
}

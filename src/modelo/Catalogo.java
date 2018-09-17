package modelo;

import java.sql.Date;

public class Catalogo {
    private Long idCatalogo;
    private Date fecha;
    private Long cuit;

    public Catalogo(Date fecha, Long cuit) {
        this.fecha = fecha;
        this.cuit = cuit;
    }
    
    public Catalogo(Long idCatalogo, Date fecha, Long cuit) {
        this.idCatalogo = idCatalogo;
        this.fecha = fecha;
        this.cuit = cuit;
    }

    public Long getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(Long idCatalogo) {
        this.idCatalogo = idCatalogo;
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
        return "Catalogo{" + "idCatalogo=" + idCatalogo + ", cuit=" + cuit + '}';
    }    
}

package modelo;

public class ItemCatalogo {

    public class Id {

        private Long precioUnitario;
        private String nombre;
        private String marca;

        public Id(Long precioUnitario, String nombre, String marca) {
            this.precioUnitario = precioUnitario;
            this.nombre = nombre;
            this.marca = marca;
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

    }
    
    private Id id;
    private Long idCatalogo;

    public ItemCatalogo(Long precioUnitario, String nombre, String marca, Long idCatalogo) {
        this.id = new Id(precioUnitario, nombre, marca);
        this.idCatalogo = idCatalogo;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Long getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(Long idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    @Override
    public String toString() {
        return "ItemCatalogo{" + "precioUnitario=" + id.precioUnitario + ", nombre=" + id.nombre + ", marca=" + id.marca + ", idCatalogo=" + idCatalogo + '}';
    }
}

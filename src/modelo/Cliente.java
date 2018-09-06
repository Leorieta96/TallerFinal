package modelo;

public class Cliente {
    private Long DNI;
    private String nomCliente;
    private int telCliente;
    private String dirCliente;
    private String emailCliente;

    public Cliente(Long DNI, String nomCliente, int telCliente, String dirCliente, String emailCliente) {
        this.DNI = DNI;
        this.nomCliente = nomCliente;
        this.telCliente = telCliente;
        this.dirCliente = dirCliente;
        this.emailCliente = emailCliente;
    }

    public Long getDNI() {
        return DNI;
    }

    public void setDNI(Long DNI) {
        this.DNI = DNI;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public int getTelCliente() {
        return telCliente;
    }

    public void setTelCliente(int telCliente) {
        this.telCliente = telCliente;
    }

    public String getDirCliente() {
        return dirCliente;
    }

    public void setDirCliente(String dirCliente) {
        this.dirCliente = dirCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "DNI=" + DNI + ", nomCliente=" + nomCliente + ", telCliente=" + telCliente + ", dirCliente=" + dirCliente + ", emailCliente=" + emailCliente + '}';
    }
}

package registrarcita.modelo;

public class Paciente {
    private final String nss;
    private final String nombreCompleto;

    public Paciente(String nss, String nombreCompleto) {
        this.nss = nss;
        this.nombreCompleto = nombreCompleto;
    }

    public String getNss() {
        return nss;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }
}

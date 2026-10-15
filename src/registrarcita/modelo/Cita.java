package registrarcita.modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cita {
    private final Paciente paciente;
    private final Medico medico;
    private final LocalDate fecha;
    private final LocalTime hora;

    public Cita(Paciente paciente, Medico medico, LocalDate fecha, LocalTime hora) {
        this.paciente = paciente;
        this.medico = medico;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }
}

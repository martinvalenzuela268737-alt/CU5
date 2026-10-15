package registrarcita.modelo;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class Horario {
    private final DayOfWeek dia;
    private final LocalTime horaInicio;
    private final LocalTime horaFin;

    public Horario(DayOfWeek dia, LocalTime horaInicio, LocalTime horaFin) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public DayOfWeek getDia() {
        return dia;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }
}

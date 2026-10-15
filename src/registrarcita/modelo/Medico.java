package registrarcita.modelo;

import java.util.List;

public class Medico {
    private final String nombreCompleto;
    private final String especialidad;
    private final String consultorio;
    private final List<Horario> horarios;

    public Medico(String nombreCompleto, String especialidad, String consultorio, List<Horario> horarios) {
        this.nombreCompleto = nombreCompleto;
        this.especialidad = especialidad;
        this.consultorio = consultorio;
        this.horarios = horarios;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }
}

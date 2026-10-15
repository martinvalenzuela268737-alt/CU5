package registrarcita.modelo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Clinica {
    private final List<Paciente> pacientes = new ArrayList<>();
    private final List<Medico> medicos = new ArrayList<>();
    private final List<Cita> citas = new ArrayList<>();

    public Clinica() {
        cargarDatosDeEjemplo();
    }

    private void cargarDatosDeEjemplo() {
        pacientes.add(new Paciente("12345678901", "Ana Sofía Ramírez Torres"));
        pacientes.add(new Paciente("98765432109", "Carlos Ruiz Medina"));

        medicos.add(new Medico("Dr. Luis Hernández Pérez", "Medicina general", "Consultorio 3", List.of(
                new Horario(DayOfWeek.MONDAY, LocalTime.of(9, 0), LocalTime.of(14, 0)),
                new Horario(DayOfWeek.WEDNESDAY, LocalTime.of(9, 0), LocalTime.of(14, 0)),
                new Horario(DayOfWeek.FRIDAY, LocalTime.of(9, 0), LocalTime.of(14, 0)))));
        medicos.add(new Medico("Dra. Carla Mendoza Ruiz", "Pediatría", "Consultorio 5", List.of(
                new Horario(DayOfWeek.TUESDAY, LocalTime.of(10, 0), LocalTime.of(15, 0)),
                new Horario(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(15, 0)))));
        medicos.add(new Medico("Dr. Jorge Salazar Vega", "Cardiología", "Consultorio 8", List.of(
                new Horario(DayOfWeek.MONDAY, LocalTime.of(14, 0), LocalTime.of(19, 0)),
                new Horario(DayOfWeek.THURSDAY, LocalTime.of(14, 0), LocalTime.of(19, 0)))));
        medicos.add(new Medico("Dra. Patricia Núñez Soto", "Dermatología", "Consultorio 2", List.of(
                new Horario(DayOfWeek.WEDNESDAY, LocalTime.of(8, 0), LocalTime.of(13, 0)),
                new Horario(DayOfWeek.FRIDAY, LocalTime.of(8, 0), LocalTime.of(13, 0)))));
    }

    /** Devuelve el paciente con ese NSS, o null si no está registrado. */
    public Paciente buscarPaciente(String nss) {
        for (Paciente p : pacientes) {
            if (p.getNss().equals(nss)) {
                return p;
            }
        }
        return null;
    }

    public List<Medico> obtenerMedicos() {
        return List.copyOf(medicos);
    }

    public Cita registrarCita(Paciente paciente, Medico medico, LocalDate fecha, LocalTime hora) {
        Cita cita = new Cita(paciente, medico, fecha, hora);
        citas.add(cita);
        return cita;
    }
}

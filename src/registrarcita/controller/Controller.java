package registrarcita.controller;

import registrarcita.modelo.Cita;
import registrarcita.modelo.Clinica;
import registrarcita.modelo.Medico;
import registrarcita.modelo.Paciente;
import registrarcita.vista.Vista;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Controller {
    private final Vista vista;
    private final Clinica clinica;
    private Paciente pacienteActual;
    private Medico medicoSeleccionado;

    public Controller(Vista vista, Clinica clinica) {
        this.vista = vista;
        this.clinica = clinica;
    }

    /** Flujo completo del caso de uso: NSS, médico, fecha y hora. */
    public void iniciar() {
        System.out.println("=== Sistema de citas médicas ===");

        // Flujo alterno: si el NSS no existe, se vuelve a solicitar
        while (pacienteActual == null) {
            buscarPaciente(vista.solicitarNSS());
        }

        List<Medico> medicos = clinica.obtenerMedicos();
        seleccionarMedico(vista.solicitarMedico(medicos.size()));

        LocalDate fecha = vista.solicitarFecha();
        LocalTime hora = vista.solicitarHora();
        apartarCita(fecha, hora);
    }

    public void buscarPaciente(String nss) {
        pacienteActual = clinica.buscarPaciente(nss);
        if (pacienteActual == null) {
            vista.mostrarError("NSS no registrado. Verifica el número e inténtalo de nuevo.");
            return;
        }
        vista.mostrarPaciente(pacienteActual);
        vista.mostrarMedicos(clinica.obtenerMedicos());
    }

    public void seleccionarMedico(int indice) {
        medicoSeleccionado = clinica.obtenerMedicos().get(indice);
        vista.mostrarDatosMedico(medicoSeleccionado);
    }

    public void apartarCita(LocalDate fecha, LocalTime hora) {
        Cita cita = clinica.registrarCita(pacienteActual, medicoSeleccionado, fecha, hora);
        vista.mostrarCita(cita);
    }
}

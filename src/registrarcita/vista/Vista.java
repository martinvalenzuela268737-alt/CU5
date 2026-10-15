package registrarcita.vista;

import registrarcita.modelo.Cita;
import registrarcita.modelo.Horario;
import registrarcita.modelo.Medico;
import registrarcita.modelo.Paciente;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Vista {
    private static final Locale ES = Locale.forLanguageTag("es-MX");
    private static final DateTimeFormatter ENTRADA_FECHA =
            DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
    private static final DateTimeFormatter ENTRADA_HORA = DateTimeFormatter.ofPattern("HH:mm");
    private static final DateTimeFormatter SALIDA_FECHA =
            DateTimeFormatter.ofPattern("EEEE d 'de' MMMM 'de' yyyy", ES);

    private final Scanner entrada;
    private String nssIngresado = "";

    public Vista(Scanner entrada) {
        this.entrada = entrada;
    }

    public String solicitarNSS() {
        System.out.print("Ingresa tu Número de Seguridad Social (NSS): ");
        nssIngresado = entrada.nextLine().trim();
        return nssIngresado;
    }

    public void mostrarPaciente(Paciente paciente) {
        System.out.println();
        System.out.println("--- Paciente ---");
        System.out.println("Nombre: " + paciente.getNombreCompleto());
        System.out.println("NSS: " + paciente.getNss());
    }

    public void mostrarMedicos(List<Medico> medicos) {
        System.out.println();
        System.out.println("--- Médicos ---");
        for (int i = 0; i < medicos.size(); i++) {
            Medico m = medicos.get(i);
            System.out.println((i + 1) + ". " + m.getNombreCompleto() + " (" + m.getEspecialidad() + ")");
        }
    }

    /** Pide el número del médico y devuelve su índice (empezando en 0). */
    public int solicitarMedico(int total) {
        while (true) {
            System.out.print("Selecciona un médico (1-" + total + "): ");
            try {
                int numero = Integer.parseInt(entrada.nextLine().trim());
                if (numero >= 1 && numero <= total) {
                    return numero - 1;
                }
            } catch (NumberFormatException e) {
                // se vuelve a pedir
            }
            System.out.println("Opción no válida.");
        }
    }

    public void mostrarDatosMedico(Medico medico) {
        System.out.println();
        System.out.println("--- Datos del médico ---");
        System.out.println("Nombre completo: " + medico.getNombreCompleto());
        System.out.println("Especialidad: " + medico.getEspecialidad());
        System.out.println("Consultorio: " + medico.getConsultorio());
        System.out.println("Días y horas de consulta:");
        for (Horario h : medico.getHorarios()) {
            System.out.println("  " + h.getDia().getDisplayName(TextStyle.FULL, ES)
                    + " de " + h.getHoraInicio() + " a " + h.getHoraFin());
        }
    }

    public LocalDate solicitarFecha() {
        while (true) {
            System.out.print("Fecha de la cita (dd/mm/aaaa): ");
            try {
                return LocalDate.parse(entrada.nextLine().trim(), ENTRADA_FECHA);
            } catch (Exception e) {
                System.out.println("Fecha no válida.");
            }
        }
    }

    public LocalTime solicitarHora() {
        while (true) {
            System.out.print("Hora de la cita (hh:mm): ");
            try {
                return LocalTime.parse(entrada.nextLine().trim(), ENTRADA_HORA);
            } catch (Exception e) {
                System.out.println("Hora no válida.");
            }
        }
    }

    public void mostrarCita(Cita cita) {
        System.out.println();
        System.out.println("--- Datos de la cita ---");
        System.out.println("Paciente: " + cita.getPaciente().getNombreCompleto()
                + " (NSS " + cita.getPaciente().getNss() + ")");
        System.out.println("Médico: " + cita.getMedico().getNombreCompleto());
        System.out.println("Consultorio: " + cita.getMedico().getConsultorio());
        System.out.println("Fecha: " + cita.getFecha().format(SALIDA_FECHA));
        System.out.println("Hora: " + cita.getHora());
    }

    public void mostrarError(String mensaje) {
        System.out.println();
        System.out.println("[ERROR] " + mensaje);
        System.out.println();
    }
}

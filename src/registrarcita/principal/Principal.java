package registrarcita.principal;

import registrarcita.controller.Controller;
import registrarcita.modelo.Clinica;
import registrarcita.vista.Vista;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Vista vista = new Vista(entrada);
        Clinica clinica = new Clinica();
        new Controller(vista, clinica).iniciar();
    }
}

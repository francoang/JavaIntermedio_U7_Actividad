package jint_act07;

import dao.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import negocio.*;

/**
 *
 * @author fnang
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Creamos una instancia de la interfaz DAO a traves del patron Factory.
        PersonaDAOFactory factory = new PersonaDAOFactory();
        PersonaDAO dao = factory.crearPersona();

        //Las operaciones se haran en otro metodo. 
        //Recibe como parametro un objeto dao para que puseda utilizarlo
        operaciones(dao);

    }

    public static void operaciones(PersonaDAO dao) {
        int opcion;
        do {
            Persona nuevaPersona = cargarPersona();
            if (nuevaPersona != null) {
                dao.agregar(nuevaPersona);
                System.out.println("¡" + nuevaPersona.getNombreApellido() + " cargado con exito!");
            }

            System.out.println("___Listado___");
            Persona[] personas = dao.obtenerTodasPersonas();
            for (Persona persona : personas) {
                System.out.println(persona + "\n");
            }
            System.out.println("_____________");
            
            System.out.println("\n1 para continuar");
            System.out.println("0 para salir");
            opcion = Consola.readInt();
        } while (opcion != 0);

    }

    public static Persona cargarPersona() {

        System.out.println("Ingrese el documento: ");
        int documento = Consola.readInt();

        System.out.println("Ingrese nombre y apellido: ");
        String nomApe = Consola.readLine();

        System.out.println("¿Es un (P)aciente o un (D)octor?");
        String letra = Consola.readLine();
        switch (letra.toUpperCase()) {
            case "P":
                System.out.println("Ingrese el nro. de obra social: ");
                int obraSocial = Consola.readInt();
                return new Paciente(obraSocial, documento, nomApe);
            case "D":
                System.out.println("Ingrese la matricula: ");
                int mat = Consola.readInt();
                return new Doctor(mat, documento, nomApe);
            default:
                System.out.println("ERROR. Por favor, cargue correctamente los datos.");
                return null;
        }

    }
}

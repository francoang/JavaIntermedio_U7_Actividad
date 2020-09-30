package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import negocio.Doctor;
import negocio.Paciente;
import negocio.Persona;

/**
 *
 * @author Angonoa Franco
 */
public class PersonaDAOenArrayList implements PersonaDAO{
    private static List<Persona> arregloPersona = new ArrayList<>();

    @Override
    public void agregar(Persona per) {
        arregloPersona.add(per);
    }

    @Override
    public void modificar(Persona per) {
        //Tarea
    }

    @Override
    public void borrar(int documento) {
        //Tarea
    }

    @Override
    public Persona buscarPorDNI(int documento) {
        //Tarea
        return null;
    }

    @Override
    public Persona[] obtenerTodasPersonas() {
        /*Si, la implementacion es muy rebuscada. Es solo para practicar
            el tema de colecciones. Fijarse que los pacientes y doctores
            se ordenan por el compareTo() que posee cada clase.
            Tiene que hacerse dos listas porque uno reune solo Pacientes
            y otro solo Doctores, sino habria error de conversion en el
            compareTo()
        */
        
        //Lista ordenada de pacientes
        Set<Paciente> pacientesOrdenados = new TreeSet<>();
        for (Persona pers : arregloPersona) {
            if(pers instanceof Paciente)
                pacientesOrdenados.add((Paciente)pers);
        }
        
        //Lista ordenadas de doctores
        Set<Doctor> doctoresOrdenados = new TreeSet<>();
        for (Persona pers : arregloPersona) {
            if(pers instanceof Doctor)
                doctoresOrdenados.add((Doctor)pers);
        }
        
        //Creo un arreglo del mismo tamanio del arreglo
        //Cada vez que se agregue uno nuevo, se llama a este metodo}
        //y se crean nuevas instancias.
        Persona[] personas = new Persona[arregloPersona.size()];
        
        int i = 0;
        for(Persona pers : pacientesOrdenados){
            personas[i] = pers;
            i++;
        }        
        
        //Despues de cargas a los pacientes, se carga a los doctores
        //Notar que el ultimo indice de los pacientes, el proximo indice
        //corresponde al de doctores.
        int j = i++; 
        for(Persona pers: doctoresOrdenados){
            personas[j] = pers;
            j++;
        }
        
        
        return personas;
    }
    
    
}

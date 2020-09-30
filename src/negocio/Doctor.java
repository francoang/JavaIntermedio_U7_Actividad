package negocio;

/**
 *
 * @author fnang
 */
public class Doctor extends Persona implements Comparable<Doctor>{
    private int matricula;

    public Doctor(int matricula, int documento, String nombreApellido) {
        super(documento, nombreApellido);
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return "Doctor: Matricula: " + matricula + "\t" +super.toString();
    }

    @Override
    public int compareTo(Doctor t) {
        if(this.matricula > t.matricula) return 1;
        else if(this.matricula < t.matricula) return -1;
        else return 0;
    }
    
    
}

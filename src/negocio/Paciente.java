package negocio;

/**
 *
 * @author fnang
 */
public class Paciente extends Persona implements Comparable<Paciente>{
    private int nroObraSocial;

    public Paciente(int nroObraSocial, int documento, String nombreApellido) {
        super(documento, nombreApellido);
        this.nroObraSocial = nroObraSocial;
    }

    public int getNroObraSocial() {
        return nroObraSocial;
    }

    @Override
    public String toString() {
        return "Paciente: Nro. ObraSocial: " + nroObraSocial + "\t" + super.toString();
    }

    @Override
    public int compareTo(Paciente t) {
        if (getDocumento() > t.getDocumento()) {
            return 1;
        } else if (this.getDocumento() < t.getDocumento()) {
            return -1;
        } else {
            return 0;
        }
    }


}

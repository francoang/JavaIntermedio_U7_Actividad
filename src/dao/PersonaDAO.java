
package dao;

import negocio.Persona;

/**
 *
 * @author fnang
 */
public interface PersonaDAO {
    
    public void agregar(Persona per);
    
    public void modificar(Persona per);
    
    public void borrar(int documento);
    
    public Persona buscarPorDNI(int documento);
    
    public Persona[] obtenerTodasPersonas();
}

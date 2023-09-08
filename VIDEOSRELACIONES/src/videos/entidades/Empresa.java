
package videos.entidades;

import java.util.List;

/**
 *
 * @author paula
 */
public class Empresa {
    //COMPOSICION
    //si la empresa muere, los registros de empleados mueren tambien\
    //si muere contenedor, mueren los contenidos
    
    //empresa tiene muchos empleados
    private List<Empleado> empleados;
    
    //AGREGACION
    //Se elimina la empresa, pero los clientes no, es info util.
    
    //empresa usa muchos clientes
    private List<Cliente> clientes; 
}

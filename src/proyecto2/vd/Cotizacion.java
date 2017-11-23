/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.vd;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Danii
 */
public class Cotizacion extends Boleta
{
    private Calendar fechaTermino; 
    private boolean validacion; 

    public Cotizacion(boolean validacion)
    {
        super();
        this.fechaTermino = Calendar.getInstance();
        this.fechaTermino.add(Calendar.WEEK_OF_MONTH, 1);
        this.validacion = validacion;
    }

    

    public Calendar getFechaTermino()
    {
        return fechaTermino;
    }

    public void setFechaTermino(Calendar fechaTermino)
    {
        this.fechaTermino = fechaTermino;
    }

    public boolean isValidacion()
    {
        return validacion;
    }

    public void setValidacion(boolean validacion)
    {
        this.validacion = validacion;
    }

    
    
    
    
    
    
    
}

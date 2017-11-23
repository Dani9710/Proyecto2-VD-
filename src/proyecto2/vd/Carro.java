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
public abstract class Carro
{
    private ArrayList<Producto> productos;
    private Calendar fechaInicio;

    public Carro()
    {
        this.productos = new ArrayList<Producto>();
        this.fechaInicio = Calendar.getInstance();
    }
    
    public Calendar getFechaInicio()
    {
        return fechaInicio;
    }

    public void setFechaInicio(Calendar fechaInicio)
    {
        this.fechaInicio = fechaInicio;
    }
    
    public int size()
    {
        return productos.size();
    }

    public Producto get(int index)
    {
        return productos.get(index);
    }

    public boolean add(Producto e)
    {
        return productos.add(e);
    }

    public Producto remove(int index)
    {
        return productos.remove(index);
    }
}

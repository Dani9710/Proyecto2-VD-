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
///sdkjsdkjsdkjsdkjsd XD
///SJDKSJDKJSD
public abstract class Carro
{
    protected ArrayList<Producto> productos;
    protected Calendar fechaInicio;
    protected int codigo;

    public Carro(ArrayList<Producto> productos, int codigo)
    {
        this.productos = productos;
        this.fechaInicio = Calendar.getInstance();
        this.codigo = codigo; 
    }
    
    public Calendar getFechaInicio()
    {
        return fechaInicio;
    }

    public void setFechaInicio(Calendar fechaInicio)
    {
        this.fechaInicio = fechaInicio;
    }
    
    public int sizeProducto()
    {
        return productos.size();
    }

    public Producto getProducto(int index)
    {
        return productos.get(index);
    }

    public boolean addProducto(Producto e)
    {
        return productos.add(e);
    }

    public Producto removeProducto(int index)
    {
        return productos.remove(index);
    }

    public ArrayList<Producto> getProductos()
    {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos)
    {
        this.productos = productos;
    }

    public int getCodigo()
    {
        return codigo;
    }

    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }
    
    
}

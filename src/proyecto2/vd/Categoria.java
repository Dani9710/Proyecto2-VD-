/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.vd;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


/**
 *
 * @author Danii
 */
public class Categoria implements Serializable
{
    protected HashMap<Integer, Producto> productos;
    protected float numeroCategoria; 

    public Categoria(float numeroCategoria)
    {
        this.productos = new HashMap<Integer, Producto>();
        this.numeroCategoria = numeroCategoria;
    }

    public int sizeProducto()
    {
        return productos.size();
    }

    public Producto getProducto(int codigo)
    {
        return productos.get(codigo);
    }

    public void addProducto(Producto e)
    {
        productos.put(e.getCodigo(), e);
    }

    public Producto removeProducto(int codigo)
    {
        return productos.remove(codigo);
    }

    public float getNumeroCategoria()
    {
        return numeroCategoria;
    }

    public void setNumeroCategoria(float numeroCategoria)
    {
        this.numeroCategoria = numeroCategoria;
    }
    
    
}

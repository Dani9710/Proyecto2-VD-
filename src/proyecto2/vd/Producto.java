/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.vd;

import java.io.Serializable;

/**
 *
 * @author Danii
 */
public class Producto implements Serializable
{
    int precio; 
    String nombre;
    int codigo;
    float categoria; 

    public Producto(float categoria, int codigo, String nombre, int precio)
    {
        this.precio = precio;
        this.nombre = nombre;
        this.codigo = codigo; 
        this.categoria = categoria; 
    }

    public int getPrecio()
    {
        return precio;
    }

    public void setPrecio(int precio)
    {
        this.precio = precio;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public int getCodigo()
    {
        return codigo;
    }

    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }

    public float getCategoria()
    {
        return categoria;
    }

    public void setCategoria(float categoria)
    {
        this.categoria = categoria;
    }
    
    
    
}

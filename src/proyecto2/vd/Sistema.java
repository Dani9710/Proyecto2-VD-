/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.vd;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/**
 *
 * @author sebap
 */
public class Sistema
{
    private Categoria jardin; 
    private Categoria ferreteria; 
    private Categoria hogar; 
    private Categoria electrohogar;
    private HashMap<Integer, Producto> catalogoProductos;
    private HashMap<Integer, Carro> cotizaciones; 
    private ArrayList<Producto> carritoCompras; 
    private Lector lector; 

    public Sistema()
    {
       /* this.jardin = new Jardin();
        this.hogar = new Hogar();
        this.ferreteria = new Ferreteria();
        this.electrohogar = new Electrohogar();*/
        this.cotizaciones = new HashMap<Integer, Carro>();
        this.carritoCompras = new ArrayList<Producto>();
        this.lector = new Lector(); 
        this.catalogoProductos = lector.cargarArchivo();
        
    }
//    
//    public void mostrarCategorias()
//    {
//        System.out.println("Hogar: ");
//        hogar.listarProductos();
//        System.out.println("Electrohogar: ");
//        electrohogar.listarProductos();
//        System.out.println("Jardin: ");
//        jardin.listarProductos();
//        System.out.println("Ferreteria: ");
//        ferreteria.listarProductos();
//        
//    }
    public void mostrarProductosCategoria(float numeroCategoria)
    {
        Set<Integer> codigos = this.catalogoProductos.keySet();
        
        for (Integer codigo : codigos)
        {
            Producto p = this.catalogoProductos.get(codigo);
            if(numeroCategoria < p.getCategoria() && numeroCategoria > (p.getCategoria()+1))
            {
                System.out.println(p.getCategoria()+ "\t" + p.getCodigo() + "\t" + p.getNombre() + "\t" + p.getPrecio());
            }
        }
    }
    
    public void mostrarProductoPorCodigo(int codigo)
    {
        Set<Integer> codigos = this.catalogoProductos.keySet();
    
        for (Integer c : codigos)
        {
            Producto p = this.catalogoProductos.get(c);
            
            if(c == codigo )
            {
                System.out.println(p.getCategoria()+ "\t" + p.getCodigo() + "\t" + p.getNombre() + "\t" + p.getPrecio());
            }
        }
    }
        
         
    
    public void imprimirCatalogoProductos()
    {
        Iterator i = this.catalogoProductos.entrySet().iterator();
        
        while(i.hasNext())
        {
            Map.Entry e = (Map.Entry)i.next();
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
    
    public Producto seleccionarProducto(int codigo)
    {
        Producto producto = this.catalogoProductos.get(codigo);
        
        return producto; 
    }
    
    
    /*public Producto seleccionarProducto(String nombre)
    {
        
    }*/

    public int sizeCarritoCompras()
    {
        return carritoCompras.size();
    }

    public boolean addCarrito(Producto e)
    {
        return carritoCompras.add(e);
    }

    public Producto removeProducto(int index)
    {
        return carritoCompras.remove(index);
    }
   
    
    
   // Niko
    /*public void preguntarCotizacion()
    {
        boolean cotizacion;
        cotizacion = validar.isValidacion();
        
        if(cotizacion == true)
        {
            
            System.out.println("Existe la cotizacion");   
            
        }
        else{
            
            System.out.println("No existe la cotizacion, lo sentimos mucho");
            
        }
        
    }*/

    public void eliminarCotizacion()
    {
        int eliminar;
        
        //Eliminar = Validar.remove(Eliminar);
        
    }
    
    public void TopeSemana()
    {
        Calendar semana = Calendar.getInstance();
        
        //Revisar como comparar dos fechas Calendar
        if(semana.equals(this))
        {
            
            eliminarCotizacion();
            
        }    
    }        
    
    public void seleccionarMedioDePago()
    {        
        System.out.println("Como desea Pagar?: ");
        Pago pago = null;
        int opcion = lector.leerNumero("Ingresa opcion", 1, 4);
        
        switch(opcion){
            
            case 1: pago = Pago.CHEQUE;
            break;
            case 2: pago = Pago.CREDITO;
            break;
            case 3: pago = Pago.DEBITO;
            break;
            case 4: pago = Pago.EFECTIVO;
            break;
          
        }
    }
        
        
    public void mostrarCodigos()
    {
        Set<Integer> codigos = this.catalogoProductos.keySet();
     
        for (Integer c : codigos)
        {
            Producto p = this.catalogoProductos.get(c);
            System.out.println(p.getCodigo() + "t" + p.getNombre());
        }
    }
    
    
        //Generar Cotizacion
        
        public void generarCotizacion()
        {
             
        
        }
        
        /*ArrayList<Producto> productosDeCategoria = new ArrayList<Producto>();

        Iterator<Codigo> it = hashmap.getIterator();

        for (Codigo codigo : it){
            Producto p = hashmap.get(codigo);*/

    
    
}

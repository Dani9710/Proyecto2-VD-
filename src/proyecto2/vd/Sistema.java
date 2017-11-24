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
    private HashMap<Integer, Producto> catalogoProductos;
    private HashMap<Integer, Carro> cotizaciones; 
    private ArrayList<Producto> carritoCompras; 
    private Lector lector; 

    public Sistema()
    {
        this.cotizaciones = new HashMap<Integer, Carro>();
        this.carritoCompras = new ArrayList<Producto>();
        this.lector = new Lector(); 
        this.catalogoProductos = lector.cargarArchivo();
        
    }
    
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
    
    public Carro obtenerCotizacionCodigo(int codigo)
    {
        Carro c = this.cotizaciones.get(codigo);
        if(c instanceof Cotizacion)
        {
            return c; 
        }
    }
    public void validarCotizacion(int codigo)
    {
        Carro carrito = obtenerCotizacionCodigo(codigo);
        boolean validacion = true; 
        carrito.setValidacion(validacion);
        
    }
    public ArrayList<Producto> agregarProductosCarritoDeCotizaciones(int codigo, ArrayList<Producto> productos)
    { 
        Producto producto = seleccionarProducto(codigo);
        productos.add(producto);
        
        return productos; 
    }

    public int size()
    {
        return cotizaciones.size();
    }

    public Carro put(Integer key, Carro value)
    {
        return cotizaciones.put(key, value);
    }

    public Carro remove(Object key)
    {
        return cotizaciones.remove(key);
    }
    
    public void efectuarCompra(int totalPago)
    {
        Pago tipoPago = seleccionarMedioDePago();
         
        int totalPagoDescuento = aplicarDescuento(tipoPago, totalPago);
        System.out.println("Desea pagar $" + totalPagoDescuento + "? n0. No n1. Si");
        boolean pagoRealizado = lector.leerBoolean();
        if(pagoRealizado == true)
        {
            System.out.println("Pago realizado con exito!");
        }
        else
        {
            System.out.println("El pago ha sido cancelado.");
        } 
    }
     
    public Pago seleccionarMedioDePago()
    {        
        System.out.println("Como desea Pagar?: ");
        Pago pago = null;
        int opcion = lector.leerNumero("Ingresa opcion", 1, 4);
         
        switch(opcion)
        {
             
            case 1: pago = Pago.CHEQUE;
            break;
            case 2: pago = Pago.CREDITO;
            break;
            case 3: pago = Pago.DEBITO;
            break;
            case 4: pago = Pago.EFECTIVO;
            break;
           
        }
         
        return pago;
    }
     
     
    public int aplicarDescuento(Pago tipoPago, int totalPago)
    {
        if(tipoPago == tipoPago.CHEQUE)
        {
            System.out.println("No se efectuaron descuentos, el monto a pagar es $" + totalPago);
        }
        else if(tipoPago == tipoPago.CREDITO)
        {
            System.out.println("No se efectuaron descuentos, el monto a pagar es $" + totalPago);
        }
        else if(tipoPago == tipoPago.DEBITO)
        {
            totalPago = (int)(totalPago * 0.95);
            System.out.println("Se hizo un 5% de descuento, el monto a pagar es $" + totalPago);
        }
        else if(tipoPago == tipoPago.EFECTIVO)
        {
            totalPago = (int)(totalPago * 0.9);
            System.out.println("Se hizo un 10% de descuento, el monto a pagar es $" + totalPago);
        }
         
        return totalPago;
    }
    
    public void verificarCotizacion()
    {
        
    }

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
    
    public void mostrarCodigos()
    {
        Set<Integer> codigos = this.catalogoProductos.keySet();
     
        for (Integer c : codigos)
        {
            Producto p = this.catalogoProductos.get(c);
            System.out.println(p.getCodigo() + "\t" + p.getNombre());
        }
    }
    
    
}

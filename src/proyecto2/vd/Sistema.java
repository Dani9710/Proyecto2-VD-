/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.vd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
/**
 *
 * @author sebap
 */
public class Sistema
{
    private HashMap<Integer, Producto> catalogoProductos;
    private HashMap<Integer, Carrito> carritos; 
    private Lector lector;
    private Set<Integer> numerosCotizacionGenerados;

    public Sistema()
    {
        this.carritos = new HashMap<Integer, Carrito>();
        this.lector = new Lector(); 
        this.catalogoProductos = lector.cargarArchivo();
        this.numerosCotizacionGenerados = new HashSet<Integer>();
        
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
    
    public Carrito obtenerCotizacion(Carrito c)
    {
        //Carro c = this.cotizaciones.get(codigo);
        boolean validacion = isCotizacion(c);
        if(validacion == false)
        {
            c = validarCotizacion(c);
            
        }
        else
            System.out.println("Esta cotizacion ya esta validada");
        return c;
    }
    
    public Carrito obtenerCotizacionPorCodigo(int codigo)
    {
        Carrito c = this.carritos.get(codigo);
        return c;
    }
    
    public boolean isCotizacion(Carrito c)
    {
        if(c instanceof Cotizacion)
            return true;
        else
            return false;
    }
    
    public Carrito validarCotizacion(Carrito c)
    {
        if(c instanceof Cotizacion)
        {
            ((Cotizacion) c).setValidacion(true);
            System.out.println("Esta cotizacion se validó con exito");
        }
        
        return c;
    }
    
    public ArrayList<Producto> agregarProductosCarritoDeCotizaciones(int codigo, ArrayList<Producto> productos)
    { 
        Producto producto = seleccionarProducto(codigo);
        productos.add(producto);
        
        return productos; 
    }

    public int size()
    {
        return carritos.size();
    }

    public Carrito put(Integer key, Carrito value)
    {
        return carritos.put(key, value);
    }

    public Carrito remove(Object key)
    {
        return carritos.remove(key);
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
    
    public void mostrarCodigos()
    {
        Set<Integer> codigos = this.catalogoProductos.keySet();
     
        for (Integer c : codigos)
        {
            Producto p = this.catalogoProductos.get(c);
            System.out.println(p.getCodigo() + "\t" + p.getNombre());
        }
    }
    
    public void eliminarCotizacionesExpiradas()
    {
        Calendar hoy = Calendar.getInstance();
        
        Set<Integer> codigos = this.carritos.keySet();
    
        for (Integer code : codigos)
        {
            Carrito c = this.carritos.get(code);
            if(c instanceof Cotizacion)
            {
                if(hoy.compareTo( ((Cotizacion) c).getFechaTermino() ) == 0)
                {
                    carritos.remove(c);
                }
            }
        }     
    } 
    
    
    public void serializarHashMapCatalogoProductos()
    {
           try
           {
                FileOutputStream fos = new FileOutputStream("catalogoProductos.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(this.catalogoProductos);
                oos.close();
                fos.close();
                System.out.printf("El HashMap catalogoProductos fue serializado en catalogoProductos.ser con exito!");
           }
           catch(IOException ioe)
           {
                ioe.printStackTrace();
           }
    }
    
    public void serializarHashMapCarritos()
    {
           try
           {
                FileOutputStream fos = new FileOutputStream("carritos.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(this.carritos);
                oos.close();
                fos.close();
                System.out.printf("El HashMap carritos fue serializado en carritos.ser con exito!");
           }
           catch(IOException ioe)
           {
                ioe.printStackTrace();
           }
    }
    
    public void serializarHashSetNumerosCotizacionesGenerados()
    {
           try
           {
                FileOutputStream fos = new FileOutputStream("numerosCotizacionesGenerados.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(this.numerosCotizacionGenerados);
                oos.close();
                fos.close();
                System.out.printf("El HashSet numerosCotizacionesGenerados fue serializado en numerosCotizacionesGenerados.ser con exito!");
           }
           catch(IOException ioe)
           {
                ioe.printStackTrace();
           }
    }
    
    
    public void deserializarHashMapCatalogoProductos()
    {
        this.catalogoProductos = null;
        try
        {
           FileInputStream fis = new FileInputStream("catalogoProductos.ser");
           ObjectInputStream ois = new ObjectInputStream(fis);
           this.catalogoProductos = (HashMap) ois.readObject();
           ois.close();
           fis.close();
        }
        catch(IOException ioe)
        {
           ioe.printStackTrace();
           return;
        }
        catch(ClassNotFoundException c)
        {
           System.out.println("Class not found");
           c.printStackTrace();
           return;
        }
        System.out.println("Se deserializo el HashMap catalogoProductos con exito!");
    }
          
    public void deserializarHashMapCarritos()
    {
        this.carritos = null;
        try
        {
           FileInputStream fis = new FileInputStream("carritos.ser");
           ObjectInputStream ois = new ObjectInputStream(fis);
           this.carritos = (HashMap) ois.readObject();
           ois.close();
           fis.close();
        }
        catch(IOException ioe)
        {
           ioe.printStackTrace();
           return;
        }
        catch(ClassNotFoundException c)
        {
           System.out.println("Class not found");
           c.printStackTrace();
           return;
        }
        System.out.println("Se deserializo el HashMap carritos con exito!");
    }
          
    
    
    public void deserializarHashSetNumerosCotizacionesGenerados()
    {
        this.numerosCotizacionGenerados = null;
        try
        {
           FileInputStream fis = new FileInputStream("numerosCotizacionesGenerados.ser");
           ObjectInputStream ois = new ObjectInputStream(fis);
           this.numerosCotizacionGenerados = (HashSet) ois.readObject();
           ois.close();
           fis.close();
        }
        catch(IOException ioe)
        {
           ioe.printStackTrace();
           return;
        }
        catch(ClassNotFoundException c)
        {
           System.out.println("Class not found");
           c.printStackTrace();
           return;
        }
        System.out.println("Se deserializo el HashSet numerosCotizacionesGenerados con exito!");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void serializar(String nombre)
    {
        Carrito c = new Cotizacion();
        
        try {
            FileOutputStream fileOut = new FileOutputStream(nombre);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(c);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in " + nombre);
        } 
        
        catch (IOException i)
        {
            i.printStackTrace();
        }
    }
    
    public int generarNumerosAleatoriosSinRepetir()
    {
        Random rnd = new Random();
        int aleatorio = -1;
        boolean generado = false;
        while (!generado)
        {
            int posible = rnd.nextInt();
            if (!this.numerosCotizacionGenerados.contains(posible)) 
            {
                this.numerosCotizacionGenerados.add(posible);
                aleatorio = posible;
                generado = true;
            }
        }
        return aleatorio;
    }
}

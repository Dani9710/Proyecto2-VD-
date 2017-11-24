package proyecto2.vd;

import java.util.ArrayList;

/**
 *
 * @author sebap
 */
public class Interfaz
{
    
    private Lector lector;
    private Sistema sistema;

    public Interfaz()
    {
        this.lector = new Lector();
        this.sistema = new Sistema();
    }
    

    public void iniciar()
    {
        
        //falta deserializar y cargar al iniciar programa
        
        //sistema.deserializar();
        
        System.out.println("Bienvenido a la tienda!");
        Menu.mostrarMenuPrincipal();
        int opcion = lector.leerNumero("Ingresa opcion", 1, 6);
        
        while( opcion != 0 )
        {
            
            //Orden de funcionalidades//
            
            
            //Consultar productor //por codigo //por categoria
            //Generar Cotizacion
            //Efectuar compra apartir de su cotizacion //Pagar una compra
            //Efectuar compra normalmente //Pagar una compra
            //Consultar descuentos
            
            
            switch( opcion )
            {
                case 1: mostrarCodigos();
                        break;
                case 2: consultarProductos();
                        break;
                case 3: generarCotizacion();
                        break;
                case 4: efectuarCompraConCotizacion();
                        break;
                case 5: efectuarCompraNormalmente();
                        break;
                case 6: consultarDescuentos();
                        break;
                
            }
           
            
            Menu.mostrarMenuPrincipal();
            opcion = lector.leerNumero("Ingresa opcion", 1, 6);

        }
        
        
      }
    
        

      public void mostrarCodigos()
      {
          sistema.mostrarCodigos();
      }
        
      
      
      
      
      
      
    public void consultarProductos()
    {

        int opcion = lector.leerNumero("1 para consultar por codigo, 2 para consultar por categoria: ", 1, 2);
        if(opcion == 1)
        {
            consultarPorCodigo();
        }
        else if(opcion == 2)
        {
            consultarPorCategoria();
        }
        
    } 
    
    public void efectuarCompraNormalmente()
    {
        ///////// Compra directa***
        
        boolean continuar = true; 
        int codigo = 0;
        int pagoTotal = 0; 
        while(continuar)
        {
            codigo = lector.leerNumero("Ingrese el codigo del producto que desea comprar");
        
            Producto producto = sistema.seleccionarProducto(codigo);
            sistema.addCarrito(producto);
            continuar = seguirAgregandoProductos();
            pagoTotal = pagoTotal + producto.getPrecio();
            
        }
        
        pagarCompra(pagoTotal);
        
        
        
    }
    
    public void efectuarCompraConCotizacion()
    {
        int codigo = lector.leerNumero("Ingrese codigo de cotizacion: ");
        Carro cotizacion = sistema.obtenerCotizacionPorCodigo(codigo);
        validarCotizacion(cotizacion);
        ArrayList<Producto> compras = cotizacion.getProductos();
        int pagoTotal = 0;
        for(Producto actual: compras)
        {
            pagoTotal = pagoTotal + actual.getPrecio();
        }
        pagarCompra(pagoTotal);
        
        generarBoleta(cotizacion);
        
        
    }
    
    
    public void generarBoleta(Carro c)
    {
        
    }
    
    
    public void consultarDescuentos()
    {
        Menu.mostrarDescuentos();
    }
    
    public void consultarPorCodigo()
    {
        int codigo = lector.leerNumero("Ingrese codigo de producto: ");
        sistema.mostrarProductoPorCodigo(codigo);
        
    }
    
    public void consultarPorCategoria()
    {
        float opcion = lector.leerNumero("Escoja categoria:  \n1. Hogar \n2.Electrohogar \n3.Jardin \n4.Ferreteria", 1,4);
        sistema.mostrarProductosCategoria(opcion);
    }
    
    
    
    
    public void generarCotizacion()
    {
        Carro cotizacion = crearCotizacion();
        
    }
    //validarCotizacion(cotizacion);
    
    //
    
    public Carro crearCotizacion()
    {
        
        int codigoProducto = lector.leerNumero("Ingrese codigo del producto que desea cotizar");
        ArrayList<Producto> productos = new ArrayList<Producto>();
        boolean continuar = true; 
        while(continuar)
        {
            productos = sistema.agregarProductosCarritoDeCotizaciones(codigoProducto, productos);
            
            Menu.menuSeguirComprando();
            seguirAgregandoProductos();
        }
        ////////////////// GENERAR NUMEROS RANDOM NO REPITA
        /////////////////METODO DISTINTO
        int codigoCotizacion = 0; /////METODO RANDOM
        
        Carro cotizacion = new Cotizacion(false, productos, codigoCotizacion);
        sistema.put(codigoCotizacion, cotizacion);
        return cotizacion;
    }   
    
    public void validarCotizacion(Carro c)
    {
        sistema.obtenerCotizacion(c);
        
    }
    
    /////////Pago: dar como parametro el precio
    public void pagarCompra(int totalPago)
    {
        sistema.efectuarCompra(totalPago);
    }
    
    public boolean seguirAgregandoProductos()
    {
        boolean continuar = true; 
        
        int opcion = lector.leerNumero("Ingrese su opcion");
        
        if(opcion == 1)
        {
            continuar = true;
        }
        
        else
        {
            continuar = false;
        }
        
        return continuar; 
    }
}
    
    
    
   

 


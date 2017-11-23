package proyecto2.vd;

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
    
    public void generarCotizacion()
    {
        
    }
    
    public void efectuarCompraConCotizacion()
    {
        boolean continuar = true; 
       
        while(continuar)
        {
            //reviso los productos
            
            continuar = seguirComprando();
            //selecciono el que voy a compra
            //pregunto si quiere comprar otro 
        }
        
        
        
    } 
    
    public void efectuarCompraNormalmente()
    {
        boolean continuar = true; 
        int codigo = 0;
        int pagoTotal = 0; 
        while(continuar)
        {
            codigo = lector.leerNumero("Ingrese el codigo del producto que desea comprar");
        
            Producto producto = sistema.seleccionarProducto(codigo);
            sistema.addCarrito(producto);
            continuar = seguirComprando();
            pagoTotal = pagoTotal + producto.getPrecio();
            
        }
        
        
        Pago pago = pagarCompra();
        
    }
    
    public void consultarDescuentos()
    {
        
        
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
    
    public Pago pagarCompra()
    {
        Pago pago = null; 
        int opcion = lector.leerNumero("Escoja el medio de pago con el que desea realizar su compra", 1,4);
        
        switch(opcion)
        {
            case 1: pago = Pago.DEBITO;    break;
            case 2: pago = Pago.EFECTIVO;  break;
            case 3: pago = Pago.CHEQUE;    break;
            case 4: pago = Pago.CREDITO;   break;
            
        }
        
        return pago; 
    }
    
    
    
   
}
 


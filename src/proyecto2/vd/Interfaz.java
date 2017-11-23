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
        int opcion = lector.leerNumero("Ingresa opcion", 1, 5);
        
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
                
                case 1: consultarProductos();
                        break;
                case 2: generarCotizacion();
                        break;
                case 3: efectuarCompraConCotizacion();
                        break;
                case 4: efectuarCompraNormalmente();
                        break;
                case 5: consultarDescuentos();
                        break;
                
            }
           
            
            Menu.mostrarMenuPrincipal();
            opcion = lector.leerNumero("Ingresa opcion", 1, 5);

        }
        
        
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
            seleccionCategoriaProducto();
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
        
            Producto producto = sistema.pedirProducto(codigo);
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
        
        
    }
    
    public void consultarPorCategoria()
    {
        //sistema.mostrarCategorias();
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
    
    
    public boolean seguirComprando()
    {
        boolean continuar = true; 
        System.out.println("¿Desea continuar comprando mas de nuestros productos?");
        System.out.println("[1]Si");
        System.out.println("[0]No");
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
    
    public void seleccionarHogar()
    {
        String seleccion = lector.leerLinea("Indique que produccto desea seleccionar"); 
        sistema.mostrarHogar();
        //Retornar objeto producto del hashmap
    }
    
    public void seleccionarElectrohogar()
    {
        String seleccion = lector.leerLinea("Indique que produccto desea seleccionar"); 
        sistema.mostrarElectrohogar();
        
        //Retornar objeto producto del hashmap
    }
    
    public void seleccionarJardin()
    {
        String seleccion = lector.leerLinea("Indique que produccto desea seleccionar"); 
        sistema.mostrarJardin();
        //Retornar objeto producto del hashmap
    }
    
    public void seleccionarFerreteria()
    {
        String seleccion = lector.leerLinea("Indique que produccto desea seleccionar"); 
        sistema.mostrarFerreteria();
        //Retornar objeto producto del hashmap
    }
    
    public void seleccionCategoriaProducto()
    {
        int opcion = lector.leerNumero("Escoja en que categoria desea realizar su compra", 1, 4);
        
        switch(opcion)
        {
            case 1: seleccionarHogar();        break;
            case 2: seleccionarElectrohogar(); break;
            case 3: seleccionarJardin();       break;
            case 4: seleccionarFerreteria();   break;
            
        }
    }
    
    
      
    
      
      
}
 


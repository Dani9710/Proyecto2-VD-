/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.vd;

/**
 *
 * @author Danii
 */
public class Menu
{
    public static void mostrarMenuPrincipal()
    {
        System.out.println("1: Mostrar productos");
        System.out.println("2: Consultar productos");
        System.out.println("3: Generar cotizacion");
        System.out.println("4: Efectuar compra con cotizacion");
        System.out.println("5: Efectuar compra normalmente");
        System.out.println("6: Consultar descuentos");
    }
    
    public static void mostrarMenuPago() {
        
        System.out.println("1: Cheque");
        System.out.println("2: Credito");
        System.out.println("3: Debito");
        System.out.println("4: Efectivo");
        
    }
    public static void mostrarDescuentos() {
        
        System.out.println("Cheque: No tiene descuento");
        System.out.println("Credito: No tiene descuento");
        System.out.println("Debito: Tiene 5% de descuento");
        System.out.println("Efectivo: Tiene 10% de descuento");
    }
    
    public static void menuSeguirComprando()
    {
        System.out.println("¿Desea continuar comprando mas de nuestros productos?");
        System.out.println("[1]Si");
        System.out.println("[0]No");
    
    }
    
    public static void consultarProductos()
    {
        System.out.println("1: Codigo");
        System.out.println("2: Categoria");

    }
    
    
}

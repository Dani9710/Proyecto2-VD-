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
        System.out.println("1: Consultar productos");
        System.out.println("2: Cotizar productos");
        System.out.println("3: Comprar prodcutos con cotizacion");
        System.out.println("4: Comprar productos normalmente");
        System.out.println("5: Consultar Descuentos");
    }
    
    static void mostrarMenuPago() {
        
        System.out.println("1: Cheque");
        System.out.println("2: Credito");
        System.out.println("3: Debito");
        System.out.println("4: Efectivo");
        
    }
}

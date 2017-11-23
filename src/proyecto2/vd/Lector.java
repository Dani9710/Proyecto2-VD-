/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.vd;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author sebap
 */
public class Lector
{
    
    private Scanner scanner;
    
    public Lector()
    {
        this.scanner = new Scanner(System.in);
    }
    
    public int leerNumero(String mensaje)
    {
        int numero = 0;
        boolean continuar = true;
        
        while(continuar)
        {
            try
            {
                System.out.print(mensaje + ": ");
                numero = Integer.parseInt( this.scanner.nextLine() );
                continuar = false;
            }
            catch(Exception e)
            {
                System.out.println("Error al leer el número entero, por favor ingreselo nuevamente.");
                continuar = true;
            }
        }
        
        return numero;
    }
    
    public int leerNumero(String mensaje, int menor, int mayor)
    {
        int opcion = leerNumero(mensaje);
        while( !( menor <= opcion && opcion <= mayor) )
        {
            System.out.printf("Error, el valor ingresado debe estar en el rango [%d, %d]\n", menor, mayor);
            opcion = leerNumero(mensaje);
        }
        return opcion;
    }
    
     
    public float leerFloat(String mensaje)
    {
        float numero = 0;
        boolean continuar = true;
        
        while(continuar)
        {
            try
            {
                System.out.print(mensaje + ": ");
                numero = Float.parseFloat(this.scanner.nextLine() );
                continuar = false;
            }
            catch(Exception e)
            {
                System.out.println("Error al leer el número, por favor ingreselo nuevamente.");
                continuar = true;
            }
        }
        
        return numero;
    }
    
    public boolean leerBoolean()
    {
        int opcion = leerNumero("Ingrese opcion", 0, 1);
        
        boolean b = true;
        switch (opcion)
        {
            case 0: b = false; break;
            case 1: b = true; break;
        }
        return b;
    }
    
    
    
    public boolean leerBoolean(String numero)
    {
        
        int opcion = Integer.parseInt(numero);
        
        boolean b = true;
        switch (opcion)
        {
            case 0: b = false; break;
            case 1: b = true; break;
        }
        return b;
    }
    
    
    
    public String leerLinea(String mensaje)
    {
        System.out.print(mensaje + ": ");
        return this.scanner.nextLine();
    }
    
    public HashMap<Integer, Producto> cargarArchivo()
    {
        HashMap productos = new HashMap<Integer, Producto>();
        
        try
        {
            Scanner scanner = new Scanner(new File("Proyecto2.txt"));
            while(scanner.hasNextLine())
            {
                String linea = scanner.nextLine();
                int indiceEspacio = linea.indexOf(' ');
                float categoria = Float.parseFloat(linea.substring(0, indiceEspacio));
                linea = linea.substring(indiceEspacio + 1);
                indiceEspacio = linea.indexOf(' ');
                int codigo = Integer.parseInt(linea.substring(0, indiceEspacio));
                linea = linea.substring(indiceEspacio + 1);
                indiceEspacio = linea.indexOf(' ');
                String nombre = linea.substring(0, indiceEspacio);
                linea = linea.substring(indiceEspacio + 1);
                int precio = Integer.parseInt(linea);
                
                Producto p = new Producto(categoria, codigo, nombre, precio);
                
                productos.put(codigo, p); 
            }
        } 
        
        catch (Exception e)
        {
            System.out.println("Error, no se pudo obtener los productos");
            e.printStackTrace();
        }
        
        return productos; 
    }
    
}


    
    
    


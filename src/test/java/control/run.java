/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.Autor;
import modelo.FichaEjemplar;
import modelo.MagnamentFicha;
import modelo.Yacimiento;
/**
 *
 * @author 57320
 */
public class run {
    
    public static void main(String args[]) throws ParseException{
        MagnamentFicha mag=new MagnamentFicha();
        Yacimiento y=new Yacimiento(12,"soga",122.1,233.3);
        DateFormat format=new SimpleDateFormat("DD/MM/YYYY");
        Date fecha=format.parse("12/03/2016");
        
        
        mag.añadirAutor(10,"pepe","encargado");
        
        
        System.out.println(mag.añadirFicha(1, "aw", "a", "a", 1, 1, "yaci", 10, 10, fecha, 1, 10));
        mag.añadirFicha(2, "em", "a", "a", 1, 1, "yaci", 10, 10, fecha, 1, 10);
        mag.añadirFicha(3, "em", "a", "a", 1, 1, "yaci", 10, 10, fecha, 1, 10);
        mag.añadirFicha(4, "ui", "a", "a", 1, 1, "yaci", 10, 10, fecha, 1, 10);
        
        System.out.println(mag.buscarFicha(3));
        
        
        
        for(FichaEjemplar ficha:mag.mostrarFicha("em")){
            System.out.println(ficha.toString());
        }
        
        mag.modificarFicha(2, "nombre", "pepe");
        
       
        
         for(FichaEjemplar ficha:mag.mostrarFicha("pepe")){
            System.out.println(ficha.toString());
        }
        
        
        
        
    }
}

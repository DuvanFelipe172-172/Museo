/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author Duvan Felipe
 */
public class MagnamentFicha {
    
    private ArrayList<FichaEjemplar> fichas;
    private ArrayList<Autor> autores;

    public MagnamentFicha() {
        fichas=new ArrayList<>(); 
        autores=new ArrayList<>();
    }
    
    
    public boolean añadirAutor(int id_autor, String nombre, String cargo){          
        if (this.buscarautor(id_autor) != null){
            return false;
        }else{
            autores.add(new Autor(id_autor, nombre, cargo));
            
            return true;      
        }
        
    }
    
    
    
    public boolean añadirFicha(int idEjemplar,String nombre,String filum, String tamaño, double peso,int idYacimiento, String nombreYacimineto, double latitud,double longitud, Date fechaIngreso, int edadEjemplar,int idautor){
        
        Autor autor = this.buscarautor(idautor);
        
        if(autor != null){
            
            if (this.buscarFicha(idEjemplar)) {
                return false;
            }else{
                fichas.add(new FichaEjemplar(idEjemplar,nombre,filum,tamaño,peso,new Yacimiento(idYacimiento,nombreYacimineto,latitud,longitud),fechaIngreso,edadEjemplar,autor));
                return true;
        } 
            
            
        }
        
        return false;
        
    }
    
    
    public Autor buscarautor(int id){
               
        for(Autor autor:autores ){
            if(autor.getId_autor()==id){
                return autor;
            }
        }
        return null;   
    }
    
    public boolean buscarFicha(int id){
               
        for(FichaEjemplar ficha:fichas ){
            if(ficha.getId_Ejemplar()==id){
                return true;
            }
        }
        return false;   
    }
    
    public int contador(int id){
        
        int i=0;
        for(FichaEjemplar ficha:fichas ){
            i++;
            if(ficha.getId_Ejemplar()==id){
                return i;
            }
        }
        return i;   
    }
    
    
    
    public ArrayList<FichaEjemplar> mostrarFicha(String nombre){
        
        ArrayList<FichaEjemplar> aux = new ArrayList<>();  
                
        for(FichaEjemplar ficha:fichas ){
            if(ficha.getNombre().equals(nombre)){
                aux.add(ficha);
            }
        }
        return aux;   
    }
    
    
    
    
    
    public boolean modificarFicha(int id,String option, String valor) throws ParseException{
        
        if(this.buscarFicha(id)){
            
            switch(option){
            
            case("nombre"):
                fichas.get(this.contador(id)).setNombre(valor);
                break;
            case("filum"):
                fichas.get(this.contador(id)).setFilum(valor);
                break;
            case("tamaño"):
                fichas.get(this.contador(id)).setTamaño(valor);
                break;
            case("peso"):
                fichas.get(this.contador(id)).setPeso(Double.parseDouble(valor));
                break;
            case("nombreyaci"):
                fichas.get(this.contador(id)).getProcedencia().setNombre(valor);
                break;
            case("latitud"):
                fichas.get(this.contador(id)).getProcedencia().setLatitud(Double.parseDouble(valor));
                break;
            case("longitud"):
                fichas.get(this.contador(id)).getProcedencia().setLongitud(Double.parseDouble(valor));
                break;
            case("fechaIngreso"):
                DateFormat format=new SimpleDateFormat("DD/MM/YYYY");
                Date fecha=format.parse(valor);
                fichas.get(this.contador(id)).setFechaIngreso(fecha);
                
                break;
            case("edadejemplar"):
                fichas.get(this.contador(id)).setEdadEjemplar(Integer.parseInt(valor));
                
                break;
            
            
            } 
            return true;
        }
        return false;
        
      
    }
    
    
    public boolean eliminarFicha(int id){
        int i= 0;
        
        for(FichaEjemplar ficha:fichas ){
            i++;
            if(ficha.getId_Ejemplar()==id){
                fichas.remove(i-1);
                return true;
            }
        }
        return false;   
    }
}

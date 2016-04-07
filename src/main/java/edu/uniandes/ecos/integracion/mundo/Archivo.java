package edu.uniandes.ecos.integracion.mundo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Clase generica que se encarga de realizar la lectura de los
 * datos del archivo de texto.
 * @author Leonardo Valbuena Calderon
 * @date 15/02/2016 
 */
public class Archivo {
    
    /**
     * Obtiene los datos de un archivo
     * @param archivo nombre del archivo donde se encuentran los datos
     * @return lista de valores obtenida del archivo 
     */
    //@METODO
    public static LinkedList obtenerDatos(String archivo) {        
        LinkedList datos = new LinkedList();
        try {            
            FileReader f = null;
            f = new FileReader(archivo);
            BufferedReader b = new BufferedReader(f);
                        
            String cadena = "";
            while((cadena = b.readLine())!=null) {
                datos.add(Double.parseDouble(cadena));                
            }
            b.close();
            
        } catch (FileNotFoundException ex) {        
            
        } catch(IOException e) {
            
        }        
        return datos;
    }    
    
}

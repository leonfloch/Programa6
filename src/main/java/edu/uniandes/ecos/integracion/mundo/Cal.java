package edu.uniandes.ecos.integracion.mundo;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author leonardo valbuena calderon
 * Clase que se encarga de realizar los calculos de la media 
 * y la desviacion estandar
 */
public class Cal {
    
    /**
     * Se encarga de calcular la media para una lista de valores 
     * enviado
     * @param valores lista de valores 
     * @return valor de la media 
     */
    //@METODO
    public static double calcularMedia(LinkedList valores) {
        double media;
        double suma = 0;
        
        Iterator iterador = valores.iterator();
        while(iterador.hasNext()) {
            suma += (double)iterador.next();
        }        
        media = suma / valores.size();

        //redondeo
        //int cifras=(int) Math.pow(10,2);
        //media = Math.rint(media * cifras) / cifras;        
        
        return media;
    }
    
    /**
     * Se encarga de calcular la desviacion estandar 
     * @param media valor de la media
     * @param valores lista de valores 
     * @return valor de la desviacion estandar 
     */
    //@METODO
    public static double calcularDesviacionEstandar(double media, LinkedList valores) {
        double desvEstandar;        
        double suma = 0;
        
        Iterator iterador = valores.iterator();
        while(iterador.hasNext()) {                        
            double resta = (double)iterador.next() - media;              
            suma += Math.pow(resta, 2);
        }        
        desvEstandar = Math.sqrt(suma / (valores.size()-1));
        
        //se realiza redondeo
        int cifras=(int) Math.pow(10,2);
        desvEstandar = Math.rint(desvEstandar * cifras) / cifras;        
        return desvEstandar;
    }
    
    /**
     * Realiza la sumatoria de una lista de valores
     * @param valores datos que se van a sumar
     * @return suma de todos los valores
     */
    //@METODO
    public static double sumatoria(LinkedList valores) {
        double resultado = 0;        
        Iterator iterador = valores.iterator();
        while(iterador.hasNext()) {                                    
            resultado += (Double)iterador.next();
        }
        return resultado;        
    }
    
    /**
     * por cada valor de la lista se eleva al cuadrado y se realiza sumatoria
     * @param valores datos a calcular
     * @return 
     */
    //@METODO
    public static double sumElevarAlCuadrado(LinkedList valores) {
        double resultado = 0;        
        Iterator iterador = valores.iterator();
        while(iterador.hasNext()) {                                    
            double valor = (Double)iterador.next();
            resultado += Math.pow(valor, 2);
        }
        return resultado;        
    }
    
    /**
     * se toman los valores de las listas, se multiplican y se realiza sumatoria
     * @param valoresX datos a clacular
     * @param valoresY datos a calcular
     * @return resultado de la sumatoria
     */
    //@METODO
    public static double sumMultiplicacion(LinkedList valoresX, 
            LinkedList valoresY) {
        double resultado = 0;        
        int cont = 0;
        Iterator iteradorX = valoresX.iterator();
        while(iteradorX.hasNext()) {
            resultado += (Double)valoresY.get(cont) * (Double)iteradorX.next();                    
            cont++;
        }
        return resultado;
    }
    
    /**
     * realiza redondeo cifras
     * @param valor valor a redondear
     * @param cifra cantidad de cifras a redondear
     * @return 
     */
    //@METODO
    public static double redondeo(double valor, int cifra) {
        int cifras=(int) Math.pow(10, cifra);
        return Math.rint(valor * cifras) / cifras;
    }
    
    /**
     * Realiza el calculo de la varianza para una lista de datos
     * @param datos
     * @return 
     */
    //@METODO
    public static double calcularVarianza (double avg, LinkedList datos) {
        double resultado = 0;
        double sumatoria = 0;
        Iterator iteradorDatos = datos.iterator();
        while(iteradorDatos.hasNext()) {            
            sumatoria += Math.pow(((double)iteradorDatos.next()) - avg, 2);
        }
        resultado = sumatoria / (datos.size() - 1);        
        return resultado;
    }
    
    /**
     * a partir de una lista de datos, calcula el logaritmo natural
     * para cada uno de ellos
     * @param datos lista de datos a calcular
     * @return lista de datos calculados
     */
    //@METODO
    public static LinkedList calcularLogNatural(LinkedList datos) {
        LinkedList resultado = new LinkedList();        
        Iterator iteradorDatos = datos.iterator();
        while(iteradorDatos.hasNext()) {
            double log = Math.log((double) iteradorDatos.next());
            resultado.add(log);
        }        
        return resultado;
    }
    
    /**
     * realiza el calculo del factorial para el valor dado
     * @param valor
     * @return valor calculado 
     */
    //@METODO
    public static double factorial(double valor) { 
        if (valor <= 0) {
            return 1;
        } else {
            return valor*(factorial(valor-1));
        }
    }
    
    /**
     * calcula el multiplicativo para el valor dado
     * @param valor
     * @return 
     */
    //@METODO
    public static int multiplicativo(int valor) {        
        if (valor == 0 || valor == 10)
            return 1;
        return valor%2 == 0 ? 2 : 4;
    }
    
    
}

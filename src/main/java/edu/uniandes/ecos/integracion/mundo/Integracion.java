package edu.uniandes.ecos.integracion.mundo;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Calse principal donde se coordinan los calculos y se envian 
 * a la interfaz
 * @author Leonardo Valbuena Calderon
 * @date 25/03/2016
 */
public class Integracion {
    
    /**
     * datos donde se encuentran los valores de x
     */
    private static final String TABLA_X = "data/tableX.txt";
    
    /**
     * datos donde se encuentran los valores de dof
     */
    private static final String TABLA_DOF = "data/tableDof.txt";
    
    /**
     * contiene los datos esperados
     */
    private static final String DATOS_ESPERADOS = "data/ExpectedValue.txt";
    
    
    /**
     * Constructor
     */
    //@METODO
    public Integracion() {
        
    }
    
    /**
     * Se toma informacion de los archivos donde se realizan los calculos
     * para calcular las integrales
     * @return tabla de resultado
     */
    //@METODO
    public LinkedList iniciarCalculos() {
        LinkedList<Resultado> resultados = new LinkedList<Resultado>();
                
        LinkedList datosX = Archivo.obtenerDatos(TABLA_X);
        LinkedList datosDof = Archivo.obtenerDatos(TABLA_DOF);
        LinkedList datosExp = Archivo.obtenerDatos(DATOS_ESPERADOS);        
        
        Iterator iteradorDataX = datosX.iterator();
        int cont = 0;
        while(iteradorDataX.hasNext()) {
            double valorX = (double)iteradorDataX.next();            
            double dof = (double)datosDof.get(cont);
                        
            double result = this.calcularIntegral(valorX, dof);
            
            Resultado resultado = new Resultado(String.valueOf(valorX), dof, (double)datosExp.get(cont), result);
            resultados.add(resultado);
            
           cont++; 
        }        
        return resultados;
    }
    
    /**
     * realiza el calculo de la integral para los valores dados
     * @param valorX
     * @param dof
     * @return 
     */
    //@METODO
    public double calcularIntegral(double valorX, double dof) {
        double resultado = 0;
        int numSeg = 10; 
        double w = valorX / numSeg;
        
        for (int i=0; i <= numSeg; i++) {            
            double xi = i * w;
            double distribucion = this.calcularDistribucion(dof, xi);

            int multiplier = Cal.multiplicativo(i);
            resultado += this.calcularTemr(multiplier, w, distribucion);            
        }
        return Cal.redondeo(resultado, 5);
    }
    
    /**
     * realiza el calculo de la distribucion
     * @param dof
     * @param xi
     * @return 
     */
    //@METODO
    private double calcularDistribucion(double dof, double xi) {
        double col2 = 1 + (Math.pow(xi, 2) / dof);    
        double potDof = (dof + (double)1) / (double)2;
        double col3 = Math.pow(col2, -potDof);        
        double facDof2 = (Cal.factorial((dof / (double)2) - (double)1)) * Math.sqrt(Math.PI);
        double numerador = (Cal.factorial(potDof - (double)1));
        
        double col4 = numerador /                 
                (Math.pow((dof * Math.PI), (double)1 / (double)2) * facDof2);            
         return col4 * col3;
    }
    
    /**
     * realiza el calculo temr para ir sumando los resultados
     * @param multiplier
     * @param w
     * @param distribucion
     * @return 
     */
    //@METODO
    private double calcularTemr(double multiplier, double w, 
            double distribucion) {
        return (w / 3) * multiplier * distribucion;
    }
    
}

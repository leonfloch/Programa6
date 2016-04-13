package edu.uniandes.ecos.integracion.mundo;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Clase encargada de encontrar el valor de x
 * @author Leonardo Valbuena Calderon
 * @date 12/06/2016
 */
public class IntegradorX {
    
    /**
     * datos donde se encuentran los valores de x
     */
    private static final String TABLA_X6 = "data/tablexP6.txt";
    
    /**
     * datos donde se encuentran los valores de dof
     */
    private static final String TABLA_DOF6 = "data/tableDofP6.txt";
    
    /**
     * contiene los datos esperados
     */
    private static final String DATOS_P = "data/tableP.txt";
    
    /** 
     * rango de error aceptado. 
     */
    public static final double RANGO_ERROR = 0.00001;
    
    /**
     * Inicia los calculos para encontrar las X
     * @return resultado con los x encontrados 
     */
    //@METODO
    public LinkedList encontrarX() {
        LinkedList<Resultado> resultados = new LinkedList<Resultado>();        
                
        LinkedList datosX = Archivo.obtenerDatos(TABLA_X6);
        LinkedList datosDof = Archivo.obtenerDatos(TABLA_DOF6);
        LinkedList datosP = Archivo.obtenerDatos(DATOS_P);
        
        Iterator iteradorDataX = datosX.iterator();
        int cont = 0;
        while(iteradorDataX.hasNext()) {
            double valorX = (double)iteradorDataX.next();
            double dof = (double)datosDof.get(cont);
            double p = (double)datosP.get(cont);
            
            //se incia la busqueda del x
            double xEncontrado = buscarX(p, 1.0, dof);
            
            Resultado resultado = new Resultado(p, dof, String.valueOf(valorX), xEncontrado);
            resultados.add(resultado);
            cont++;
        }
        return resultados;
    }
    
    /**
     * se encarga de encontrar la x que hace que calule la p enviada
     * @param pEsperado
     * @param xInicial
     * @param dof
     * @return 
     */
    //@METODO
    public double buscarX(double pEsperado, double xInicial, double dof) {
        Integracion integracion = new Integracion();
        boolean encontro = false;
        double resultado = 0;
        double factor = 0.5;
        double xTemporal = xInicial;
        String signoAnterior = "";
        String signoActual = "";
        
        int cont = 0;
        while (!encontro) {                        
            double pCalculado = integracion.calcularIntegral(xTemporal, dof);            
            double valorErrorValido =  pEsperado - pCalculado;
            
            if (Math.abs(valorErrorValido) < RANGO_ERROR) {
                encontro = true;
                resultado = xTemporal;
            } else {                
                signoActual = valorErrorValido < 0 ? "-" : "+";
                if (signoAnterior.isEmpty()) {
                    signoAnterior = signoActual;
                }                
                if (cont > 0) {
                    factor = calcularFactor(factor, signoAnterior, signoActual);
                }
                signoAnterior = signoActual;
            
                if (pCalculado < pEsperado) {
                    xTemporal += factor;
                } else {
                    xTemporal -= factor;
                }
            }
            cont++;
        }
        return Cal.redondeo(resultado, 5);
    }

    /**
     * realiza el calculo del factor en cada iteracion de x
     * @param factor
     * @param signoAnterior
     * @param signoActual
     * @return 
     */
    private double calcularFactor(double factor, String signoAnterior, 
            String signoActual) {        
        if (!signoActual.equals(signoAnterior)) {
            factor /= 2;
        }
        return factor;
    }
    
}

package edu.uniandes.ecos.integracion.test;

import edu.uniandes.ecos.integracion.mundo.IntegradorX;
import static edu.uniandes.ecos.integracion.mundo.IntegradorX.RANGO_ERROR;
import static junit.framework.Assert.assertTrue;
import junit.framework.TestCase;
import org.junit.*;



/**
 * Se definen los casos de prueba
 * @author Leonardo Valbuena Calderon
 * @date 06/04/2016
 */
public class IntegradorXTest extends TestCase {   
    
    /** 
     * rango de error aceptado. 
     */
    public static final double RANGO_ERROR = 0.00001;
    
    /**
     * Clase donde se gestionan los calculos
     */
    IntegradorX integradorX = new IntegradorX();
    
    
    /**
     * test para p=0.20 dof=6
     */
    @Test
    //@METODO
    public void test1() {
        double result = integradorX.buscarX(0.20, 1.0, 6);
        assertTrue(0.55338 <= result && result <= 0.55350);
    }
    
    /**
     * test para p=0.45 dof=15
     */
    @Test
    //@METODO
    public void test2() {                        
        double result = integradorX.buscarX(0.45, 1.0, 15);
        assertEquals(1.75305, result);
    }
    
    /**
     * test para p=0.495 dof=4
     */
    @Test
    //@METODO
    public void test3() {
        double result = integradorX.buscarX(0.495, 1.0, 4);
        assertTrue(4.6010 <= result && result <= 4.60940);        
    }
    
    
    
    
}

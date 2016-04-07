package edu.uniandes.ecos.integracion.mundo;

/**
 * Representa la tabla de resultados
 * @author Leonardo Valbuena Calderon
 * @date 25/03/2016
 */
public class Resultado {
    
    /**
     * limite para la integral
     */
    private String x;
    
    /**
     * representa los grados de libertad
     */
    private double dof;
    
    /**
     * valor de la integral esperado
     */
    private double p;
    
    /**
     * valor de la integral actual
     */
    private double pActual;
    
    

    

    /**
     * 
     * @param x
     * @param dof
     * @param p
     * @param pActual 
     */
    //@METODO
    public Resultado(String x, double dof, double p, double pActual) {
        this.x = x;
        this.dof = dof;
        this.p = p;
        this.pActual = pActual;
    }
    
    

    /**
     * 
     * @return 
     */
    //@METODO
    public String getX() {
        return x;
    }

    /**
     * 
     * @param x 
     */
    //@METODO
    public void setX(String x) {
        this.x = x;
    }

    /**
     * 
     * @return 
     */
    //@METODO
    public double getDof() {
        return dof;
    }

    /**
     * 
     * @param dof 
     */
    //@METODO
    public void setDof(double dof) {
        this.dof = dof;
    }

    /**
     * 
     * @return 
     */
    //@METODO
    public double getP() {
        return p;
    }

    /**
     * 
     * @param p 
     */
    //@METODO
    public void setP(double p) {
        this.p = p;
    }

    /**
     * 
     * @return 
     */
    //@METODO
    public double getpActual() {
        return pActual;
    }

    /**
     * 
     * @param pActual 
     */
    //@METODO
    public void setpActual(double pActual) {
        this.pActual = pActual;
    }

    
    
    
    
    
    
    
}

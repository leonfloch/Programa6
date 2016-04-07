
import edu.uniandes.ecos.integracion.mundo.Cal;
import edu.uniandes.ecos.integracion.mundo.Integracion;
import edu.uniandes.ecos.integracion.mundo.Resultado;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedList;

import static spark.SparkBase.staticFileLocation;
import static spark.Spark.get;
import static spark.SparkBase.port;

/**
 * Calse de presentacion donde se muestran los resultados.
 *
 * @author Leonardo Valbuena Calderon
 * @date 25/03/2016
 */
public class InterfazIntegracion {

    /**
     * Main de la aplicacion
     *
     * @param args
     */
    //@METODO
    public static void main(String[] args) {        
        Integracion integracion = new Integracion();        
        mostrarResultados(integracion.iniciarCalculos());
    }

    /**
     * Utilizando Heroku se muestran los resultados
     *
     * @param result
     */
    //@METODO
    public static void mostrarResultados(LinkedList result) {
        port(Integer.valueOf(System.getenv("PORT")));
        staticFileLocation("/public");
        get("/", (req, res) -> getHtml(result));
    }

    /**
     * Genera el codigo html del resultado
     *
     * @param result
     * @return
     */
    //@METODO
    public static StringBuffer getHtml(LinkedList result) {
        StringBuffer html = new StringBuffer();
        html.append("<table border=1>");
        html.append("<tr>");        
        html.append("<th colspan=\"2\">Test</th>");
        html.append("<th>Expected Value</th>");
        html.append("<th>Actual Value</th>");
        html.append("</tr>");
        html.append("<tr>");
        html.append("<th>X</th>");
        html.append("<th>Dof</th>");
        html.append("<th>P</th>");
        html.append("<th></th>");        
        html.append("</tr>");

        Iterator iterador = result.iterator();        
        while (iterador.hasNext()) {
            Resultado res = (Resultado) iterador.next();
            html.append("<tr>");
            html.append("<td> 0 to x= " + res.getX() + "</td>");
            html.append("<td>" + res.getDof() + "</td>");
            html.append("<td>" + res.getP() + "</td>");
            html.append("<td>" + res.getpActual() + "</td>");            
            html.append("</tr>");
        }
        html.append("</table>");
        html.append("</body>");
        html.append("</html>");
        return html;
    }

    

}

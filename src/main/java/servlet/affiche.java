/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import packageDao.DAO;
import packageDao.DAOException;
import packageDao.DISCOUNTIDENTITY;
import packageDao.DataSourceFactory;
/**
 *
 * @author pedago
 */
@WebServlet(name = "affiche", urlPatterns = {"/affiche"})
public class affiche extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DAOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet affiche</title>");
            out.println("<style>\n" +
"				.table\n" +
"				{\n" +
"					display:table;\n" +
"					border-collapse:separate;\n" +
"					border-spacing:2px;\n" +
"				}\n" +
"				.thead\n" +
"				{\n" +
"					display:table-header-group;\n" +
"					color:white;\n" +
"					font-weight:bold;\n" +
"					background-color:grey;\n" +
"				}\n" +
"				.tbody\n" +
"				{\n" +
"					display:table-row-group;\n" +
"				}\n" +
"				.tr\n" +
"				{\n" +
"					display:table-row;\n" +
"				}\n" +
"				.td\n" +
"				{\n" +
"					display:table-cell;\n" +
"					border:1px solid black;\n" +
"					padding:1px;\n" +
"				}			\n" +
"		</style>	");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Edition des taux de remise</h1>");
            out.println("<form method='GET'>\n" +
"			Code : <input name=\"code\" size=\"1\" maxlength=\"1\" pattern=\"[A-Z]{1}+\" title=\"Une lettre en MAJUSCULES\"><br/>\n" +
"			Taux : <input name=\"taux\" type=\"number\" step=\"0.01\" min=\"0.0\" max=\"99.99\" size=\"5\"><br/>\n" +
"			<input type=\"hidden\" name=\"action\" value=\"ADD\">\n" +
"			<input type=\"submit\" value=\"Ajouter\">\n" +"</form>\n" +" ");
              DAO dao = new DAO(DataSourceFactory.getDataSource());
             ArrayList<DISCOUNTIDENTITY> liste= new  ArrayList<DISCOUNTIDENTITY>();
             liste=dao.parcour();
            out.println("<div><h4></h4></div>");
            out.println("<div class=\"table\">");
            out.println("<div class=\"thead\"><div class=\"td\">Code</div><div class=\"td\">Taux</div><div class=\"td\">Action</div></div>\n" +
"			<div class=\"tbody\">");
          
            
            
           
            for (int i = 0 ;i<liste.size();i++){
                
                out.println("<form class=\"tr\" method=\"get\">");
                out.println("<div class=\"td\"><input type=\"text\" name=\"code\"  value=\""+liste.get(i).lettre+"\"readonly/></div>");
                out.println("<div class=\"td\"><input name=\"taux\" type=\"number\" step=\"0.01\" min=\"0.0\" max=\"99.99\" value=\""+liste.get(i).taux+"\" size=\"5\"/></div>");
                out.println("<div class=\"td\"><input type=\"submit\" name=\"action\" value=\"DELETE\"/></div>");
                out.println("</form>");
                
            }
            
            
            
            
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (DAOException ex) {
            Logger.getLogger(affiche.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (DAOException ex) {
            Logger.getLogger(affiche.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

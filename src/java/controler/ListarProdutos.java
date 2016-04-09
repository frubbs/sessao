/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Catalogo;
import model.ClassificacaoProduto;
import model.Produto;
import model.Usuario;

/**
 *
 * @author Rafael.Soares
 */
public class ListarProdutos extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListarProdutos</title>");            
            out.println("</head>");
            out.println("<body>");
            
           
            
            
            
            HttpSession session = request.getSession(false);
            if(session == null){
                System.out.println("nao logado");
                request.getRequestDispatcher("index.html").forward(request, response);
            }
            else {
                
               Usuario usua = (Usuario) request.getAttribute("usu");
               
               out.println("Ola, " + usua.getNome() 
                       + " (" + usua.getLogin() 
                       + "). Voce tem " + usua.getIdade() 
                       + " anos. | <a href=\"ListarCarrinho\"> <small> carrinho</small></a>"
                       + "| <a href=\"Logoff\"> <small> logoff</small></a><br/>");
               
               Catalogo cat = new Catalogo();
               
               
               // listar os produtos infantis
               for(Produto p : cat.listarProdutos(ClassificacaoProduto.INFANTIL)){
                   out.println("produto: " + p.getNome() + "(" + p.getTipo() + ") "
                           + "<a href=adicionarCarrinho?idprod=" + p.getId() +"> Adicionar </a>"
                           + ""
                           + "<br/>");
               }
               
               //verificar a idade do usuario
               if (usua.getIdade() > 18){
               // se for maior de idade
               //listar os produtos de adulto
                for(Produto p : cat.listarProdutos(ClassificacaoProduto.ADULTO)){
                    out.println("produto: " + p.getNome() + "(" + p.getTipo() + ") <br/>");
                }
                for(Produto p : cat.listarProdutos(ClassificacaoProduto.IDOSO)){
                   out.println("produto: " + p.getNome() + "(" + p.getTipo() + ") <br/>");
               }
               
               }
               
               
            }
            
            
            
            
            out.println("<h1>Servlet ListarProdutos at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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

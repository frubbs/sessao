/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rafael.Soares
 */
public class adicionarCarrinho extends HttpServlet {

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
            
            
            //recuperar o carrinho do usuario
            HttpSession sessao = request.getSession(false);
            if(sessao == null) {
                request.getRequestDispatcher("index.html").forward(request, response);
            }
            
            ArrayList<Integer> carrinho= (ArrayList<Integer>) sessao.getAttribute("carr");
            
            
            int numeroAleatorio = new Random().nextInt(5);
            
            
            
            //se nao existir carrinho, criar um
            if(carrinho == null){
                carrinho = new ArrayList<Integer>();
            }
            
             //Descobrir o id do produto
            int id = Integer.parseInt(request.getParameter("idprod"));
           
            // adicionar o id no carrinho
            carrinho.add(id);
            
            //armazena o carrinho atualizado na sessao
            sessao.setAttribute("carr", carrinho);
            
            // exibir mensagem de sucesso
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet adicionarCarrinho</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Produto adicionado com sucesso...</h1>");
            out.println("<h2>Itens no carrinho:</h2>");
            
            for(Integer i : carrinho){
                out.println(i + "<br/>");
            }
            
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

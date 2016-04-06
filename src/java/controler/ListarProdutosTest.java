/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Catalogo;
import model.ClassificacaoProduto;
import model.Produto;

/**
 *
 * @author rafa
 */
public class ListarProdutosTest extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListarProdutosTest</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListarProdutosTest at " + request.getContextPath() + "</h1>");
            
            
            //Cria produtos falsos
            HashMap<Integer,Produto> lista = new HashMap<Integer,Produto>();
            Produto p1 = new Produto(1,"Prod1",ClassificacaoProduto.ADULTO);
            lista.put(1,p1);
            lista.put(2,new Produto(2,"Prod2",ClassificacaoProduto.ADULTO));
            lista.put(3,new Produto(3,"Prod3",ClassificacaoProduto.ADULTO));
            lista.put(4,new Produto(4,"Prod4",ClassificacaoProduto.IDOSO));
            lista.put(5,new Produto(5,"Prod5",ClassificacaoProduto.INFANTIL));
            lista.put(6,new Produto(6,"Prod6",ClassificacaoProduto.IDOSO));
            lista.put(7,new Produto(7,"Prod7",ClassificacaoProduto.INFANTIL));
            lista.put(8,new Produto(8,"Prod8",ClassificacaoProduto.INFANTIL));
            lista.put(9,new Produto(9,"Prod9",ClassificacaoProduto.ADULTO));
            lista.put(10,new Produto(10,"Prod10",ClassificacaoProduto.IDOSO));
            
            
            Catalogo catalogo = new Catalogo();
            catalogo.setLista(lista);
            
            out.println("Todos:<br/>");
            
            
            ArrayList<Produto> l = catalogo.listarProdutos();
            for (Produto p : l) {
                out.println("-" + p.getNome() + "(" + p.getTipo().toString() + ") <br/>");
            }
            out.println("--<br/>");
            for(ClassificacaoProduto c : ClassificacaoProduto.values()){
                out.println(c.toString() + "<br/>");
                for (Produto produto : catalogo.listarProdutos(c)) {
                    out.println("-" + produto.getNome() + "(" + produto.getTipo().toString() + ") <br/>");
                }
                out.println("--<br/>");
            }
            
            
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
        processRequest(request, response);
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

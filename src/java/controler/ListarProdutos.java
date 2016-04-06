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
                       + " anos. <br/>");
               
               Catalogo cat = new Catalogo();
               cat.setLista(lista);
               
               
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

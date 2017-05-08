/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HP
 */
@WebServlet(urlPatterns = {"/game", "/UpdateGame"})
public class GameHandler extends HttpServlet {

    final board board = new board();
    final players players = new players();
    private int count = 1;

    @Override
    public void init(final ServletConfig config) {
        
        Logger.getGlobal().log(Level.INFO, "Started stock price updates");
    }

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
        /* response.setContentType("text/event-stream;charset=UTF-8");
         PrintWriter out = response.getWriter();
         /* TODO output your page here. You may use following sample code. */
        /* String str = "{ \"DOTS\": [ [\"B\", 5, 6], [\"G\", 23, 12], [\"R\", 34, 7], [\"B\", 25, 8], [\"G\", 28, 1], [\"R\", 42, 17],  [\"B\", 15, 36], [\"G\", 22, 22], [\"R\", 5, 37], [\"B\", 25, 28], [\"G\", 9, 39], [\"R\", 10, 21]  ], \"PLAYERS\": [[\"P1\", 8, 0, 0], [\"P2\", 5, 44, 0], [\"P3\", -6, 0, 44], [\"P4\", 10, 44, 44]] }";
         out.println("data: " + str);
         out.println();
         out.flush();*/

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
        response.setContentType("text/event-stream;charset=UTF-8");

        HttpSession session = request.getSession();
        if (session.getAttribute("player") == null) {
            try {
                session.setAttribute("player", "P" + count);
                count += 1;
            } catch (Exception ex) {
                //Logger.getLogger(AddressBookServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            //book=(AddressBook) session.getAttribute("Addbook");
        }

        try (final PrintWriter out = response.getWriter()) {
            while (!Thread.interrupted()) {
                synchronized (board) {
                    // board board1=board;
                    // players players1=players;
                    String board1 = board.toString();
                    String players1 = players.toString();

                    String str = board1 + "," + players1;

                    Logger.getGlobal().log(Level.INFO, str);

                    out.println("data: " + str);
                    out.println();
                    out.flush();
                    board.wait();
                }
            }
        } catch (InterruptedException e) {
            throw new ServletException(e);
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

        //processRequest(request, response);
        HttpSession session = request.getSession();
        if (session.getAttribute("player") == null) {
            try {
                session.setAttribute("player", "P" + count);
                count += 1;
            } catch (Exception ex) {
                //Logger.getLogger(AddressBookServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            //book=(AddressBook) session.getAttribute("Addbook");
        }
        synchronized (board) {
            
            String pl = (String) session.getAttribute("player");

            String key = request.getParameter("keypress");
            //        System.out.println(key);
            Logger.getGlobal().log(Level.INFO, "key pressed "+key+" "+pl);
            
            players.update(pl, key);
            board.notifyAll();
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nouni.tuto.simulateurcredit.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nouni.tuto.simulateurcredit.metier.SimulateurCredit;
import nouni.tuto.simulateurcredit.metier.SimulateurCreditImp;

/**
 *
 * @author HP
 */
public class SimultateurCtrServlet extends HttpServlet {

    protected SimulateurCredit simulateur;
    
    public SimultateurCtrServlet() {
        simulateur = new SimulateurCreditImp();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("model", new SimulationDataModel(200000,240,4.5));
        req.getRequestDispatcher("pages/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SimulationDataModel model = new SimulationDataModel();
        model.fillFrom(req);
        model.setMensualite(simulateur.calculer(model.getMontant(), model.getDuree(), model.getTaux()));
        req.setAttribute("model", model);
        req.getRequestDispatcher("pages/form.jsp").forward(req, resp);
    }
    
    
}

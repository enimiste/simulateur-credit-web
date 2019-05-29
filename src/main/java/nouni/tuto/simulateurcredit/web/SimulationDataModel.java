/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nouni.tuto.simulateurcredit.web;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author HP
 */
public class SimulationDataModel {

    private double montant;
    private int duree;
    private double taux;
    private double mensualite;
    private double surPlus;//par rapport au capital initial
    private double surPlusRapport;//%
    private boolean calculDone;
    private String error;
    private boolean hasError;

    public SimulationDataModel() {
    }

    public SimulationDataModel(double montant, int duree, double taux) {
        this.montant = montant;
        this.duree = duree;
        this.taux = taux;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    public double getMensualite() {
        return mensualite;
    }

    public void setMensualite(double mensualite) {
        this.mensualite = mensualite;
        setCalculDone(true);
    }

    public double getSurPlus() {
        return mensualite * duree - montant;
    }
    
    public double getSurPlusRapport() {
        return montant == 0 ? 0 : getSurPlus()/montant;
    }

    public boolean isCalculDone() {
        return calculDone;
    }

    public void setCalculDone(boolean calculDone) {
        this.calculDone = calculDone;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public boolean hasError() {
        return hasError;
    }

    public void setHasError(boolean hasError) {
        this.hasError = hasError;
    }

    /**
     *
     * @param req
     */
    void fillFrom(HttpServletRequest req) {
        String ms = req.getParameter("montant"), ds = req.getParameter("duree"), ts = req.getParameter("taux");
        try {
            montant = Double.parseDouble(ms);
            taux = Double.parseDouble(ts);
            duree = Integer.parseInt(ds, 10);
        } catch (NumberFormatException e) {
            error = "Format des données saisies est invalid";
            hasError = true;
        }
    }

}

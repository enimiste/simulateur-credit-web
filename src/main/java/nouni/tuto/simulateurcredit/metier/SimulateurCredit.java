/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nouni.tuto.simulateurcredit.metier;

/**
 *
 * @author HP
 */
public interface SimulateurCredit {
    /**
     * 
     * @param montant
     * @param duree
     * @param taux
     * @return 
     */
    public double calculer(double montant, int duree, double taux);
}

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
public class SimulateurCreditImp implements SimulateurCredit {

    @Override
    public double calculer(double montant, int duree, double taux) {
        taux = taux / 100;
        return (montant * taux / 12) / (1 - Math.pow(1 + taux / 12, -duree));
    }

}

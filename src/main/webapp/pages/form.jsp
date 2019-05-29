<%-- 
    Document   : form
    Created on : 29 mai 2019, 00:05:29
    Author     : HP
--%>

<%@page import="nouni.tuto.simulateurcredit.web.SimulationDataModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    SimulationDataModel model = (SimulationDataModel) request.getAttribute("model");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simulateur</title>
    </head>
    <body>
        <h1>Saisir les informations relatives á votre crédit pour faire la simulation :</h1>
        <div style='color:red;display: <%= model.hasError() ? "block" : "none"%>'>
            <%= model.getError()%>
        </div>
        <fieldset>
            <legend>Formulaire</legend>
            <form method="POST" action="<%= request.getContextPath() + "/calculer.do"%>">
                <table>
                    <tr>
                        <td>Montant :</td>
                        <td><input type="number" name="montant" min="0" value="<%= model.getMontant()%>"/></td>
                        <td>DH</td>
                    </tr>
                    <tr>
                        <td>Durée :</td>
                        <td><input type="number" name="duree" min="1" value="<%= model.getDuree()%>"/></td>
                        <td>Mois</td>
                    </tr>
                    <tr>
                        <td>taux :</td>
                        <td><input type="number" step="any" name="taux" min="0.01" max="100" value="<%= model.getTaux()%>"/></td>
                        <td>%</td>
                    </tr>
                    <tr>
                        <td colspan="3"><button type="submit">Calculer</button></td>
                    </tr>
                </table>
            </form>
        </fieldset>
        <fieldset style='display: <%= model.isCalculDone() ? "block" : "none"%>'>
            <legend>Résultat</legend>
            <p>Mensulaité de <strong><%= String.format("%.2f", model.getMensualite())%> DH/mois</strong> 
                et un surplus par rapport au capital de <strong><%= String.format("%.2f", model.getSurPlus())%> DH</strong>
                (<%= String.format("%.2f", model.getSurPlusRapport() * 100)%>% du montant initial).</p>
        </fieldset>
    </body>
</html>

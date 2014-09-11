/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bdclass;

/**
 * 
 * Classe Objet faisant le lien avec la table Docteur
 * 
 * @author kocupyr
 */
public class Docteur {
    
    /**
     * 
     * variable de la classe Docteur
     * 
     */
    Employe numero;
    String specialite;

    /**
     * 
     * Getter/Setter de la classe Docteur
     * 
     */
    
    /**
     *  renvoie l'Employe lié au docteur
     * @return Employe - L'Employe lié au docteur
     */
    public Employe getNumero() {
        return numero;
    }

    /**
     * Modifie l'Employe lié au docteur avec le parametre
     * @param numero
     */
    public void setNumero(Employe numero) {
        this.numero = numero;
    }

    /**
     * renvoie la spécialité
     * @return String - La Spécialité
     */
    public String getSpecialite() {
        return specialite;
    }

    /**
     * Modifie la Spécialité du Docteur avec le parametre
     * @param specialite
     */
    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
    
}

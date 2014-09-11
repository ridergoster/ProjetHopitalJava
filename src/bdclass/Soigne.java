/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bdclass;

/**
 *
 * Classe Objet faisant le lien avec la table Soigne
 * 
 * @author kocupyr
 */
public class Soigne {
    
    /**
     * 
     *  variable de la classe Soigne
     * 
     */
    Docteur no_docteur;
    Malade no_malade;

    /**
     * 
     *  Getter/Setter de la classe Soigne
     * 
     */
    
    /**
     * renvoie le docteur en soin
     * @return Docteur - Docteur lié au Soin
     */
    public Docteur getNo_docteur() {
        return no_docteur;
    }

    /**
     *
     * Modifie le Docteur lié au Soin
     * @param no_docteur
     */
    public void setNo_docteur(Docteur no_docteur) {
        this.no_docteur = no_docteur;
    }

    /**
     * renvoie le malade en soin
     * @return Malade - Malade en Soin
     */
    public Malade getNo_malade() {
        return no_malade;
    }

    /**
     * Modifie le Malade lié au Soin
     * @param no_malade
     */
    public void setNo_malade(Malade no_malade) {
        this.no_malade = no_malade;
    }
}

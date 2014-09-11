/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bdclass;

/**
 *
 * Classe Objet faisant le lien avec la table Chambre
 * 
 * @author kocupyr
 */
public class Chambre {
    
    
    /**
     * 
     *  variable de la classe Chambre
     * 
     */
    int no_chambre;
    Service code_service;
    int surveillant;
    int nb_lits;
    
    
    /**
     * 
     *  Getter/Setter de la classe Chambre
     *
     */
    
    /**
     * renvoie le Numéro de Chambre
     * @return int - Numéro de Chambre
     * 
     */
    public int getNo_chambre() {
        return no_chambre;
    }

    /**
     * 
     * Modifie le Numéro de Chambre avec le parametre
     * @param no_chambre
     * 
     */
    public void setNo_chambre(int no_chambre) {
        this.no_chambre = no_chambre;
    }

    /**
     * renvoie le service lié à la Chambre
     * @return Service - Le service lié à la Chambre
     * 
     */
    public Service getCode_service() {
        return code_service;
    }

    /**
     * Modifie le Service lié avec un autre Service en parametre
     * @param code_service
     * 
     */
    public void setCode_service(Service code_service) {
        this.code_service = code_service;
    }

    /**
     * renvoie le Surveillant
     * @return int - Surveillant
     * 
     */
    public int getSurveillant() {
        return surveillant;
    }

    /**
     * Modifie le Surveillant avec le parametre
     * @param surveillant
     * 
     */
    public void setSurveillant(int surveillant) {
        this.surveillant = surveillant;
    }

    /**
     * renvoie le Nombre de lits
     * @return int - Nombre de Lits
     * 
     */
    public int getNb_lits() {
        return nb_lits;
    }

    /**
     * Modifie le Nombre de lits avec le parametre
     * @param nb_lits
     * 
     */
    public void setNb_lits(int nb_lits) {
        this.nb_lits = nb_lits;
    }

}

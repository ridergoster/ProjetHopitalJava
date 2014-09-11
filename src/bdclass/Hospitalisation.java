/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bdclass;

/**
 *
 * Classe Objet faisant le lien avec la table Hospitalisation
 * 
 * @author kocupyr
 */
public class Hospitalisation {
    
    /**
     * 
     *  variable de la classe Hospitalisation
     * 
     */
    Malade no_malade;
    Service code_service;
    Chambre no_chambre;
    int lit;

    /**
     * 
     *  Getter/Setter de la classe Employe
     *  
     */
    
    /**
     * renvoie le malade lié a l'hospitalisation
     * @return Malade - Malade lié a l'hospitalisation
     */
    public Malade getNo_malade() {
        return no_malade;
    }

    /**
     * Modifie le malade lié à cette hospitalisation
     * @param no_malade
     */
    public void setNo_malade(Malade no_malade) {
        this.no_malade = no_malade;
    }

    /**
     * renvoie le service lié à l'hospitalisation
     * @return Service - Service lié à l'hospitalisation
     */
    public Service getCode_service() {
        return code_service;
    }

    /**
     * Modifie le service lié à cette hospitalisation
     * @param code_service
     */
    public void setCode_service(Service code_service) {
        this.code_service = code_service;
    }

    /**
     * renvoie la chambre lié à l'hospitalisation
     * @return Chambre - Chambre lié à l'hospitalisation
     * 
     */
    public Chambre getNo_chambre() {
        return no_chambre;
    }

    /**
     * Modifie la Chambre lié à cette hospitalisation
     * @param no_chambre
     */
    public void setNo_chambre(Chambre no_chambre) {
        this.no_chambre = no_chambre;
    }

    /**
     * renvoie le numéro du lit
     * @return int - numéro du lit
     */
    public int getLit() {
        return lit;
    }

    /**
     * Modifie le numéro du lit de l'hospitalisation
     * @param lit
     */
    public void setLit(int lit) {
        this.lit = lit;
    }
    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bdclass;

/**
 *
 * Classe Objet faisant le lien avec la table Infirmier
 * 
 * @author kocupyr
 */
public class Infirmier {
    
    /**
     * 
     *  variable de la classe Employe
     * 
     */
    Employe numero;
    Service code_service;
    String rotation;
    int salaire;

    /**
     * 
     *  Getter/Setter de la classe Infirmier
     * 
     */
    
    /**
     * renvoie le l'Employe lié à l'infirmier
     * @return Employe - Employe lié à l'infirmier
     */
    public Employe getNumero() {
        return numero;
    }

    /**
     * Modifie l'employé lié avec le parametre
     * @param numero
     */
    public void setNumero(Employe numero) {
        this.numero = numero;
    }

    /**
     * renvoie le service lié avec l'infirmier
     * @return Service - Service lié avec l'infirmier
     */
    public Service getCode_service() {
        return code_service;
    }

    /**
     * Modifie le Service lié avec le parametre
     * @param code_service
     */
    public void setCode_service(Service code_service) {
        this.code_service = code_service;
    }

    /**
     * renvoie la rotation
     * @return String - Rotation (JOUR/NUIT)
     */
    public String getRotation() {
        return rotation;
    }

    /**
     * Modifie la rotation avec le parametre (JOUR/NUIT)
     * @param rotation
     */
    public void setRotation(String rotation) {
        this.rotation = rotation;
    }

    /**
     * renvoie le salaire
     * @return int - Salaire
     * 
     */
    public int getSalaire() {
        return salaire;
    }

    /**
     * Modifie le salaire de l'infirmier
     * @param salaire
     */
    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }  
}

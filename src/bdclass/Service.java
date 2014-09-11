/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bdclass;

/**
 *
 * Classe Objet faisant le lien avec la table Service
 * 
 * @author kocupyr
 */
public class Service {
    
    /**
     * 
     * variable de la classe Service
     * 
     */
    String code;
    String nomserv;
    char batiment;
    int directeur;

    
    /**
     * 
     * Getter/Setter de la classe Service
     * 
     */
    
    /**
     *  Modifie le code du service avec le parametre
     * @param code 
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Modifie le nom du service avec le parametre
     * @param nomserv
     */
    public void setNomserv(String nomserv) {
        this.nomserv = nomserv;
    }

    /**
     * Modifie le batiment du service avec le parametre
     * @param batiment
     */
    public void setBatiment(char batiment) {
        this.batiment = batiment;
    }

    /**
     * Modifie le directeur avec le parametre
     * @param directeur
     * 
     */
    public void setDirecteur(int directeur) {
        this.directeur = directeur;
    }

    /**
     * renvoie le code du service
     * @return String - Code du service
     * 
     */
    public String getCode() {
        return code;
    }

    /**
     * renvoie le nom du service
     * @return String - Nom du Service
     * 
     */
    public String getNomserv() {
        return nomserv;
    }

    /**
     * renvoie la lettre du batiment
     * @return Char - Batiment
     * 
     */
    public char getBatiment() {
        return batiment;
    }

    /**
     * renvoie le numéro du directeur
     * @return int - Directeur
     * 
     */
    public int getDirecteur() {
        return directeur;
    }
    
}

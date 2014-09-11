/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bdclass;

/**
 *
 * Classe Objet faisant le lien avec la table Employe
 * 
 * @author kocupyr
 */
public class Employe {
    
    /**
     * 
     *  variable de la classe Employe
     * 
     */
    int numero;
    String nom;
    String prenom;
    String tel;
    String adr;

    /**
     * 
     *  Getter/Setter de la classe Employe
     * 
     */
    
    /**
     * renvoie le numéro de l'employe
     * @return int - Numéro de l'employe
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Modifie le numéro de l'employe avec le parametre
     * @param numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * renvoie le nom
     * @return String - Nom de l'employe
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifie le nom de l'employe avec le parametre
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * renvoie le prenom
     * @return String - Prenom de l'employe
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Modifie le prenom de l'employe avec le parametre
     * @param prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * renvoie le téléphone
     * @return String - Téléphone de l'employe
     */
    public String getTel() {
        return tel;
    }

    /**
     * Modifie le téléphone de l'employe avec le parametre
     * @param tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * renvoie l'adresse
     * @return String - Adresse de l'employe
     * 
     */
    public String getAdr() {
        return adr;
    }

    /**
     * Modifie l'adresse de l'employe avec le parametre 
     * @param adr
     * 
     */
    public void setAdr(String adr) {
        this.adr = adr;
    }
}

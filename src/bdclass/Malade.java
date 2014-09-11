/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bdclass;

/**
 *
 * Classe Objet faisant le lien avec la table Malade
 * 
 * @author kocupyr
 */
public class Malade {
    
    /**
     * 
     *  variable de la classe Malade
     * 
     */
    int numero;
    String nom;
    String prenom;
    String tel;
    String adr;
    String mutuelle;

    
    /**
     * 
     *  Getter/Setter de la classe Malade
     * 
     */
    
    /**
     * renvoie le numéro du malade
     * @return int - numéro du malade
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Modifie le numéro du malade avec le parametre
     * @param numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * renvoie le nom
     * @return String - Nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifie le nom avec le parametre
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * renvoie le prenom
     * @return String - Prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Modifie le prénom avec le parametre
     * @param prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * renvoie le téléphone
     * @return String - Téléphone
     */
    public String getTel() {
        return tel;
    }

    /**
     * Modifie le téléphone avec le parametre
     * @param tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * renvoie l'adresse
     * @return String - Adresse
     */
    public String getAdr() {
        return adr;
    }

    /**
     * Modifie l'adresse avec le parametre
     * @param adr
     */
    public void setAdr(String adr) {
        this.adr = adr;
    }

    /**
     * renvoie la mutuelle
     * @return String - Mutuelle
     */
    public String getMutuelle() {
        return mutuelle;
    }

    /**
     * Modifie la mutuelle avec le parametre
     * @param mutuelle
     * 
     */
    public void setMutuelle(String mutuelle) {
        this.mutuelle = mutuelle;
    }
}

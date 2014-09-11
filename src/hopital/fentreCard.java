/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hopital;

import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 * Fenetre fentreCard - Fenetre utilisé pour toute l'application. On va changer
 * son contenu pour naviguer sur les différentes page.
 * @author youenlecloirec
 */
public class fentreCard {
    public static JPanel fentre;
    
    /**
     * Constructeur de fentreCard
     */
    public fentreCard(){
        fentre = new JPanel();
        fentre.setLayout(new CardLayout());
    }
    
    /**
     * Ajoute une fenetre (pan) avec un nom (name) dans notre List de fenetre
     * @param name
     * @param pan
     */
    public static void add(String name, JPanel pan){
        fentre.add(name,pan);
    }
    
    /**
     * On Change l'affichage pour afficher la fenetre avec le nom en parametre
     * @param name
     */
    public static void show(String name){
        ((CardLayout)fentre.getLayout()).show(fentre,name);
    }
    
    /**
     *Renvoie la Fenetre
     * @return JPanel - fentre
     */
    public static JPanel getFen(){
        return fentre;
    }

}

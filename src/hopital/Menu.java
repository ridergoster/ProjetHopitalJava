/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hopital;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lib.img;



/**
 * Fenetre du Menu. affichage après la connexion pour choisir quoi faire
 * dans l'application.
 * @author youenlecloirec
 * 
 */
public class Menu extends JFrame implements ActionListener {
JButton recherche;
JButton histo;
JButton maj;
JButton quitter;
  
    /**
     * Constructeur de Menu
     * @param titre
     * @throws IOException
     */
    public Menu(String titre) throws IOException{
        setTitle(titre);
        setSize(1200,800);
        InputStream input = img.class.getResourceAsStream("med.jpg");
        JPanel panneau=new PanelImage(input);
        //panneau.setOpaque(false);

        
        panneau.setLayout(null);


        recherche=new JButton ("Rechercher");
        recherche.setBounds(350,220,500,70);
        recherche.setBackground(Color.BLACK);
        recherche.setOpaque(false);
        panneau.add(recherche);
        
      
        histo=new JButton ("Historisation");
        histo.setBounds(350,320,500,70);
        panneau.add(histo);
    
        maj=new JButton ("Ajouter");
        maj.setBounds(350,420,500,70);
        panneau.add(maj);
       
        quitter=new JButton("Quitter le programme");
        
        quitter.setBounds(520,700,160,40);
        
        quitter.setForeground(Color.red);
         panneau.add(quitter);
        
        recherche.addActionListener(this);
        histo.addActionListener(this);
        maj.addActionListener(this);
        quitter.addActionListener(this);
        
        fentreCard.add("Menu",panneau);
       // this.add(fentreCard.getFen());
        
       fentreCard.show("Menu");
        setVisible(false);
    }
    
    
    @Override
 public void actionPerformed(ActionEvent event){
     
     if(event.getSource()==recherche){
         try {                  
             Recherche f = new Recherche("Recherche");
         } catch (IOException ex) {
             Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
         }
         
        
        
         fentreCard.show("Recherche");
         this.setTitle("Recherche");
     }
     else if(event.getSource()==histo){
         try {
             Historisation h = new Historisation("Historisation");
         } catch (IOException ex) {
             Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
         }
        fentreCard.show("Historisation");
        this.setTitle("Historisation");
     }
     else if(event.getSource()==maj){
        try {
             try {
                 Ajouter m = new Ajouter("MAJ");
             } catch (SQLException ex) {
                 Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
             }
         } catch (IOException ex) {
             Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
         }
        fentreCard.show("MAJ");
     }
     else if (event.getSource()==quitter){
                this.dispose();
                System.exit(0);
     }
 }   
}



        
    
    
   

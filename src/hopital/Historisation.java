/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hopital;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import lib.img;

/**
 * Fenetre d'Historisation. Menu de l'historisation ou on peut selectionner
 * RDV ou Operation.
 * @author youenlecloirec
 */
public class Historisation extends JFrame implements ActionListener {
JButton rdv;
JButton operation;
JButton exit;

    /**
     * Constructeur de Historisation
     * @param titre
     * @throws IOException
     */
    public Historisation(String titre) throws IOException {
        setTitle(titre);
        InputStream input = img.class.getResourceAsStream("med.jpg");
        JPanel panneau=new PanelImage(input);
        panneau.setLayout(null);
        setSize(400,300);

        
        
        rdv=new JButton ("RDV");
        rdv.setBounds(350,280,500,70);
        //rdv.setOpaque(false);
        //rdv.setContentAreaFilled(false);
        //rdv.setBorderPainted(false);
        panneau.add(rdv);
      
        operation=new JButton ("Opération");
        operation.setBounds(350,380,500,70);
        panneau.add(operation);
        
        exit=new JButton("Retour");
        exit.setBounds(500,700,200,40);
        exit.setForeground(Color.red);
        panneau.add(exit);
        
        
        
        exit.addActionListener(this);
        rdv.addActionListener(this);
        operation.addActionListener(this);

        //conteneur.add(panneau);
        fentreCard.add("Historisation", panneau);
        setVisible(false);
        
    }
    
    
@Override
 public void actionPerformed(ActionEvent event){
     if(event.getSource()==rdv){
         try {
             RDV r = new RDV("RDV");
         } catch (IOException ex) {
             Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
         }
        fentreCard.show("RDV");
         
     }
     else if(event.getSource()==operation){
            try {
             Operation o = new Operation("Operation");
         } catch (IOException ex) {
             Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
         }
        fentreCard.show("Operation");
        this.setTitle("Operation");
            }
     
     else if (event.getSource()==exit){
        fentreCard.show("Menu"); 
        this.setTitle("Menu");
     }

 }     
    

}

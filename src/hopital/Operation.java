package hopital;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import lib.img;


/**
 * Fenetre Operation. Permet de sauvegardé des Opérations avec un formulaire
 * contenant des éléments pré-défini.
 * @author youenlecloirec
 */
public class Operation extends JFrame implements ActionListener {
JLabel medecin;
JComboBox med;
JLabel patient;
JComboBox pat;
JLabel chambre;
JTextField chamb;
JLabel date;
JTextField dat;
JTextField notes;
JButton exit;
JButton save;

JLabel JJ;
JComboBox JJJ;
JLabel MM;
JComboBox MMM;
JLabel AA;
JComboBox AAA;
JTextField medecine,patiente;

    /**
     *
     * @param titre
     * @throws IOException
     */
    public Operation(String titre) throws IOException{
        setTitle(titre);
        InputStream input = img.class.getResourceAsStream("med.jpg");
        JPanel panneau=new PanelImage(input);
       panneau.setLayout(null);
       setSize(1200,800);
       
    
        
        
        medecin=new JLabel("Médecin");
        medecin.setBounds(30,26,300,104);
        panneau.add(medecin);
        
        med=new JComboBox() ;
        med.setBounds(210,26,435,104);
        panneau.add(med);
        
        medecine=new JTextField();
        medecine.setBounds(645,56,555,39);
        panneau.add(medecine);
        
        patient=new JLabel("Patient");
        patient.setBounds(30,130,300,104);
        panneau.add(patient);
        
        pat=new JComboBox();
        pat.setBounds(210,130,435,104);
        panneau.add(pat);
        
        patiente=new JTextField();
        patiente.setBounds(645,160,555,39);
        panneau.add(patiente);
        
        chambre=new JLabel("Chambre");
        chambre.setBounds(30,234,300,104);
        panneau.add(chambre);
        
        chamb=new JTextField("N° Chambre");
        chamb.setBounds(210,269,300,39);
        panneau.add(chamb);
        
        JJ=new JLabel("JJ");
        JJ.setBounds(90,338,150,104);
        panneau.add(JJ);
        
        JJJ=new JComboBox();
        JJJ.setBounds(180,338,150,104);
        panneau.add(JJJ);
        
        MM=new JLabel("MM");
        MM.setBounds(390,338,150,104);
        panneau.add(MM);
        
        MMM=new JComboBox();
        MMM.setBounds(510,338,150,104);
        panneau.add(MMM);
        
        AA=new JLabel("AAAA");
        AA.setBounds(705,338,150,104);
        panneau.add(AA);
        
        AAA=new JComboBox();
        AAA.setBounds(855,338,150,104);
        panneau.add(AAA);
        
        notes=new JTextField("Notes ...");
        notes.setBounds(0,442,1200,182);
        panneau.add(notes);
       
        exit=new JButton("Quitter");
        panneau.add(exit);
        exit.setBounds(630,650,240,52);
        exit.setForeground(Color.RED);
        exit.addActionListener(this);
        
        save=new JButton("sauvegarder");
        save.setBounds(330,650,240,52);
        save.setForeground(Color.GREEN);
        panneau.add(save);
        save.addActionListener(this);
        
        
        fentreCard.add("Operation", panneau);
        setVisible(false);
    }
    
    
   @Override
 public void actionPerformed(ActionEvent event){
     
     if(event.getSource()==med){
        
     }
     else if(event.getSource()==pat){
         
     }
     else if(event.getSource()==date){
         
     }
     else if(event.getSource()==notes){
         
     }
     else if(event.getSource()==exit){
         fentreCard.show("Historisation");
         this.setTitle("Historisation");
     }
        }
     
 }

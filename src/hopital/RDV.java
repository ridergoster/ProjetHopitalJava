package hopital;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import lib.img;


/**
 * Fenetre RDV.Un formulaire permet de remplie un RDV pour le sauvegardé 
 * selon différents critère.
 * @author youenlecloirec
 */
public class RDV extends JFrame implements ActionListener {
JLabel medecin;
JComboBox med;
JLabel patient;
JComboBox pat;
JLabel JJ;
JComboBox JJJ;
JLabel MM;
JComboBox MMM;
JLabel AA;
JComboBox AAA;
JTextField notes;
JButton exit,save;
JTextField medecine,patiente;

    /**
     * Constructeur de RDV
     * @param titre
     * @throws IOException
     */
    public RDV(String titre) throws IOException{
        setTitle(titre);
        InputStream input = img.class.getResourceAsStream("med.jpg");
        JPanel panneau=new PanelImage(input);
        panneau.setLayout(null);
        setSize(400,300);
       
   
        
        
        
        medecin=new JLabel("Médecin");
        medecin.setBounds(30,26,300,104);
        panneau.add(medecin);
        
        med=new JComboBox() ;
        med.setBounds(210,26,435,104);
        panneau.add(med);
        
        medecine=new JTextField();
        medecine.setBounds(645,36,555,78);
        panneau.add(medecine);
        
        patient=new JLabel("Patient");
        patient.setBounds(30,156,300,104);
        panneau.add(patient);
        
        pat=new JComboBox();
        pat.setBounds(210,156,435,104);
        panneau.add(pat);
        
        patiente=new JTextField();
        patiente.setBounds(645,166,555,78);
        panneau.add(patiente);
        
        JJ=new JLabel("JJ");
        JJ.setBounds(90,286,150,104);
        JJ.setBackground(Color.lightGray);
       // JJ.setOpaque(true);
        panneau.add(JJ);
        
        JJJ=new JComboBox();
        JJJ.setBounds(180,286,150,104);
        panneau.add(JJJ);
        
        for(int i =0; i < 32; i++){
            JJJ.insertItemAt(i,i);
        }
        
        MM=new JLabel("MM");
        MM.setBounds(390,286,150,104);
        MM.setBackground(Color.lightGray);
        //MM.setOpaque(true);
        panneau.add(MM);
        
        MMM=new JComboBox();
        MMM.setBounds(510,286,150,104);
        panneau.add(MMM);
        
        for(int j =0; j < 13; j++){
            MMM.insertItemAt(j,j);
        }
        
        AA=new JLabel("AAAA");
        AA.setBounds(705,286,150,104);
        AA.setBackground(Color.lightGray);
        //AA.setOpaque(true);
        panneau.add(AA);
        
        AAA=new JComboBox();
        AAA.setBounds(855,286,150,104);
        panneau.add(AAA);
        
       for(int k =0; k < 120; k++){
            AAA.insertItemAt(1900+k,k);
        }

        notes=new JTextField("Notes ...");
        notes.setBounds(0,416,1200,208);
        panneau.add(notes);
        
        exit=new JButton("Quitter");
        exit.setBounds(630,650,240,50);
        exit.addActionListener(this); 
        exit.setForeground(Color.red);
        panneau.add(exit);
        
        save=new JButton("sauvegarder");
        save.setBounds(330,650,240,50);
        save.addActionListener(this);
        save.setForeground(Color.GREEN);
        panneau.add(save);
       
        fentreCard.add("RDV", panneau);
        setVisible(false);
    }
    
    
   @Override
 public void actionPerformed(ActionEvent event){
     
     if(event.getSource()==med){
        
     }
     else if(event.getSource()==pat){
         
     }
     else if(event.getSource()==JJ){
         
     }
     else if(event.getSource()==notes){
         
     }
     else if(event.getSource()==exit){
         fentreCard.show("Historisation");
         this.setTitle("Historisation");
     }
        }
     
 }   
   
    
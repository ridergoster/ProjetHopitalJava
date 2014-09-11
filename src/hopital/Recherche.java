package hopital;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import jobpackage.JobChambre;
import jobpackage.JobDocteur;
import jobpackage.JobEmploye;
import jobpackage.JobHospitalisation;
import jobpackage.JobInfirmier;
import jobpackage.JobMalade;
import jobpackage.JobService;
import jobpackage.JobSoigne;
import lib.img;


/**
 * Fenetre Recherche. Affiche le menu de recherche ou on peut choisir
 * différentes table et attribut pour effectuer une recherche
 * @author youenlecloirec
 */
public class Recherche extends JFrame implements ActionListener {

JLabel rechercheDesire,explication,rech1,rech2,rech3;
JTextField recherche1;
JTextField recherche2;
JTextField recherche3;
JButton exit, valider;
JComboBox rechercheDesireBox,result1,result2,result3;

    private int switchcherche;

    /**
     * Constructeur de recherche
     * @param titre
     * @throws IOException
     */
    public Recherche (String titre) throws IOException{
        setTitle(titre);
       // Container conteneur=this.getContentPane();
       // conteneur.setLayout(new BorderLayout(2,1));
        switchcherche = 0;
        setSize(1200,800);
        InputStream input = img.class.getResourceAsStream("med.jpg");
        JPanel panneau=new PanelImage(input);
        panneau.setLayout(null);
        
       // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        String[] typeRecherche = {"Docteur", "Malade","Chambre","Employe","Infirmier","Service","Hospitalisation","Soigne"};
        
    
    
        rechercheDesire=new JLabel();
        rechercheDesire.setText("                               Selectionner une table :");
        rechercheDesire.setBounds(400,120,400,40);
        rechercheDesire.setBackground(Color.lightGray);
        rechercheDesire.setOpaque(true);
        panneau.add(rechercheDesire);
        
        rechercheDesireBox=new JComboBox();
        for(int i =0; i < typeRecherche.length; i++){
            rechercheDesireBox.insertItemAt(typeRecherche[i], i);
        }
        rechercheDesireBox.setBounds(400,160,400,80);
        panneau.add(rechercheDesireBox);
        
        explication=new JLabel();
       explication.setBounds(200,240,800,40);
       panneau.add(explication);
       explication.setBackground(Color.LIGHT_GRAY);
       explication.setOpaque(true);
       explication.setText("                                                    Pour tout afficher : ne rien saisir dans les lignes de recherche");
        
        rech1=new JLabel();
        rech1.setBounds(200,300,200,50);
        rech1.setText("              Recherche 1");
        rech1.setBackground(Color.LIGHT_GRAY);
        rech1.setOpaque(true);
        panneau.add(rech1);
        
        recherche1=new JTextField ("");
        recherche1.setBounds(400,300,200,50);
        //this.add("South",result1);
        panneau.add(recherche1);
        
        result1=new JComboBox();
        result1.setBounds(600,300,400,50);
        panneau.add(result1);
       
       rech2=new JLabel();
       rech2.setBounds(200,370,200,50);
       rech2.setText("              Recherche 2");
       rech2.setBackground(Color.lightGray);
       rech2.setOpaque(true);
       panneau.add(rech2);
      
       recherche2=new JTextField ("");
       recherche2.setBounds(400,370,200,50);
       //this.add("South",result2);
       panneau.add(recherche2);
       
       result2=new JComboBox();
        result2.setBounds(600,370,400,50);
        panneau.add(result2);

       rech3=new JLabel();
       rech3.setBounds(200,440,200,50);
       rech3.setText("              Recherche 3");
       rech3.setBackground(Color.lightGray);
       rech3.setOpaque(true);
       panneau.add(rech3);
       
       recherche3=new JTextField ("");
       recherche3.setBounds(400,440,200,50);
       panneau.add(recherche3);
       
       result3=new JComboBox();
       result3.setBounds(600,440,400,50);
       panneau.add(result3);
       

       
       
        exit=new JButton("Retour");
        exit.setForeground(Color.red);
        exit.setBounds(430,700,160,40);
        
        valider=new JButton("Rechercher");
        //valider.setForeground(Color.green);
        valider.setBounds(610,700,160,40);
         panneau.add(valider);
         panneau.add(exit);
         
        rechercheDesireBox.addActionListener(this);
        recherche1.addActionListener(this);
        recherche2.addActionListener(this);
        recherche3.addActionListener(this);
        valider.addActionListener(this);
        exit.addActionListener(this);

       //  conteneur.add(panneau);
       fentreCard.add("Recherche", panneau);
        setVisible(false);
       
    }
    
    
@Override
 public void actionPerformed(ActionEvent event){
     
if(event.getSource().getClass()==JButton.class)
     {
        if(event.getSource()==exit){
            fentreCard.show("Menu"); 
        }
       if(event.getSource()== valider){
               try 
               {
                    
                    try 
                    {
                        String at1, re1, at2, re2, at3, re3;
                             re1 = recherche1.getText();
                             re2 = recherche2.getText();
                             re3 = recherche3.getText();
                             try{
                             at1 = result1.getSelectedItem().toString();
                             }
                             catch(Exception e){ at1 = "";}
                             try{
                             at2 = result2.getSelectedItem().toString();
                             }
                             catch(Exception e){ at2 = "";}
                             try{
                             at3 = result3.getSelectedItem().toString();
                             }
                             catch(Exception e){ at3 = "";}
                             
                        switch(switchcherche){
                        case 1:
                            RechercheTab r1 = new RechercheTab(JobDocteur.FindResult(at1, re1, at2, re2, at3, re3), 1);
                            break;
                        case 2:
                            RechercheTab r2 = new RechercheTab(JobMalade.FindResult(at1, re1, at2, re2, at3, re3), 2);
                            break;
                        case 3:
                            RechercheTab r3 = new RechercheTab(JobInfirmier.FindResult(at1, re1, at2, re2, at3, re3),3);
                            break;
                        case 4:
                            RechercheTab r4 = new RechercheTab(JobEmploye.FindResult(at1, re1, at2, re2, at3, re3),4);
                            break;
                        case 5:
                            RechercheTab r5 = new RechercheTab(JobHospitalisation.FindResult(at1, re1, at2, re2, at3, re3),5);
                            break;
                        case 6:
                            RechercheTab r6 = new RechercheTab(JobChambre.FindResult(at1, re1, at2, re2, at3, re3), 6);
                            break;
                        case 7:
                            RechercheTab r7 = new RechercheTab(JobService.FindResult(at1, re1, at2, re2, at3, re3), 7);
                            break;
                        case 8:
                            RechercheTab r8 = new RechercheTab(JobSoigne.FindResult(at1, re1, at2, re2, at3, re3), 8);
                            break;
                        default:
                            break;
                    
                        } 
                    }
                    catch (SQLException ex) 
                    {
                        Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
                    }
               } 
               catch (IOException ex) 
               {
                   Logger.getLogger(Recherche.class.getName()).log(Level.SEVERE, null, ex);
               }
               fentreCard.show("RechercheTab");
           }
     }
     
     else if(event.getSource().getClass()==JComboBox.class)
     {

        if("Docteur".equals((String)((JComboBox)event.getSource()).getSelectedItem())){
            String[] DocteurRecherche = {"Numero","Nom","Prenom","Adresse","Telephone","Specialite"};
           result1.removeAllItems();
           result2.removeAllItems();
           result3.removeAllItems();
           switchcherche=1;
            for(int i =0; i < DocteurRecherche.length; i++){
               result1.insertItemAt(DocteurRecherche[i], i);
               result2.insertItemAt(DocteurRecherche[i], i);
               result3.insertItemAt(DocteurRecherche[i], i);
           }
        }
        else if("Malade".equals((String)((JComboBox)event.getSource()).getSelectedItem())){
           String[] MaladeRecherche = {"Numero","Nom","Prenom","Telephone","Adresse","Mutuelle"};
           result1.removeAllItems();
           result2.removeAllItems();
           result3.removeAllItems();
           switchcherche=2;
           for(int i =0; i < MaladeRecherche.length; i++){
               result1.insertItemAt(MaladeRecherche[i], i);
               result2.insertItemAt(MaladeRecherche[i], i);
               result3.insertItemAt(MaladeRecherche[i], i);
           }
        }
        else if("Infirmier".equals((String)((JComboBox)event.getSource()).getSelectedItem())){
           String[] InfirmierRecherche ={"Numero","Nom","Prenom","Nom Service","Telephone","Adresse","Rotation"};        
           result1.removeAllItems();
           result2.removeAllItems();
           result3.removeAllItems();
           switchcherche=3;
           for(int i =0; i < InfirmierRecherche.length; i++){
               result1.insertItemAt(InfirmierRecherche[i], i);
               result2.insertItemAt(InfirmierRecherche[i], i);
               result3.insertItemAt(InfirmierRecherche[i], i);
           }
        }
        else if("Employe".equals((String)((JComboBox)event.getSource()).getSelectedItem())){
               String[] EmployeRecherche = {"Numero","Nom","Prenom","Telephone","Adresse"};        
               result1.removeAllItems();
               result2.removeAllItems();
               result3.removeAllItems();
               switchcherche=4;
               for(int i =0; i < EmployeRecherche.length; i++){
               result1.insertItemAt(EmployeRecherche[i], i);
               result2.insertItemAt(EmployeRecherche[i], i);
               result3.insertItemAt(EmployeRecherche[i], i);
           }
        }
        else if("Hospitalisation".equals((String)((JComboBox)event.getSource()).getSelectedItem())){
        String[] HospitalisationRecherche = {"Numero du Malade","Nom du Malade","Numero du Service","Nom du Service","Chambre","Numero du lit"};
           result1.removeAllItems();
           result2.removeAllItems();
           result3.removeAllItems();
           switchcherche=5;
        for(int i =0; i < HospitalisationRecherche.length; i++){
               result1.insertItemAt(HospitalisationRecherche[i], i);
               result2.insertItemAt(HospitalisationRecherche[i], i);
               result3.insertItemAt(HospitalisationRecherche[i], i);
           }
        }
        else if("Chambre".equals((String)((JComboBox)event.getSource()).getSelectedItem())){
           String[] ChambreRecherche = {"Numero Chambre","Surveillant","Nom Service","Nombres de lits"};
           result1.removeAllItems();
           result2.removeAllItems();
           result3.removeAllItems();
           switchcherche=6;
           for(int i =0; i < ChambreRecherche.length; i++){
               result1.insertItemAt(ChambreRecherche[i], i);
               result2.insertItemAt(ChambreRecherche[i], i);
               result3.insertItemAt(ChambreRecherche[i], i);
           }
        }
        else if("Service".equals((String)((JComboBox)event.getSource()).getSelectedItem())){
        String[] ServiceRecherche = {"Code du Service","Nom Service","Batiment","Directeur"};
           result1.removeAllItems();
           result2.removeAllItems();
           result3.removeAllItems();
           switchcherche=7;
        for(int i =0; i < ServiceRecherche.length; i++){
               result1.insertItemAt(ServiceRecherche[i], i);
               result2.insertItemAt(ServiceRecherche[i], i);
               result3.insertItemAt(ServiceRecherche[i], i);
           }

        }
        else if("Soigne".equals((String)((JComboBox)event.getSource()).getSelectedItem())){
        String[] SoigneRecherche = {"Numero du Docteur","Nom Docteur","Specialite du Docteur","Numero du Malade","Nom du Malade","Mutuelle"};
           result1.removeAllItems();
           result2.removeAllItems();
           result3.removeAllItems();
           switchcherche=8;
        for(int i =0; i < SoigneRecherche.length; i++){
               result1.insertItemAt(SoigneRecherche[i], i);
               result2.insertItemAt(SoigneRecherche[i], i);
               result3.insertItemAt(SoigneRecherche[i], i);
           }

        }
    }
}
    
     
}
package hopital;
import bdclass.Chambre;
import bdclass.Docteur;
import bdclass.Employe;
import bdclass.Infirmier;
import bdclass.Malade;
import bdclass.Service;
import daopackage.DAOChambre;
import daopackage.DAODocteur;
import daopackage.DAOEmploye;
import daopackage.DAOInfirmier;
import daopackage.DAOMalade;
import daopackage.DAOService;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;
import jobpackage.JobChambre;
import jobpackage.JobDocteur;
import jobpackage.JobEmploye;
import jobpackage.JobHospitalisation;
import jobpackage.JobInfirmier;
import jobpackage.JobMalade;
import jobpackage.JobService;
import jobpackage.JobSoigne;
import connexionpackage.Connexion;
import java.io.InputStream;
import lib.img;


/**
 * Fenetre d'Ajout dans la BD avec un menu changeant selon le type d'ajout
 * voulu. Le formulaire change de manière dynamique, et un contrôle est effectué
 * sur la validité des éléments.
 * @author youenlecloirec & Trask
 */
public class Ajouter extends JFrame implements ActionListener {

private final JTextField ajout1,ajout2,ajout3,ajout4,ajout5;
private final JComboBox box1,box2,box3,box4;
private final JLabel lab1,lab2,lab3,lab4,lab5;
private int var =0;

private final JButton exit,ajouter;

private final JComboBox type; 
private final JLabel table;

private final JLabel error;


        DAODocteur daodoc = new DAODocteur(Connexion.getInstance());
        DAOEmploye daoemp = new DAOEmploye(Connexion.getInstance());
        DAOService daosrv = new DAOService(Connexion.getInstance());
        DAOMalade daomal  = new DAOMalade(Connexion.getInstance());
        DAOChambre daoch  = new DAOChambre(Connexion.getInstance());
        DAOInfirmier daoinf = new DAOInfirmier(Connexion.getInstance());
        ArrayList<Docteur> listdoc = (ArrayList<Docteur>) daodoc.findAll();
        ArrayList<Employe> listemp = (ArrayList<Employe>) daoemp.findAll();
        ArrayList<Service> listsrv = (ArrayList<Service>) daosrv.findAll();
        ArrayList<Malade> listmal = (ArrayList<Malade>) daomal.findAll();
        ArrayList<Chambre> listch = (ArrayList<Chambre>) daoch.findAll();
        ArrayList<Infirmier> listinf = (ArrayList<Infirmier>) daoinf.findAll();
        ArrayList<Employe> listempinactif = (ArrayList<Employe>) daoemp.findAll();
        
    /**
     * Constructeur de la fenetre d'ajout
     * @param titre
     * @throws IOException
     * @throws SQLException
     */
    public Ajouter(String titre) throws IOException, SQLException{
        setTitle(titre);
        //Container conteneur=this.getContentPane();
        //conteneur.setLayout(new GridLayout(6,1));
        InputStream input = img.class.getResourceAsStream("med.jpg");
        JPanel panneau=new PanelImage(input);
        panneau.setLayout(null);
        setSize(1200,800);
        
        //Initialisation list employe inactif
        
        for(int i = 0; i < listempinactif.size(); i++){
            for (Docteur listdoc1 : listdoc) {
                if (listempinactif.get(i).getNumero() == listdoc1.getNumero().getNumero()) {
                    listempinactif.remove(i);
                }          
            }
        }
        for(int i = 0; i < listempinactif.size(); i++){
            for (Infirmier listinf1 : listinf) {
                if (listempinactif.get(i).getNumero() == listinf1.getNumero().getNumero()) {
                    listempinactif.remove(i);
                }          
            }
        }

        //Creation des Combobox,label et Textfield de la table choisie
        ajout1 = new JTextField();
        ajout2 = new JTextField();
        ajout3 = new JTextField();
        ajout4 = new JTextField();
        ajout5 = new JTextField();
        
        box1 = new JComboBox();
        box2 = new JComboBox();
        box3 = new JComboBox();
        box4 = new JComboBox();
        
        lab1 = new JLabel("");
        lab2 = new JLabel("");
        lab3 = new JLabel("");
        lab4 = new JLabel("");
        lab5 = new JLabel("");
        
        lab1.setBackground(Color.LIGHT_GRAY);
        lab1.setOpaque(true);
        lab2.setBackground(Color.LIGHT_GRAY);
        lab2.setOpaque(true);
        lab3.setBackground(Color.LIGHT_GRAY);
        lab3.setOpaque(true);
        lab4.setBackground(Color.LIGHT_GRAY);
        lab4.setOpaque(true);
        lab5.setBackground(Color.LIGHT_GRAY);
        lab5.setOpaque(true);
          
        ajout1.addActionListener(this);
        ajout2.addActionListener(this);
        ajout3.addActionListener(this);
        ajout4.addActionListener(this);
        ajout5.addActionListener(this);
        box1.addActionListener(this);
        box2.addActionListener(this);
        box3.addActionListener(this);
        box4.addActionListener(this);
        //
        panneau.add(ajout1);
        panneau.add(ajout2);
        panneau.add(ajout3);
        panneau.add(ajout4);
        panneau.add(ajout5);
        panneau.add(box1);
        panneau.add(box2);
        panneau.add(box3);
        panneau.add(box4);
        panneau.add(lab1);
        panneau.add(lab2);
        panneau.add(lab3);
        panneau.add(lab4);
        panneau.add(lab5);
        
        error = new JLabel(" !!!!!!!!!!!!!!!!!! Veuillez remplir tous les blancs CORRECTEMENT !!!!!!!!!!!!!!!!!! ");
        panneau.add(error);
        error.setBounds(360, 20, 464, 50);
        error.setForeground(Color.RED);
        error.setBackground(Color.ORANGE);
        error.setVisible(false);
        error.setOpaque(true);

       
       table=new JLabel(" Saisir une table :");
       table.setBounds(380,121,115,25);
       table.setBackground(Color.LIGHT_GRAY);
       table.setOpaque(true);
       panneau.add(table);
       
       String[] Label={"Docteur", "Malade","Chambre","Employe","Infirmier","Hospitalisation","Soigne","Service"};
       
        
       type = new JComboBox();
       type.setBounds(500,110,250,50);
       for (int i=0;i<Label.length;i++){
           type.insertItemAt(Label[i],i);
       }
       panneau.add(type);
       type.addActionListener(this);

        ajouter = new JButton("ajouter");
        ajouter.setBounds(650,550,300,60);
        ajouter.addActionListener(this);
        ajouter.setBackground(Color.orange);
        ajouter.setOpaque(true);
        panneau.add(ajouter);
        
        
        exit=new JButton("Retour");
        exit.setForeground(Color.red);
        exit.setBounds(30,680,160,30);
        exit.addActionListener(this);
        
        panneau.add(exit);
        
        fentreCard.add("MAJ", panneau);
        setVisible(false);
        
        
        
        
    }
    
    
   @Override
 public void actionPerformed(ActionEvent event){
     
if(event.getSource().getClass()==JComboBox.class)
     {
        if("Docteur".equals((String)((JComboBox)event.getSource()).getSelectedItem()))
        {
            var =1;
            lab1.setVisible(true);
            lab2.setVisible(true);
            lab3.setVisible(false);
            lab4.setVisible(false);
            lab5.setVisible(false);
            ajout1.setVisible(false);
            ajout2.setVisible(false);
            ajout3.setVisible(false);
            ajout4.setVisible(false);
            ajout5.setVisible(false);
            box1.setVisible(true);
            box2.setVisible(true);
            box3.setVisible(false);
            box4.setVisible(false);
            
            
            box1.setBounds(600,260,400,20); //Specialité
            lab1.setBounds(450,260,150,20);
            lab1.setText(" Specialite :");
            
            box2.setBounds(600,320,400,20);
            lab2.setBounds(450,320,150,20);//emp num
            lab2.setText(" Numero d'employe :");
           // box3.setBounds(600,320,400,50);
            box1.removeAllItems();
            box2.removeAllItems();
            
           // box3.removeAllItems();
            
            for (int i=0;i<listdoc.size();i++)
            {
                box1.insertItemAt(listdoc.get(i).getSpecialite(),i);
            }     
            for (int i=0;i<listempinactif.size();i++)
            {
                box2.insertItemAt(""+listempinactif.get(i).getNumero(),i);
            }    
       
            
            
          }
        
        else if("Malade".equals((String)((JComboBox)event.getSource()).getSelectedItem()))
        {
            var =2;
            lab1.setVisible(true);
            lab2.setVisible(true);
            lab3.setVisible(true);
            lab4.setVisible(true);
            lab5.setVisible(true);
            ajout1.setVisible(true);
            ajout2.setVisible(true);
            ajout3.setVisible(true);
            ajout4.setVisible(true);
            ajout5.setVisible(true);
            box1.setVisible(false);
            box2.setVisible(false);
            box3.setVisible(false);
            box4.setVisible(false);
            
            ajout1.setText("");
            ajout2.setText("");
            ajout3.setText("");
            ajout4.setText("");
            ajout5.setText("");
            
            ajout1.setBounds(600,260,400,20);
            lab1.setText(" Nom :");
            lab1.setBounds(450,260,150,20);
            
            ajout2.setBounds(600,320,400,20);
            lab2.setText(" Prenom :");
            lab2.setBounds(450,320,150,20);
            
            ajout3.setBounds(600,380,400,20);
            lab3.setText(" Mutuelle :");
            lab3.setBounds(450,380,150,20);
            
            ajout4.setBounds(600,440,400,20);
            lab4.setText(" Adresse :");
            lab4.setBounds(450,440,150,20);
            
            ajout5.setBounds(600,500,400,20);
            lab5.setText(" Telephone :");
            lab5.setBounds(450,500,150,20);
            
           }
        
        else if("Infirmier".equals((String)((JComboBox)event.getSource()).getSelectedItem()))
        {
            var =3;
            lab1.setVisible(true);
            lab2.setVisible(true);
            lab3.setVisible(true);
            lab4.setVisible(true);
            lab5.setVisible(false);
            ajout1.setVisible(true);
            ajout2.setVisible(false);
            ajout3.setVisible(false);
            ajout4.setVisible(false);
            ajout5.setVisible(false);
            box1.setVisible(true);
            box2.setVisible(true);
            box3.setVisible(true);
            box4.setVisible(false);
            
            ajout1.setText("");
            
            ajout1.setBounds(600,440,400,20);//salaire
            lab4.setText(" Salaire :");
            lab4.setBounds(450,440,150,20);
            
            box1.setBounds(600,260,400,20); //Numero d'employe :
            lab1.setBounds(450,260,150,20);
            lab1.setText(" Numero d'employe :");
            
            box2.setBounds(600,320,400,20);
            lab2.setBounds(450,320,150,20);//code service
            lab2.setText(" Service :");
            
            box3.setBounds(600,380,400,20);//rotation
            lab3.setText(" Rotation :");
            lab3.setBounds(450,380,150,20);
            
            
            
           // box3.setBounds(600,320,400,50);
            box1.removeAllItems();
            box2.removeAllItems();
            box3.removeAllItems();
            
           // box3.removeAllItems();
            
            for (int i=0;i<listempinactif.size();i++)
            {
            box1.insertItemAt(""+listempinactif.get(i).getNumero(),i);
            }
            
            for (int i=0;i<listsrv.size();i++)
            {
            box2.insertItemAt(listsrv.get(i).getCode(),i);
            }

            String[] rotation={"JOUR","NUIT"};
            for (int i=0;i<rotation.length;i++)
            {
                box3.insertItemAt(rotation[i],i);
            }
       
           }
        
        else if("Employe".equals((String)((JComboBox)event.getSource()).getSelectedItem()))
        {
            var =4;
            lab1.setVisible(true);
            lab2.setVisible(true);
            lab3.setVisible(false);
            lab4.setVisible(true);
            lab5.setVisible(true);
            ajout1.setVisible(true);
            ajout2.setVisible(true);
            ajout3.setVisible(false);
            ajout4.setVisible(true);
            ajout5.setVisible(true);
            box1.setVisible(false);
            box2.setVisible(false);
            box3.setVisible(false);
            box4.setVisible(false);
            
            ajout1.setText("");
            ajout2.setText("");
            ajout5.setText("");
            ajout4.setText("");
            
            ajout1.setBounds(600,260,400,20);
            lab1.setText(" Nom :");
            lab1.setBounds(450,260,150,20);
            
            ajout2.setBounds(600,320,400,20);
            lab2.setText(" Prenom :");
            lab2.setBounds(450,320,150,20);
            
            ajout4.setBounds(600,440,400,20);
            lab4.setText(" Adresse :");
            lab4.setBounds(450,440,150,20);
            
            ajout5.setBounds(600,500,400,20);
            lab5.setText(" Telephone :");
            lab5.setBounds(450,500,150,20);
       
           }
        
        else if("Hospitalisation".equals((String)((JComboBox)event.getSource()).getSelectedItem()))
        {
            var = 5;
            lab1.setVisible(true);
            lab2.setVisible(true);
            lab3.setVisible(true);
            lab4.setVisible(true);
            lab5.setVisible(false);
            ajout1.setVisible(true);
            ajout2.setVisible(false);
            ajout3.setVisible(false);
            ajout4.setVisible(false);
            ajout5.setVisible(false);
            box1.setVisible(true);
            box2.setVisible(true);
            box3.setVisible(true);
            box4.setVisible(false);
            
            ajout1.setText("");
            
            
            box1.setBounds(600,260,400,20); //num du Malade:
            lab1.setBounds(450,260,150,20);
            lab1.setText(" Numero du malade :");
            
            box2.setBounds(600,320,400,20);
            lab2.setBounds(450,320,150,20);//code service
            lab2.setText(" Service :");
            
            
            box3.setBounds(600,380,400,20);
            lab3.setBounds(450,380,150,20);//Num chambre
            lab3.setText(" Numero de Chambre :");
            
            ajout1.setBounds(600,440,400,20);//num lit
            lab4.setText(" Numero du lit :");
            lab4.setBounds(450,440,150,20);
            
            box1.removeAllItems();
            box2.removeAllItems();
            box3.removeAllItems();
            
           // box3.removeAllItems();
            
            for (int i=0;i<listmal.size();i++)
            {
            box1.insertItemAt(""+listmal.get(i).getNumero(),i);
            }     
            for (int i=0;i<listsrv.size();i++)
            {
            box2.insertItemAt(listsrv.get(i).getCode(),i);
            }
            for (int i=0;i<listch.size();i++)
            {
            box3.insertItemAt(""+listch.get(i).getNo_chambre(),i);
            }
            
            
            
        
           }
        
        else if("Chambre".equals((String)((JComboBox)event.getSource()).getSelectedItem()))
        {
            var = 6;
            lab1.setVisible(true);
            lab2.setVisible(true);
            lab3.setVisible(true);
            lab4.setVisible(false);
            lab5.setVisible(false);
            ajout1.setVisible(true);
            ajout2.setVisible(true);
            ajout3.setVisible(false);
            ajout4.setVisible(false);
            ajout5.setVisible(false);
            box1.setVisible(true);
            box2.setVisible(false);
            box3.setVisible(false);
            box4.setVisible(false);
            
            ajout1.setText("");
            ajout2.setText("");
            
            box1.setBounds(600,260,400,20); //code service
            lab1.setBounds(450,260,150,20);
            lab1.setText(" Code du Service :");
            
            ajout1.setBounds(600,320,400,20);
            lab2.setBounds(450,320,150,20);//surveillant
            lab2.setText(" Code du Serveillant :");
            
            
            ajout2.setBounds(600,380,400,20);
            lab3.setBounds(450,380,150,20);//Nb de lits
            lab3.setText(" Nombre de lits :");
            
            
            
            box1.removeAllItems();

            
           // box3.removeAllItems();
            
            for (int i=0;i<listsrv.size();i++)
            {
            box1.insertItemAt(listsrv.get(i).getCode(),i);
            }     
           
         
           }
        
        else if("Service".equals((String)((JComboBox)event.getSource()).getSelectedItem()))
        {
            var =7;
            lab1.setVisible(true);
            lab2.setVisible(true);
            lab3.setVisible(false);
            lab4.setVisible(true);
            lab5.setVisible(true);
            ajout1.setVisible(true);
            ajout2.setVisible(true);
            ajout3.setVisible(false);
            ajout4.setVisible(true);
            ajout5.setVisible(true);
            box1.setVisible(false);
            box2.setVisible(false);
            box3.setVisible(false);
            box4.setVisible(false);
            
            ajout1.setText("");
            ajout2.setText("");
            ajout5.setText("");
            ajout4.setText("");
            
            ajout1.setBounds(600,260,400,20);
            lab1.setText(" Code du Service:");
            lab1.setBounds(450,260,150,20);
            
            ajout2.setBounds(600,320,400,20);
            lab2.setText(" Nom du Service :");
            lab2.setBounds(450,320,150,20);
            
            ajout4.setBounds(600,440,400,20);
            lab4.setText(" Directeur :");
            lab4.setBounds(450,440,150,20);
            
            ajout5.setBounds(600,500,400,20);
            lab5.setText(" Batiment :");
            lab5.setBounds(450,500,150,20);
            
        
           }

        
        else if("Soigne".equals((String)((JComboBox)event.getSource()).getSelectedItem()))
        {
            var=8;
            lab1.setVisible(true);
            lab2.setVisible(true);
            lab3.setVisible(false);
            lab4.setVisible(false);
            lab5.setVisible(false);
            ajout1.setVisible(false);
            ajout2.setVisible(false);
            ajout3.setVisible(false);
            ajout4.setVisible(false);
            ajout5.setVisible(false);
            box1.setVisible(true);
            box2.setVisible(true);
            box3.setVisible(false);
            box4.setVisible(false);
            
            
            box1.setBounds(600,260,400,20); //Num duDocteur
            lab1.setBounds(450,260,150,20);
            lab1.setText(" Numero du Docteur :");
            
            box2.setBounds(600,320,400,20);
            lab2.setBounds(450,320,150,20);//Malade
            lab2.setText(" Numero du Malade :");
           // box3.setBounds(600,320,400,50);
            box1.removeAllItems();
            box2.removeAllItems();
            
           // box3.removeAllItems();
            
            for (int i=0;i<listdoc.size();i++)
            {
                box1.insertItemAt(""+listdoc.get(i).getNumero().getNumero(),i);
            }     
            for (int i=0;i<listmal.size();i++)
            {
                box2.insertItemAt(""+listmal.get(i).getNumero(),i);
            }    
       
        
           }

        
    }
    else if(event.getSource().getClass() == JButton.class)
    {
        if(event.getSource()==exit){
            fentreCard.show("Menu");
            this.setTitle("Menu");
        }
        else if(event.getSource() == ajouter)
        {
            try
            {
                switch(var)
                {
                    case 1:
                        String spe = box1.getSelectedItem().toString();
                        int numemp1 = Integer.parseInt(box2.getSelectedItem().toString());
                        JobDocteur.Create(spe,numemp1);
                        fentreCard.show("Menu");
                        this.setTitle("Menu");
                        break;
                        
                    case 2:                                              
                        String nom1 = ajout1.getText();
                        String prenom1 = ajout2.getText();
                        String mutuelle = ajout3.getText();
                        String adr1 = ajout4.getText();
                        String tel1 = ajout5.getText();
                        JobMalade.Create(nom1,prenom1,mutuelle,adr1,tel1);
                        if(nom1.length()>0 && prenom1.length()>0 && mutuelle.length()>0 && adr1.length()>0 && tel1.length()>0)
                        {
                        fentreCard.show("Menu");
                        this.setTitle("Menu");
                        }
                        else{error.setVisible(true);}
                        break;
                        
                    case 3:
                        int salaire = Integer.parseInt(ajout1.getText());
                        int numemp2 = Integer.parseInt(box1.getSelectedItem().toString());
                        String codesrv1 = box2.getSelectedItem().toString();
                        String rotation = box3.getSelectedItem().toString();
                        JobInfirmier.Create(salaire,numemp2,codesrv1,rotation);
                        fentreCard.show("Menu");
                        this.setTitle("Menu");
                        break;
                        
                    case 4:
                        String nom2 = ajout1.getText();
                        String prenom2 = ajout2.getText();
                        String adr2 = ajout4.getText();
                        String tel2 = ajout5.getText();
                        JobEmploye.Create(nom2,prenom2,adr2,tel2);
                        if(nom2.length()>0 && prenom2.length()>0 && adr2.length()>0 && tel2.length()>0)
                        {
                            
                        fentreCard.show("Menu");
                        this.setTitle("Menu");
                        }
                        else{error.setVisible(true);}
                        break;
                        
                    case 5:
                        int numlit = Integer.parseInt(ajout1.getText());
                        int nummal1 = Integer.parseInt(box1.getSelectedItem().toString());
                        String codesrv2 = box2.getSelectedItem().toString();
                        int numch = Integer.parseInt(box3.getSelectedItem().toString());
                        JobHospitalisation.Create(numlit,nummal1,codesrv2,numch);
                        fentreCard.show("Menu");
                        this.setTitle("Menu");
                        break;
                        
                    case 6:                        
                        int surv = Integer.parseInt(ajout1.getText());
                        int nblits = Integer.parseInt(ajout2.getText());
                        String codesrv3 = box1.getSelectedItem().toString();
                        JobChambre.Create(surv,nblits,codesrv3);
                        fentreCard.show("Menu");
                        this.setTitle("Menu");
                        break;
                        
                    case 7:
                        String codesrv4 = ajout1.getText();
                        String nomsrv = ajout2.getText();
                        int directeur = Integer.parseInt(ajout4.getText());
                        char batiment = ajout5.getText().charAt(0);
                        JobService.Create(codesrv4,nomsrv,directeur,batiment);
                        if(codesrv4.length()>0 && nomsrv.length()>0 )
                        {
                        fentreCard.show("Menu");
                        this.setTitle("Menu");
                        }else{error.setVisible(true);}
                        break;
                        
                    case 8:
                        int numdoc = Integer.parseInt(box1.getSelectedItem().toString());
                        int numma2 = Integer.parseInt(box2.getSelectedItem().toString());
                        JobSoigne.Create(numdoc,numma2);
                        fentreCard.show("Menu");
                        this.setTitle("Menu");
                        break;
                        
                    default:
                        break;
                }
            }
            catch(NumberFormatException e)
            {
                error.setVisible(true);
            } catch (SQLException e) {
                error.setVisible(true);
            }
        }
    }
  }
     
 }
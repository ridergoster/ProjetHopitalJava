package hopital;

import connexionpackage.Connexion;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import lib.img;

/**
 * Fenetre Presentation. Fenetre d'ouverture de l'application. On doit se 
 * connecter à la base de donné ici.
 * @author youenlecloirec
 */
public class Presentation extends JFrame implements ActionListener {

    private final JLabel nameUsr, passwdUsr, loginBDD, passwdBDD;
    private final JTextField nameECETexte, loginBDDTexte;
    private final JPasswordField passwdECETexte, passwdBDDTexte;
    private final JButton connectbut, fermerbut, conneclocbut;
    private final JPanel formcon, buttoncon;
    private boolean boolssh, boolbd;
    private Connection connect;

    /**
     * Constructeur de Presentation
     * @param titre
     * @throws IOException
     */
    public Presentation(String titre) throws IOException {
        setTitle(titre);
        InputStream input = img.class.getResourceAsStream("med.jpg");
        JPanel panneau=new PanelImage(input);
        panneau.setLayout(null);
        setSize(1200,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        boolssh = false;
        boolbd = false;
        
        // creation des boutons
        connectbut = new JButton("Connexion web");
        fermerbut = new JButton("Fermer");
        conneclocbut = new JButton("Connexion local");
        // creation des textes
        nameECETexte = new JTextField();
        passwdECETexte = new JPasswordField(8);
        loginBDDTexte = new JTextField();
        passwdBDDTexte = new JPasswordField(8);

        // creation des labels
        nameUsr = new JLabel("nom SHH (Ou nom de la BD en local) :", JLabel.CENTER);
        passwdUsr = new JLabel("mot de passe SHH :", JLabel.CENTER);
        loginBDD = new JLabel("nom user base :", JLabel.CENTER);
        passwdBDD = new JLabel("mot de passe de la base :", JLabel.CENTER);

        // creation des panneaux
        formcon = new JPanel();
        buttoncon = new JPanel();


        // mise en page des panneaux
        formcon.setLayout(new GridLayout(4,2));
        buttoncon.setLayout(new GridLayout(1,2));
        
        // ajout des objets graphqiues dans les panneaux
        formcon.add(nameUsr);
        formcon.add(nameECETexte);
        formcon.add(passwdUsr);
        formcon.add(passwdECETexte);
        formcon.add(loginBDD);
        formcon.add(loginBDDTexte);
        formcon.add(passwdBDD);
        formcon.add(passwdBDDTexte);
        buttoncon.add(fermerbut);
        buttoncon.add(connectbut);
        buttoncon.add(conneclocbut);
        
        panneau.add(formcon);
        formcon.setBounds(300,200,600,300);
        
        panneau.add(buttoncon);
        buttoncon.setBounds(400,600,400,40);
        // ajout des listeners
        conneclocbut.addActionListener(this);
        connectbut.addActionListener(this);
        fermerbut.addActionListener(this);
        nameECETexte.addActionListener(this);
        passwdECETexte.addActionListener(this);
        loginBDDTexte.addActionListener(this);
        passwdBDDTexte.addActionListener(this);
        
         fentreCard.add("Presentation",panneau);
         fentreCard.show("Presentation");
         this.add(fentreCard.getFen());
        setResizable(false);
        setVisible(true);
    }
    
    
    @Override
 public void actionPerformed(ActionEvent evt){
     
        if ("Fermer".equals(evt.getActionCommand())){
                this.dispose();
                System.exit(0);
        }
        else if("Connexion web".equals(evt.getActionCommand())){
                String passwdECEString = new String(passwdECETexte.getPassword());
                String passwdBDDString = new String(passwdBDDTexte.getPassword());
                try 
                {
                    if(!boolssh)
                        boolssh = Connexion.ConnexionSSH(nameECETexte.getText(), passwdECEString);
                    if(boolssh)
                        boolbd = Connexion.ConnexionBD(nameECETexte.getText(), loginBDDTexte.getText(), passwdBDDString);
                    if(boolbd){
                        connect = Connexion.getInstance();
                        try {
                            Menu m = new Menu("Menu");
                        } catch (IOException ex) {
                            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                        }
                       fentreCard.show("Menu");  
                       this.setTitle("Menu");
                    }
                        
                } 
                catch (ClassNotFoundException ex) 
                {
                    Logger.getLogger(Presentation.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        else if("Connexion local".equals(evt.getActionCommand())){
            String namebdd = nameECETexte.getText();
            String nameusr = loginBDDTexte.getText();
            String pwdBDD;
            try{
                pwdBDD = new String(passwdBDDTexte.getPassword());
            }catch(Exception e) { pwdBDD = "";}
            boolbd = Connexion.ConnexionLocal(namebdd,nameusr,pwdBDD);
            if(boolbd){
                connect = Connexion.getInstance();
                try {
                    Menu m = new Menu("Menu");
                } catch (IOException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
                fentreCard.show("Menu");
                this.setTitle("Menu");
            }
        }
 }     
    

}


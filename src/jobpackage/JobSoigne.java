/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jobpackage;

import bdclass.Docteur;
import bdclass.Employe;
import bdclass.Malade;
import bdclass.Soigne;
import daopackage.DAODocteur;
import daopackage.DAOEmploye;
import daopackage.DAOMalade;
import daopackage.DAOSoigne;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connexionpackage.Connexion;

/**
 * JobSoigne : Stock les fonctions de modification voulu pour Soigne
 * @author Vincent
 */
public class JobSoigne {
    
    /**
     * Effectue une recherche dans les Soigne selon les 3 attribut voulu
     * contenant les 3 informations données en parametre
     * @param att1
     * @param arg1
     * @param att2
     * @param arg2
     * @param att3
     * @param arg3
     * @return ListSoigne
     * @throws java.sql.SQLException
     */
    public static List<Soigne> FindResult(String att1, String arg1, String att2, String arg2, String att3, String arg3) throws SQLException{
        
        String[] SoigneRecherche = {"Numero du Docteur","Nom Docteur","Specialite du Docteur","Numero du Malade","Nom du Malade","Mutuelle"};
        // Initialisation
        DAOSoigne daosgn = new DAOSoigne(Connexion.getInstance());
        DAODocteur daodoc = new DAODocteur(Connexion.getInstance());
        DAOMalade daomal = new DAOMalade(Connexion.getInstance());
        DAOEmploye daoemp = new DAOEmploye(Connexion.getInstance());
        List<Soigne> ListSgn = new ArrayList<Soigne>();
        
        // Mise en place de la liste ALL
        
        List<Soigne> ListAllSgn = daosgn.findAll();
        for(Soigne sgn: ListAllSgn){
            sgn.setNo_docteur(daodoc.getById(sgn.getNo_docteur().getNumero().getNumero()));
            sgn.setNo_malade(daomal.getById(sgn.getNo_malade().getNumero()));
            sgn.getNo_docteur().setNumero(daoemp.getById(sgn.getNo_docteur().getNumero().getNumero()));
        }
        
        
        // Att1
        if("Numero du Docteur".equals(att1))
        {
            for(Soigne sgn : ListAllSgn){
                if((""+sgn.getNo_docteur().getNumero().getNumero()).contains(arg1))
                    ListSgn.add(sgn);  
            }
        }
        else if("Nom Docteur".equals(att1))
        {
            for(Soigne sgn : ListAllSgn){
                if(sgn.getNo_docteur().getNumero().getNom().contains(arg1))
                    ListSgn.add(sgn);  
            }
        }
        else if("Specialite du Docteur".equals(att1))
        {
            for(Soigne sgn : ListAllSgn){
                if(sgn.getNo_docteur().getSpecialite().contains(arg1))
                    ListSgn.add(sgn);  
            }
        }
        else if("Numero du Malade".equals(att1))
        {
            for(Soigne sgn : ListAllSgn){
                if((""+sgn.getNo_malade().getNumero()).contains(arg1))
                    ListSgn.add(sgn);  
            }
        }
        else if("Nom du Malade".equals(att1))
        {
            for(Soigne sgn : ListAllSgn){
                if(sgn.getNo_malade().getNom().contains(arg1))
                    ListSgn.add(sgn);  
            }
        }
        else if("Mutuelle".equals(att1))
        {
            for(Soigne sgn : ListAllSgn){
                if(sgn.getNo_malade().getMutuelle().contains(arg1))
                    ListSgn.add(sgn);  
            }
        }
        
        // Att2
        if("Numero du Docteur".equals(att2))
        {
            for(Soigne sgn : ListAllSgn){
                if((""+sgn.getNo_docteur().getNumero().getNumero()).contains(arg2))
                    ListSgn.add(sgn);  
            }
        }
        else if("Nom du Docteur".equals(att2))
        {
            for(Soigne sgn : ListAllSgn){
                if(sgn.getNo_docteur().getNumero().getNom().contains(arg2))
                    ListSgn.add(sgn);  
            }
        }
        else if("Specialite du Docteur".equals(att2))
        {
            for(Soigne sgn : ListAllSgn){
                if(sgn.getNo_docteur().getSpecialite().contains(arg2))
                    ListSgn.add(sgn);  
            }
        }
        else if("Numero du Malade".equals(att2))
        {
            for(Soigne sgn : ListAllSgn){
                if((""+sgn.getNo_malade().getNumero()).contains(arg2))
                    ListSgn.add(sgn);  
            }
        }
        else if("Nom du Malade".equals(att2))
        {
            for(Soigne sgn : ListAllSgn){
                if(sgn.getNo_malade().getNom().contains(arg2))
                    ListSgn.add(sgn);  
            }
        }
        else if("Mutuelle".equals(att2))
        {
            for(Soigne sgn : ListAllSgn){
                if(sgn.getNo_malade().getMutuelle().contains(arg2))
                    ListSgn.add(sgn);  
            }
        }
        
        // Att3
        if("Numero du Docteur".equals(att3))
        {
            for(Soigne sgn : ListAllSgn){
                if((""+sgn.getNo_docteur().getNumero().getNumero()).contains(arg3))
                    ListSgn.add(sgn);  
            }
        }
        else if("Nom du Docteur".equals(att3))
        {
            for(Soigne sgn : ListAllSgn){
                if(sgn.getNo_docteur().getNumero().getNom().contains(arg3))
                    ListSgn.add(sgn);  
            }
        }
        else if("Specialite du Docteur".equals(att3))
        {
            for(Soigne sgn : ListAllSgn){
                if(sgn.getNo_docteur().getSpecialite().contains(arg3))
                    ListSgn.add(sgn);  
            }
        }
        else if("Numero du Malade".equals(att3))
        {
            for(Soigne sgn : ListAllSgn){
                if((""+sgn.getNo_malade().getNumero()).contains(arg3))
                    ListSgn.add(sgn);  
            }
        }
        else if("Nom du Malade".equals(att3))
        {
            for(Soigne sgn : ListAllSgn){
                if(sgn.getNo_malade().getNom().contains(arg3))
                    ListSgn.add(sgn);  
            }
        }
        else if("Mutuelle".equals(att3))
        {
            for(Soigne sgn : ListAllSgn){
                if(sgn.getNo_malade().getMutuelle().contains(arg3))
                    ListSgn.add(sgn);  
            }
        }
        

        if(att1.equals(att2) && att1.equals(att3) && att3.equals("")) {
            ListSgn = ListAllSgn;
        }
        return ListSgn;
    } 

    /**
     * Créer un nouveau Soigne dans la Base de données selon les attributs
     * en parametre
     * @param numdoc
     * @param numma2
     * @throws SQLException
     */
    public static void Create(int numdoc, int numma2) throws SQLException {
        DAOSoigne dao = new DAOSoigne(Connexion.getInstance());
        
        Employe emp = new Employe();
        Docteur doc = new Docteur();
        Malade mal = new Malade();
        
        emp.setNumero(numdoc);
        doc.setNumero(emp);
        mal.setNumero(numma2);
        
        Soigne soin = new Soigne();
        
        soin.setNo_docteur(doc);
        soin.setNo_malade(mal);
        
        dao.insert(soin);
        
        
    }
    /**
     * Supprime un Soigne dans la Base de données selon les identifiants
     * @param numdoc
     * @param numma2
     * @throws SQLException
     */
    public static void Supr(int numdoc, int numma2) throws SQLException {
        DAOSoigne dao = new DAOSoigne(Connexion.getInstance());
        
        Employe emp = new Employe();
        Docteur doc = new Docteur();
        Malade mal = new Malade();
        
        emp.setNumero(numdoc);
        doc.setNumero(emp);
        mal.setNumero(numma2);
        
        Soigne soin = new Soigne();
        
        soin.setNo_docteur(doc);
        soin.setNo_malade(mal);
        
        dao.delete(soin);
    }
    
}

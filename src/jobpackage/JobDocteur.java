/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jobpackage;

import bdclass.Docteur;
import bdclass.Employe;
import bdclass.Soigne;
import daopackage.DAODocteur;
import daopackage.DAOEmploye;
import daopackage.DAOSoigne;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connexionpackage.Connexion;

/**
 * JobDocteur : Stock les fonctions de modification voulu pour Docteur
 * @author Vincent
 */
public class JobDocteur {
    
    /**
     * Constructeur de JobDocteur
     */
    public JobDocteur(){
        
    }
    
    /**
     * Créer un nouveau Docteur dans la Base de données selon les attributs
     * en parametre
     * @param spe - Specialite
     * @param numemp1 - Employe
     * @throws SQLException
     */
    public static void Create(String spe, int numemp1) throws SQLException {
        DAODocteur dao = new DAODocteur(Connexion.getInstance());
        Employe emp = new Employe();
        emp.setNumero(numemp1);
        
        Docteur doc = new Docteur();
        doc.setNumero(emp);
        doc.setSpecialite(spe);
        
        dao.insert(doc);
        
    }

    /**
     * Supprime un Docteur dans la Base de données selon ses identifiants
     * @param num - Numero du Docteur (Employe)
     * @throws SQLException
     */
    public static void Supr(int num) throws SQLException {
        DAODocteur dao = new DAODocteur(Connexion.getInstance());
        DAOSoigne daos = new DAOSoigne(Connexion.getInstance());
        
        int var = 0;
        ArrayList<Soigne> allsoin = (ArrayList<Soigne>)daos.findAll();
        
        for(Soigne s: allsoin){
            if(s.getNo_docteur().getNumero().getNumero() == num)
                var = 1;
        }
        
        Docteur doc = new Docteur();
        Employe emp = new Employe();
        emp.setNumero(num);
        doc.setNumero(emp);
        
        if(var == 0){
            dao.delete(doc);
        }
    }
    

    /**
     * Effectue une recherche dans les Docteurs selon les 3 attribut voulu
     * contenant les 3 informations données en parametre
     * @param att1
     * @param arg1
     * @param att2
     * @param arg2
     * @param att3
     * @param arg3
     * @return ListDocteur
     * @throws java.sql.SQLException
     */
    public static List<Docteur> FindResult(String att1, String arg1, String att2, String arg2, String att3, String arg3) throws SQLException{
        
        // Initialisation
        DAODocteur daodoc = new DAODocteur(Connexion.getInstance());
        DAOEmploye daoemp = new DAOEmploye(Connexion.getInstance());
        List<Docteur> ListDoc = new ArrayList<Docteur>();
        List<Docteur> ListFinal = new ArrayList<Docteur>();
        // Mise en place de la liste ALL
        List<Docteur> ListAllDoc = daodoc.findAll();
        for(Docteur doc: ListAllDoc){
            doc.setNumero(daoemp.getById(doc.getNumero().getNumero()));
        }
        
        
        // Att1
        if("Numero".equals(att1))
        {
            try{
            boolean add = ListDoc.add(daodoc.getById(Integer.parseInt(arg1)));
            }
            catch(NumberFormatException e){}
        }
        else if("Nom".equals(att1))
        {
            List<Employe> Listemp = daoemp.findByNom(arg1);
            for(Employe emp: Listemp){
                boolean add = ListDoc.add(daodoc.getById(emp.getNumero()));
            }
           
        }
        else if("Prenom".equals(att1))
        {
            List<Employe> Listemp = daoemp.findByPrenom(arg1);
            for(Employe emp: Listemp){
                boolean add = ListDoc.add(daodoc.getById(emp.getNumero()));
            }
           
        } 
        else if("Adresse".equals(att1))
        {
            List<Employe> Listemp = daoemp.findByAdr(arg1);
            for(Employe emp: Listemp){
                boolean add = ListDoc.add(daodoc.getById(emp.getNumero()));
            }
           
        } 
        else if("Telephone".equals(att1))
        {
            List<Employe> Listemp = daoemp.findByTel(arg1);
            for(Employe emp: Listemp){
                boolean add = ListDoc.add(daodoc.getById(emp.getNumero()));
            }
           
        } 
        else if("Specialite".equals(att1))
        {
            ListDoc = daodoc.findBySpe(arg1);
        } 
        
        
        // Att2
        if("Numero".equals(att2))
        {
            try{
            boolean add = ListDoc.add(daodoc.getById(Integer.parseInt(arg2)));
            }
            catch(NumberFormatException e){}
        }
        else if("Nom".equals(att2))
        {
            List<Employe> Listemp = daoemp.findByNom(arg2);
            for(Employe emp: Listemp){
                boolean add = ListDoc.add(daodoc.getById(emp.getNumero()));
            }
           
        }
        else if("Prenom".equals(att2))
        {
            List<Employe> Listemp = daoemp.findByPrenom(arg2);
            for(Employe emp: Listemp){
                boolean add = ListDoc.add(daodoc.getById(emp.getNumero()));
            }
           
        } 
        else if("Adresse".equals(att2))
        {
            List<Employe> Listemp = daoemp.findByAdr(arg2);
            for(Employe emp: Listemp){
                boolean add = ListDoc.add(daodoc.getById(emp.getNumero()));
            }
           
        } 
        else if("Telephone".equals(att2))
        {
            List<Employe> Listemp = daoemp.findByTel(arg2);
            for(Employe emp: Listemp){
                boolean add = ListDoc.add(daodoc.getById(emp.getNumero()));
            }
           
        } 
        else if("Specialite".equals(att2))
        {
            ListDoc = daodoc.findBySpe(att2);
        } 
        
        // Att3
        if("Numero".equals(att3))
        {
            try{
            boolean add = ListDoc.add(daodoc.getById(Integer.parseInt(arg3)));
            }
            catch(NumberFormatException e){}
        }
        else if("Nom".equals(att3))
        {
            List<Employe> Listemp = daoemp.findByNom(arg3);
            for(Employe emp: Listemp){
                boolean add = ListDoc.add(daodoc.getById(emp.getNumero()));
            }
           
        }
        else if("Prenom".equals(att3))
        {
            List<Employe> Listemp = daoemp.findByPrenom(arg3);
            for(Employe emp: Listemp){
                boolean add = ListDoc.add(daodoc.getById(emp.getNumero()));
            }
           
        } 
        else if("Adresse".equals(att3))
        {
            List<Employe> Listemp = daoemp.findByAdr(arg3);
            for(Employe emp: Listemp){
                boolean add = ListDoc.add(daodoc.getById(emp.getNumero()));
            }
           
        } 
        else if("Telephone".equals(att3))
        {
            List<Employe> Listemp = daoemp.findByTel(arg3);
            for(Employe emp: Listemp){
                boolean add = ListDoc.add(daodoc.getById(emp.getNumero()));
            }
           
        } 
        else if("Specialite".equals(att3))
        {
            ListDoc = daodoc.findBySpe(att3);
        }
        if(ListDoc.size() > 0){
            for (Docteur ListDoc1 : ListDoc) {
                if (ListDoc1.getNumero() != null) {
                    ListFinal.add(ListDoc1);
                }
            }
            for(Docteur doc: ListFinal){
                    doc.setNumero(daoemp.getById(doc.getNumero().getNumero()));
            }
        }
        
        if(att1.equals(att2) && att1.equals(att3) && att3.equals("")) {
            ListFinal = ListAllDoc;
        }
        return ListFinal;
    }
}

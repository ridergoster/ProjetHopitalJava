/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jobpackage;

import bdclass.Docteur;
import bdclass.Employe;
import bdclass.Infirmier;
import daopackage.DAODocteur;
import daopackage.DAOEmploye;
import daopackage.DAOInfirmier;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connexionpackage.Connexion;

/**
 * JobEmploye : Stock les fonctions de modification voulu pour Employe
 * @author Vincent
 */
public class JobEmploye {
    
    /**
     * Constructeur de JobEmploye
     */
    public JobEmploye(){
        
    }
    
    /**
     * Créer un nouveau Employe dans la Base de données selon les attributs
     * en parametre
     * @param nom2 - Nom 
     * @param prenom2 - Prenom
     * @param adr2 - Adresse
     * @param tel2 - Telephone
     * @throws SQLException
     */
    public static void Create(String nom2, String prenom2, String adr2, String tel2) throws SQLException {
        DAOEmploye dao = new DAOEmploye(Connexion.getInstance());
               
        ArrayList<Employe> listall = (ArrayList<Employe>)dao.findAll();
        int id = listall.get(0).getNumero();
        for(Employe emp: listall)
        {
            if(id < emp.getNumero()) 
            {
                id = emp.getNumero();
            }
        }
        id = id + 1;
        
        Employe emp = new Employe();
        
        emp.setAdr(adr2);
        emp.setNom(nom2);
        emp.setNumero(id);
        emp.setPrenom(prenom2);
        emp.setTel(tel2);
        
        dao.insert(emp);
    }

    /**
     * Supprime un Employe dans la Base de données selon ses identifiants
     * @param num4 - Numéro
     * @throws SQLException
     */
    public static void Supr(int num4) throws SQLException {
        DAOEmploye dao = new DAOEmploye(Connexion.getInstance());
        DAODocteur daod = new DAODocteur(Connexion.getInstance());
        DAOInfirmier daoi = new DAOInfirmier(Connexion.getInstance());
        int var = 0;
        ArrayList<Docteur> alldoc = (ArrayList<Docteur>)daod.findAll();
        ArrayList<Infirmier> allinf = (ArrayList<Infirmier>)daoi.findAll();
        
        for(Docteur doc : alldoc){
            if(doc.getNumero().getNumero() == num4)
                var = 1;
        }
        for(Infirmier inf : allinf){
            if(inf.getNumero().getNumero() == num4)
                var = 1;
        }
        
        Employe emp = new Employe();
        emp.setNumero(num4);
        
        if(var == 0){
            dao.delete(emp);
        }
    }
    

    
    /**
     * Effectue une recherche dans les Employes selon les 3 attribut voulu
     * contenant les 3 informations données en parametre
     * @param att1
     * @param arg1
     * @param att2
     * @param arg2
     * @param att3
     * @param arg3
     * @return ListEmploye
     * @throws java.sql.SQLException
     */
    public static List<Employe> FindResult(String att1, String arg1, String att2, String arg2, String att3, String arg3) throws SQLException{
        
        String[] EmployeRecherche = {"Numéro","Nom","Prenom","Telephone","Adresse"};  
        // Initialisation
        DAOEmploye daoemp = new DAOEmploye(Connexion.getInstance());
        List<Employe> ListEmp = new ArrayList<Employe>();
        List<Employe> ListFinal = new ArrayList<Employe>();
        
        // Mise en place de la liste ALL
        List<Employe> ListAllEmp = daoemp.findAll();
        
        
        // Att1
        if("Numero".equals(att1))
        {
            try{
            boolean add = ListEmp.add(daoemp.getById(Integer.parseInt(arg1)));
            }
            catch(NumberFormatException e){} catch (SQLException e) {
            }
        }
        else if("Nom".equals(att1))
        {
            boolean add = ListEmp.addAll(daoemp.findByNom(arg1));    
        }
        else if("Prenom".equals(att1))
        {
            boolean add = ListEmp.addAll(daoemp.findByPrenom(arg1)); 
        } 
        else if("Adresse".equals(att1))
        {
            boolean add = ListEmp.addAll(daoemp.findByAdr(arg1)); 
        } 
        else if("Telephone".equals(att1))
        {
            boolean add = ListEmp.addAll(daoemp.findByTel(arg1)); 
        } 
        
        
        // Att2
        if("Numero".equals(att2))
        {
            try{
            boolean add = ListEmp.add(daoemp.getById(Integer.parseInt(arg2)));
            }
            catch(NumberFormatException e){} catch (SQLException e) {
            }
        }
        else if("Nom".equals(att2))
        {
            boolean add = ListEmp.addAll(daoemp.findByNom(arg2));  
        }
        else if("Prenom".equals(att2))
        {
            boolean add = ListEmp.addAll(daoemp.findByPrenom(arg2));  
        } 
        else if("Adresse".equals(att2))
        {
            boolean add = ListEmp.addAll(daoemp.findByAdr(arg2));  
        } 
        else if("Telephone".equals(att2))
        {
            boolean add = ListEmp.addAll(daoemp.findByTel(arg2));  
        } 
        
        // Att3
        if("Numero".equals(att3))
        {
            try{
            boolean add = ListEmp.add(daoemp.getById(Integer.parseInt(arg3)));
            }
            catch(NumberFormatException e){} catch (SQLException e) {
            }
        }
        else if("Nom".equals(att3))
        {
            boolean add = ListEmp.addAll(daoemp.findByNom(arg3));  
        }
        else if("Prenom".equals(att3))
        {
            boolean add = ListEmp.addAll(daoemp.findByPrenom(arg3));  
        } 
        else if("Adresse".equals(att3))
        {
            boolean add = ListEmp.addAll(daoemp.findByAdr(arg3));  
        } 
        else if("Telephone".equals(att3))
        {
            boolean add = ListEmp.addAll(daoemp.findByAdr(arg3));  
        } 
        
        // Mettre en place la liste final
        if(ListEmp.size() > 0){
            for (Employe ListEmp1 : ListEmp) {
                for (Employe ListAllEmp1 : ListAllEmp) {
                    if (ListEmp1.getNumero() == ListAllEmp1.getNumero()) {
                        ListFinal.add(ListAllEmp1);
                    }
                }
            }
        }
        if(att1.equals(att2) && att1.equals(att3) && att3.equals("")) {
            ListFinal = ListAllEmp;
        }
        return ListFinal;
    }
}

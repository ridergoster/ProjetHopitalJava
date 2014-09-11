/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jobpackage;

import bdclass.Employe;
import bdclass.Infirmier;
import bdclass.Service;
import daopackage.DAOEmploye;
import daopackage.DAOInfirmier;
import daopackage.DAOService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connexionpackage.Connexion;

/**
 * JobInfirmier : Stock les fonctions de modification voulu pour Infirmier
 * @author Vincent
 */
public class JobInfirmier {
    
    /**
     * Effectue une recherche dans les Infirmier selon les 3 attribut voulu
     * contenant les 3 informations données en parametre
     * @param att1
     * @param arg1
     * @param att2
     * @param arg2
     * @param att3
     * @param arg3
     * @return ListInfirmier
     * @throws java.sql.SQLException
     */
    public static List<Infirmier> FindResult(String att1, String arg1, String att2, String arg2, String att3, String arg3) throws SQLException{
        
        String[] InfirmierRecherche ={"Numero","Nom","Prenom","Nom Service","Telephone","Adresse","Rotation"};  
        // Initialisation
        DAOInfirmier daoinf = new DAOInfirmier(Connexion.getInstance());
        DAOEmploye daoemp = new DAOEmploye(Connexion.getInstance());
        DAOService daosrv = new DAOService(Connexion.getInstance());
        List<Infirmier> ListInf = new ArrayList<Infirmier>();
        
        // Mise en place de la liste ALL
        List<Infirmier> ListAllInf = daoinf.findAll();
        for(Infirmier inf : ListAllInf){
            inf.setCode_service(daosrv.getById(inf.getCode_service().getCode()));
            inf.setNumero(daoemp.getById(inf.getNumero().getNumero()));
        }
        
        // Att1
        if("Numero".equals(att1))
        {
            for(Infirmier inf : ListAllInf){
                if((""+inf.getNumero().getNumero()).contains(arg1))
                    ListInf.add(inf);  
            }
        }
        else if("Nom".equals(att1))
        {
            for(Infirmier inf : ListAllInf){
                if(inf.getNumero().getNom().contains(arg1))
                    ListInf.add(inf);  
            }   
        }
        else if("Prenom".equals(att1))
        {
            for(Infirmier inf : ListAllInf){
                if(inf.getNumero().getPrenom().contains(arg1))
                    ListInf.add(inf);  
            }   
        }
        else if("Nom Service".equals(att1))
        {
            for(Infirmier inf : ListAllInf){
                if(inf.getCode_service().getNomserv().contains(arg1))
                    ListInf.add(inf);  
            }     
        } 
        else if("Telephone".equals(att1))
        {
            for(Infirmier inf : ListAllInf){
                if(inf.getNumero().getTel().contains(arg1))
                    ListInf.add(inf);  
            }  
        } 
        else if("Adresse".equals(att1))
        {
            for(Infirmier inf : ListAllInf){
                if(inf.getNumero().getAdr().contains(arg1))
                    ListInf.add(inf);  
            }  
        } 
        else if("Rotation".equals(att1))
        {
            for(Infirmier inf : ListAllInf){
                if(inf.getRotation().contains(arg1))
                    ListInf.add(inf);  
            }  
        } 
        
        // Att2
        if("Numero".equals(att2))
        {
            for(Infirmier inf : ListAllInf){
                if((""+inf.getNumero().getNumero()).contains(arg2))
                    ListInf.add(inf);  
            }
        }
        else if("Nom".equals(att2))
        {
            for(Infirmier inf : ListAllInf){
                if(inf.getNumero().getNom().contains(arg2))
                    ListInf.add(inf);  
            }   
        }
        else if("Prenom".equals(att2))
        {
            for(Infirmier inf : ListAllInf){
                if(inf.getNumero().getPrenom().contains(arg2))
                    ListInf.add(inf);  
            }   
        }
        else if("Nom Service".equals(att2))
        {
            for(Infirmier inf : ListAllInf){
                if(inf.getCode_service().getNomserv().contains(arg2))
                    ListInf.add(inf);  
            }     
        } 
        else if("Telephone".equals(att2))
        {
            for(Infirmier inf : ListAllInf){
                if(inf.getNumero().getTel().contains(arg2))
                    ListInf.add(inf);  
            }  
        } 
        else if("Adresse".equals(att2))
        {
            for(Infirmier inf : ListAllInf){
                if(inf.getNumero().getAdr().contains(arg2))
                    ListInf.add(inf);  
            }  
        } 
        else if("Rotation".equals(att2))
        {
            for(Infirmier inf : ListAllInf){
                if(inf.getRotation().contains(arg2))
                    ListInf.add(inf);  
            }  
        } 
        
        // Att3
        if("Numero".equals(att3))
        {
            for(Infirmier inf : ListAllInf){
                if((""+inf.getNumero().getNumero()).contains(arg3))
                    ListInf.add(inf);  
            }
        }
        else if("Nom".equals(att3))
        {
            for(Infirmier inf : ListAllInf){
                if(inf.getNumero().getNom().contains(arg3))
                    ListInf.add(inf);  
            }   
        }
        else if("Prenom".equals(att3))
        {
            for(Infirmier inf : ListAllInf){
                if(inf.getNumero().getPrenom().contains(arg3))
                    ListInf.add(inf);  
            }   
        }
        else if("Nom Service".equals(att3))
        {
            for(Infirmier inf : ListAllInf){
                if(inf.getCode_service().getNomserv().contains(arg3))
                    ListInf.add(inf);  
            }     
        } 
        else if("Telephone".equals(att3))
        {
            for(Infirmier inf : ListAllInf){
                if(inf.getNumero().getTel().contains(arg3))
                    ListInf.add(inf);  
            }  
        } 
        else if("Adresse".equals(att3))
        {
            for(Infirmier inf : ListAllInf){
                if(inf.getNumero().getAdr().contains(arg3))
                    ListInf.add(inf);  
            }  
        } 
        else if("Rotation".equals(att3))
        {
            for(Infirmier inf : ListAllInf){
                if(inf.getRotation().contains(arg3))
                    ListInf.add(inf);  
            }  
        } 
        

        if(att1.equals(att2) && att1.equals(att3) && att3.equals("")) {
            ListInf = ListAllInf;
        }
        return ListInf;
    } 

    /**
     * Créer un nouveau Infirmier dans la Base de données selon les attributs
     * en parametre
     * @param salaire - Salaire
     * @param numemp2 - Numéro employe
     * @param codesrv1 - Code service
     * @param rotation - Rotation(JOUR/NUIT)
     * @throws SQLException
     */
    public static void Create(int salaire, int numemp2, String codesrv1, String rotation) throws SQLException 
    {
       DAOInfirmier dao = new DAOInfirmier(Connexion.getInstance());
        Employe emp = new Employe();
        emp.setNumero(numemp2);
        
        Service src = new Service();
        src.setCode(codesrv1);
        
        Infirmier inf = new Infirmier();
        inf.setRotation(rotation);        
        inf.setCode_service(src);
        inf.setNumero(emp);
        inf.setSalaire(salaire);
        
        dao.insert(inf);

    }

    /**
     * Supprime un Docteur dans la Base de données selon ses identifiants
     * @param num3 - Numéro d'infirmier (employe)
     * @throws SQLException
     */
    public static void Supr(int num3) throws SQLException {
        DAOInfirmier dao = new DAOInfirmier(Connexion.getInstance());
        Infirmier inf = new Infirmier();
        Employe emp = new Employe();
        
        emp.setNumero(num3);
        inf.setNumero(emp);
        
        dao.delete(inf);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jobpackage;

import bdclass.Hospitalisation;
import bdclass.Malade;
import bdclass.Soigne;
import daopackage.DAOHospitalisation;
import daopackage.DAOMalade;
import daopackage.DAOSoigne;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connexionpackage.Connexion;

/**
 * JobMalade : Stock les fonctions de modification voulu pour Malade
 * @author Vincent
 */
public class JobMalade {
    /**
     * Effectue une recherche dans les Malade selon les 3 attribut voulu
     * contenant les 3 informations données en parametre
     * @param att1
     * @param arg1
     * @param att2
     * @param arg2
     * @param att3
     * @param arg3
     * @return ListMalade
     * @throws java.sql.SQLException
     */
    public static List<Malade> FindResult(String att1, String arg1, String att2, String arg2, String att3, String arg3) throws SQLException{
        
        String[] MaladeRecherche = {"Numero","Nom","Prenom","Telephone","Adresse","Mutuelle"};
        // Initialisation
        DAOMalade daomal = new DAOMalade(Connexion.getInstance());
        List<Malade> ListMal = new ArrayList<Malade>();
        
        // Mise en place de la liste ALL
        List<Malade> ListAllMal = daomal.findAll();
        
        // Att1
        if("Numero".equals(att1))
        {
            for(Malade mal : ListAllMal){
                if((""+mal.getNumero()).contains(arg1))
                    ListMal.add(mal);  
            }
        }
        else if("Nom".equals(att1))
        {
            for(Malade mal : ListAllMal){
                if(mal.getNom().contains(arg1))
                    ListMal.add(mal);  
            }  
        }
        else if("Prenom".equals(att1))
        {
            for(Malade mal : ListAllMal){
                if(mal.getPrenom().contains(arg1))
                    ListMal.add(mal);  
            }  
        }
        else if("Telephone".equals(att1))
        {
            for(Malade mal : ListAllMal){
                if(mal.getTel().contains(arg1))
                    ListMal.add(mal);  
            }   
        } 
        else if("Adresse".equals(att1))
        {
            for(Malade mal : ListAllMal){
                if(mal.getAdr().contains(arg1))
                    ListMal.add(mal);  
            }   
        }
        
        // Att2
        if("Numero".equals(att2))
        {
            for(Malade mal : ListAllMal){
                if((""+mal.getNumero()).contains(arg2))
                    ListMal.add(mal);  
            }
        }
        else if("Nom".equals(att2))
        {
            for(Malade mal : ListAllMal){
                if(mal.getNom().contains(arg2))
                    ListMal.add(mal);  
            }  
        }
        else if("Prenom".equals(att2))
        {
            for(Malade mal : ListAllMal){
                if(mal.getPrenom().contains(arg2))
                    ListMal.add(mal);  
            }  
        }
        else if("Telephone".equals(att2))
        {
            for(Malade mal : ListAllMal){
                if(mal.getTel().contains(arg2))
                    ListMal.add(mal);  
            }   
        } 
        else if("Adresse".equals(att2))
        {
            for(Malade mal : ListAllMal){
                if(mal.getAdr().contains(arg2))
                    ListMal.add(mal);  
            }   
        }
        
        // Att3
        if("Numero".equals(att3))
        {
            for(Malade mal : ListAllMal){
                if((""+mal.getNumero()).contains(arg3))
                    ListMal.add(mal);  
            }
        }
        else if("Nom".equals(att3))
        {
            for(Malade mal : ListAllMal){
                if(mal.getNom().contains(arg3))
                    ListMal.add(mal);  
            }  
        }
        else if("Prenom".equals(att3))
        {
            for(Malade mal : ListAllMal){
                if(mal.getPrenom().contains(arg3))
                    ListMal.add(mal);  
            }  
        }
        else if("Telephone".equals(att3))
        {
            for(Malade mal : ListAllMal){
                if(mal.getTel().contains(arg3))
                    ListMal.add(mal);  
            }   
        } 
        else if("Adresse".equals(att3))
        {
            for(Malade mal : ListAllMal){
                if(mal.getAdr().contains(arg3))
                    ListMal.add(mal);  
            }   
        }
        

        if(att1.equals(att2) && att1.equals(att3) && att3.equals("")) {
            ListMal = ListAllMal;
        }
        return ListMal;
    } 

    /**
     * Créer un nouveau Malade dans la Base de données selon les attributs
     * en parametre
     * @param nom1 - Nom
     * @param prenom1 - Prenom
     * @param mutuelle - Mutuelle
     * @param adr1 - Adresse
     * @param tel1 - Téléphone
     * @throws SQLException
     */
    public static void Create(String nom1, String prenom1, String mutuelle, String adr1, String tel1) throws SQLException {
        DAOMalade dao = new DAOMalade(Connexion.getInstance());
        ArrayList<Malade> listall = (ArrayList<Malade>)dao.findAll();
        int id = listall.get(0).getNumero();
        for(Malade mal: listall){
            if(id < mal.getNumero()) {
                id = mal.getNumero();
            }
        }
        id = id+1;
        Malade mal = new Malade();
        mal.setNumero(id);
        mal.setNom(nom1);
        mal.setPrenom(prenom1);
        mal.setMutuelle(mutuelle);
        mal.setAdr(adr1);
        mal.setTel(tel1);
        
        dao.insert(mal);
        
    }

    /**
     * Supprime un Malade dans la Base de données selon ses identifiants
     * @param num2 - Numéro malade
     * @throws SQLException
     */
    public static void Supr(int num2) throws SQLException {
        DAOMalade dao = new DAOMalade(Connexion.getInstance());
        DAOHospitalisation daoh = new DAOHospitalisation(Connexion.getInstance());
        DAOSoigne daos = new DAOSoigne(Connexion.getInstance());
        
        ArrayList<Soigne> lists = (ArrayList<Soigne>) daos.findAll();
        ArrayList<Hospitalisation> listh = (ArrayList<Hospitalisation>) daoh.findAll();
        
        for(Hospitalisation h : listh){
            if(h.getNo_malade().getNumero() == num2)
                daoh.delete(h);
        }
        for(Soigne s: lists){
            if(s.getNo_malade().getNumero() == num2)
                daos.delete(s);
        }
        Malade mal = new Malade();
        mal.setNumero(num2);
        
        dao.delete(mal);
        
        
    }
}

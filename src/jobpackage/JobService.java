/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jobpackage;

import bdclass.Service;
import daopackage.DAOService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connexionpackage.Connexion;

/**
 * JobService : Stock les fonctions de modification voulu pour Service
 * @author Vincent
 */
public class JobService {
    
    /**
     * Effectue une recherche dans les Service selon les 3 attribut voulu
     * contenant les 3 informations données en parametre
     * @param att1
     * @param arg1
     * @param att2
     * @param arg2
     * @param att3
     * @param arg3
     * @return ListService
     * @throws java.sql.SQLException
     */
    public static List<Service> FindResult(String att1, String arg1, String att2, String arg2, String att3, String arg3) throws SQLException{
        
        String[] ServiceRecherche = {"Code du Service","Nom Service","Batiment","Directeur"};
        // Initialisation
        DAOService daosrv = new DAOService(Connexion.getInstance());
        List<Service> ListSrv = new ArrayList<Service>();
        
        // Mise en place de la liste ALL
        List<Service> ListAllSrv = daosrv.findAll();
        
        // Att1
        if("Code du Service".equals(att1))
        {
            for(Service srv : ListAllSrv){
                if(srv.getCode().contains(arg1))
                    ListSrv.add(srv);  
            }
        }
        else if("Nom Service".equals(att1))
        {
            for(Service srv : ListAllSrv){
                if(srv.getNomserv().contains(arg1))
                    ListSrv.add(srv);  
            } 
        }
        else if("Batiment".equals(att1))
        {
            for(Service srv : ListAllSrv){
                if((""+srv.getBatiment()).contains(arg1))
                    ListSrv.add(srv);  
            }
        }
        else if("Directeur".equals(att1))
        {
            for(Service srv : ListAllSrv){
                if((""+srv.getDirecteur()).contains(arg1))
                    ListSrv.add(srv);  
            } 
        }
        
        // Att2
        if("Code du Service".equals(att2))
        {
            for(Service srv : ListAllSrv){
                if(srv.getCode().contains(arg2))
                    ListSrv.add(srv);  
            }
        }
        else if("Nom Service".equals(att2))
        {
            for(Service srv : ListAllSrv){
                if(srv.getNomserv().contains(arg2))
                    ListSrv.add(srv);  
            } 
        }
        else if("Batiment".equals(att2))
        {
            for(Service srv : ListAllSrv){
                if((""+srv.getBatiment()).contains(arg2))
                    ListSrv.add(srv);  
            }
        }
        else if("Directeur".equals(att2))
        {
            for(Service srv : ListAllSrv){
                if((""+srv.getDirecteur()).contains(arg2))
                    ListSrv.add(srv);  
            } 
        }
        
        // Att3
        if("Code du Service".equals(att3))
        {
            for(Service srv : ListAllSrv){
                if(srv.getCode().contains(arg3))
                    ListSrv.add(srv);  
            }
        }
        else if("Nom Service".equals(att3))
        {
            for(Service srv : ListAllSrv){
                if(srv.getNomserv().contains(arg3))
                    ListSrv.add(srv);  
            } 
        }
        else if("Batiment".equals(att3))
        {
            for(Service srv : ListAllSrv){
                if((""+srv.getBatiment()).contains(arg3))
                    ListSrv.add(srv);  
            }
        }
        else if("Directeur".equals(att3))
        {
            for(Service srv : ListAllSrv){
                if((""+srv.getDirecteur()).contains(arg3)) {
                    ListSrv.add(srv);
                }  
            } 
        }
        

        if(att1.equals(att2) && att1.equals(att3) && att3.equals("")) {
            ListSrv = ListAllSrv;
        }
        return ListSrv;
    } 

    /**
     * Créer un nouveau Service dans la Base de données selon les attributs
     * en parametre
     * @param codesrv4 - Code service
     * @param nomsrv - Nom service
     * @param directeur - Numéro directeur
     * @param batiment - Lettre batiment
     * @throws SQLException
     */
    public static void Create(String codesrv4, String nomsrv, int directeur, char batiment) throws SQLException {
       DAOService dao = new DAOService(Connexion.getInstance());
       ArrayList<Service> listall = (ArrayList<Service>)dao.findAll();
       int var = 0;
       Service srv = new Service();
       
       srv.setBatiment(batiment);
       srv.setCode(codesrv4);
       srv.setDirecteur(directeur);
       srv.setNomserv(nomsrv);
       
       for(Service sr : listall){
           if(sr.getCode().equals(codesrv4)) {
               var = 1;
           }
       }
       
       if(var == 0) {
            dao.insert(srv);
        }
    }
}

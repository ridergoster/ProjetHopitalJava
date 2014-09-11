/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jobpackage;

import bdclass.Chambre;
import bdclass.Hospitalisation;
import bdclass.Malade;
import bdclass.Service;
import daopackage.DAOChambre;
import daopackage.DAOHospitalisation;
import daopackage.DAOMalade;
import daopackage.DAOService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connexionpackage.Connexion;

/**
 * JobHospitalisation : Stock les fonctions de modification voulu pour 
 * Hospitalisation
 * @author Vincent
 */
public class JobHospitalisation {
    
    /**
     * Constructeur de JobHospitalisation
     */
    public JobHospitalisation(){
        
    }
    /**
     * Créer un nouveau Hospitalisation dans la Base de données selon les attributs
     * en parametre
     * @param numlit - Numéro de lit
     * @param nummal1 - Numéro de malade
     * @param codesrv2 - Numéro de service
     * @param numch - Numéro de chambre
     * @throws SQLException
     */
    public static void Create(int numlit, int nummal1, String codesrv2, int numch) throws SQLException {
        DAOHospitalisation dao = new DAOHospitalisation(Connexion.getInstance());
        
        Chambre ch = new Chambre();
        Service srv = new Service();
        Malade mal = new Malade();
        
        srv.setCode(codesrv2);
        ch.setCode_service(srv);
        ch.setNo_chambre(numch);
        mal.setNumero(nummal1);
        
        Hospitalisation hospi = new Hospitalisation();
        hospi.setCode_service(srv);
        hospi.setLit(numlit);
        hospi.setNo_chambre(ch);
        hospi.setNo_malade(mal);
        
        dao.insert(hospi);
       
    }
    
    /**
     * Effectue une recherche dans les Hospitalisation selon les 3 attribut voulu
     * contenant les 3 informations données en parametre
     * @param att1
     * @param arg1
     * @param att2
     * @param arg2
     * @param att3
     * @param arg3
     * @return ListHospitalisation
     * @throws java.sql.SQLException
     */
    public static List<Hospitalisation> FindResult(String att1, String arg1, String att2, String arg2, String att3, String arg3) throws SQLException{
        
        String[] HospitalisationRecherche = {"Numero du Malade","Nom du Malade","Numero du Service","Nom du Service","Chambre","Numero du lit"};
        // Initialisation
        DAOHospitalisation daohos = new DAOHospitalisation(Connexion.getInstance());
        DAOMalade daomal = new DAOMalade(Connexion.getInstance());
        DAOService daosrv = new DAOService(Connexion.getInstance());
        DAOChambre daoch = new DAOChambre(Connexion.getInstance());
        
        List<Hospitalisation> ListHos = new ArrayList<Hospitalisation>();
        
        // Mise en place de la liste ALL
        List<Hospitalisation> ListAllHos = daohos.findAll();
        for(Hospitalisation hosp : ListAllHos){
                hosp.setCode_service(daosrv.getById(hosp.getCode_service().getCode()));
                hosp.setNo_chambre(daoch.getById(hosp.getCode_service().getCode(),hosp.getNo_chambre().getNo_chambre()));
                hosp.setNo_malade(daomal.getById(hosp.getNo_malade().getNumero()));
        }
        
        // Att1
        if("Numero du Malade".equals(att1))
        {
            for(Hospitalisation hosp : ListAllHos){
                if((""+hosp.getNo_malade().getNumero()).contains(arg1))
                    ListHos.add(hosp);  
            }
        }
        else if("Nom du Malade".equals(att1))
        {
            for(Hospitalisation hosp : ListAllHos){
                if(hosp.getNo_malade().getNom().contains(arg1))
                    ListHos.add(hosp);  
            }
        }
        else if("Numero du Service".equals(att1))
        {
            for(Hospitalisation hosp : ListAllHos){
                if(hosp.getCode_service().getCode().contains(arg1))
                    ListHos.add(hosp);  
            }
        } 
        else if("Nom du Service".equals(att1))
        {
            for(Hospitalisation hosp : ListAllHos){
                if(hosp.getCode_service().getNomserv().contains(arg1))
                    ListHos.add(hosp);  
            }
        } 
        else if("Chambre".equals(att1))
        {
            for(Hospitalisation hosp : ListAllHos){
                if((""+hosp.getNo_chambre().getNo_chambre()).contains(arg1))
                    ListHos.add(hosp);  
            }
        } 
        else if("Numero du lit".equals(att1))
        {
            for(Hospitalisation hosp : ListAllHos){
                if((""+hosp.getNo_chambre().getNb_lits()).contains(arg1))
                    ListHos.add(hosp);  
            }
        } 
        
        // Att2
        if("Numero du Malade".equals(att2))
        {
            for(Hospitalisation hosp : ListAllHos){
                if((""+hosp.getNo_malade().getNumero()).contains(arg2))
                    ListHos.add(hosp);  
            }
        }
        else if("Nom du Malade".equals(att2))
        {
            for(Hospitalisation hosp : ListAllHos){
                if(hosp.getNo_malade().getNom().contains(arg2))
                    ListHos.add(hosp);  
            }
        }
        else if("Numero du Service".equals(att2))
        {
            for(Hospitalisation hosp : ListAllHos){
                if(hosp.getCode_service().getCode().contains(arg2))
                    ListHos.add(hosp);  
            }
        } 
        else if("Nom du Service".equals(att2))
        {
            for(Hospitalisation hosp : ListAllHos){
                if(hosp.getCode_service().getNomserv().contains(arg2))
                    ListHos.add(hosp);  
            }
        } 
        else if("Chambre".equals(att2))
        {
            for(Hospitalisation hosp : ListAllHos){
                if((""+hosp.getNo_chambre().getNo_chambre()).contains(arg2))
                    ListHos.add(hosp);  
            }
        } 
        else if("Numero du lit".equals(att2))
        {
            for(Hospitalisation hosp : ListAllHos){
                if((""+hosp.getNo_chambre().getNb_lits()).contains(arg2))
                    ListHos.add(hosp);  
            }
        } 
        
        // att3
        if("Numero du Malade".equals(att3))
        {
            for(Hospitalisation hosp : ListAllHos){
                if((""+hosp.getNo_malade().getNumero()).contains(arg3))
                    ListHos.add(hosp);  
            }
        }
        else if("Nom du Malade".equals(att3))
        {
            for(Hospitalisation hosp : ListAllHos){
                if(hosp.getNo_malade().getNom().contains(arg3))
                    ListHos.add(hosp);  
            }
        }
        else if("Numero du Service".equals(att3))
        {
            for(Hospitalisation hosp : ListAllHos){
                if(hosp.getCode_service().getCode().contains(arg3))
                    ListHos.add(hosp);  
            }
        } 
        else if("Nom du Service".equals(att3))
        {
            for(Hospitalisation hosp : ListAllHos){
                if(hosp.getCode_service().getNomserv().contains(arg3))
                    ListHos.add(hosp);  
            }
        } 
        else if("Chambre".equals(att3))
        {
            for(Hospitalisation hosp : ListAllHos){
                if((""+hosp.getNo_chambre().getNo_chambre()).contains(arg3))
                    ListHos.add(hosp);  
            }
        } 
        else if("Numero du lit".equals(att3))
        {
            for(Hospitalisation hosp : ListAllHos){
                if((""+hosp.getNo_chambre().getNb_lits()).contains(arg3))
                    ListHos.add(hosp);  
            }
        } 

        if(att1.equals(att2) && att1.equals(att3) && att3.equals("")) {
            ListHos = ListAllHos;
        }
        return ListHos;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jobpackage;

import bdclass.*;
import daopackage.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connexionpackage.Connexion;

/**
 * JobChambre : Stock les fonctions de modification voulu pour Malade
 * @author kocupyr
 */
public class JobChambre {

    /**
     * Constructeur de JobChambre
     */
    public JobChambre(){
        
    }
    /**
     * Créer un nouveau Malade dans la Base de données selon les attributs
     * en parametre
     * @param surv - Surveillant
     * @param nblits - Nombre de lit
     * @param codesrv3 - Service
     * @throws SQLException
     */
    public static void Create(int surv, int nblits, String codesrv3) throws SQLException {
        DAOChambre dao = new DAOChambre(Connexion.getInstance());
        ArrayList<Chambre> listall = (ArrayList<Chambre>)dao.findAll();
        ArrayList<Chambre> listchsrv = new ArrayList<Chambre>();
        
        for(Chambre ch: listall){
            if(ch.getCode_service().getCode().equals(codesrv3)) {
                listchsrv.add(ch);
            }
        }
        
        int id = listchsrv.get(0).getNo_chambre();
        
        for(Chambre ch : listchsrv){
            if(id < ch.getNo_chambre()) {
                id = ch.getNo_chambre();
            }
        }
        id = id+1;
        
        Service srv = new Service();
        srv.setCode(codesrv3);
        
        Chambre ch = new Chambre();
        ch.setCode_service(srv);
        ch.setNb_lits(nblits);
        ch.setNo_chambre(id);
        ch.setSurveillant(surv);
        
        dao.insert(ch);
    }
    
    /**
     * Effectue une recherche dans les Malades selon les 3 attribut voulu
     * contenant les 3 informations données en parametre
     * @param att1
     * @param arg1
     * @param att2
     * @param arg2
     * @param att3
     * @param arg3
     * @return ListChambre
     * @throws java.sql.SQLException
     */
    public static List<Chambre> FindResult(String att1, String arg1, String att2, String arg2, String att3, String arg3) throws SQLException{

        // Initialisation
        DAOChambre daoch = new DAOChambre(Connexion.getInstance());
        DAOService daoserv = new DAOService(Connexion.getInstance());
        List<Chambre> ListCh = new ArrayList<Chambre>();
        
        // Mise en place de la liste ALL
        List<Chambre> ListAllCh = daoch.findAll();
        for(Chambre ch: ListAllCh){
            ch.setCode_service(daoserv.getById(ch.getCode_service().getCode()));
        }
        
        
        // Att1
        if("Numero Chambre".equals(att1))
        {
            boolean add = ListCh.addAll(daoch.findByNoCh(Integer.parseInt(arg1)));
        }
        else if("Surveillant".equals(att1))
        {
            boolean add = ListCh.addAll(daoch.findBySurv(Integer.parseInt(arg1)));
        }
        else if("Nom Service".equals(att1))
        {
            List<Service> Listserv = daoserv.findByName(arg1);
            for(Service serv : Listserv){
                boolean add = ListCh.addAll(daoch.findByServ(serv.getCode()));
            }
            
        }
        else if("Nombres de lits".equals(att1))
        {
            boolean add = ListCh.addAll(daoch.findByNbLits(Integer.parseInt(arg1)));
        }
        
        // Att2
        if("Numero Chambre".equals(att2))
        {
            boolean add = ListCh.addAll(daoch.findByNoCh(Integer.parseInt(arg2)));
        }
        else if("Surveillant".equals(att2))
        {
            boolean add = ListCh.addAll(daoch.findBySurv(Integer.parseInt(arg2)));
        }
        else if("Nom Service".equals(att2))
        {
            List<Service> Listserv = daoserv.findByName(arg2);
            for(Service serv : Listserv){
                boolean add = ListCh.addAll(daoch.findByServ(serv.getCode()));
            }
            
        }
        else if("Nombres de lits".equals(att2))
        {
            boolean add = ListCh.addAll(daoch.findByNbLits(Integer.parseInt(arg2)));
        }      
        
        // Att3
        if("Numero Chambre".equals(att3))
        {
            boolean add = ListCh.addAll(daoch.findByNoCh(Integer.parseInt(arg3)));
        }
        else if("Surveillant".equals(att3))
        {
            boolean add = ListCh.addAll(daoch.findBySurv(Integer.parseInt(arg3)));
        }
        else if("Nom Service".equals(att3))
        {
            List<Service> Listserv = daoserv.findByName(arg3);
            for(Service serv : Listserv){
                boolean add = ListCh.addAll(daoch.findByServ(serv.getCode()));
            }
            
        }
        else if("Nombres de lits".equals(att3))
        {
            boolean add = ListCh.addAll(daoch.findByNbLits(Integer.parseInt(arg3)));
        }
        

        for(Chambre ch: ListCh){
            ch.setCode_service(daoserv.getById(ch.getCode_service().getCode()));
        }
                      
        
        if(att1.equals(att2) && att1.equals(att3) && att3.equals("")) {
            ListCh = ListAllCh;
        }
        return ListCh;
    }

}

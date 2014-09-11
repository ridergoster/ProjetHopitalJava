/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daopackage;
import bdclass.Service;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DAOService - Classe destiné à faire le lien entre 
 * l'objet java Service et les données de la BD
 * @author kocupyr
 */
public class DAOService implements DAO<Service> {
    Connection connexion;
    
    /**
     * Constructeur du DAO
     * @param Conn
     * @throws SQLException
     */
    public DAOService(Connection Conn) throws SQLException { 
	connexion = Conn;
    };
				
    @Override
    public List<Service> findAll() throws SQLException {
		List<Service> services = new ArrayList<Service> ();
		Statement s1 = connexion.createStatement();
		String sqlAll = "SELECT * FROM service ";
		ResultSet res1 = s1.executeQuery(sqlAll);

		while (res1.next()) {
		Service service = new Service ();
		service.setCode(res1.getString("code"));
		service.setNomserv(res1.getString("nom"));
		service.setBatiment(res1.getString("batiment").charAt(0));
		service.setDirecteur(res1.getInt("directeur"));
                
		services.add(service);
		}
		res1.close();
		return services;
    }
    
    /**
     * Récupérer les Service d'après leur nom
     * @param nom
     * @return ListService services - ListServiceParNom
     * @throws SQLException
     */
    public List<Service> findByName(String nom) throws SQLException {
		List<Service> services = new ArrayList<Service> ();
		Statement s1 = connexion.createStatement();
		String sqlAll = "SELECT * FROM service WHERE nom LIKE  '%" + nom + "%'";
		ResultSet res1 = s1.executeQuery(sqlAll);

		while (res1.next()) {
		Service service = new Service ();
		service.setCode(res1.getString("code"));
		service.setNomserv(res1.getString("nom"));
		service.setBatiment(res1.getString("batiment").charAt(0));
		service.setDirecteur(res1.getInt("directeur"));
                
		services.add(service);
		}
		res1.close();
		return services;
    }

    @Override
    public Service insert(Service obj) throws SQLException {
        
		Statement s1 = connexion.createStatement();
		// Mise en place INSERT SQL
		String sqlInsert = "INSERT INTO service VALUES (    '" + obj.getCode() + "' , '"
                                                                      + obj.getNomserv()+ "' , '"
                                                                      + obj.getBatiment()+ "' , "
                                                                      + obj.getDirecteur()+ ")";

		s1.executeUpdate(sqlInsert);
		
		// retour Etudiant
		Service service = new Service();
		service.setCode(obj.getCode());
		service.setNomserv(obj.getNomserv());
		service.setBatiment(obj.getBatiment());
		service.setDirecteur(obj.getDirecteur());
		
		System.out.println("insert valide !");
		System.out.println(service + "\n");
		return service;
    }

    @Override
    public boolean update(Service obj) throws SQLException {
		
		// UPDATE SQL
		String sqlUpdate = "UPDATE service" 	
                                    + " SET nom = '" + obj.getNomserv()+ "',"
				    + " batiment = '" + obj.getBatiment()+ "',"
                                    + " directeur = " + obj.getDirecteur()+ " WHERE code = '" + obj.getCode() + "'";
		Statement s1 = connexion.createStatement();
                
		// EXCUTION ET VERIFICATION
		int bool = s1.executeUpdate(sqlUpdate);
		if (bool == 0) {
			System.out.println("Mise à jour non valide...");
			return false;
                }
		else {
			System.out.println("Mise à jour valide !");
			System.out.println(obj + "\n");
			return true;
                }
    } // update(service):boolean

    @Override
    public boolean delete(Service obj) throws SQLException {
		// DELETE SQL
		String sqlDelete = "DELETE FROM service WHERE code = '" + obj.getCode() + "'";
		Statement s1 = connexion.prepareStatement(sqlDelete);
                
		// EXECUTION ET VERIFICATION
		int bool = s1.executeUpdate(sqlDelete);
		if (bool == 0) {
			System.out.println("Suppression non valide...");
			return false;
                }
		else {
			System.out.println("Suppression valide !");
			System.out.println(obj + "\n");
			return true;
                }	
	}// delete(service):boolean

    @Override
    public Service getById(String strT) throws SQLException {
		// service by code
		Service service = new Service ();
		String req = "SELECT * FROM service WHERE code = '" + strT + "'";
		Statement s1 = connexion.prepareStatement(req);
		ResultSet res1 = s1.executeQuery(req);
		
		// Sauvegarde Etudiant
		res1.next();
		service.setCode(res1.getString("code"));
		service.setNomserv(res1.getString("nom"));
		service.setBatiment(res1.getString("batiment").charAt(0));
		service.setDirecteur(res1.getInt("directeur"));
		res1.close();
		
		System.out.println("Requete valide !");
		System.out.println(service + "\n");
		return service;
	}// getById(int):service

    @Override
    public Service getById(int numT) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Service getById(String strT, int numT) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Service getById(int numT1, int numT2) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
    
}

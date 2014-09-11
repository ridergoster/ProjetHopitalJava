/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daopackage;

import bdclass.Employe;
import bdclass.Infirmier;
import bdclass.Service;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DAOInfirmier - Classe destiné à faire le lien entre 
 * l'objet java Infirmier et les données de la BD
 * @author kocupyr
 */
public class DAOInfirmier implements DAO<Infirmier> {
    Connection connexion;
    
    /**
     * Constructeur du DAO
     * @param Conn
     * @throws SQLException
     */
    public DAOInfirmier(Connection Conn) throws SQLException { 
	connexion = Conn;
    };
				
    @Override
    public List<Infirmier> findAll() throws SQLException {
		List<Infirmier> infirmiers = new ArrayList<Infirmier> ();
		Statement s1 = connexion.createStatement();
		String sqlAll = "SELECT * FROM infirmier ";
		ResultSet res1 = s1.executeQuery(sqlAll);

		while (res1.next()) {
                
                Employe employe = new Employe();
                employe.setNumero(res1.getInt("numero"));
                
                Service service = new Service();
                service.setCode(res1.getString("code_service"));
                    
                Infirmier infirmier = new Infirmier();
                
                infirmier.setNumero(employe);
                infirmier.setCode_service(service);
                infirmier.setRotation(res1.getString("rotation"));
                infirmier.setSalaire(res1.getInt("salaire"));
                
		infirmiers.add(infirmier);
		}
		res1.close();
		return infirmiers;
    }

    @Override
    public Infirmier insert(Infirmier obj) throws SQLException {
        
		Statement s1 = connexion.createStatement();
		// Mise en place INSERT SQL
		String sqlInsert = "INSERT INTO infirmier VALUES (    " + obj.getNumero().getNumero() + ",'"
                                                                      + obj.getCode_service().getCode()+ "','"
                                                                      + obj.getRotation()+ "',"
                                                                      + obj.getSalaire()+ ")";

		s1.executeUpdate(sqlInsert);
		
		// retour infirmier
		Infirmier infirmier = new Infirmier();
		infirmier.setNumero(obj.getNumero());
		infirmier.setCode_service(obj.getCode_service());
		infirmier.setRotation(obj.getRotation());
		infirmier.setSalaire(obj.getSalaire());
		
		System.out.println("insert valide !");
		System.out.println(infirmier + "\n");
		return infirmier;
    }

    @Override
    public boolean update(Infirmier obj) throws SQLException {
		
		// UPDATE SQL
		String sqlUpdate = "UPDATE infirmier" 	
                                    + " SET code_service = '" + obj.getCode_service().getCode() + "', " 
                                    + " rotation = '" + obj.getRotation()+ "',"
                                    + " salaire = " + obj.getSalaire()+ ","
                                    + " WHERE numero = " + obj.getNumero().getNumero();
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
    } // update(Infirmier):boolean

    @Override
    public boolean delete(Infirmier obj) throws SQLException {
		// DELETE SQL
		String sqlDelete = "DELETE FROM infirmier WHERE numero = " + obj.getNumero().getNumero();
                
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
	}// delete(Infirmier):boolean

    @Override
    public Infirmier getById(int numT) throws SQLException {
		// Infirmier by code
		Infirmier infirmier = new Infirmier ();
		String req = "SELECT * FROM infirmier WHERE numero = " + numT;
		Statement s1 = connexion.prepareStatement(req);
		ResultSet res1 = s1.executeQuery(req);
		
		// Sauvegarde infirmier
		res1.next();
                
                Employe employe = new Employe();
                employe.setNumero(res1.getInt("numero"));
                
                Service service = new Service();
                service.setCode(res1.getString("code_service"));
                
                infirmier.setNumero(employe);
                infirmier.setCode_service(service);
                infirmier.setRotation(res1.getString("rotation"));
                infirmier.setSalaire(res1.getInt("salaire"));
                
		res1.close();
		
		System.out.println("Requete valide !");
		System.out.println(infirmier + "\n");
		return infirmier;
	}// getById(int):Infirmier

    @Override
    public Infirmier getById(String strT, int numT) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Infirmier getById(String strT) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Infirmier getById(int numT1, int numT2) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

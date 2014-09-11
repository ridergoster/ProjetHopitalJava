/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daopackage;

import bdclass.Chambre;
import bdclass.Hospitalisation;
import bdclass.Malade;
import bdclass.Service;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DAOHospitalisation - Classe destiné à faire le lien entre 
 * l'objet java Hospitalisation et les données de la BD
 * @author kocupyr
 */
public class DAOHospitalisation implements DAO<Hospitalisation> {
    Connection connexion;
    
    /**
     * Constructeur du DAO
     * @param Conn
     * @throws SQLException
     */
    public DAOHospitalisation(Connection Conn) throws SQLException { 
	connexion = Conn;
    };
				
    @Override
    public List<Hospitalisation> findAll() throws SQLException {
		List<Hospitalisation> hospitalisations = new ArrayList<Hospitalisation> ();
		Statement s1 = connexion.createStatement();
		String sqlAll = "SELECT * FROM hospitalisation ";
		ResultSet res1 = s1.executeQuery(sqlAll);

		while (res1.next()) {
                
                Service service = new Service();
                service.setCode(res1.getString("code_service"));
                
                Chambre chambre = new Chambre();
                chambre.setNo_chambre(res1.getInt("no_chambre"));
                
                Malade malade = new Malade();
                malade.setNumero(res1.getInt("no_malade"));
                
                
                Hospitalisation hospitalisation = new Hospitalisation();
                
                hospitalisation.setNo_malade(malade);
                hospitalisation.setCode_service(service);
                hospitalisation.setNo_chambre(chambre);
                hospitalisation.setLit(res1.getInt("lit"));
                
		hospitalisations.add(hospitalisation);
                
		}
		res1.close();
		return hospitalisations;
    }

    @Override
    public Hospitalisation insert(Hospitalisation obj) throws SQLException {
        
		Statement s1 = connexion.createStatement();
		// Mise en place INSERT SQL
		String sqlInsert = "INSERT INTO hospitalisation VALUES (    " + obj.getNo_malade().getNumero() + ",'"
                                                                      + obj.getCode_service().getCode()+ "',"
                                                                      + obj.getNo_chambre().getNo_chambre()+ ","
                                                                      + obj.getLit()+ "')";

		s1.executeUpdate(sqlInsert);
		
		// retour hospitalisation
		Hospitalisation hospitalisation = new Hospitalisation();
		hospitalisation.setNo_malade(obj.getNo_malade());
		hospitalisation.setCode_service(obj.getCode_service());
		hospitalisation.setNo_chambre(obj.getNo_chambre());
		hospitalisation.setLit(obj.getLit());
                
		System.out.println("insert valide !");
		System.out.println(hospitalisation + "\n");
		return hospitalisation;
    }

    @Override
    public boolean update(Hospitalisation obj) throws SQLException {
		
        // Aucune mise à jour possible pour une hospitalisation
	return true;
        
    } // update(Hospitalisation):boolean

    @Override
    public boolean delete(Hospitalisation obj) throws SQLException {
		// DELETE SQL
		String sqlDelete = "DELETE FROM hospitalisation WHERE no_malade = " + obj.getNo_malade().getNumero();
                
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
	}// delete(Hospitalisation):boolean

    @Override
    public Hospitalisation getById(int numT) throws SQLException {
		// Hospitalisation by code
		Hospitalisation hospitalisation = new Hospitalisation ();
		String req = "SELECT * FROM hospitalisation WHERE no_malade = " + numT;
		Statement s1 = connexion.prepareStatement(req);
		ResultSet res1 = s1.executeQuery(req);
		
		// Sauvegarde hospitalisation
		res1.next();
                
                
                Service service = new Service();
                service.setCode(res1.getString("code_service"));
                
                Chambre chambre = new Chambre();
                chambre.setNo_chambre(res1.getInt("no_chambre"));
                
                Malade malade = new Malade();
                malade.setNumero(res1.getInt("no_malade"));
                
                hospitalisation.setNo_malade(malade);
                hospitalisation.setCode_service(service);
                hospitalisation.setNo_chambre(chambre);
                hospitalisation.setLit(res1.getInt("lit"));
                
		res1.close();
		
		System.out.println("Requete valide !");
		System.out.println(hospitalisation + "\n");
		return hospitalisation;
	}// getById(int):Hospitalisation

    @Override
    public Hospitalisation getById(String strT, int numT) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Hospitalisation getById(String strT) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Hospitalisation getById(int numT1, int numT2) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

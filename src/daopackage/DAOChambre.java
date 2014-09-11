/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daopackage;
import bdclass.Chambre;
import bdclass.Service;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DAOChambre - Classe destiné à faire le lien entre 
 * l'objet java Chambre et les données de la BD
 * @author kocupyr
 */
public class DAOChambre implements DAO<Chambre> {
    Connection connexion;
    
    /**
     * Constructeur du DAO
     * @param Conn
     * @throws SQLException
     */
    public DAOChambre(Connection Conn) throws SQLException { 
	connexion = Conn;
    };
				
    @Override
    public List<Chambre> findAll() throws SQLException {
		List<Chambre> chambres = new ArrayList<Chambre> ();
		Statement s1 = connexion.createStatement();
		String sqlAll = "SELECT * FROM chambre ";
		ResultSet res1 = s1.executeQuery(sqlAll);

		while (res1.next()) {
                    
		Chambre chambre = new Chambre();
                
                Service service = new Service();
                service.setCode(res1.getString("code_service"));
                
		chambre.setCode_service(service);
		chambre.setNo_chambre(res1.getInt("no_chambre"));
		chambre.setSurveillant(res1.getInt("surveillant"));
		chambre.setNb_lits(res1.getInt("nb_lits"));
                
		chambres.add(chambre);
		}
		res1.close();
		return chambres;
    }

    /**
     * Récupérer les chambre d'après leur numéro
     * @param num
     * @return ListChambre chambres - ListChambreParNumero
     * @throws SQLException
     */
    public List<Chambre> findByNoCh(int num) throws SQLException {
		List<Chambre> chambres = new ArrayList<Chambre> ();
		Statement s1 = connexion.createStatement();
		String sqlAll = "SELECT * FROM chambre WHERE no_chambre LIKE '%" + num + "%'";
		ResultSet res1 = s1.executeQuery(sqlAll);

		while (res1.next()) {
                    
		Chambre chambre = new Chambre();
                
                Service service = new Service();
                service.setCode(res1.getString("code_service"));
                
		chambre.setCode_service(service);
		chambre.setNo_chambre(res1.getInt("no_chambre"));
		chambre.setSurveillant(res1.getInt("surveillant"));
		chambre.setNb_lits(res1.getInt("nb_lits"));
                
		chambres.add(chambre);
		}
		res1.close();
		return chambres;
    }

    /**
     * Récupérer les chambre d'après leur Surveillant
     * @param num
     * @return ListChambre chambres - ListChambreParSurveillant
     * @throws SQLException
     */
    public List<Chambre> findBySurv(int num) throws SQLException {
		List<Chambre> chambres = new ArrayList<Chambre> ();
		Statement s1 = connexion.createStatement();
		String sqlAll = "SELECT * FROM chambre WHERE surveillant LIKE '%" + num + "%'";
		ResultSet res1 = s1.executeQuery(sqlAll);

		while (res1.next()) {
                    
		Chambre chambre = new Chambre();
                
                Service service = new Service();
                service.setCode(res1.getString("code_service"));
                
		chambre.setCode_service(service);
		chambre.setNo_chambre(res1.getInt("no_chambre"));
		chambre.setSurveillant(res1.getInt("surveillant"));
		chambre.setNb_lits(res1.getInt("nb_lits"));
                
		chambres.add(chambre);
		}
		res1.close();
		return chambres;
    }

    /**
     * Récupérer les chambre d'après leur Service
     * @param serv
     * @return ListChambre chambres - ListChambreParService
     * @throws SQLException
     */
    public List<Chambre> findByServ(String serv) throws SQLException {
		List<Chambre> chambres = new ArrayList<Chambre> ();
		Statement s1 = connexion.createStatement();
		String sqlAll = "SELECT * FROM chambre WHERE code_service LIKE '%" + serv + "%'";
		ResultSet res1 = s1.executeQuery(sqlAll);

		while (res1.next()) {
                    
		Chambre chambre = new Chambre();
                
                Service service = new Service();
                service.setCode(res1.getString("code_service"));
                
		chambre.setCode_service(service);
		chambre.setNo_chambre(res1.getInt("no_chambre"));
		chambre.setSurveillant(res1.getInt("surveillant"));
		chambre.setNb_lits(res1.getInt("nb_lits"));
                
		chambres.add(chambre);
		}
		res1.close();
		return chambres;
    }
    
    /**
     * Récupérer les chambre d'après leur nombre de lits
     * @param lits
     * @return ListChambre chambres - ListChambreParNblit
     * @throws SQLException
     */
    public List<Chambre> findByNbLits(int lits) throws SQLException {
		List<Chambre> chambres = new ArrayList<Chambre> ();
		Statement s1 = connexion.createStatement();
		String sqlAll = "SELECT * FROM chambre WHERE nb_lits LIKE '%" + lits + "%'";
		ResultSet res1 = s1.executeQuery(sqlAll);

		while (res1.next()) {
                    
		Chambre chambre = new Chambre();
                
                Service service = new Service();
                service.setCode(res1.getString("code_service"));
                
		chambre.setCode_service(service);
		chambre.setNo_chambre(res1.getInt("no_chambre"));
		chambre.setSurveillant(res1.getInt("surveillant"));
		chambre.setNb_lits(res1.getInt("nb_lits"));
                
		chambres.add(chambre);
		}
		res1.close();
		return chambres;
    }
    
    @Override
    public Chambre insert(Chambre obj) throws SQLException {
        
		Statement s1 = connexion.createStatement();
		// Mise en place INSERT SQL
		String sqlInsert = "INSERT INTO chambre VALUES (    '" + obj.getCode_service().getCode() + "',"
                                                                      + obj.getNo_chambre()+ ","
                                                                      + obj.getSurveillant()+ ","
                                                                      + obj.getNb_lits()+ ")";

		s1.executeUpdate(sqlInsert);
		
		// retour chambre
		Chambre chambre = new Chambre();
		chambre.setCode_service(obj.getCode_service());
		chambre.setNo_chambre(obj.getNo_chambre());
		chambre.setSurveillant(obj.getSurveillant());
		chambre.setNb_lits(obj.getNb_lits());
		
		System.out.println("insert valide !");
		System.out.println(chambre + "\n");
		return chambre;
    }

    @Override
    public boolean update(Chambre obj) throws SQLException {
		
		// UPDATE SQL
		String sqlUpdate = "UPDATE chambre" 	
                                    + " SET surveillant = " + obj.getSurveillant() + ","
				    + " nb_lits = " + obj.getNb_lits()+ ","
                                    + " WHERE code_service = '" + obj.getCode_service().getCode() + "' AND "
                                    + " no_chambre = " + obj.getNo_chambre();
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
    } // update(Chambre):boolean

    @Override
    public boolean delete(Chambre obj) throws SQLException {
		// DELETE SQL
		String sqlDelete = "DELETE FROM chambre WHERE code_service = '" + obj.getCode_service().getCode() + "' AND "
                                    + " no_chambre = " + obj.getNo_chambre();
                
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
	}// delete(Chambre):boolean

    @Override
    public Chambre getById(String strT, int numT) throws SQLException {
		// Chambre by code
		Chambre chambre = new Chambre ();
		String req = "SELECT * FROM chambre WHERE code_service = '" + strT + "' AND "
                                    + " no_chambre = " + numT;
		Statement s1 = connexion.prepareStatement(req);
		ResultSet res1 = s1.executeQuery(req);
		
		// Sauvegarde chambre
		res1.next();
                
                Service service = new Service();
                service.setCode(res1.getString("code_service"));
                
		chambre.setCode_service(service);
		chambre.setNo_chambre(res1.getInt("no_chambre"));
		chambre.setSurveillant(res1.getInt("surveillant"));
		chambre.setNb_lits(res1.getInt("nb_lits"));
		res1.close();
		
		System.out.println("Requete valide !");
		System.out.println(chambre + "\n");
		return chambre;
	}// getById(int):Chambre

    @Override
    public Chambre getById(int numT) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Chambre getById(String strT) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Chambre getById(int numT1, int numT2) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

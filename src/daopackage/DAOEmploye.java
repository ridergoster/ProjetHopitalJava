/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daopackage;

import bdclass.Employe;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DAOEmploye - Classe destiné à faire le lien entre 
 * l'objet java Employe et les données de la BD
 * @author kocupyr
 */
public class DAOEmploye implements DAO<Employe> {
    Connection connexion;
    
    /**
     * Constructeur du DAO
     * @param Conn
     * @throws SQLException
     */
    public DAOEmploye(Connection Conn) throws SQLException { 
	connexion = Conn;
    };
				
    @Override
    public List<Employe> findAll() throws SQLException {
		List<Employe> employes = new ArrayList<Employe> ();
		Statement s1 = connexion.createStatement();
		String sqlAll = "SELECT * FROM employe ";
		ResultSet res1 = s1.executeQuery(sqlAll);

		while (res1.next()) {
                
                Employe employe = new Employe();
                employe.setNumero(res1.getInt("numero"));
                employe.setNom(res1.getString("nom"));
                employe.setPrenom(res1.getString("prenom"));
                employe.setAdr(res1.getString("adresse"));
		employe.setTel(res1.getString("tel"));
                
		employes.add(employe);
		}
		res1.close();
		return employes;
    }
    
    /**
     * Récupérer les Employe d'après leur nom
     * @param nom
     * @return ListEmploye employes - ListEmployeParNom
     * @throws SQLException
     */
    public List<Employe> findByNom(String nom) throws SQLException {
		List<Employe> employes = new ArrayList<Employe> ();
		Statement s1 = connexion.createStatement();
		String sqlAll = "SELECT * FROM employe WHERE nom LIKE '%" + nom + "%'";
		ResultSet res1 = s1.executeQuery(sqlAll);

		while (res1.next()) {
                
                Employe employe = new Employe();
                employe.setNumero(res1.getInt("numero"));
                employe.setNom(res1.getString("nom"));
                employe.setPrenom(res1.getString("prenom"));
                employe.setAdr(res1.getString("adresse"));
		employe.setTel(res1.getString("tel"));
                
		employes.add(employe);
		}
		res1.close();
		return employes;
    }

    /**
     * Récupérer les Employe d'après leur prenom
     * @param prenom
     * @return ListEmploye employes - ListEmployeParPrenom
     * @throws SQLException
     */
    public List<Employe> findByPrenom(String prenom) throws SQLException {
		List<Employe> employes = new ArrayList<Employe> ();
		Statement s1 = connexion.createStatement();
		String sqlAll = "SELECT * FROM employe WHERE prenom LIKE '%" + prenom + "%'";
		ResultSet res1 = s1.executeQuery(sqlAll);

		while (res1.next()) {
                
                Employe employe = new Employe();
                employe.setNumero(res1.getInt("numero"));
                employe.setNom(res1.getString("nom"));
                employe.setPrenom(res1.getString("prenom"));
                employe.setAdr(res1.getString("adresse"));
		employe.setTel(res1.getString("tel"));
                
		employes.add(employe);
		}
		res1.close();
		return employes;
    }

    /**
     * Récupérer les Employe d'après leur adresse
     * @param adresse
     * @return ListEmploye employes - ListEmployeParAdr
     * @throws SQLException
     */
    public List<Employe> findByAdr(String adresse) throws SQLException {
		List<Employe> employes = new ArrayList<Employe> ();
		Statement s1 = connexion.createStatement();
		String sqlAll = "SELECT * FROM employe WHERE adresse LIKE '%" + adresse + "%'";
		ResultSet res1 = s1.executeQuery(sqlAll);

		while (res1.next()) {
                
                Employe employe = new Employe();
                employe.setNumero(res1.getInt("numero"));
                employe.setNom(res1.getString("nom"));
                employe.setPrenom(res1.getString("prenom"));
                employe.setAdr(res1.getString("adresse"));
		employe.setTel(res1.getString("tel"));
                
		employes.add(employe);
		}
		res1.close();
		return employes;
    }

    /**
     * Récupérer les Employe d'après leur telephone
     * @param tel
     * @return ListEmploye employes - ListEmployeParTel
     * @throws SQLException
     */
    public List<Employe> findByTel(String tel) throws SQLException {
		List<Employe> employes = new ArrayList<Employe> ();
		Statement s1 = connexion.createStatement();
		String sqlAll = "SELECT * FROM employe WHERE tel LIKE '%" + tel + "%'";
		ResultSet res1 = s1.executeQuery(sqlAll);

		while (res1.next()) {
                
                Employe employe = new Employe();
                employe.setNumero(res1.getInt("numero"));
                employe.setNom(res1.getString("nom"));
                employe.setPrenom(res1.getString("prenom"));
                employe.setAdr(res1.getString("adresse"));
		employe.setTel(res1.getString("tel"));
                
		employes.add(employe);
		}
		res1.close();
		return employes;
    }
    @Override
    public Employe insert(Employe obj) throws SQLException {
        
		Statement s1 = connexion.createStatement();
		// Mise en place INSERT SQL
		String sqlInsert = "INSERT INTO employe VALUES (    " + obj.getNumero()+ ",'"
                                                                      + obj.getNom()+ "','"
                                                                      + obj.getPrenom()+ "','"
                                                                      + obj.getAdr()+ "','"
                                                                      + obj.getTel()+ "')";

		s1.executeUpdate(sqlInsert);
		
		// retour employe
		Employe employe = new Employe();
		employe.setNumero(obj.getNumero());
		employe.setAdr(obj.getAdr());
		employe.setNom(obj.getNom());
		employe.setPrenom(obj.getPrenom());
                employe.setTel(obj.getTel());
		
		System.out.println("insert valide !");
		System.out.println(employe + "\n");
		return employe;
    }

    @Override
    public boolean update(Employe obj) throws SQLException {
		
		// UPDATE SQL
		String sqlUpdate = "UPDATE employe" 	
                                    + " SET nom = '" + obj.getNom()+ "', " 
                                    + " prenom = '" + obj.getPrenom() + "',"
                                    + " adresse = '" + obj.getAdr() + "',"
                                    + " tel = '" + obj.getTel() + "',"
                                    + " WHERE numero = " + obj.getNumero();
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
    } // update(Employe):boolean

    @Override
    public boolean delete(Employe obj) throws SQLException {
		// DELETE SQL
		String sqlDelete = "DELETE FROM employe WHERE numero = " + obj.getNumero();
                
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
	}// delete(Employe):boolean

    @Override
    public Employe getById(int numT) throws SQLException {
		// Employe by code
		Employe employe = new Employe ();
		try{
                    String req = "SELECT * FROM employe WHERE numero = " + numT;
                    Statement s1 = connexion.prepareStatement(req);
                    ResultSet res1 = s1.executeQuery(req);

                    // Sauvegarde employe
                    res1.next();

                    employe.setNumero(res1.getInt("numero"));
                    employe.setNom(res1.getString("nom"));
                    employe.setPrenom(res1.getString("prenom"));
                    employe.setAdr(res1.getString("adresse"));
                    employe.setTel(res1.getString("tel"));
                    res1.close();

                    System.out.println("Requete valide !");
                    System.out.println(employe + "\n");
                }
                catch(SQLException e){}
		return employe;
	}// getById(int):Employe

    @Override
    public Employe getById(String strT, int numT) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Employe getById(String strT) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Employe getById(int numT1, int numT2) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
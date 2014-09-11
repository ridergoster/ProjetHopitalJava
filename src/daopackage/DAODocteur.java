/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daopackage;

import bdclass.Docteur;
import bdclass.Employe;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DAODocteur - Classe destiné à faire le lien entre 
 * l'objet java Docteur et les données de la BD
 * @author kocupyr
 */
public class DAODocteur implements DAO<Docteur> {
    Connection connexion;
    
    /**
     * Constructeur du DAO
     * @param Conn
     * @throws SQLException
     */
    public DAODocteur(Connection Conn) throws SQLException { 
	connexion = Conn;
    };
				
    @Override
    public List<Docteur> findAll() throws SQLException {
		List<Docteur> docteurs = new ArrayList<Docteur> ();
		Statement s1 = connexion.createStatement();
		String sqlAll = "SELECT * FROM docteur ";
		ResultSet res1 = s1.executeQuery(sqlAll);

		while (res1.next()) {
                    
		Docteur docteur = new Docteur();
                
                Employe hospitalisation = new Employe();
                hospitalisation.setNumero(res1.getInt("numero"));
                
		docteur.setNumero(hospitalisation);
		docteur.setSpecialite(res1.getString("specialite"));
                
		docteurs.add(docteur);
		}
		res1.close();
		return docteurs;
    }

    /**
     * Récupérer les Docteurs d'après leur spécialité
     * @param spe
     * @return ListDocteur docteurs - ListDocteurParSpe
     * @throws SQLException
     */
    public List<Docteur> findBySpe(String spe) throws SQLException {
		List<Docteur> docteurs = new ArrayList<Docteur> ();
		Statement s1 = connexion.createStatement();
		String sqlAll = "SELECT * FROM docteur WHERE specialite LIKE '%" + spe + "%'";
		ResultSet res1 = s1.executeQuery(sqlAll);

		while (res1.next()) {
                    
		Docteur docteur = new Docteur();
                
                Employe hospitalisation = new Employe();
                hospitalisation.setNumero(res1.getInt("numero"));
                
		docteur.setNumero(hospitalisation);
		docteur.setSpecialite(res1.getString("specialite"));
                
		docteurs.add(docteur);
		}
		res1.close();
		return docteurs;
    }
    @Override
    public Docteur insert(Docteur obj) throws SQLException {
        
		Statement s1 = connexion.createStatement();
		// Mise en place INSERT SQL
		String sqlInsert = "INSERT INTO docteur VALUES (    " + obj.getNumero().getNumero() + ",'"
                                                                      + obj.getSpecialite()+ "')";

		s1.executeUpdate(sqlInsert);
		
		// retour docteur
		Docteur docteur = new Docteur();
		docteur.setNumero(obj.getNumero());
		docteur.setSpecialite(obj.getSpecialite());
		
		System.out.println("insert valide !");
		System.out.println(docteur + "\n");
		return docteur;
    }

    @Override
    public boolean update(Docteur obj) throws SQLException {
		
		// UPDATE SQL
		String sqlUpdate = "UPDATE docteur" 	
                                    + " SET specialite = '" + obj.getSpecialite()+ "' "
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
    } // update(Docteur):boolean

    @Override
    public boolean delete(Docteur obj) throws SQLException {
		// DELETE SQL
		String sqlDelete = "DELETE FROM docteur WHERE numero = " + obj.getNumero().getNumero();
                
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
	}// delete(Docteur):boolean

    @Override
    public Docteur getById(int numT) throws SQLException {
            Docteur docteur = new Docteur ();
            try
            {
		// Docteur by code

		String req = "SELECT * FROM docteur WHERE numero = " + numT;
		Statement s1 = connexion.prepareStatement(req);
		ResultSet res1 = s1.executeQuery(req);
		
		// Sauvegarde docteur
		res1.next();
                
                Employe hospitalisation = new Employe();
                hospitalisation.setNumero(res1.getInt("numero"));
                
		docteur.setNumero(hospitalisation);
		docteur.setSpecialite(res1.getString("specialite"));
		res1.close();
		
		System.out.println("Requete valide !");
		System.out.println(docteur + "\n");
		return docteur;
            }
            catch(SQLException e){}
            return docteur;
	}// getById(int):Docteur

    @Override
    public Docteur getById(String strT, int numT) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Docteur getById(String strT) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Docteur getById(int numT1, int numT2) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
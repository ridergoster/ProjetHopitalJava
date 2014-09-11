/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daopackage;

import bdclass.Docteur;
import bdclass.Employe;
import bdclass.Malade;
import bdclass.Soigne;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DAOSoigne - Classe destiné à faire le lien entre 
 * l'objet java Soigne et les données de la BD
 * @author kocupyr
 */
public class DAOSoigne implements DAO<Soigne> {
    Connection connexion;
    
    /**
     * Constructeur du DAO
     * @param Conn
     * @throws SQLException
     */
    public DAOSoigne(Connection Conn) throws SQLException { 
	connexion = Conn;
    };
				
    @Override
    public List<Soigne> findAll() throws SQLException {
		List<Soigne> soignes = new ArrayList<Soigne> ();
		Statement s1 = connexion.createStatement();
		String sqlAll = "SELECT * FROM soigne ";
		ResultSet res1 = s1.executeQuery(sqlAll);

		while (res1.next()) {
                    
                Soigne soigne = new Soigne();
                Docteur docteur = new Docteur();
                Employe employe = new Employe();
                Malade malade = new Malade();
                
                employe.setNumero(res1.getInt("no_docteur"));
                docteur.setNumero(employe);
                
                malade.setNumero(res1.getInt("no_malade"));
                
                soigne.setNo_docteur(docteur);
                soigne.setNo_malade(malade);
                
		soignes.add(soigne);
		}
		res1.close();
		return soignes;
    }

    @Override
    public Soigne insert(Soigne obj) throws SQLException {
        
		Statement s1 = connexion.createStatement();
		// Mise en place INSERT SQL
		String sqlInsert = "INSERT INTO soigne VALUES (    " + obj.getNo_docteur().getNumero().getNumero() + ","
                                                                      + obj.getNo_malade().getNumero() + ")";

		s1.executeUpdate(sqlInsert);
		
		// retour Soigne
		Soigne soigne = new Soigne();
                soigne.setNo_docteur(obj.getNo_docteur());
                soigne.setNo_malade(obj.getNo_malade());
		
		System.out.println("insert valide !");
		System.out.println(soigne + "\n");
		return soigne;
    }

    @Override
    public boolean update(Soigne obj) throws SQLException {
        // Aucune mise à jour prévue ici
        return true;
    } // update(Soigne):boolean

    @Override
    public boolean delete(Soigne obj) throws SQLException {
		// DELETE SQL
		String sqlDelete = "DELETE FROM soigne WHERE no_docteur = " + obj.getNo_docteur().getNumero().getNumero() +
                                   " AND no_malade = " + obj.getNo_malade().getNumero();
                
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
	}// delete(Soigne):boolean

    @Override
    public Soigne getById(int numT1, int numT2) throws SQLException {
		// Soigne by code
		Soigne soigne = new Soigne ();
		String req = "SELECT * FROM soigne WHERE no_docteur = " + numT1 +
                                   " AND no_malade = " + numT2;
		Statement s1 = connexion.prepareStatement(req);
		ResultSet res1 = s1.executeQuery(req);
		
		// Sauvegarde Soigne
		res1.next();
                
                Docteur docteur = new Docteur();
                Employe employe = new Employe();
                Malade malade = new Malade();
                
                employe.setNumero(res1.getInt("no_docteur"));
                docteur.setNumero(employe);
                
                malade.setNumero(res1.getInt("no_malade"));
                
                soigne.setNo_docteur(docteur);
                soigne.setNo_malade(malade);
                
                
		res1.close();
		
		System.out.println("Requete valide !");
		System.out.println(soigne + "\n");
		return soigne;
	}// getById(int):Soigne

    @Override
    public Soigne getById(String strT, int numT) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Soigne getById(String strT) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Soigne getById(int numT) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

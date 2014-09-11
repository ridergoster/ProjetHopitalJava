/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daopackage;

import bdclass.Malade;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DAOMalade - Classe destiné à faire le lien entre 
 * l'objet java Malade et les données de la BD
 * @author kocupyr
 */
public class DAOMalade implements DAO<Malade> {
    Connection connexion;
    
    /**
     * Constructeur du DAO
     * @param Conn
     * @throws SQLException
     */
    public DAOMalade(Connection Conn) throws SQLException { 
	connexion = Conn;
    };
				
    @Override
    public List<Malade> findAll() throws SQLException {
		List<Malade> malades = new ArrayList<Malade> ();
		Statement s1 = connexion.createStatement();
		String sqlAll = "SELECT * FROM malade ";
		ResultSet res1 = s1.executeQuery(sqlAll);

		while (res1.next()) {
                    
                Malade malade = new Malade();
                
                malade.setNumero(res1.getInt("numero"));
                malade.setNom(res1.getString("nom"));
                malade.setPrenom(res1.getString("prenom"));
                malade.setAdr(res1.getString("adresse"));
                malade.setTel(res1.getString("tel"));
                malade.setMutuelle(res1.getString("mutuelle"));
                
		malades.add(malade);
		}
		res1.close();
		return malades;
    }

    /**
     * Récupérer les Malade d'après leur nom
     * @param nom
     * @return ListMalade malades - ListMaladeParNom
     * @throws SQLException
     */
    public List<Malade> findByName(String nom) throws SQLException {
		List<Malade> malades = new ArrayList<Malade> ();
		Statement s1 = connexion.createStatement();
		String sqlAll = "SELECT * FROM malade WHERE nom LIKE '%"+nom+"%'";
		ResultSet res1 = s1.executeQuery(sqlAll);

		while (res1.next()) {
                    
                Malade malade = new Malade();
                
                malade.setNumero(res1.getInt("numero"));
                malade.setNom(res1.getString("nom"));
                malade.setPrenom(res1.getString("prenom"));
                malade.setAdr(res1.getString("adresse"));
                malade.setTel(res1.getString("tel"));
                malade.setMutuelle(res1.getString("mutuelle"));
                
		malades.add(malade);
		}
		res1.close();
		return malades;
    }
    @Override
    public Malade insert(Malade obj) throws SQLException {
        
		Statement s1 = connexion.createStatement();
		// Mise en place INSERT SQL
		String sqlInsert = "INSERT INTO malade VALUES (    " + obj.getNumero() + ",'"
                                                                      + obj.getNom()+ "','"
                                                                      + obj.getPrenom()+ "','"
                                                                      + obj.getAdr()+ "','"
                                                                      + obj.getTel()+"','"
                                                                      + obj.getMutuelle()+ "')";

		s1.executeUpdate(sqlInsert);
		
		// retour malade
		Malade malade = new Malade();
                malade.setNumero(obj.getNumero());
                malade.setNom(obj.getNom());
                malade.setPrenom(obj.getPrenom());
                malade.setAdr(obj.getAdr());
                malade.setTel(obj.getTel());
                malade.setMutuelle(obj.getMutuelle());
		
		System.out.println("insert valide !");
		System.out.println(malade + "\n");
		return malade;
    }

    @Override
    public boolean update(Malade obj) throws SQLException {
		
		// UPDATE SQL
		String sqlUpdate = "UPDATE malade" 	
                                    + " SET nom = '" + obj.getNom()+ "', " 
                                    + " prenom = '" + obj.getPrenom()+ "',"
                                    + " adresse = '" + obj.getAdr()+ "',"
                                    + " tel = '" + obj.getTel()+ "',"
                                    + " mutuelle = '" + obj.getMutuelle()+ "',"
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
    } // update(Malade):boolean

    @Override
    public boolean delete(Malade obj) throws SQLException {
		// DELETE SQL
		String sqlDelete = "DELETE FROM malade WHERE numero = " + obj.getNumero();
                
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
	}// delete(Malade):boolean

    @Override
    public Malade getById(int numT) throws SQLException {
		// Malade by code
		Malade malade = new Malade ();
		String req = "SELECT * FROM malade WHERE numero = " + numT;
		Statement s1 = connexion.prepareStatement(req);
		ResultSet res1 = s1.executeQuery(req);
		
		// Sauvegarde malade
		res1.next();
                
                malade.setNumero(res1.getInt("numero"));
                malade.setNom(res1.getString("nom"));
                malade.setPrenom(res1.getString("prenom"));
                malade.setAdr(res1.getString("adresse"));
                malade.setTel(res1.getString("tel"));
                malade.setMutuelle(res1.getString("mutuelle"));
                
		res1.close();
		
		System.out.println("Requete valide !");
		System.out.println(malade + "\n");
		return malade;
	}// getById(int):Malade

    @Override
    public Malade getById(String strT, int numT) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Malade getById(String strT) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Malade getById(int numT1, int numT2) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}


package daopackage;

import java.sql.SQLException;
import java.util.List;

/**
 * Interface DAO : Data Access Object : Objet destiné à faire le lien entre 
 * les objet java et les données de la BD
 * @author Vincent
 * @param <T>
 */
public abstract interface DAO<T> {
	
	/**
	 * Permet de recuperer tout les objet
	 * @return ListT - tout les objet d'une table
	 * @throws SQLException 
	 */
	public List<T> findAll() throws SQLException;
	
	/**
	 * Permet de creer une entree dans la base de donnees
	 * par rapport a un objet
	 * @param obj
         * @return  T - L'objet inséré en BD
	 * @throws SQLException 
	 */
	public T insert(T obj) throws SQLException;
	
	/**
	 * Permet de mettre a jour les donnees d'une entree dans la base 
	 * @param obj
         * @return  boolean TRUE (update OK) - FALSE (update échoué)
	 * @throws SQLException 
	 */
	public boolean update(T obj) throws SQLException;
	
	/**
	 * Permet la suppression d'une entree de la base
	 * @param obj
         * @return  boolean TRUE (deletre ok) - FALSE (delete échoué)
	 * @throws SQLException 
	 */
	public boolean delete(T obj) throws SQLException;
	
	/**
	 * permet de recuprer un objet depuis son identifiant
         * @param numT
         * @return T - Objet récupéré par son ID
	 * @throws SQLException 
	 */
	public T getById(int numT) throws SQLException;
        
	/**
	 * permet de recuprer un objet depuis son identifiant
	 * @param strT
         * @return T - Objet récupéré par son ID
	 * @throws SQLException 
	 */
	public T getById(String strT) throws SQLException;
        
        /**
	 * permet de recuprer un objet depuis son identifiant
	 * @param strT
         * @param numT
         * @return T - Objet récupéré par son ID
	 * @throws SQLException 
	 */
        public T getById(String strT, int numT) throws SQLException;
        
        
        /**
	 * permet de recuprer un objet depuis son identifiant
	 * @param numT1
         * @param numT2
         * @return T - Objet récupéré par son ID
	 * @throws SQLException 
	 */
        public T getById(int numT1, int numT2) throws SQLException;
}
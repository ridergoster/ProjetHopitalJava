/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connexionpackage;

/*
 * 
 * Librairies importées
 */
import java.sql.*;

/*
 * 
 * Connexion a votre BDD via le tunnel SSH
 * 
 * @author segado
 */
public class Connexion {

    /**
     * Attributs prives : connexion JDBC
     */
    private static Connection conn;
    private static SSHTunnel ssh;

    /**
     * Constructeur de Connexion
     */
    public Connexion() { }

    /**
     * Connection au réseau SSH via mysql
     * @param usernameECE
     * @param passwordECE
     * @return boolean TRUE (Connection ok) - FALSE (Connection échoué)
     * @throws ClassNotFoundException
     */
    public static boolean ConnexionSSH(String usernameECE, String passwordECE) throws ClassNotFoundException {
        
        // chargement driver "com.mysql.jdbc.Driver"
        Class.forName("com.mysql.jdbc.Driver");

        // Connexion via le tunnel SSH avec le username et le password ECE
        Connexion.ssh = new SSHTunnel(usernameECE, passwordECE);
        return ssh.connect();
    }
    
    /**
     * Connection à la BD via mysql
     * @param usernameECE
     * @param loginDatabase
     * @param passwordDatabase
     * @return boolean TRUE (Connection ok) - FALSE (Connection échoué)
     */
    public static boolean ConnexionBD(String usernameECE, String loginDatabase, String passwordDatabase) {
        System.out.println("Connexion Utilisateur reussie");

        // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
        String urlDatabase = "jdbc:mysql://localhost:3305/" + usernameECE;
        
        try {
            //création d'une connexion JDBC à la base
            Connexion.conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);
            System.out.println("Connexion BD reussie");
            System.out.println("Ouverture de la fenetre de Travail...");
            return true;
        }
        catch(SQLException e) {
            System.out.println("Erreur Connexion BD : mauvais identifiant ou BD introuvable");
        }
        
        return false;
    }
    
    /**
     * Connection à la BD en local via mysql
     * @param nomBD
     * @param loginDatabase
     * @param passwordDatabase
     * @return boolean TRUE (Connection ok) - FALSE (Connection échoué)
     */
    public static boolean ConnexionLocal(String nomBD, String loginDatabase, String passwordDatabase) {
        System.out.println("Connexion Utilisateur reussie");

        // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
        String urlDatabase = "jdbc:mysql://localhost/" + nomBD;
        
        try {
            //création d'une connexion JDBC à la base
            Connexion.conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);
            System.out.println("Connexion BD reussie");
            System.out.println("Ouverture de la fenetre de Travail...");
            return true;
        }
        catch(SQLException e) {
            System.out.println("Erreur Connexion BD : mauvais identifiant ou BD introuvable");
        }
        
        return false;
    }
    
    /**
     * 
     *
     * @return Connection - renvoie l'objet instancié de la connexion établie au démarrage
     */
    public static Connection getInstance(){
		return Connexion.conn;	
	}
}


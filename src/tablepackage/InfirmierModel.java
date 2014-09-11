/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tablepackage;

import bdclass.Infirmier;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * InfirmierModel : Model utilisé pour le tableau d'affichage de Infirmier
 * @author Trask
 */
public class InfirmierModel extends AbstractTableModel {
    
private final String[] entetes = { "Numero", "Nom", "Prénom","Service", "Telephone", "Adresse", "Rotation" };

	private final List<Infirmier> infirmiers;

    /**
     * Constructeur de InfirmierModel
     * @param list
     */
    public InfirmierModel(List<Infirmier> list) {
		super();
                infirmiers = list;
	}

	@Override
	public int getColumnCount() {
		return entetes.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	@Override
	public int getRowCount() {
		return infirmiers.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {

		case 0:
			// Numero
			return infirmiers.get(rowIndex).getNumero().getNumero();

		case 1:
			// Nom
			return infirmiers.get(rowIndex).getNumero().getNom();

		case 2:
			// Prenom
			return infirmiers.get(rowIndex).getNumero().getPrenom();

                case 3:
                        // Nom Service
                        return infirmiers.get(rowIndex).getCode_service().getNomserv();
                  
		case 4:
			// Telephone
			return infirmiers.get(rowIndex).getNumero().getTel();

		case 5:
			// Adresse
			return infirmiers.get(rowIndex).getNumero().getAdr();
		case 6:
			// Rotation
			return infirmiers.get(rowIndex).getRotation();
		default:
			throw new IllegalArgumentException();
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {

		case 0:
                        return Integer.class;
		case 1:
		case 2:
		case 3:
		case 4:
                case 5:
                case 6:
                        return String.class;
		default:
			return Object.class;
		}
	}

}
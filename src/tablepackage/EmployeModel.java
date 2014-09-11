/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tablepackage;

import bdclass.Employe;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * EmployeModel : Model utilisé pour le tableau d'affichage de Employe
 * @author kocupyr
 */
public class EmployeModel extends AbstractTableModel {
    
private final String[] entetes = { "Numero", "Nom", "Prénom", "Telephone", "Adresse" };

	private final List<Employe> employes;

    /**
     * Constructeur de EmployeModel
     * @param list
     */
    public EmployeModel(List<Employe> list) {
		super();
                employes = list;
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
		return employes.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {

		case 0:
			// Numero
			return employes.get(rowIndex).getNumero();

		case 1:
			// Nom
			return employes.get(rowIndex).getNom();

		case 2:
			// Prenom
			return employes.get(rowIndex).getPrenom();

		case 3:
			// Telephone
			return employes.get(rowIndex).getTel();

		case 4:
			// Adresse
			return employes.get(rowIndex).getAdr();

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
                        return String.class;
		default:
			return Object.class;
		}
	}
}
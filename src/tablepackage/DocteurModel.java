/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tablepackage;

import bdclass.Docteur;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * DocteurModel : Model utilisé pour le tableau d'affichage de Docteur
 * @author kocupyr
 */
public class DocteurModel extends AbstractTableModel {
    
private final String[] entetes = { "Numero", "Nom", "Prénom", "Telephone", "Adresse", "Specialite" };

	private final List<Docteur> docteurs;

    /**
     * Constructeur de DocteurModel
     * @param list
     */
    public DocteurModel(List<Docteur> list) {
		super();
                docteurs = list;
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
		return docteurs.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {

		case 0:
			// Numero
			return docteurs.get(rowIndex).getNumero().getNumero();

		case 1:
			// Nom
			return docteurs.get(rowIndex).getNumero().getNom();

		case 2:
			// Prenom
			return docteurs.get(rowIndex).getNumero().getPrenom();

		case 3:
			// Telephone
			return docteurs.get(rowIndex).getNumero().getTel();

		case 4:
			// Adresse
			return docteurs.get(rowIndex).getNumero().getAdr();
		case 5:
			// Specialite
			return docteurs.get(rowIndex).getSpecialite();
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
                        return String.class;
		default:
			return Object.class;
		}
	}
}
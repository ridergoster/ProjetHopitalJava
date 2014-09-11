/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tablepackage;

import bdclass.*;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * MaladeModel : Model utilisé pour le tableau d'affichage de Malade
 * @author kocupyr
 */
public class MaladeModel extends AbstractTableModel {
    
private final String[] entetes = { "Numero", "Nom", "Prenom", "Telephone", "Mutuelle"};

	private final List<Malade> malades;

    /**
     * Constructeur de MaladeModel
     * @param list
     */
    public MaladeModel(List<Malade> list) {
		super();
                malades = list;
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
		return malades.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {

		case 0:
			// Numero
			return malades.get(rowIndex).getNumero();

		case 1:
			// Nom
			return malades.get(rowIndex).getNom();

		case 2:
			// Prenom
			return malades.get(rowIndex).getPrenom();

		case 3:
			// Telephone
			return malades.get(rowIndex).getTel();
                    
		case 4:
                        // Adresse
			return malades.get(rowIndex).getAdr();
                    
		case 5:
			// Mutuelle
			return malades.get(rowIndex).getMutuelle();
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
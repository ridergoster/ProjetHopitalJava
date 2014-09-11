/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tablepackage;

import bdclass.*;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * SoigneModel : Model utilisé pour le tableau d'affichage de Soigne
 * @author kocupyr
 */
public class SoigneModel extends AbstractTableModel {
    
private final String[] entetes = { "Numero Docteur", "Nom Docteur", "Specialite", "Numero Malade", "Nom","Mutuelle"};

	private final List<Soigne> soignes;

    /**
     * Constructeur de SoigneModel
     * @param list
     */
    public SoigneModel(List<Soigne> list) {
		super();
                soignes = list;
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
		return soignes.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {

		case 0:
			// Numero
			return soignes.get(rowIndex).getNo_docteur().getNumero().getNumero();

		case 1:
			// Nom
			return soignes.get(rowIndex).getNo_docteur().getNumero().getNom();

		case 2:
			// Specialite
			return soignes.get(rowIndex).getNo_docteur().getSpecialite();

		case 3:
			// Numero
			return soignes.get(rowIndex).getNo_malade().getNumero();
                    
		case 4:
                        // Nom
			return soignes.get(rowIndex).getNo_malade().getNom();
                    
		case 5:
			// Mutuelle
			return soignes.get(rowIndex).getNo_malade().getMutuelle();
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
                        return String.class;
		case 3:
                        return Integer.class;
		case 4:
                case 5: 
                        return String.class;
		default:
			return Object.class;
		}
	}
}

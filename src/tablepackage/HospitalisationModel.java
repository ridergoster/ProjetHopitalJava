/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tablepackage;

import bdclass.*;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * HospitalisationModel : Model utilisé pour le tableau d'affichage
 * de Hospitalisation
 * @author kocupyr
 */
public class HospitalisationModel extends AbstractTableModel {
    
private final String[] entetes = { "Numero Malade","Nom Malade", "Numero Service", "Nom Service", "Chambre", "Numero Lit"};

	private final List<Hospitalisation> hospitalisations;

    /**
     * Constructeur de HospitalisationModel
     * @param list
     */
    public HospitalisationModel(List<Hospitalisation> list) {
		super();
                hospitalisations = list;
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
		return hospitalisations.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {

		case 0:
			// Numero
			return hospitalisations.get(rowIndex).getNo_malade().getNumero();

		case 1:
			// Nom
			return hospitalisations.get(rowIndex).getNo_malade().getNom();

		case 2:
			// Specialite
			return hospitalisations.get(rowIndex).getCode_service().getCode();

		case 3:
			// Numero
			return hospitalisations.get(rowIndex).getCode_service().getNomserv();
                    
		case 4:
                        // Nom
			return hospitalisations.get(rowIndex).getNo_chambre().getNo_chambre();
                    
		case 5:
			// Mutuelle
			return hospitalisations.get(rowIndex).getLit();
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
                case 5: 
                        return Integer.class;
		default:
			return Object.class;
		}
	}

}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tablepackage;

import bdclass.*;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * ChambreModel : Model utilisé pour le tableau d'affichage de Chambre
 * @author kocupyr
 */
public class ChambreModel extends AbstractTableModel {
    
private final String[] entetes = {"Numero Chambre","Surveillant","Nom Service","Nombres de lits"};
private final List<Chambre> chambres;

    /**
     * Constructeur de ChambreModel
     * @param list
     */
    public ChambreModel(List<Chambre> list) {
		super();
                chambres = list;
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
		return chambres.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {

		case 0:
			// Num_Chambre
			return chambres.get(rowIndex).getNo_chambre();

		case 1:
			// Surveillant
			return chambres.get(rowIndex).getSurveillant();

		case 2:
			// Nom_Service
			return chambres.get(rowIndex).getCode_service().getNomserv();

		case 3:
			// Nbr_lits
			return chambres.get(rowIndex).getNb_lits();
		default:
			throw new IllegalArgumentException();
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {

		case 0:
		case 1:
                        return Integer.class;
		case 2:
                        return String.class;
		case 3:
                        return Integer.class;
		default:
			return Object.class;
		}
	}

}
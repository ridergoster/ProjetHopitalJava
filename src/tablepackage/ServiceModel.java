/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tablepackage;

import bdclass.Service;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * ServiceModel : Model utilisé pour le tableau d'affichage de Service
 * @author Trask
 */
public class ServiceModel extends AbstractTableModel {
    
private final String[] entetes = { "Code du Service", "Nom Service", "Batiment","Directeur"};

	private final List<Service> services;

    /**
     * Constructeur de ServiceModel
     * @param list
     */
    public ServiceModel(List<Service> list) {
		super();
                services = list;
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
		return services.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {

		case 0:
			// Code du service
			return services.get(rowIndex).getCode();

		case 1:
			// Nom du service
			return services.get(rowIndex).getNomserv();

		case 2:
			// Batiment
			return services.get(rowIndex).getBatiment();

                case 3:
                        //Directeur
                        return services.get(rowIndex).getDirecteur();
                  
		default:
			throw new IllegalArgumentException();
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {

		case 0:
		case 1:
                        return String.class;
		case 2:
                        return Character.class;
		case 3:
                        return Integer.class;
		default:
			return Object.class;
		}
	}
        
}
    


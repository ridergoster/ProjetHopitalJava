/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hopital;

import bdclass.Chambre;
import bdclass.Docteur;
import bdclass.Employe;
import bdclass.Hospitalisation;
import bdclass.Infirmier;
import bdclass.Malade;
import bdclass.Service;
import bdclass.Soigne;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import jobpackage.JobDocteur;
import jobpackage.JobEmploye;
import jobpackage.JobInfirmier;
import jobpackage.JobMalade;
import jobpackage.JobSoigne;
import lib.img;
import tablepackage.ChambreModel;
import tablepackage.DocteurModel;
import tablepackage.EmployeModel;
import tablepackage.HospitalisationModel;
import tablepackage.InfirmierModel;
import tablepackage.MaladeModel;
import tablepackage.ServiceModel;
import tablepackage.SoigneModel;

/**
 * Fenetre RechercheTab. Le résultat de la recherche est affiché ici. De plus
 * nous pouvons selectionner les éléments pour les supprimer ou les modifié
 * dans la BD.
 * @author Trask
 * 
 */
public class RechercheTab extends JFrame implements ActionListener {

        
	private final JTable table;
        private final JButton retour, edit, supprimer;
        private final JScrollPane pane;
        private final JPanel barbut;
        private int nbr;

    /**
     * Constructeur de RechercheTab
     * @param list
     * @param var
     * @throws SQLException
     * @throws IOException
     */
    public RechercheTab(List<?> list, int var) throws SQLException, IOException {
                
		super();
                retour = new JButton("Retour");
                edit = new JButton("Edit");
                supprimer = new JButton("Supprimer");
                
                InputStream input = img.class.getResourceAsStream("med.jpg");
                JPanel panneau=new PanelImage(input);
                barbut = new JPanel(new GridLayout(1,3));
                panneau.setLayout(new BorderLayout());
                
		
                switch(var)
                {
                    case 1 :
                        nbr =1;
                        DocteurModel docmod = new DocteurModel((List<Docteur>)list);
                        table = new JTable(docmod);
                        table.setAutoCreateRowSorter(true);
                        //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                        break;
                    case 2 :       
                        nbr =2;
                        MaladeModel malmod = new MaladeModel((List<Malade>)list);
                        table = new JTable(malmod);
                        table.setAutoCreateRowSorter(true);
                        //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                        break;
                    case 3 :
                        nbr = 3;
                        InfirmierModel infmod = new InfirmierModel((List<Infirmier>)list);
                        table = new JTable(infmod);
                        table.setAutoCreateRowSorter(true);
                        //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                        break;
                    case 4 :
                        nbr =4;
                        EmployeModel empmod = new EmployeModel((List<Employe>)list);
                        table = new JTable(empmod);
                        table.setAutoCreateRowSorter(true);
                        //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                        break;
                    case 5 :
                        nbr = 5;
                        HospitalisationModel hosmod = new HospitalisationModel((List<Hospitalisation>)list);
                        table = new JTable(hosmod);
                        table.setAutoCreateRowSorter(true);
                        //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                        break;
                    case 6 :
                        nbr = 6;
                        ChambreModel chmod = new ChambreModel((List<Chambre>)list);
                        table = new JTable(chmod);
                        table.setAutoCreateRowSorter(true);
                        //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                        break;
                    case 7 :
                        nbr = 7;
                        ServiceModel sermod = new ServiceModel((List<Service>)list);
                        table = new JTable(sermod);
                        table.setAutoCreateRowSorter(true);
                        //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                        break;
                    case 8 :
                        nbr =8;
                        SoigneModel sgnmod = new SoigneModel((List<Soigne>)list);
                        table = new JTable(sgnmod);
                        table.setAutoCreateRowSorter(true);
                        //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                        break;
                    default:
                        table = new JTable();
                        break;
                        
                }
                    
                pane = new JScrollPane(table);
                
                
                edit.addActionListener(this);
                supprimer.addActionListener(this);
		retour.addActionListener(this);
                
                edit.setForeground(Color.green);
                supprimer.setForeground(Color.red);
                
                panneau.add(barbut,BorderLayout.SOUTH);
                barbut.add(supprimer,BorderLayout.EAST);
                barbut.add(edit,BorderLayout.CENTER);
                barbut.add(retour,BorderLayout.EAST);
                
		panneau.add(table.getTableHeader(), BorderLayout.NORTH);
                panneau.add(pane, BorderLayout.CENTER);
                
                
                fentreCard.add("RechercheTab", panneau);
                setVisible(false);
                
                edit.revalidate();
                retour.revalidate();
                supprimer.revalidate();
	}

    @Override
    public void actionPerformed(ActionEvent event) 
    {
            if((event.getSource().getClass()==JButton.class))
            {
                    if("Retour".equals(event.getActionCommand()))
                    {
                        fentreCard.show("Recherche");
                    }
                    else if("Supprimer".equals(event.getActionCommand()))
                    {
                        try{
                            switch(nbr)
                            {

                                case 1:
                                    // Docteur : identifiant : num
                                    int num1 = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
                                    try {
                                        JobDocteur.Supr(num1);
                                    } catch (SQLException ex) {
                                        Logger.getLogger(RechercheTab.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    break;
                                case 2:
                                    //Malade : identifiant : num
                                    int num2 = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
                                    try {
                                        JobMalade.Supr(num2);
                                    } catch (SQLException ex) {
                                        Logger.getLogger(RechercheTab.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    break;
                                case 3:
                                    // Infirmier : identifiant : num
                                    int num3 = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
                                    try {
                                        JobInfirmier.Supr(num3);
                                    } catch (SQLException ex) {
                                        Logger.getLogger(RechercheTab.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    break;
                                case 4:
                                    // Employe : identifiant : num
                                    int num4 = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
                                    try {
                                        JobEmploye.Supr(num4);
                                    } catch (SQLException ex) {
                                        Logger.getLogger(RechercheTab.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    break;
                                case 5:
                                    // nothing
                                    break;
                                case 6:
                                    // nothing
                                    break;
                                case 7:
                                    // nothing
                                    break;
                                case 8:
                                    // Employe : identifiant : num
                                    int numdoc = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
                                    int nummal = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 3).toString());
                                    try {
                                        JobSoigne.Supr(numdoc, nummal);
                                    } catch (SQLException ex) {
                                        Logger.getLogger(RechercheTab.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    break;
                            }
                        }
                        catch(NumberFormatException e){}
                       fentreCard.show("Recherche");
                    }
                    else if("edit".equals(event.getActionCommand()))
                    {
                        
                    }
            }
    }
    
}
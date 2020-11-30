/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanager.controller.view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import projectmanager.controller.Controller;
import projectmanager.controller.view.coordinator.MainCoordinator;
import projectmanager.controller.view.form.FrmAllProjects;
import projectmanager.domain.Project;

/**
 *
 * @author EMA
 */
public class AllProjectsController {
    private final FrmAllProjects frmAllProjects;

    public AllProjectsController(FrmAllProjects frmAllProjects) {
        this.frmAllProjects = frmAllProjects;
        addActionListener();
    }
    
    private void addActionListener() {
        frmAllProjects.getBtnDetailsAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = frmAllProjects.getTblProjects().getSelectedRow();
                if (row >= 0) {
 //                   Project project = frmAllProjects.getTblProjects().getcompo
//                    MainCoordinator.getInstance().addParam(Constants.PARAM_PRODUCT, product);
//                    MainCoordinator.getInstance().openProductDetailsProductForm();
                } else {
                    JOptionPane.showMessageDialog(frmAllProjects, "You must select a product", "PRODUCT DETAILS", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        frmAllProjects.addWindowListener(new WindowAdapter(){
            @Override
            public void windowActivated(WindowEvent e) {
                fillTblProjects();
            }
        });

    }
    
     public void openForm() {
        frmAllProjects.setLocationRelativeTo(null);
        prepareView();
        frmAllProjects.setVisible(true);
    }

    private void prepareView() {
        frmAllProjects.setTitle("View products");
        fillTblProjects();
    }

    private void fillTblProjects() {
        List<Project> projects;
        try {
           // projects = Controller.getInstance().getAllProducts();
//            ProductTableModel ptm = new ProductTableModel(products);
//            frmAllProjects.getTblProjects().setModel(ptm);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frmAllProjects, "Error: " + ex.getMessage(), "ERROR DETAILS", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(AllProjectsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void refresh() {
        fillTblProjects();
    }
}

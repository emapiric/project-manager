/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanager.controller.view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import projectmanager.controller.Controller;
import projectmanager.controller.view.component.validator.impl.RequiredStringValidator;
import projectmanager.controller.view.coordinator.MainCoordinator;
import projectmanager.controller.view.form.FrmProjectTask;
import projectmanager.domain.ProjectTask;
import projectmanager.domain.Status;
import projectmanager.domain.Task;
import projectmanager.domain.User;
import projectmanager.view.form.util.FormMode;

/**
 *
 * @author Ema
 */
public class ProjectTaskController {
    private final FrmProjectTask frmProjectTask;
    private FormMode formMode;

    public ProjectTaskController(FrmProjectTask frmProjectTask) {
        this.frmProjectTask = frmProjectTask;
        addActionListener();
    }

    private void addActionListener() {
        frmProjectTask.addSaveBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
            private void save() {
                try {
                    ProjectTask projectTask = new ProjectTask();
                    projectTask.setDescription(frmProjectTask.getInputProjectTaskDescription().getValue().toString());
                    projectTask.setTask((Task) frmProjectTask.getInputTask().getValue());
                    projectTask.setAssignee((User) frmProjectTask.getInputAssignee().getValue());
                    projectTask.setStatus((Status) frmProjectTask.getInputStatus().getValue());
                    switch(formMode) {
                        case FORM_ADD:
                            Controller.getInstance().addProjectTask(projectTask);
                            break;
                        case FORM_VIEW:
                            projectTask.setId(Integer.parseInt(frmProjectTask.getInputId().getValue().toString()));
                            Controller.getInstance().editProjectTask(projectTask);
                            break;
                    }
                    JOptionPane.showMessageDialog(frmProjectTask, "Project task successfully saved");
                    frmProjectTask.dispose();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(frmProjectTask, e.getMessage());
                }
            }
        });
    }
    
    public void openForm(FormMode formMode) {
        this.formMode = formMode;
        frmProjectTask.setLocationRelativeTo(MainCoordinator.getInstance().getAllProjectsController().getFrmAllProjects());
        prepareView();
        setupComponents();
        frmProjectTask.setVisible(true);
    }

    private void prepareView() {
        fillCbTask();
        fillCbAssignee();
        fillCbStatus();
        frmProjectTask.getInputId().getLblText().setText("ID:");
        frmProjectTask.getInputId().getLblErrorValue().setText("");
        frmProjectTask.getInputId().getTxtValue().setEnabled(false);
        
        frmProjectTask.getInputProject().getLblText().setText("Project:");
        frmProjectTask.getInputProject().getLblErrorValue().setText("");
        frmProjectTask.getInputProject().getTxtValue().setEnabled(false);
        
        frmProjectTask.getInputAuthor().getLblText().setText("Author:");
        frmProjectTask.getInputAuthor().getLblErrorValue().setText("");
        frmProjectTask.getInputAuthor().getTxtValue().setEnabled(false);
        
        frmProjectTask.getInputTaskDescription().getLblText().setText("Task description:");
        frmProjectTask.getInputTaskDescription().getLblErrorValue().setText("");
        frmProjectTask.getInputTaskDescription().getTxtAreaValue().setEnabled(false);
        
        frmProjectTask.getInputProjectTaskDescription().setValidator(new RequiredStringValidator());
        frmProjectTask.getInputProjectTaskDescription().getLblText().setText("Description:");
        frmProjectTask.getInputProjectTaskDescription().getLblErrorValue().setText("");
    }
    
    private void fillCbTask() {
//        try {
//            frmProjectTask.getInputTask().getCb().setModel(new DefaultComboBoxModel<>(Controller.getInstance().getAllTasks().toArray()));
//            frmProjectTask.getInputTask().getCb().setSelectedIndex(-1);
//            frmProjectTask.getInputTask().getCb().addItemListener(new ItemListener() {
//                @Override
//                public void itemStateChanged(ItemEvent e) {
//                    if (e.getStateChange() == ItemEvent.SELECTED) {
//                        Product product = (Product) e.getItem();
//                        frmProjectTask.getTxtProductPrice().setText(String.valueOf(product.getPrice()));
//                        frmProjectTask.getTxtProductMeasurementUnit().setText(product.getMeasurementUnit().toString());
//                        frmProjectTask.getTxtProductQuantity().setText("1");
//                        frmProjectTask.getTxtProductQuantity().grabFocus();
//                        frmProjectTask.getTxtProductQuantity().setSelectionStart(0);
//                    }
//                }
//            });
//        } catch (Exception ex) {
//            Logger.getLogger(InvoiceController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
    private void fillCbAssignee() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void fillCbStatus() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setupComponents() {
        
    }

}

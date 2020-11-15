/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanager.controller.view.component;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author EMA
 */
public class ButtonEditor extends DefaultCellEditor{
    protected JButton btn;
    private String label;
    private Boolean clicked;
    private Long projectId;

    public ButtonEditor(JTextField textField, String label) {
        super(textField);
        btn = new JButton();
        btn.setOpaque(true);
        this.label = label;
        btn.setText(label);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
       //lbl = (value == null) ? "" : value.toString();
       //btn.setText(lbl);
       projectId = Long.parseLong(value.toString());
       clicked = true;
       return btn;
    }

    @Override
    public Object getCellEditorValue() {
        if (clicked) {
            JOptionPane.showMessageDialog(btn, projectId+" ");
//            switch(lbl) {
//                case "View":
//                    JOptionPane.showMessageDialog(btn, "description");
//                    break;
//                case "Delete":
//                    JOptionPane.showMessageDialog(btn, "delete");
//                    break;
//            }
        }
        clicked = false;
        return null;
    }

    @Override
    public boolean stopCellEditing() {
        clicked = false;
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}

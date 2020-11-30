/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanager.controller.view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import projectmanager.controller.Controller;
import projectmanager.controller.view.coordinator.MainCoordinator;
import projectmanager.controller.view.form.FrmLogin;
import projectmanager.domain.User;

/**
 *
 * @author EMA
 */
public class LoginController {
    private final FrmLogin frmLogin;

    public LoginController(FrmLogin frmLogin) {
        this.frmLogin = frmLogin;
        //addActionListener();
    }

    public void openForm() {
        frmLogin.setVisible(true);
    }

//    private void addActionListener() {
//        frmLogin.loginAddActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                loginUser(actionEvent);
//            }
//
//            private void loginUser(ActionEvent actionEvent) {
//                resetForm();
//                try {
//                    String username = frmLogin.getTxtUsername().getText().trim();
//                    String password = String.copyValueOf(frmLogin.getTxtPassword().getPassword());
//
//                    validateForm(username, password);
//
//                    User user = Controller.getInstance().login(username, password);
//                    JOptionPane.showMessageDialog(
//                            frmLogin,
//                            "Welcome " + user.getFirstname() + ", " + user.getLastname(),
//                            "Login", JOptionPane.INFORMATION_MESSAGE
//                    );
//                    frmLogin.dispose();
//                    //MainCoordinator.getInstance().addParam(Constants.CURRENT_USER, user);
//                    MainCoordinator.getInstance().openAllProjectsForm();
//                } catch (Exception e) {
//                    JOptionPane.showMessageDialog(frmLogin, e.getMessage(), "Login error", JOptionPane.ERROR_MESSAGE);
//                }
//            }
//
//            private void resetForm() {
//                frmLogin.getLblUsernameError().setText("");
//                frmLogin.getLblPasswordError().setText("");
//            }
//
//            private void validateForm(String username, String password) throws Exception {
//                String errorMessage = "";
//                if (username.isEmpty()) {
//                    frmLogin.getLblUsernameError().setText("Username can not be empty!");
//                    errorMessage += "Username can not be empty!\n";
//                }
//                if (password.isEmpty()) {
//                    frmLogin.getLblPasswordError().setText("Password can not be empty!");
//                    errorMessage += "Password can not be empty!\n";
//                }
//                if (!errorMessage.isEmpty()) {
//                    throw new Exception(errorMessage);
//                }
//            }
//        });
//    }
}

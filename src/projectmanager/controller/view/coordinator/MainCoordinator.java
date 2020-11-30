/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanager.controller.view.coordinator;

import java.util.HashMap;
import java.util.Map;
import projectmanager.controller.view.controller.AllProjectsController;
import projectmanager.controller.view.controller.LoginController;
import projectmanager.controller.view.form.FrmAllProjects;
import projectmanager.controller.view.form.FrmLogin;

/**
 *
 * @author EMA
 */
public class MainCoordinator {
     private static MainCoordinator instance;

    private final AllProjectsController allProjectsController;
    private final Map<String, Object> params;

    private MainCoordinator() {
        allProjectsController = new AllProjectsController(new FrmAllProjects());
        params = new HashMap<>();
    }

    public static MainCoordinator getInstance() {
        if (instance == null) {
            instance = new MainCoordinator();
        }
        return instance;
    }
     public void openLoginForm() {
        LoginController loginContoller = new LoginController(new FrmLogin());
        loginContoller.openForm();
    }

    public void openAllProjectsForm() {
        allProjectsController.openForm();
    }

//    public void openAddNewProductForm() {
//        ProductController productController = new ProductController(new FrmProduct(mainContoller.getFrmMain(), true));
//        productController.openForm(FormMode.FORM_ADD);
//    }
//    public void openProductDetailsProductForm() {
//        FrmProduct productDetails = new FrmProduct(mainContoller.getFrmMain(), true);
//        ProductController productController = new ProductController(productDetails);
//        productController.openForm(FormMode.FORM_VIEW);
//        params.put(Constants.PARAM_PRODUCT,productDetails);
//    }

    public AllProjectsController getAllProjectsController() {
        return allProjectsController;
    }


    public void addParam(String name, Object key) {
        params.put(name, key);
    }

    public Object getParam(String name) {
        return params.get(name);
    }
}

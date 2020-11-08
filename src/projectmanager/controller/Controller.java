/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanager.controller;

import java.util.List;
import projectmanager.domain.User;
import projectmanager.domain.Project;
import projectmanager.repository.RepositoryProject;
import projectmanager.repository.RepositoryUser;

/**
 *
 * @author EMA
 */
public class Controller {
    private static Controller controller;
    private final RepositoryUser repositoryUser;
    private final RepositoryProject repositoryProject;

    public Controller() {
        this.repositoryUser = new RepositoryUser();
        this.repositoryProject = new RepositoryProject();
    }
    
    public static Controller getInstance() {
        if (controller == null)
            controller = new Controller();
        return controller;
    }
    
    public User login(String username, String password) throws Exception {
        List<User> users = repositoryUser.getUsers();
        for (User user: users) {
            if (user.getUsername().equals(username)&&user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new Exception("Unknown user");
    }
    
    public void addProject(Project project) {
        repositoryProject.add(project);
    }
    
    public List<Project> getAllProjects() {
        return repositoryProject.getProjects();
    }
}

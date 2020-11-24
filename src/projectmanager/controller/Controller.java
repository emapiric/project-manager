/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanager.controller;

import java.util.List;
import projectmanager.domain.User;
import projectmanager.domain.Project;
import projectmanager.repository.Repository;
import projectmanager.repository.RepositoryProject;
import projectmanager.repository.RepositoryUser;
import projectmanager.repository.db.DBRepository;
import projectmanager.repository.db.impl.DBRepositoryProject;
import projectmanager.repository.db.impl.DBRepositoryUser;

/**
 *
 * @author EMA
 */
public class Controller {
    private static Controller controller;
    private final Repository<User> repositoryUser;
    private final Repository<Project> repositoryProject;
    private User user;

    public Controller() {
        this.repositoryUser = new DBRepositoryUser();
        this.repositoryProject = new DBRepositoryProject();
        this.user = new User();
    }
    
    public static Controller getInstance() {
        if (controller == null)
            controller = new Controller();
        return controller;
    }
    
        public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public User login(String username, String password) throws Exception {
        List<User> users = repositoryUser.getAll();
        for (User user: users) {
            if (user.getUsername().equals(username)&&user.getPassword().equals(password)) {
                this.user = user;
                return user;
            }
        }
        throw new Exception("Unknown user");
    }
    
    public void addProject(Project project) throws Exception {
        repositoryProject.add(project);
    }
    
    public List<Project> getAllProjects() {
        return repositoryProject.getAll();
    }

    public void deleteProject(int projectId) throws Exception {
       repositoryProject.delete(projectId);
    }
    
    public Project getProjectById(int projectId) throws Exception {
        return repositoryProject.getById(projectId);
    }
    
    public void updateProject(Project project) throws Exception {
        repositoryProject.update(project);
    }
    
}

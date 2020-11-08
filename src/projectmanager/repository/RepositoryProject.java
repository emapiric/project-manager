/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanager.repository;
import java.util.ArrayList;
import java.util.List;
import projectmanager.domain.Project;

/**
 *
 * @author EMA
 */
public class RepositoryProject {
    private final List<Project> projects;

    public RepositoryProject() {
        this.projects = new ArrayList<>();
    }
    
    public void add(Project project) {
        projects.add(project);
    }
    
    public List<Project> getProjects() {
        return projects;
    }
    
}

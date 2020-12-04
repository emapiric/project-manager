/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanager.repository.db.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import projectmanager.controller.Controller;
import projectmanager.controller.view.constant.Constants;
import projectmanager.controller.view.coordinator.MainCoordinator;
import projectmanager.domain.Project;
import projectmanager.domain.ProjectTask;
import projectmanager.domain.Status;
import projectmanager.domain.Task;
import projectmanager.domain.User;
import projectmanager.repository.db.DBConnectionFactory;
import projectmanager.repository.db.DBRepository;

/**
 *
 * @author Ema
 */
public class DBRepositoryProjectTask implements DBRepository<ProjectTask>{

    @Override
    public List<ProjectTask> getAll() {
         try {
            String sql = "SELECT * FROM project_task WHERE projectId=?";
            List<ProjectTask> projectTasks = new ArrayList<>();
            Connection connection = DBConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            Project project = (Project) MainCoordinator.getInstance().getParam(Constants.PARAM_PROJECT);
            statement.setInt(1, project.getId());
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()){
                ProjectTask projectTask = new ProjectTask();
                projectTask.setId(rs.getInt("id"));
                projectTask.setProject(project);
                projectTask.setCreatedOn(rs.getDate("createdOn"));
                projectTask.setDescription(rs.getString("description"));
                Task task = Controller.getInstance().getTaskById(rs.getInt("taskId"));
                projectTask.setTask(task);
                User assignee = Controller.getInstance().getUserById(rs.getInt("assigneeId"));
                projectTask.setAssignee(assignee);
                projectTask.setStatus(Status.values()[rs.getInt("statusId")]);
                User author = Controller.getInstance().getUserById(rs.getInt("authorId"));
                projectTask.setAuthor(author);
                projectTasks.add(projectTask);
            }
            rs.close();
            statement.close();
            return projectTasks;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void add(ProjectTask param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(ProjectTask param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(ProjectTask param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProjectTask getById(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
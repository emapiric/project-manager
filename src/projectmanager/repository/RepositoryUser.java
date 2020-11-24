/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanager.repository;

import java.util.ArrayList;
import java.util.List;
import projectmanager.domain.User;

/**
 *
 * @author EMA
 */
public class RepositoryUser {
     private final List<User> users;

    public RepositoryUser() {
        this.users = new ArrayList<User>(){
            {
                add(new User(1, "Admin", "Admin","admin","admin","admin@gmail.com"));
                add(new User(2, "Admin2", "Admin2","admin2","admin2","admin2@gmail.com"));
                add(new User(3, "Admin3", "Admin3","admin3","admin3","admin3@gmail.com"));
            }
        };
    }

    public List<User> getUsers() {
        return users;
    }
}

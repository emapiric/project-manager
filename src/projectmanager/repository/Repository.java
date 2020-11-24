/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanager.repository;

import java.util.List;

/**
 *
 * @author EMA
 */
public interface Repository<T> {
    List<T> getAll();

    void add(T param) throws Exception;

    void delete(int projectId) throws Exception;
    
    T getById(int id) throws Exception;
    
    void update(T param) throws Exception;
}

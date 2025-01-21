package com.projetCC.repository;

import com.projetCC.DataBaseService.MySqlConnector;

import java.sql.Connection;
import java.util.List;

public interface IRepository<T> {
    Connection connection = MySqlConnector.getInstance().getConnection();

//    T update(T entity, int id) throws Exception;
//
//    T insert(T entity) throws Exception;

    T findById(int id);

//    List<T> findAll() throws Exception;
//
//    /**
//     * @param id The id of the user to delete
//     * @return The number of affected rows
//     */
//    int deleteById(int id) throws Exception;
//
//    /**
//     * @return The number of affected rows
//     */
//    int deleteAll() throws Exception;
}

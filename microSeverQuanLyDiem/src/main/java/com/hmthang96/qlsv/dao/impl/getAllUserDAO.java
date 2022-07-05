package com.hmthang96.qlsv.dao.impl;

import com.hmthang96.qlsv.dao.IGetAllUserDAO;
import com.hmthang96.qlsv.model.UserModel;

import javax.swing.tree.RowMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class getAllUserDAO extends getConnectionDAO implements IGetAllUserDAO {
    @Override
    public List<UserModel> findAll() {
        List<UserModel> results = new ArrayList<>();
        String sql = "SELECT * FROM User";
        Connection connection = getConnectionDAO();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null ){
            try {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                while (resultSet.next()){
                    UserModel userModel = new UserModel();
                    userModel.setFullName(resultSet.getString("name"));
                    userModel.setMssv(resultSet.getString("mssv"));
                    userModel.setStatus(resultSet.getString("status"));
                    userModel.setRoleId(resultSet.getString("role"));
                    userModel.setPassword(resultSet.getString("password"));
                    results.add(userModel);
                }
            } catch (SQLException e) {
                return null;
            }
        }
        return results;
    }

    @Override
    public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
        return null;
    }

    @Override
    public List query(String sql, RowMapper rowMapper, Object... parameters) {
        return null;
    }

    @Override
    public void update(String sql, Object... parameters) {

    }

    @Override
    public Long insert(String sql, Object... parameters) {
        return null;
    }

    @Override
    public int count(String sql, Object... parameters) {
        return 0;
    }
}

package com.hmthang96.qlsv.dao.impl;

import com.hmthang96.qlsv.dao.IGetAllUserDAO;
import com.hmthang96.qlsv.model.UserModel;

import javax.swing.tree.RowMapper;
import java.util.List;

public class userDAO implements IGetAllUserDAO {

    @Override
    public List<UserModel> findAll() {
        return null;
    }

    @Override
    public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
        StringBuilder sql = new StringBuilder("SELECT * FROM user AS u");
        sql.append(" INNER JOIN role AS r ON r.id = u.roleid");
        sql.append(" WHERE username = ? AND password = ? AND status = ?");
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

package com.hmthang96.qlsv.service.impl;

import com.hmthang96.qlsv.dao.IGetAllUserDAO;
import com.hmthang96.qlsv.dao.impl.getAllUserDAO;
import com.hmthang96.qlsv.model.UserModel;
import com.hmthang96.qlsv.service.IUserService;

public class UserService implements IUserService {

    private IGetAllUserDAO userDAO;

    public UserService() {
        userDAO = new getAllUserDAO();
    }

    @Override
    public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
        return userDAO.findByUserNameAndPasswordAndStatus(userName, password, status);
    }
}

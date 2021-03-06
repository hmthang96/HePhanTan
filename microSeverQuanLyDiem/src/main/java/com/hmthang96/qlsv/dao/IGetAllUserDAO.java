package com.hmthang96.qlsv.dao;

import com.hmthang96.qlsv.model.UserModel;

import java.util.List;

public interface IGetAllUserDAO extends GenericDAO {
    List<UserModel> findAll();
    UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
}

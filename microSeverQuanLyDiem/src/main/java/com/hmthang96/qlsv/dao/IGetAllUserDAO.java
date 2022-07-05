package com.hmthang96.qlsv.dao;

import com.hmthang96.qlsv.model.UserModel;

import java.util.List;

public interface IGetAllUserDAO {
    List<UserModel> findAll();
}

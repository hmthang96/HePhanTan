package com.hmthang96.qlsv.dao;

import com.hmthang96.qlsv.model.UserModel;

import java.util.List;

public interface INewDAO extends GenericDAO<UserModel> {
    UserModel findOne(Long id);
    List<UserModel> findByCategoryId(Long categoryId);
    Long save(UserModel userModel);
    void update(UserModel updateNew);
    void delete(long id);
    int getTotalItem();
}


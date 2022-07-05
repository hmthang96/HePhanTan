package com.hmthang96.qlsv.service.impl;

import com.hmthang96.qlsv.dao.IGetAllUserDAO;
import com.hmthang96.qlsv.dao.impl.getAllUserDAO;
import com.hmthang96.qlsv.model.UserModel;
import com.hmthang96.qlsv.service.IGetAllStudentService;

import java.util.List;

public class GetAllStudentService implements IGetAllStudentService {

    private IGetAllUserDAO getAllUserDAO = new getAllUserDAO();
    @Override
    public List<UserModel> findall() {
        return getAllUserDAO.findAll();
    }
}

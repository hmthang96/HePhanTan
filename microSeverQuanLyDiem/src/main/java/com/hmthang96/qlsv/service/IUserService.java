package com.hmthang96.qlsv.service;

import com.hmthang96.qlsv.model.UserModel;

public interface IUserService {
    UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
}

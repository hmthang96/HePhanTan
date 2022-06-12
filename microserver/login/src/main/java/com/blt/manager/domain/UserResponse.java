package com.blt.manager.domain;


import com.blt.manager.model.User;

import java.util.List;

public class UserResponse extends BaseResponse {

    User user;



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



}


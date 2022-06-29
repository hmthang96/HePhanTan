package com.blt.manager.service;

import antlr.Token;
import com.blt.manager.domain.UserResponse;
import com.blt.manager.model.User;
import com.blt.manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.SQLOutput;
import java.util.List;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;

    UserResponse userResponse;


    public UserResponse checkLogin(User user) {
        userResponse = new UserResponse();
        String password = user.getPassword();

        String username = user.getEmail();

        if (userRepository.findByEmail(username) == null) {

                userResponse.setCode("001");
                userResponse.setMessage("Sai tài khoản !");
                System.out.println("001");
        } else if (!userRepository.findByEmail(username).getPassword().equals(password)) {
            userResponse.setCode("002");
            userResponse.setMessage("Sai mật khẩu !");
            System.out.println("002");
        } else {
            userResponse.setCode("000");
            userResponse.setMessage("Success !");
            System.out.println("000");
            userRepository.findByEmail(username).setToken(username+password);

        }

        return userResponse;
    }

    public UserResponse logout(User user) {
        userResponse = new UserResponse();
        if (userRepository.findByToken(user.getToken()) == null) {
            userResponse.setCode("003");
            userResponse.setMessage("Sai token");
        }else {
            userRepository.findByToken(user.getToken()).setToken("");
            userResponse.setCode("000");
            userResponse.setMessage("Success !");
        }

        return userResponse;
    }

    public UserResponse register(User user) {
        if (userRepository.findByUsername(user.getUsername())!= null){
            userResponse.setCode("005");
            userResponse.setMessage("Tên đăng nhập đã tồn tại");
        } else if (userRepository.findByEmail(user.getEmail())!= null){
            userResponse.setCode("006");
            userResponse.setMessage("Email đã tồn tại");
        } else {
            user.setStatus(1);
            userRepository.save(user);
            userResponse.setCode("007");
            userResponse.setMessage("Đăng ký thành công, đang chờ kiểm duyệt");
        }

        return userResponse;
    }

    public UserResponse checkRegister(User user){// gửi thông tin email của người cần phê duyệt và token của người đang phê duyệt
        if(userRepository.findByToken(user.getToken()) == null){
            userResponse.setCode("003");
            userResponse.setMessage("Sai token");
        } else if (userRepository.findByToken(user.getToken()).getIdGroup() != 1) {
            userResponse.setCode("004");
            userResponse.setMessage("Không đủ quyền");
        }else {
            userRepository.findByEmail(user.getEmail()).setStatus(3);
            userResponse.setCode("000");
            userResponse.setMessage("Success !");
        }
        return userResponse;
    }

    public UserResponse blockUser(User user){// gửi thông tin email của người cần phê duyệt và token của người đang phê duyệt
        if(userRepository.findByToken(user.getToken()) == null){
            userResponse.setCode("003");
            userResponse.setMessage("Sai token");
        } else if (userRepository.findByToken(user.getToken()).getIdGroup() != 1 || userRepository.findByEmail(user.getEmail()).getIdGroup() == 1) {
            userResponse.setCode("004");
            userResponse.setMessage("Không đủ quyền");
        }else {
            userRepository.findByEmail(user.getEmail()).setStatus(2);
            userResponse.setCode("000");
            userResponse.setMessage("Success !");
        }
        return userResponse;
    }


}

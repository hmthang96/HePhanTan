package com.blt.manager.service;

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

    public UserResponse callServerCheckLogin(User user) {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://localhost:8081/user/login";
        ResponseEntity<UserResponse> response
                = restTemplate.postForEntity(fooResourceUrl, user,UserResponse.class);

        response.toString();
        return response.getBody();
    }

    public UserResponse callServerLogout(User user) {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://localhost:8081/user/logout";
        ResponseEntity<UserResponse> response
                = restTemplate.postForEntity(fooResourceUrl, user,UserResponse.class);

        response.toString();
        return response.getBody();
    }



//    public UserResponse checkLogin(User user) {
//        UserResponse userResponse = new UserResponse();
//        System.out.println(user.getPassword());
//        System.out.println(user.getUsername());
//        String password = user.getPassword();
//
//        String username = user.getEmail();
////        List<User> userList = userRepository.findAll();
////        for (User user1:
////             userList) {
////            System.out.println(user1);
////        }
//        System.out.println(username);
//        System.out.println(userRepository.findByEmail(username));
//        if (userRepository.findByEmail(username) == null) {
//
//                userResponse.setCode("001");
//                userResponse.setMessage("Sai tài khoản !");
//                System.out.println("001");
//        } else if (!userRepository.findByEmail(username).getPassword().equals(password)) {
//            userResponse.setCode("002");
//            userResponse.setMessage("Sai mật khẩu !");
//            System.out.println("002");
//        } else {
//            userResponse.setCode("000");
//            userResponse.setMessage("Success !");
//            System.out.println("000");
//        }
//
//        return userResponse;
//    }

}

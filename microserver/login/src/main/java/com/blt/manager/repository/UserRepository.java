package com.blt.manager.repository;

import com.blt.manager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByIdUser(int id);

    User findByEmail(String email);



    User findByUsername(String username);

    List<User> findAll();
    List<User> findByIdGroup(Integer id);

}

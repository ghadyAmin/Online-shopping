package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    public User findByEmailAndPassword(String email, String password);

    public User findByEmail(String email); }

//   @Modifying
//   @Query("Update User u set u.fullname = :name")
//   public void updateUsername(@RequestParam("name") String name);

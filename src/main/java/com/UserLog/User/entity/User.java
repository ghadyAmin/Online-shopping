package com.UserLog.User.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name ="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "fullName", length = 100, nullable = false)
    private String fullName;
    @Column(name = "email", length = 100, nullable = false)
    private String email;
    @Column(name = "password", length = 50, nullable = false)
    private String password;


    public User(Long id, String fullName, String email, String password) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }
    public User(String fullName, String email, String password) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }




    //
//	public User(String email, String fullName) {
//		super();
//		this.email = email;
//		this.fullName = fullName;
//
//
//}








}

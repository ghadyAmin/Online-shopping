package com.UserLog.User.service;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import com.UserLog.User.dto.UserDto;
import com.UserLog.User.dto.UserRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.UserLog.User.entity.User;
import com.UserLog.User.repository.UserRepo;
import org.springframework.web.bind.annotation.RequestBody;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private  UserRepo userRepo;

    // saving user
    @Override
    public ResponseEntity addUser(UserRequest user) {
        if (user != null) {
            if(userRepo.findByEmail(user.getEmail())==null)
            {
              if(patternMatches(user.getEmail())==false)
                {
                    return ResponseEntity.badRequest().body("Enter a valid email");
                }
                if(user.getPassword().length()<8)
                {
                    return ResponseEntity.badRequest().body("Enter an 8 character password");
                }
                User u=new User(user.getName(), user.getEmail(), user.getPassword());
                userRepo.save(u);

                return ResponseEntity.ok().body(new UserDto(user.getName(), user.getEmail()));
            }
            else {
              return ResponseEntity.badRequest().body("User is already registered");
            }

        }
        throw new IllegalStateException("User Body is null");
    }

    public static boolean patternMatches(String emailAddress) {
        return Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
                .matcher(emailAddress)
                .matches();
    }



//	@Override
//	public List<UserDto> fetchUserList() {
//		List<User> users = (List<User>) userRepo.findAll();
//		List<UserDto> usersDtoList = null;
//		for(User user: users) {
//			UserDto usersDto = new UserDto();
//			BeanUtil.copyProperties(user, usersDto);
//			usersDtoList.add(usersDto);
//
//		}
//
//		return usersDtoList;
//		//return (List<User>) userRepo.findAll();
//	}

    public User findUserByEmailAndPassword(String email, String password) {
       return userRepo.findByEmailAndPassword(email, password);
    }







    // getting users

    // updating user
    @Override
    public void updateUser(User user, String email,String password) {
       User u=userRepo.findByEmailAndPassword(email,password);
       u.setFullName(user.getFullName());
       userRepo.save(u);

    }

    // delete user
    @Override
    public void deleteUserById(Long id) {
        userRepo.deleteById(id);

    }


}

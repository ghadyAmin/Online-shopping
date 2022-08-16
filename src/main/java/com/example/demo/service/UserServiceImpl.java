package com.example.demo.service;

import com.example.demo.dto.UserRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    // saving user
    @Override
    public User addUser(UserRequest user) {
        if (user != null) {
            User u=new User(user.getName(), user.getEmail(), user.getPassword());
            userRepo.save(u);
            return u;
        }
        throw new IllegalStateException("User Body is null");
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

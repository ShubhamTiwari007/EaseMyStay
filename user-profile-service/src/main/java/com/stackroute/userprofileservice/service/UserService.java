package com.stackroute.userprofileservice.service;

import com.stackroute.userprofileservice.exception.UserFoundException;
import com.stackroute.userprofileservice.exception.UserNotFoundException;
import com.stackroute.userprofileservice.models.Users;

import java.util.List;

public interface UserService {
    Users saveUser(Users user) throws UserFoundException;

    Boolean deleteUser(int userId) throws UserNotFoundException;

    List<Users> getAllUsers() throws UserNotFoundException;

    Users getUserById(int id);

    Users updateUser(Users user, int userId);

}

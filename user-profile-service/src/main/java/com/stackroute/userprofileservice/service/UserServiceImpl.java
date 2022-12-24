package com.stackroute.userprofileservice.service;

import com.stackroute.userprofileservice.configuration.Producer;
import com.stackroute.userprofileservice.exception.UserFoundException;
import com.stackroute.userprofileservice.exception.UserNotFoundException;
import com.stackroute.userprofileservice.models.Users;
import com.stackroute.userprofileservice.payload.EmailDto;
import com.stackroute.userprofileservice.payload.UserDto;
import com.stackroute.userprofileservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Producer producer;

    /**
     * This method allows to Add new User.
     * The registration is done on basis of unique email id.
     * The User will receive a unique Otp which he has to enter for successful registration.
     *
     * @author Swastika Shanker
     */

    @Value("${server.port}")
    private int port;

    @Override
    public Users saveUser(Users user) throws UserFoundException {
        Users newUser = userRepository.findByEmailId(user.getEmailId());

        if (newUser != null) {
            throw new UserFoundException("User already present with " + user.getEmailId());
        } else {
            newUser = userRepository.save(user);
            UserDto userDto = new UserDto();
            userDto.setEmail(newUser.getEmailId());
            userDto.setPassword(newUser.getPassword());
            userDto.setRole(newUser.getRole());

            EmailDto emailDto = new EmailDto();
            emailDto.setFirstName(newUser.getFirstName());
            emailDto.setEmail(newUser.getEmailId());

            producer.sendMessageToRabbitMqToSaveUser(userDto);
            producer.sendMessageToRabbitMqForEmailSuccess(emailDto);
        }
        return newUser;
    }


    /**
     * This method allows to fetch the records of Users from the Database.
     *
     * @author Swastika Shanker
     */

    @Override
    public List<Users> getAllUsers() throws UserNotFoundException {
        List<Users> list = this.userRepository.findAll();
        if (list.size() <= 0) {
            throw new UserNotFoundException();
        } else {
            return list;
        }
    }

    /**
     * This method allows to fetch the record of a User by ID from the Database.
     *
     * @author Swastika Shanker
     */

    @Override
    public Users getUserById(int id) throws UserNotFoundException {
        Users user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new UserNotFoundException();
        } else {
            return user;
        }
    }

    /**
     * This method allows to delete the record of a User by ID from the Database.
     *
     * @author Swastika Shanker
     */

    @Override
    public Boolean deleteUser(int userId) throws UserNotFoundException {
        boolean flag = false;
        Users user1 = userRepository.findById(userId).orElse(null);
        if (user1 == null) {
            throw new UserNotFoundException();
        } else {
            userRepository.deleteById(userId);
            flag = true;
        }
        return flag;
    }


    /**
     * This method allows to update the record of a User by ID from the Database.
     *
     * @author Swastika Shanker
     */
    @Override
    public Users updateUser(Users user, int userId) throws UserNotFoundException {
        Users user1 = userRepository.findById(userId).orElse(null);
        if (user1 == null) {
            throw new UserNotFoundException();
        } else {
            user1.setUserId(userId);
            user1.setFirstName(user.getFirstName());
            user1.setLastName(user.getLastName());
            user1.setAddress(user.getAddress());
            user1.setDob(user.getDob());
            user1.setGender(user.getGender());
            user1.setCreatedAt(user.getCreatedAt());
            user1.setMobileNumber(user.getMobileNumber());
            user1.setPassword(user.getPassword());

            userRepository.save(user1);

            UserDto userDto = new UserDto();
            userDto.setEmail(user1.getEmailId());
            userDto.setPassword(user1.getPassword());
            userDto.setRole(user1.getRole());
            producer.sendMessageToRabbitMqToUpdateUser(userDto);
        }
        return user1;
    }

}


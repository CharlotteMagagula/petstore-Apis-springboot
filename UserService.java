package com.redwoodgroup.petstore.service;

import com.redwoodgroup.petstore.dbmodel.UserEntity;
import com.redwoodgroup.petstore.dto.ApiResponse;
import com.redwoodgroup.petstore.dto.User;
import com.redwoodgroup.petstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    private List<User> users = new ArrayList<>();
    UserEntity userEntity = new UserEntity();
    //private User Iterable;

    public ApiResponse createUser(User user) {
        ApiResponse response = new ApiResponse();
        try {

            userEntity.setUsername(user.getUsername());
            userEntity.setFirstName(user.getFirstName());
            userEntity.setLastName(user.getLastName());
            userEntity.setEmail(user.getEmail());
            userEntity.setUserStatus(user.getUserStatus());
            userEntity.setPassword(user.getPassword());
            userEntity.setPhone(user.getPhone());

            userRepository.save(userEntity);

            response.setCode(200);
            response.setMessage("created user successfully");
        } catch (Exception e) {
            response.setCode(503);
            response.setMessage("something went wrong");
        }
        return response;
    }

    public User getUser(String username) {

        User user = new User();
        UserEntity userEntity = userRepository.findByUsername(username);

        userEntity.setUsername(user.getUsername());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setEmail(user.getEmail());
        userEntity.setUserStatus(user.getUserStatus());
        userEntity.setPassword(user.getPassword());
        userEntity.setPhone(user.getPhone());

        return user;
    }

       public  ApiResponse createWithArray (List < User > users) {
           ApiResponse response = new ApiResponse();
           List<UserEntity> usersInfo = new ArrayList<>();
           User user1 = new User();
           try{
               for (int i =0; i< users.size(); i++){
                   user1 = users.get(i);

                   userEntity.setUsername(user1.getUsername());
                   userEntity.setFirstName(user1.getFirstName());
                   userEntity.setLastName(user1.getLastName());
                   userEntity.setEmail(user1.getEmail());
                   userEntity.setUserStatus(user1.getUserStatus());
                   userEntity.setPassword(user1.getPassword());
                   userEntity.setPhone(user1.getPhone());

                   usersInfo.add(userEntity);
                   userRepository.saveAll(usersInfo);

               }
               response.setCode(404);
               response.setMessage("created users successfully");

           } catch (Exception e) {
               response.setCode(503);
               response.setMessage("An error occurred");
           }

            return response;
    }

        public ApiResponse deleteUser (String username) {
            ApiResponse response = new ApiResponse();
            User user = new User();
            try {


                UserEntity userEntity = userRepository.deleteByUsername(username);

                userEntity.setUsername(user.getUsername());
                userEntity.setFirstName(user.getFirstName());
                userEntity.setLastName(user.getLastName());
                userEntity.setEmail(user.getEmail());
                userEntity.setUserStatus(user.getUserStatus());
                userEntity.setPassword(user.getPassword());
                userEntity.setPhone(user.getPhone());

                response.setCode(200);
                response.setMessage("deleted user successfully");
            } catch (Exception e) {
                response.setCode(503);
                response.setMessage("something went wrong");
            }

            return response;
        }

        public ApiResponse updateUser (String username, User user){
            ApiResponse response = new ApiResponse();
            try{

            UserEntity userEntity = userRepository.findByUsername(username);

            userEntity.setUsername(user.getUsername());
            userEntity.setFirstName(user.getFirstName());
            userEntity.setLastName(user.getLastName());
            userEntity.setEmail(user.getEmail());
            userEntity.setUserStatus(user.getUserStatus());
            userEntity.setPassword(user.getPassword());
            userEntity.setPhone(user.getPhone());

            userRepository.save(userEntity);
            response.setCode(200);
            response.setMessage("updated user successfully");
        } catch (Exception e) {
                response.setCode(503);
                response.setMessage("something went wrong");
            }
            return response;
        }
    }











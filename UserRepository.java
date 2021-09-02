package com.redwoodgroup.petstore.repository;

import com.redwoodgroup.petstore.dbmodel.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    UserEntity findByUsername(String username);
    UserEntity deleteByUsername(String username);
}

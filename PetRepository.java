package com.redwoodgroup.petstore.repository;

import com.redwoodgroup.petstore.dbmodel.PetEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<PetEntity, Integer> {
}

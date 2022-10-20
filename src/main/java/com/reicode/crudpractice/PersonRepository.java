package com.reicode.crudpractice;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//This is the class that allows us to speak to the database
@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}

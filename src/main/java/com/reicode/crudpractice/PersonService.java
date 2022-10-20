package com.reicode.crudpractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    @Autowired //auto wires the repository into the scope
    private PersonRepository repository;

    //Adds a new record to the table the service's repository is accessing
    public Person create(Person person){
        System.out.format("Creating person [ %s ]", person);
        Person personInDatabase = repository.save(person);
        System.out.format("Person created", person);
        return personInDatabase;
    }

    //Returns the record with the specified ID from the table that the service's repository is accessing
    public Person read(Long id){
        return repository.findById(id).get();
    }

    //Returns ALL records from the table
    public List<Person> readAll() {
        Iterable<Person> allPeople = repository.findAll();
        List<Person> personList = new ArrayList<>();
        allPeople.forEach(personList::add);
        return personList;
    }

    //Updates the record in the database with the specified id, with the specified newData
    public Person update(Long id, Person newData){
        Person personInDatabase = repository.findById(id).get();
        personInDatabase.setId(newData.getId());
        personInDatabase.setFirstName(newData.getFirstName());
        personInDatabase.setLastName(newData.getLastName());
        personInDatabase = repository.save(personInDatabase);
        return personInDatabase;
    }

    //Deletes the record in the database with the specified id
    public Person delete(Long id){
        Person personInDatabase = repository.findById(id).get();
        repository.delete(personInDatabase);
        return personInDatabase;
    }
}

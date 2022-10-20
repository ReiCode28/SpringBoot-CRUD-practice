package com.reicode.crudpractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * "Speaks to the internet and the database"
 * Controllers define how to handle incoming requests from and outgoing responses to a client
 * It provides the necessary endpoints to access + manipulate domain objects
 */
@Controller
@RequestMapping(value = "/person-controller")
public class PersonController {
    private PersonService service;

    @Autowired
    public PersonController(PersonService service){
        this.service = service;
    }

    //Response entity is what the internet responds with

    /** The POST verb in a create method allows us to add a new Person record.
     *
     * @RequestBody tells spring that the entire request body needs to be converted
     * to an instance of person
     *
     */
    @PostMapping(value = "/create")
    public ResponseEntity<Person> create(@RequestBody Person person){
        return new ResponseEntity<>(service.create(person), HttpStatus.CREATED);
    }

    /**
     * The code below allows us to access an individual Person
     * The value attribute in @GetMapping takes a URI template /read/{id}.
     * The placeholder {id} along with @PathVariable annotation allows
     * Spring to examine the request URI path and extract the pollId parameter value.
     * Inside the method, we use the PersonService's read finder method to retrieve
     * the Person from the PersonRepository and pass the result to a
     * ResponseEntity.
     */
    @GetMapping(value = "/read/{id}")
    public ResponseEntity<Person> readById(@PathVariable Long id) {
        return new ResponseEntity<>(service.read(id), HttpStatus.OK);
    }

    /**
     * The code below allows us to access ALL Person records.
     * The value attribute in @GetMapping takes a URI template /read/{id}.
     * The placeholder {id} along with @PathVariable annotation allows
     * Spring to examine the request URI path and extract the pollId parameter value.
     * Inside the method, we use the PersonService's read finder method
     * to retrieve the respective Person from the PersonRepository
     * and pass the result to a ResponseEntity.
     */
    @GetMapping(value = "/readAll")
    public ResponseEntity<List<Person>> readAll(){
        return new ResponseEntity<>(service.readAll(), HttpStatus.OK);
    }

    /**
     * The code below enables us to update a Person with new data
     */
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Person> updateById(
            @PathVariable Long id,
            @RequestBody Person newData){
        return new ResponseEntity<>(service.update(id, newData), HttpStatus.OK);
    }

    /**
     * The code below enables us to delete a Person by id
     */
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Person> deleteById(@PathVariable Long id){
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }

}

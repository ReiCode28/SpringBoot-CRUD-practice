package com.reicode.crudpractice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import javax.annotation.PostConstruct;
import java.util.Arrays;

/** This class populates the "Person" table in H2 with entities
 * before the web server begins serving
 */

@Configuration //gets run immediately, before server starts.
public class PersonConfig {
    @Autowired
    private PersonService service;


    @PostConstruct
    public void setup() {
        service.create(new Person(2L, "Eric", "Coder"));
        service.create(new Person(3L, "Brent", "Coder"));
        service.create(new Person(1L, "Leon", "Hunter"));

//    Person person1 = new Person();
//    person1.setFirstName("Leon");
//    person1.setLastName("Hunter");
//
//    Person person2 = new Person();
//    person2.setFirstName("John");
//    person1.setLastName("Doe");
//
//    repository.saveAll(Arrays.asList(
//            person1,
//            person2
//            ));
    }
}

package com.reicode.crudpractice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity //annotates class signature
public class Person {
    @Id //annotates field declarations; each @Entity must be annotated with a respective ID so that JPA recognizes it
    @GeneratedValue //annotates id fields; this indicates that the id should be generated automatically
    private Long id;

    private String firstName;
    private String lastName;
    private Date birthDate;

    //default constructor only exists for the sake of JPA. Since it is not used directly, should it be protected?
    public Person() {
    }

    //this constructor is used to create instances of Person to be saved to the database
    public Person(Long id, String firstName, String lastName, Date birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}

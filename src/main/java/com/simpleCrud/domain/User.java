package com.simpleCrud.domain;

import javax.persistence.*;

/**
 * Created by jpierce on 9/3/16.
 */
@Entity
@Table(name="user")
public class User {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="FIRSTNAME")
    String firstName;

    @Column(name="LASTNAME")
    String lastName;

    @Column(name="AGE")
    Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

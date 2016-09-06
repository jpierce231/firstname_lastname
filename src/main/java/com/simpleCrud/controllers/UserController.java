package com.simpleCrud.controllers;

import com.simpleCrud.domain.User;
import com.simpleCrud.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jpierce on 9/3/16.
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    /** In a more advanced application, I'd probably want to split out some operations into a service.
     * For example, add optional parameters onto getUsers, autowire the new service, and use a method to filter the
     * actual parameters being sent in.
     * Build out a custom repo from the UserRepo that uses Hibernate most likely to create
     * custom queries for optional parameters like firstName, lastName, and age.
     * The api call would have url parameters appended to the end (?firstName=Josh)
     * The service would make use of the repo rather than using it here.
    */

    // Get all users
    @RequestMapping(method=RequestMethod.GET, value="")
    public Iterable<User> getUsers() throws Exception {
        return userRepo.findAll();
    }

    // Get user by Id
    @RequestMapping(method=RequestMethod.GET, value="{id}")
    public User getUserById(@PathVariable Integer id) throws Exception {
        return userRepo.findOne(id);
    }

    // Create a user
    @RequestMapping(method=RequestMethod.POST, value="")
    public User createUser(@RequestBody User user) throws Exception {
        return userRepo.save(user);
    }

    // Update a user
    @RequestMapping(method=RequestMethod.PUT, value="{id}")
    public User updateUser(@RequestBody User user, @PathVariable Integer id) throws Exception {

        // Go get the user to update based on the id
        User userToUpdate = userRepo.findOne(id);

        // Update user's information based on incoming info
        userToUpdate.setAge(user.getAge());
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        return userRepo.save(userToUpdate);
    }

    // Delete a user
    @RequestMapping(method=RequestMethod.DELETE, value="{id}")
    public void deleteUser(@PathVariable Integer id) throws Exception {
        userRepo.delete(id);
    }

}

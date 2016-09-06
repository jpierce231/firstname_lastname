package com.simpleCrud.repositories;

import com.simpleCrud.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by jpierce on 9/3/16.
 */
@RestResource
public interface UserRepo extends CrudRepository<User, Integer> {
    
}

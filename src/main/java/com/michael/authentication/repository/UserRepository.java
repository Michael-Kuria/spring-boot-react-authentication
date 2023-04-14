package com.michael.authentication.repository;

import com.michael.authentication.model.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ListCrudRepository< User,String> {
}

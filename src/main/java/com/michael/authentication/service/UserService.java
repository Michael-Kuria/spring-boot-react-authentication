package com.michael.authentication.service;

import com.michael.authentication.model.User;
import com.michael.authentication.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional< User > user =  userRepository.findById(email);

        if(user.isPresent()){
            return user.get();
        }
        throw new UsernameNotFoundException(String.format("User %s was not found", email));
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public long userCount(){
        return userRepository.count();
    }
}

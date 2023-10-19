package com.ayudaencasa.app.services;

import com.ayudaencasa.app.entities.User;
import com.ayudaencasa.app.exceptions.UserNotFoundException;
import java.util.List;

public interface UserService {
    
    public User create(User user);
    public void update(String id, User user) throws UserNotFoundException;
    public void delete(String id) throws UserNotFoundException;
    public User findById(String id) throws UserNotFoundException;
    public List<User> findAll();
    
}

package com.att.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    
    private User user;

    public User create(User user) {
        
    	user=new User(user.getId(),user.getFirstName(),user.getLastName(),user.getEmail());
    	repository.save(user);
    	return user;
    }

    public User delete(String id) {
        
    	try
    	{
    		user = repository.findByid(id);
            if(user != null)
            {
            repository.delete(user);
            }
        }
        catch(Exception e) {}
        return user;
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        return repository.findByid(id);
    }

    public User update(User user) {
    	try
    	{   
    		String id=user.getId();
    		user = repository.findByid(id);
            if(user != null)
            {
            repository.delete(user);
            user=new User(user.getId(),user.getFirstName(),user.getLastName(),user.getEmail());
        	repository.save(user);
            }
        }
        catch(Exception e) {}
    	return user;
    }
}

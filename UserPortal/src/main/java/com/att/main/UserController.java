package com.att.main;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/api"})
public class UserController {

    @Autowired
    private UserService userService;
    
    Scanner in; 
    List<Log> logLines;
    
    Log log;

    @PostMapping
    public List<Log> create(@RequestBody User user){
    	
    	logLines=new ArrayList<>();
    	try
    	{
    		in=new Scanner(Paths.get("log.txt"));
    	}
    	catch(Exception e) {}
        while(in.hasNextLine())
        {
        	log=new Log();
        	log.setData(in.nextLine());
        	logLines.add(log);
        }
        return logLines;
    }

    @GetMapping(path = {"/{id}"})
    public User findOne(@PathVariable("id") int id){
        return userService.findById(String.valueOf(id));
    }

    @PutMapping
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    @DeleteMapping(path ={"/{id}"})
    public User delete(@PathVariable("id") int id) {
        return userService.delete(String.valueOf(id));
    }

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }
}

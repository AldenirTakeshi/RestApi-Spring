package br.com.takeshi.spring_boot_rest.controllers;

import br.com.takeshi.spring_boot_rest.model.UserModel;
import br.com.takeshi.spring_boot_rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    // Com injection
    @Autowired
    private UserService userService;
    //Sem injection
    //private UserService userServiceSemInjection = new UserService();

    @PostMapping
//    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserModel createUser(@RequestBody UserModel user){
        return userService.createUser(user);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserModel findById(@PathVariable("id") String id){
        return userService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserModel> findAllUsers(){
        return userService.findAllUsers();
    }

    @PutMapping("/{id}")
    public UserModel updateUser(@PathVariable("id") String id, @RequestBody UserModel user){
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public UserModel deleteUser(@PathVariable("id") String id){
        return null;
    }
}

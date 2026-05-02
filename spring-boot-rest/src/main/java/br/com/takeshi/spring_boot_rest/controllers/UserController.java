package br.com.takeshi.spring_boot_rest.controllers;

import br.com.takeshi.spring_boot_rest.model.UserModel;
import br.com.takeshi.spring_boot_rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    //Sem injection
    //private UserService userServiceSemInjection = new UserService();

    @PostMapping
    public UserModel createUser(@RequestBody UserModel user){
        return userService.createUser(user);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserModel findById(@PathVariable("id") Long id){
        return userService.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserModel> findAllUsers(){
        return userService.findAllUsers();
    }

    @PutMapping("/{id}")
    public UserModel updateUser(@PathVariable("id") Long id, @RequestBody UserModel user){
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}

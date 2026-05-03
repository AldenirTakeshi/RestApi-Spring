package br.com.takeshi.spring_boot_rest.controllers;

import br.com.takeshi.spring_boot_rest.data.dto.UserDto;
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
    public UserDto createUser(@RequestBody UserDto user){
        return userService.create(user);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto findById(@PathVariable("id") Long id){
        return userService.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDto> findAllUsers(){
        return userService.findAll();
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable("id") Long id, @RequestBody UserDto user){
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

package br.com.takeshi.spring_boot_rest.controllers;

import br.com.takeshi.spring_boot_rest.model.UserModel;
import br.com.takeshi.spring_boot_rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    // Com injection
    @Autowired
    private UserService userService;
    //Sem injection
    //private UserService userServiceSemInjection = new UserService();

    @RequestMapping(value = "/{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserModel findById(@PathVariable("id") String id){
        return userService.findById(id);
    }
}

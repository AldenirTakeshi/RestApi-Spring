package br.com.takeshi.spring_boot_rest.service;

import br.com.takeshi.spring_boot_rest.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class UserService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(UserService.class.getName());

    public UserModel findById(String id){
        logger.info("Finding one User!");
        UserModel user = new UserModel();
        user.setId(counter.incrementAndGet());
        user.setFirstName("Aldenir");
        user.setLastName("Takeshi");
        user.setAddress("Porto Velho - RO - Brazil");
        user.setGender("Male");
        return user;
    }
}

package br.com.takeshi.spring_boot_rest.service;

import br.com.takeshi.spring_boot_rest.exception.ResourceNotFoundException;
import br.com.takeshi.spring_boot_rest.model.UserModel;
import br.com.takeshi.spring_boot_rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(UserService.class.getName());

    public UserModel createUser(UserModel user){
        logger.info("Create one User!");
        return userRepository.save(user);
    }

    public List<UserModel> findAllUsers(){
        logger.info("Finding All User!");
        return userRepository.findAll();
    }

    public UserModel findById(Long id){
        logger.info("Finding one User!");
        return userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No Records found for this ID"));
    }

    public UserModel updateUser(Long id, UserModel user){
        UserModel entity = this.findById(id);
        entity.setFirstName(user.getFirstName());
        entity.setLastName(user.getLastName());
        entity.setAddress(user.getAddress());
        entity.setGender(user.getGender());
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
        UserModel entity = this.findById(id);
        userRepository.delete(entity);
    }
}

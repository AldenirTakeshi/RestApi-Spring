package br.com.takeshi.spring_boot_rest.service;

import br.com.takeshi.spring_boot_rest.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class UserService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(UserService.class.getName());

    public UserModel createUser(UserModel user){
        logger.info("Create one User!");
        List<UserModel> userCreated = new ArrayList<>();
        userCreated.add(user);
        System.out.println(userCreated);
        return user;
    }

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


    public List<UserModel> findAllUsers(){
        logger.info("Finding All User!");
        List<UserModel> users = new ArrayList<UserModel>();
        for (int i = 0; i < 8; i++) {
            UserModel user = mockUser(i);
            users.add(user);
        }
        return users;
    }

    public UserModel updateUser(String id, UserModel user){
        UserModel userParaAtualizar = null;
        try {
            userParaAtualizar = this.findById(id);
        } catch (Exception e) {
            System.out.println(e);
        }
        if (userParaAtualizar == null) throw new RuntimeException("Usuário nao encontrado!");
        userParaAtualizar.setFirstName(user.getFirstName());
        userParaAtualizar.setLastName(user.getLastName());
        userParaAtualizar.setAddress(user.getAddress());
        userParaAtualizar.setGender(user.getGender());
        return userParaAtualizar;
    }

    public UserModel deleteUser(String id){
        return null;
    }

    private UserModel mockUser(int i){
        UserModel user = new UserModel();
        user.setId(counter.incrementAndGet());
        user.setFirstName("Firstname " + i);
        user.setLastName("Lastname " + i);
        user.setAddress("Same Address in Brazil");
        user.setGender("Male");
        return user;
    }

}

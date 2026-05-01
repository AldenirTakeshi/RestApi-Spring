package br.com.takeshi.spring_boot_rest.repository;

import br.com.takeshi.spring_boot_rest.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {}

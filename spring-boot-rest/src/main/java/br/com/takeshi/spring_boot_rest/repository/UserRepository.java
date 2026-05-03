package br.com.takeshi.spring_boot_rest.repository;

import br.com.takeshi.spring_boot_rest.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {}

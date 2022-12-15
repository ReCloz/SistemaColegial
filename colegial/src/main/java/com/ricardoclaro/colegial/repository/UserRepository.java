package com.ricardoclaro.colegial.repository;

import com.ricardoclaro.colegial.entity.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    Optional<UserModel> findByUsername(String username);

//    Optional<UserModel> findByUserId(Long id);

}

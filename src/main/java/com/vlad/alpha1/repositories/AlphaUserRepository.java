package com.vlad.alpha1.repositories;

import com.vlad.alpha1.model.AlphaUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlphaUserRepository extends CrudRepository<AlphaUser, Long> {

    List<AlphaUser> findAll();

    Optional<AlphaUser> findByLoginAndPassword(String login, String password);

    Boolean existsAlphaUserByLogin(String login);

}

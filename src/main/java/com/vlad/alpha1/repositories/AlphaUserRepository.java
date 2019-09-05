package com.vlad.alpha1.repositories;

import com.vlad.alpha1.Model.AlphaUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlphaUserRepository extends CrudRepository<AlphaUser,Long> {

    Optional<AlphaUser> findById(Long id);

    List<AlphaUser> findAll();

   // AlphaUser findAlphaUserByLoginEqualsAndPasswordEquals(String login, String password);

    AlphaUser findByLoginAndPassword(String login,String password);

}

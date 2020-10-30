package com.example.projekt.repository;


import com.example.projekt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private UserJpaRepository jpaRepository;

    public User create(User user){

        return jpaRepository.saveAndFlush(user);
    }

    public User update(User user){

        return jpaRepository.saveAndFlush(user);
    }
    public void delete(int id){
        jpaRepository.deleteById(id);
    }

    public User find(int id){
       return jpaRepository.getOne(id);
    }
    public List<User> list(){
       return jpaRepository.findAll();
    }

    public List<User> getUsers(String name){
        return jpaRepository.findByNameContains(name);
    }
}

package com.anjori.advanced_mappings.dao;

import org.springframework.stereotype.Service;

import com.anjori.advanced_mappings.entity.Instructor;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
public class AppDAOImpl implements AppDAO {

    private EntityManager entityManager;

    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
        System.out.println("Saving instructor: " + instructor);
    }

    @Override
    public Instructor findById(int id){
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteById(int id){
        entityManager.remove(findById(id));
    }

}

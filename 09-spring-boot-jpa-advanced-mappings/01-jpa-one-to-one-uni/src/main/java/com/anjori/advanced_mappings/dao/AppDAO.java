package com.anjori.advanced_mappings.dao;

import com.anjori.advanced_mappings.entity.Instructor;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findById(int id);

    void deleteById(int id);
}

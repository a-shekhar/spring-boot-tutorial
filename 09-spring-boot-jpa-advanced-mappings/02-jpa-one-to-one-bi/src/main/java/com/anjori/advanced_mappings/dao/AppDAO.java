package com.anjori.advanced_mappings.dao;

import com.anjori.advanced_mappings.entity.Instructor;
import com.anjori.advanced_mappings.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findById(int id);

    void deleteById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailsById(int id);
}

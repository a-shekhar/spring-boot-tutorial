package com.anjori.advanced_mappings.dao;

import java.util.List;

import com.anjori.advanced_mappings.entity.Course;
import com.anjori.advanced_mappings.entity.Instructor;
import com.anjori.advanced_mappings.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findById(int id);

    void deleteById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailsById(int id);

    List<Course> findCoursesByInstructorId(int instructorId);

    Instructor findInstructorByIdJoinFetch(int id);

    void save(Course course);

    Course findCourseAndReviewsById(int id);

    void deleteCourseById(int i);


}

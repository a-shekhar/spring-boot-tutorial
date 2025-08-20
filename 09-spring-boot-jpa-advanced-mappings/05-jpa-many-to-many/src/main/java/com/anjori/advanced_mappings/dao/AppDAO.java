package com.anjori.advanced_mappings.dao;

import java.util.List;

import com.anjori.advanced_mappings.entity.Course;
import com.anjori.advanced_mappings.entity.Instructor;
import com.anjori.advanced_mappings.entity.InstructorDetail;
import com.anjori.advanced_mappings.entity.Student;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findById(int id);

    void deleteById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailsById(int id);

    List<Course> findCoursesByInstructorId(int instructorId);

    Instructor findInstructorByIdJoinFetch(int id);

    void saveCourse(Course course);

    Course findCourseAndReviewsById(int id);

    void deleteCourseById(int i);

    Course findCourseAndStudentsById(int id);

    Student findStudentAndCoursesByStudentId(int id);

    void update(Student student);

    void deleteStudentById(int id);
}

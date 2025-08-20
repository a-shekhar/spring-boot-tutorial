package com.anjori.advanced_mappings.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anjori.advanced_mappings.entity.Course;
import com.anjori.advanced_mappings.entity.Instructor;
import com.anjori.advanced_mappings.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }


    @Override
    @Transactional
    public void deleteInstructorDetailsById(int id){
        // retrieve the instructor detail by id
        InstructorDetail instructorDetail = findInstructorDetailById(id);
        
        // remove the associated instructor
        // break bi-directional relationship
        instructorDetail.getInstructor().setInstructorDetail(null);

        entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int instructorId){
        TypedQuery<Course> query = entityManager.createQuery("            FROM Course where instructor.id = :instructorId", Course.class);  
    
        query.setParameter("instructorId", instructorId);
        List<Course> courses = query.getResultList();
        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        TypedQuery<Instructor> query = entityManager.createQuery("SELECT i FROM Instructor i JOIN FETCH i.courses WHERE i.id = :data", Instructor.class); 
    
        query.setParameter("data", id);
        Instructor instructor = query.getSingleResult();
        return instructor;
    }

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);
    }


    @Override
    public Course findCourseAndReviewsById(int id) {
        TypedQuery<Course> query = entityManager.createQuery("FROM Course c JOIN FETCH c.reviews WHERE c.id = :data", Course.class);
        query.setParameter("data", id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void deleteCourseById(int i){
        entityManager.remove(findCourseAndReviewsById(i));
    }
}

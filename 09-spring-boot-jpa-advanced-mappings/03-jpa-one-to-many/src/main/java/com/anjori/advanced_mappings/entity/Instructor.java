package com.anjori.advanced_mappings.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "instructor")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Instructor {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name= "email")
    private String email;

    // setup a mapping to detail entity
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id", referencedColumnName="id")
    @ToString.Exclude
    private InstructorDetail instructorDetail;

    @OneToMany(mappedBy="instructor", fetch= FetchType.EAGER,
               cascade = {
                   CascadeType.PERSIST,
                   CascadeType.MERGE,
                   CascadeType.DETACH,
                   CascadeType.REFRESH
               })
    private List<Course> courses;

    // add convenience methods for bi-directional relationship
    public void add(Course course) {
        if (courses == null) {
            courses = new ArrayList<>();
        }

        courses.add(course);
        course.setInstructor(this);
    }

}

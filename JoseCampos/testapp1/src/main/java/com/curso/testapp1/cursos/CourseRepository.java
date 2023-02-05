package com.curso.testapp1.cursos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository <Course, Integer> {

    List<Course> findByName(String name);
    
}

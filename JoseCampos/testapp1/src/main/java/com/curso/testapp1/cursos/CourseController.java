package com.curso.testapp1.cursos;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin

public class CourseController {
    
    @Autowired
    CourseRepository cs;	

	@GetMapping(value = "/cursos/thecorner") // URN = /curso/sistemas
	List<Course>getCursos() {
		return cs.findAll();
	}

	@GetMapping(value = "/cursos/thecorner/{id_search}")
	Course getCourseById(@PathVariable int id_search){
		Optional<Course> c = cs.findById(id_search);
		if (!c.isPresent())
			return null;
		return c.get();
	}

	@DeleteMapping(value = "/cursos/thecorner/{in_id}") // URN = /curso/sistemas
	String delete(@PathVariable int in_id) {
		cs.deleteById(in_id);
		return "El curso con Id: " + in_id + " se ha eliminado";
	}

	@PostMapping(value = "/cursos/thecorner") // URN = /curso/sistemas
	void insertCurso(@RequestBody Course curso) {
		cs.saveAndFlush(curso);
		return;
	}
}

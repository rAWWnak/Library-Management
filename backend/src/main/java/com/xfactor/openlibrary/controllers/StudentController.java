package com.xfactor.openlibrary.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xfactor.openlibrary.domain.Student;
import com.xfactor.openlibrary.repositories.StudentRepository;

@RestController
@RequestMapping("students")
public class StudentController{
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    private StudentRepository studentRepository;

    
    @PostMapping("/saveStudents")
    public Student saveStudent(@RequestBody Student Student){
        if(Student.getId()==null){
            Student student2 = studentRepository.save(Student);
            return student2;
        }
        return null;
    }

    @PutMapping("/updateStudent")
    public Student updateStudent(@RequestBody Student student) {
        if (student.getId() != null) {
            Student student2 = studentRepository.save(student);
            return student2;
        }
        return null;
    }

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("/findTotalStudents")
    public Long findTotalStudents(){
        return studentRepository.count();
    }
    
    @GetMapping("findByStudentId/{id}")
    public Student findById(@PathVariable Long id) {
        Optional<Student> optionalOfStudent = studentRepository.findById(id);
        if (optionalOfStudent.isPresent()) {
            return optionalOfStudent.get();
        }
        return null;
    }

    @DeleteMapping("deleteStudents/{id}")
    public void deleteStudents(@PathVariable Long id){
        studentRepository.deleteById(id);
    }

    @GetMapping("findByname/{name}")
    public List<Student> findByname(@PathVariable String name) {
        List<Student> students = studentRepository.findByName(name);
        return students;
    }
}
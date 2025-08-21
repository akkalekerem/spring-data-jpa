package com.keremakkale.controller.impl;


import com.keremakkale.entities.Student;
import com.keremakkale.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.keremakkale.controller.IStudentController;

import java.util.List;


@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImpl implements IStudentController {

    @Autowired
    private IStudentService studentService;  //Interface ile yakalıyoruz.

    @PostMapping(path = "/save")
    @Override
    public Student saveStudent(@RequestBody Student student){
        // Implementation for saving a student
        return studentService.saveStudent(student); // Placeholder return statement
    }

    @GetMapping(path = "/list")
    @Override
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/list/{id}")
    @Override
    public Student getStudentById(@PathVariable(name="id") Integer id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/delete-student/{id}")
    @Override
    public void deleteStudentById(@PathVariable(name = "id") Integer id) {
        studentService.deleteStudentById(id);
    }
}

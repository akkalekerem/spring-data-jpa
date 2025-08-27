package com.keremakkale.controller.impl;


import com.keremakkale.dto.DtoStudent;
import com.keremakkale.dto.DtoStudentIU;
import com.keremakkale.entities.Student;
import com.keremakkale.services.IStudentService;
import jakarta.validation.Valid;
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
    public DtoStudent saveStudent(@RequestBody @Valid DtoStudentIU dtoStudentIU){

        return studentService.saveStudent(dtoStudentIU);
    }

    @GetMapping(path = "/list")
    @Override
    public List<DtoStudent> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/list/{id}")
    @Override
    public DtoStudent getStudentById(@PathVariable(name="id") Integer id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/delete-student/{id}")
    @Override
    public void deleteStudentById(@PathVariable(name = "id") Integer id) {
        studentService.deleteStudentById(id);
    }

    @PutMapping("/update-student/{id}")
    @Override
    public DtoStudent updateStudent(@PathVariable(name = "id") Integer id, @RequestBody DtoStudentIU updateStudent) {
        return studentService.updateStudent(id, updateStudent);
    }
}

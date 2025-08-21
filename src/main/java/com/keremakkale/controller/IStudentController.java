package com.keremakkale.controller;


import com.keremakkale.entities.Student;

import java.util.List;

public interface IStudentController {

    public Student saveStudent(Student student);

    public List<Student> getAllStudents();

    public Student getStudentById(Integer id);

    public void deleteStudentById(Integer id);

}

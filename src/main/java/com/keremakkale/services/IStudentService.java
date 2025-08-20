package com.keremakkale.services;

import com.keremakkale.entities.Student;

import java.util.List;

public interface IStudentService {

    public Student saveStudent(Student student);

    public List<Student> getAllStudents();

    public Student getStudentById(Integer id);
}

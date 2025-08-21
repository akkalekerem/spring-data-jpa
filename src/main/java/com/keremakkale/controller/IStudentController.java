package com.keremakkale.controller;


import com.keremakkale.dto.DtoStudent;
import com.keremakkale.dto.DtoStudentIU;
import com.keremakkale.entities.Student;

import java.util.List;

public interface IStudentController {

    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);

    public List<DtoStudent> getAllStudents();

    public DtoStudent getStudentById(Integer id);

    public void deleteStudentById(Integer id);

    public DtoStudent updateStudent(Integer id, DtoStudentIU updateStudent);

}

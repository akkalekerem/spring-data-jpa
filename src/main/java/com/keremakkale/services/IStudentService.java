package com.keremakkale.services;

import com.keremakkale.dto.DtoStudentIU;
import com.keremakkale.entities.Student;
import com.keremakkale.dto.DtoStudent;

import java.util.List;

public interface IStudentService {

    public DtoStudent saveStudent(DtoStudentIU student);  //Insert işlemi olduğundan.

    public List<DtoStudent> getAllStudents();

    public DtoStudent getStudentById(Integer id);

    public void deleteStudentById(Integer id);

    public DtoStudent updateStudent(Integer id, DtoStudentIU updateStudent);  //Update işlemi olduğundan DtoStudentIU kullanıyoruz. DtoStudentIU'da id yok çünkü id'yi path'den alacağız.
}

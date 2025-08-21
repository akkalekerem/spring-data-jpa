package com.keremakkale.services.impl;

import com.keremakkale.entities.Student;
import com.keremakkale.repository.StudentRepository;
import com.keremakkale.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents(){
         List<Student> studentList = studentRepository.findAll();
         return studentList;
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteStudentById(Integer id) {
        /*Student dbStudent = getStudentById(id);
        if(dbStudent != null){
            studentRepository.delete(dbStudent);
        }*/
        studentRepository.deleteById(id);
    }

    @Override
    public Student updateStudent(Integer id, Student updateStudent) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()){
            Student existingStudent = optionalStudent.get();
            existingStudent.setFirstName(updateStudent.getFirstName());
            existingStudent.setLastName(updateStudent.getLastName());
            existingStudent.setBirthDate(updateStudent.getBirthDate());
            return studentRepository.save(existingStudent);
        }
        return null;
    }

}

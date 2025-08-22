package com.keremakkale.services.impl;

import com.keremakkale.dto.DtoStudent;
import com.keremakkale.dto.DtoStudentIU;
import com.keremakkale.entities.Student;
import com.keremakkale.repository.StudentRepository;
import com.keremakkale.services.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
        DtoStudent response = new DtoStudent();
        Student student = new Student();
        BeanUtils.copyProperties(dtoStudentIU, student);
        Student dbStudent = studentRepository.save(student);
        BeanUtils.copyProperties(dbStudent, response);
        return  response;
    }

    @Override
    public List<DtoStudent> getAllStudents(){
         List<DtoStudent> dtoList = new ArrayList<>();

         List<Student> studentList = studentRepository.findAllStudents();  //@Query ile yazdığımız metot.
         for (Student student : studentList){
                DtoStudent dtoStudent = new DtoStudent();
                BeanUtils.copyProperties(student, dtoStudent);
                dtoList.add(dtoStudent);
         }
         return dtoList;
    }

    @Override
    public DtoStudent getStudentById(Integer id) {
        DtoStudent dto = new DtoStudent();
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()){
            Student dbStudent = optionalStudent.get();
            BeanUtils.copyProperties(dbStudent, dto);
            return dto;
        }
        return null;
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
    public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student existingStudent = optionalStudent.get(); // Veri tabanından alınan veri
            BeanUtils.copyProperties(dtoStudentIU, existingStudent);  // DTO'daki alanlar öğrenciye kopyalanıyor
            Student updatedStudent = studentRepository.save(existingStudent);  // Güncellenen öğrenci kaydediliyor
            DtoStudent response = new DtoStudent();  // Dönüş için yeni bir DTO nesnesi oluşturuluyor
            BeanUtils.copyProperties(updatedStudent, response);  // Kaydedilen öğrenci DTO'ya kopyalanıyor
            return response;
        }
        return null;
    }

}

package com.keremakkale.repository;

import com.keremakkale.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    //Jpa Repository'nin yetmediği yerlerde buralara kendi metotlarımızı yazacağız.

    //HQL : Sınıfın ismi ve değişken isimleri ile sorgu yazılır.
    //SQL : Veritabanı tablo ve sütun isimleri ile sorgu yazılır
    //nativeQuery = true  => SQL sorgusu
    //nativeQuery = false => HQL sorgusu

   /* @Query(value = "FROM Student" , nativeQuery = false)  //Buradaki sorgular veritabanı isimleri ile değil değişken isimleri ile yazılır. HQL sorgusu.
    List<Student> findAllStudents();*/

    @Query(value = "SELECT * FROM student.student", nativeQuery = true)  //SQL sorgusu
    List<Student> findAllStudents();

    /*@Query(value = "SELECT * FROM student.student WHERE first_name='Sultan'", nativeQuery = true)  //SQL sorgusu
    List<Student> findAllStudents();*/
}

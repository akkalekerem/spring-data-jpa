package com.keremakkale.repository;

import com.keremakkale.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    //Jpa Repository'nin yetmediği yerlerde buralara kendi metotlarımızı yazacağız.
}

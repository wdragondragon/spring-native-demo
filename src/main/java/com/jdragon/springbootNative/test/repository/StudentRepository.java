package com.jdragon.springbootNative.test.repository;

/**
 * @Author JDragon
 * @Date 2023/7/5 16:31
 * @description:
 */

import com.jdragon.springbootNative.test.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByGrade(String grade);

    Optional<Student> findById(Integer id);
}
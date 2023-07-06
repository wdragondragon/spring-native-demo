package com.jdragon.springbootNative.test.controller;

import com.jdragon.springbootNative.test.entity.Student;
import com.jdragon.springbootNative.test.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: 王富贵
 * @description:
 * @createTime: 2022/11/26 21:11
 */
@RestController
public class TestController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/")
    public String tt() {
        return "Hello spring native";
    }

    @GetMapping("/findByGrade")
    public List<Student> findByGrade(@RequestParam("grade") String grade) {
        return studentRepository.findByGrade(grade);
    }
}

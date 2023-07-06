package com.jdragon.springbootNative.test;

import com.jdragon.springbootNative.test.entity.Student;
import com.jdragon.springbootNative.test.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.jdragon.springbootNative.test.repository")
public class SpringBootNativeApplication {
    private final Logger logger = LoggerFactory.getLogger(SpringBootNativeApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootNativeApplication.class, args);
    }

    @Bean
    public CommandLineRunner studentTest(StudentRepository studentRepository) {
        return args -> {
            logger.info("新增一个学生");
            studentRepository.save(new Student("小红", 0, 20, "大学"));
            logger.info("查询所有学生");
            studentRepository.findAll().forEach(s -> logger.info(s.toString()));
            logger.info("查询id为1的学生");
            Optional<Student> student = studentRepository.findById(1);
            logger.info(student.get().toString());

            logger.info("查询 grade为大学的所有学生");
            Student cond = new Student();
            cond.setGrade("大学");
            studentRepository.findAll(Example.of(cond)).forEach(s -> logger.info(s.toString()));
            studentRepository.findByGrade("大学").forEach(s -> {
                logger.info(s.toString());
            });
        };
    }
}

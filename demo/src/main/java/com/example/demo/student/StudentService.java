package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();

//        return List.of(
//                new Student(
//                        1l,
//                        "asdf",
//                        "asd@gmail.com",
//                        LocalDate.of(2000, Month.DECEMBER,26),
//                        21
//                ),
//                 new Student(
//                        2l,
//                        "asdf",
//                         "asd@gmail.com",
//                         LocalDate.of(2000, Month.DECEMBER,26),
//                      21
//                  )
//        );
    }

}





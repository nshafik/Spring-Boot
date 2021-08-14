package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository){
        return args -> {
            Student alex = new Student(

                        "alex",
                        "asd@gmail.com",
                        LocalDate.of(2000, Month.DECEMBER,26),
                        21
                );
            Student asdf = new Student(
                        "asdf",
                         "asd@gmail.com",
                         LocalDate.of(2000, Month.DECEMBER,26),
                      21
                  );
                 repository.saveAll(
                         List.of(alex,asdf)
                 );
        };
    }

}

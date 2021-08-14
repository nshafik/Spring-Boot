package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> {
    @Query("SELECT x FROM Student x WHERE x.id =?1")
    Optional<Student> findStudentByID(int id);
}

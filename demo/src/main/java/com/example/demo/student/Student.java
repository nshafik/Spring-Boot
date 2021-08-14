package com.example.demo.student;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name="students")
public class Student {

    @Id
    @SequenceGenerator(
            name= "student_name",
            sequenceName = "student_name",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_name"
    )
     @Column(name="student_id")
    private Long id;

    @Column(name="student_name")
    private String name;

   @Column (name="student_email")
    private String email;

    @Column(name="student_dob")
    private LocalDate dob;

    @Column(name="student_age")
    private Integer age;

    public Student() {
    }

    public Student(Long id,
                   String name,
                   String email,
                   LocalDate dob,
                   Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
    }

    public Student(String name,
                   String email,
                   LocalDate dob,
                   Integer age) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

package com.shailesh.spring.jpa.repository;

import com.shailesh.spring.jpa.entity.Guardian;
import com.shailesh.spring.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent()
    {
        Student student = Student.builder()
                .emailId("shaileshmahesh190@gmail.com")
                .firstName("Shailesh")
                //.guardianEmail("shailesh@gmail.com")
                //.guardianMobile("9999999999")
                //.guardianName("Maheshbhai")
                .lastName("Darji")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuadian(){
        Guardian guardian = Guardian.builder()
                .email("dalrambhai@gmail.com")
                .name("Dalrambhai")
                .mobile("9874561230")
                .build();
        Student student = Student.builder()
                .emailId("darjikanjibhai@gmail.com")
                .firstName("Kanjibhai")
                .guardian(guardian)
                .lastName("Darji")
                .build();

        studentRepository.save(student);
    }
    @Test
    public void printStudentByFirstName()
    {
        List<Student> students = studentRepository.findByStudentId(2L);
        System.out.println(students);
    }

    @Test
    public void printAllStudent()
    {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("Student_List="+studentList);
    }

    @Test
    public void printFirstByEmail()
    {
        String s =studentRepository.getStudentFirstNameByEmailAddress("darjikanjibhai@gmail.com");
        System.out.println("First Name is:"+s);
    }

    @Test
    public void printStudentByEmail()
    {
        Student student = studentRepository.getStudentByEmailAddress("darjikanjibhai@gmail.com");
        System.out.println("Student="+student);
    }

}
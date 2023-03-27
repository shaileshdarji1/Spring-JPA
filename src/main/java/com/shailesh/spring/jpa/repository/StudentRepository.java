package com.shailesh.spring.jpa.repository;

import com.shailesh.spring.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByStudentId(Long studentId);

    //JPQL
    @Query("select s.firstName from Student s where s.emailId=?1")
    String getStudentFirstNameByEmailAddress(String email);

    //Native Query
    @Query(
            value = "Select * FROM tbl_student WHERE email_address=?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddress(String email);
}

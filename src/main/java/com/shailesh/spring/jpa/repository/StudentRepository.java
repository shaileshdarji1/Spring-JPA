package com.shailesh.spring.jpa.repository;

import com.shailesh.spring.jpa.entity.Guardian;
import com.shailesh.spring.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    //Native Query using Param
    @Query(
            value = "SELECT * FROM tbl_student WHERE first_name=:firstName",
            nativeQuery = true
    )
    Student getStudentByFirstName(@Param("firstName") String firstName);

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE tbl_student SET first_name=?1 WHERE email_address=?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName,String emailId);

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE tbl_student SET email_address=:emailId,first_name=:firstName,last_name=:lastName WHERE student_id=:Id",
            nativeQuery = true
    )
    int updateStudentById(@Param("emailId") String emailId,@Param("firstName") String firstName,@Param("lastName") String lastname,@Param("Id") Long Id);
}

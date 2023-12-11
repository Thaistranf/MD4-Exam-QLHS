package com.example.md4examqlhv.repository;

import com.example.md4examqlhv.model.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, Long> {

    //Tìm theo tên hs (Containing) ko phân biệt hoa thường (IgnoreCase)
    Iterable<Student> findByNameContainingIgnoreCase(String keyword);
}

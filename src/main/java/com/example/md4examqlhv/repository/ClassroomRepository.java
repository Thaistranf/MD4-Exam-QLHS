package com.example.md4examqlhv.repository;

import com.example.md4examqlhv.model.Classroom;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
}

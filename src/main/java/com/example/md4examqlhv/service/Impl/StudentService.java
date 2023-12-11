package com.example.md4examqlhv.service.Impl;

import com.example.md4examqlhv.model.Student;
import com.example.md4examqlhv.repository.StudentRepository;
import com.example.md4examqlhv.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StudentService implements IStudentService {
    @Autowired
    StudentRepository studentRepository;
    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Iterable<Student> search(String keyword) {
        return studentRepository.findByNameContainingIgnoreCase(keyword);
    }
}

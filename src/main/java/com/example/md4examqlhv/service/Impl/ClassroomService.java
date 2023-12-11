package com.example.md4examqlhv.service.Impl;

import com.example.md4examqlhv.model.Classroom;
import com.example.md4examqlhv.repository.ClassroomRepository;
import com.example.md4examqlhv.service.IClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassroomService implements IClassroomService {
    @Autowired
    ClassroomRepository classroomRepository;
    @Override
    public Iterable<Classroom> findAll() {
        return classroomRepository.findAll();
    }

    @Override
    public Optional<Classroom> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Classroom save(Classroom classroom) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}

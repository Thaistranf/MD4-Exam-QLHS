package com.example.md4examqlhv.service;

import com.example.md4examqlhv.model.Student;

import java.util.List;

public interface IStudentService extends IGeneralService<Student>{
    Iterable<Student> search(String keyword);
}

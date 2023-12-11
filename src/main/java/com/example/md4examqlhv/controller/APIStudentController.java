package com.example.md4examqlhv.controller;

import com.example.md4examqlhv.model.Student;
import com.example.md4examqlhv.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
@CrossOrigin("*")
public class APIStudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping
    public ResponseEntity<Iterable<Student>> showList(){
        List<Student> students = (List<Student>) studentService.findAll();
        if (students.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable Long id){
        Optional<Student> studentOptional = studentService.findById(id);
        if (!studentOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(studentOptional.get(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student){
        return new ResponseEntity<>(studentService.save(student), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student){
        Optional<Student> studentOptional = studentService.findById(id);
        if (studentOptional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        student.setId(studentOptional.get().getId());
        return new ResponseEntity<>(studentService.save(student), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> delete(@PathVariable Long id){
        studentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<Student>> search(@RequestParam("studentName") String keyword){
        List<Student> students = (List<Student>) studentService.search(keyword);
        if (students.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}

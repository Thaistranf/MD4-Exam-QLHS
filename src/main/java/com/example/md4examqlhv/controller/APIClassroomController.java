package com.example.md4examqlhv.controller;

import com.example.md4examqlhv.model.Classroom;
import com.example.md4examqlhv.service.IClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/classrooms")
@CrossOrigin("*")
public class APIClassroomController {
    @Autowired
    private IClassroomService classroomService;

    @GetMapping
    public ResponseEntity<Iterable<Classroom>> showList(){
        List<Classroom> classrooms = (List<Classroom>) classroomService.findAll();
        if (classrooms.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(classrooms, HttpStatus.OK);
    }
}

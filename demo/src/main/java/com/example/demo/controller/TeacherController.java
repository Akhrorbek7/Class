package com.example.demo.controller;

import com.example.demo.model.Teacher;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping
    public HttpEntity<?> create(@RequestParam("name") String name, @RequestParam("groupId") Integer groupId){
        teacherService.create(name, groupId);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public HttpEntity<?> getAll(){
        List<Teacher> teacherList = teacherService.getAll();
        return ResponseEntity.ok(teacherList);
    }
}

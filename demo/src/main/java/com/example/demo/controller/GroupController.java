package com.example.demo.controller;

import com.example.demo.model.Group;
import com.example.demo.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @PostMapping
    public HttpEntity<?> create(@RequestParam("name") String name){
        groupService.create(name);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public HttpEntity<?> getAll(){
        List<Group> groupList = groupService.getAll();
        return ResponseEntity.ok(groupList);
    }
}

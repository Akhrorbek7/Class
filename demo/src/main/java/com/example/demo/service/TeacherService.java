package com.example.demo.service;

import com.example.demo.model.Teacher;
import com.example.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    //Main functions
    public Teacher get(Integer id){
        return getEntity(id);
    }

    public void create(String name, Integer groupId) {
        Teacher teacher = new Teacher();
        teacher.setName(name);
        teacher.setGroupId(groupId);
        teacherRepository.save(teacher);
    }

    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }

    //Secondary functions
    public Teacher getEntity(Integer id) {
        Optional<Teacher> optional = teacherRepository.findById(id);
        if(optional.isEmpty()){
            return null;
        }
        return optional.get();
    }

}

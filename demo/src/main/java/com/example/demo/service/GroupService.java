package com.example.demo.service;

import com.example.demo.model.Group;
import com.example.demo.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    //Main functions
    public Group get(Integer id){
        return getEntity(id);
    }

    public void create(String name) {
        Group group = new Group();
        group.setName(name);
        groupRepository.save(group);
    }

    public List<Group> getAll() {
        return groupRepository.findAll();
    }

    //Secondary functions
    public Group getEntity(Integer id) {
        Optional<Group> optional = groupRepository.findById(id);
        if(optional.isEmpty()){
            return null;
        }
        return optional.get();
    }

}

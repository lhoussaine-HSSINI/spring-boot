package com.mymvc.mvc.dao;


import com.mymvc.mvc.model.Entity.TestEntity;
import com.mymvc.mvc.model.repository.TestRepo;
import com.mymvc.mvc.model.repository.TestRepo_1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestDao {
    @Autowired
    private TestRepo testrepo;
    @Autowired
    private TestRepo_1 testrepo_1;
    public String getName(){
        return "lhoussaine hssini";
    }

    public List<TestEntity> guser_1(){
        return testrepo_1.findAll();
    }

    public  Iterable<TestEntity>   guser(){
        return testrepo.findAll();
    }
    public Optional<TestEntity> guser_by_id(Integer id){
        return testrepo.findById(id);
    }
    public void user_by_id_delete(Integer id){
         testrepo.deleteById(id);
    }

}

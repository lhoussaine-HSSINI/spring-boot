package com.mymvc.mvc.model.repository;

import com.mymvc.mvc.model.Entity.TestEntity;
import org.springframework.data.repository.CrudRepository;

public interface TestRepo extends CrudRepository<TestEntity, Integer> { }

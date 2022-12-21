package com.mymvc.mvc.model.repository;

import com.mymvc.mvc.model.Entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TestRepo_1 extends JpaRepository<TestEntity, Integer> {
}
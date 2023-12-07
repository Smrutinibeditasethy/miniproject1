package com.project.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.PlanCategoryEntity;

public interface PlanCategoryRepository extends JpaRepository<PlanCategoryEntity, Serializable>{

}

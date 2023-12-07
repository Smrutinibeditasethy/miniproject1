package com.project.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.PlanMasterEntity;

public interface PlanMasterRepository extends JpaRepository<PlanMasterEntity, Serializable> {
	

}

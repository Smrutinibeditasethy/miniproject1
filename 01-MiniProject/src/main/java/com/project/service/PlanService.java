package com.project.service;

import java.util.List;
import java.util.Map;

import com.project.binding.PlanData;
import com.project.binding.ResponseData;
import com.project.entity.PlanCategoryEntity;
import com.project.entity.PlanMasterEntity;

public interface PlanService {

	 public List<PlanCategoryEntity> getCategories();
	 public PlanCategoryEntity getCategoriesById(Integer categoryId);
	public boolean savePlan(PlanData plandata);
	public List<ResponseData> getAllPlan();
	public PlanMasterEntity getPlanById(Integer planId);
	public boolean deteleById(Integer planId);
	public boolean changeStatus(Integer planId, String activeSw );
	 public boolean updatePlan(PlanMasterEntity updatedPlanData);
}

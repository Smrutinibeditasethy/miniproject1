package com.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.binding.PlanData;
import com.project.binding.ResponseData;
import com.project.entity.PlanCategoryEntity;
import com.project.entity.PlanMasterEntity;
import com.project.repository.PlanCategoryRepository;
import com.project.repository.PlanMasterRepository;

@Service
public class PlanImplementationService implements PlanService {
	
	@Autowired
	private PlanMasterRepository pmr;
	
	@Autowired
	private PlanCategoryRepository pcr;

	@Override
	public List<PlanCategoryEntity> getCategories() {
       List<PlanCategoryEntity> findAll = pcr.findAll();    
        return findAll;
    }

	@Override
	public boolean savePlan(PlanData plandata) {
		PlanMasterEntity pme = new PlanMasterEntity();
		BeanUtils.copyProperties(plandata, pme);
		PlanMasterEntity save = pmr.save(pme);
		return save.getPlanId()!=null?true: false;
	}

	@Override
	public List<ResponseData> getAllPlan() {
		List<PlanMasterEntity> findAll = pmr.findAll();
		ArrayList<ResponseData> arrayList = new ArrayList<>();
		for(PlanMasterEntity entity: findAll) {
			ResponseData responseData = new ResponseData();
			BeanUtils.copyProperties(entity, responseData);
			arrayList.add(responseData);
		}
		return arrayList;
	}

	@Override
	public PlanMasterEntity getPlanById(Integer planId) {
		Optional<PlanMasterEntity> findById = pmr.findById(planId);
		return findById.orElse(null);
	}
	@Override
	public PlanCategoryEntity getCategoriesById(Integer categoryId) {
		Optional<PlanCategoryEntity> findById = pcr.findById(categoryId);
		return findById.orElse(null);
	}
	


	@Override
	public boolean deteleById(Integer planId) {
		try {
			pmr.deleteById(planId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean changeStatus(Integer planId, String activeSw) {
Optional<PlanMasterEntity> findById = pmr.findById(planId);
if (findById.isPresent()) {
	PlanMasterEntity masterEntity = findById.get();
	masterEntity.setActionSw(activeSw);
	pmr.save(masterEntity);
	return true;
}
		return false;
	}

	/*@Override
	public boolean updatePlan(PlanData plandata) {
PlanMasterEntity planMasterEntity = new PlanMasterEntity();
BeanUtils.copyProperties(plandata, planMasterEntity);
PlanMasterEntity save = pmr.save(planMasterEntity);
return save.getPlanId()!= null;
	}*/
	
	@Override
	 public boolean updatePlan(PlanMasterEntity updatedPlanData) {
	        // Check if the provided plan already exists in the database
	        Optional<PlanMasterEntity> existingPlanOptional = pmr.findById(updatedPlanData.getPlanId());

	        if (existingPlanOptional.isPresent()) {
	            PlanMasterEntity existingPlan = existingPlanOptional.get();

	            // Update the existing plan entity with the new data
	            existingPlan.setPlanName(updatedPlanData.getPlanName());
	            existingPlan.setStartDate(updatedPlanData.getStartDate());
	            existingPlan.setEndDate(updatedPlanData.getEndDate());
	            existingPlan.setCategoryName(updatedPlanData.getCategoryName());

	            // Save the updated plan entity
	            pmr.save(existingPlan);
	            return true;
	        } else {
	            return false; // Return false if the plan does not exist
	        }
	    }

	
	

}

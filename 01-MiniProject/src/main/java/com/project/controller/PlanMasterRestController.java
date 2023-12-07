package com.project.controller;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.binding.PlanData;
import com.project.binding.ResponseData;
import com.project.entity.PlanCategoryEntity;
import com.project.entity.PlanMasterEntity;
import com.project.service.PlanService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PlanMasterRestController {

    @Autowired
    private PlanService planservice;
    
	 @GetMapping(value = {"/", "/categories"}) 
	 public ResponseEntity<List<PlanCategoryEntity>> getCategoryNames() {
		 List<PlanCategoryEntity> categories = planservice.getCategories();
		return new ResponseEntity<>(categories, HttpStatus.OK);
	       
	    }
	 
    @PostMapping("/savePlan")
    public ResponseEntity<String> savePlan(@RequestBody PlanData planData) {
        boolean saved = planservice.savePlan(planData);
        if (saved) {
            return new ResponseEntity<>("Plan saved successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to save plan", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<ResponseData>> getAllPlans() {
        List<ResponseData> allPlan = planservice.getAllPlan();
        return new ResponseEntity<>(allPlan, HttpStatus.OK);
    }

    @GetMapping("/plan/{planId}")
    public ResponseEntity<PlanMasterEntity> getPlanById(@PathVariable Integer planId) {
        PlanMasterEntity plan = planservice.getPlanById(planId);
        if (plan != null) {
            return new ResponseEntity<>(plan, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<PlanCategoryEntity> getCategoryById(@PathVariable Integer categoryId) {
        PlanCategoryEntity categoriesById = planservice.getCategoriesById(categoryId);
        if (categoriesById != null) {
            return new ResponseEntity<>(categoriesById, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @PutMapping("/update/{planId}")
    public ResponseEntity<String> updatePlan(@PathVariable Integer planId, @RequestBody PlanData planData) {
        PlanMasterEntity existingPlan = planservice.getPlanById(planId);

        if (existingPlan != null) {
            existingPlan.setPlanName(planData.getPlanName());
            existingPlan.setStartDate(planData.getStartDate());
            existingPlan.setEndDate(planData.getEndDate());
            existingPlan.setCategoryName(planData.getCategoryName());

            boolean updateSuccessful = planservice.updatePlan(existingPlan);

            if (updateSuccessful) {
                return new ResponseEntity<>("Plan updated successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Failed to update plan", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>("Plan not found", HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/delete/{planId}")
    public ResponseEntity<String> deletePlan(@PathVariable Integer planId) {
        boolean deleted = planservice.deteleById(planId);
        if (deleted) {
            return new ResponseEntity<>("Plan deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to delete plan", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/change-status/{planId}")
    public ResponseEntity<String> changePlanStatus(@PathVariable Integer planId, @RequestParam String activeSw) {
        boolean statusChanged = planservice.changeStatus(planId, activeSw);
        if (statusChanged) {
            return new ResponseEntity<>("Plan status changed successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to change plan status", HttpStatus.NOT_FOUND);
        }
    }

  

}

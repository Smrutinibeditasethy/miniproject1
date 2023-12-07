package com.project.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Plan_Master")
public class PlanMasterEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Plan_Id")
	private Integer PlanId;
	
	@Column(name = "Plan_Name")
	private String planName;
	
	@Column(name = "Plan_StartDate")
	private LocalDate startDate;
	
	@Column(name = "Plan_endDate")
	private LocalDate endDate;
	
	@Column(name = "Plan_categoryName")
	private String categoryName;
	
	@Column(name = "Plan_ActionSw")
	private String actionSw;
	
}
